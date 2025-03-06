### App 설명
이 앱은 달력기능을 이용한 Todo 할일관리 앱입니다.

[[[Calendar]]]
- Calendar 탭에서 달력을 이용할 수 있습니다.

[할일]
1. 달력에서 날짜를 클릭하고, 하단 Enter Todo 란에 내용을 입력한 뒤 Enter 입력 혹은 Add Todo 버튼을 클릭하여 새로운 할일을 추가할 수 있습니다. 
(해당 일자에 할일이 존재하는 경우, 날짜 상단에 초록색 동그라미가 표시됩니다.)
1-1. 생성된 할일에 대해서는 좌측 체크박스를 통해 완료 표시가 가능합니다.
1-2. 우측 Delete 버튼을 통해 삭제가 가능합니다.
1-3. 우측 Priority 버튼을 클릭하여 3단계로 우선순위 지정이 가능합니다.

### 소스 빌드 및 실행 방법
1. VSCode 설치
2. Java 설치 (v17.0.13)
3. VSCode 터미널을 열어, 아래 명령어 붙여넣기하여 필요한 Extension 설치 
code --install-extension vscjava.vscode-java-pack \
    && code --install-extension vscjava.vscode-java-debug \
    && code --install-extension vscjava.vscode-gradle \
    && code --install-extension vscjava.vscode-java-dependency \
    && code --install-extension pivotal.vscode-spring-boot-dashboard \
    && code --install-extension vmware.vscode-boot-dev-pack \
    && code --install-extension Pivotal.vscode-spring-boot \
    && code --install-extension vscjava.vscode-spring-initializr
4. MySQL 설치 (v8.0.41)
5. DBeaver 설치하여 MySQL Connection 생성 후, "TaskMate_BackEnd\src\main\resources\DDLScript.txt 쿼리 및 DMLScript.txt 쿼리 실행하여 DB 및 테이블 생성
6. 터미널에 ./gradlew build 명령어 입력
7. VSCode 좌측 Spring Boot Dashboard 탭에서 APPS 목록 우측 Run 클릭하여 실행

### 주로 사용한 라이브러리
## Spring Web MVC
RESTful API 구현을 용이하게 하기 위해, 웹 애플리케이션의 MVC(Model-View-Controller) 패턴을 이용했습니다.

## Spring Data JPA(Java Persistence API)
DB와의 상호작용 및 복잡한 JDBC 코드 작성을 간소화하기 위해, 인터페이스 정의만으로 데이터 액세스 계층을 구현할 수 있게 도와주는 JPA를 사용했습니다.

## Springdoc OpenAPI
Swagger 형식으로 API 문서를 자동으로 생성하고 문서화하기 위해 사용한 라이브러리입니다. Spring 3.x 이상부터 해당 라이브러리를 의존성에 추가하는 것만으로 개발 환경에서 Swagger를 자동 작성할 수 있었습니다.

## Jackson DataType JSR310
Java 8의 Date & Time API(JSR-310)를 JSON으로 직렬화/역직렬화하기 위한 라이브러리입니다. 이 어플리케이션의 경우, 달력이 핵심적인 기능에 해당합니다. 따라서 API 호출 시 `LocalDate` 타입을 JSON으로 변환하거나 JSON에서 `LocalDate`로 변환하기 위해 위 라이브러리를 사용했습니다.

## H2 Database (테스트용)
인메모리 데이터베이스로, 개발 환경에서 사용했습니다. 이를 통해 실제 MySQL 데이터베이스 연결 이전에도 DB 관련 개발 및 테스트를 미리 진행할 수 있었습니다.

### API 명세
VSCode 터미널에서 ./gradlew bootRun 명령어 입력하여 개발자 모드로 실행 후, 아래 링크 접속하여 swagger 확인
http://localhost:8080/swagger-ui/swagger-ui/index.html

### 📌Test Case
## 📝 기능: 할일 추가 (Add Todo)

| Test Case ID | TC001 |
|-------------|--------|
| **기능 (Feature)** | 새로운 할일 항목 추가 |
| **설명 (Description)** | 달력에서 날짜 선택 후, 하단에 할일 내용 입력하여 저장 시 할일이 등록된다. |
| **입력값 (Test Input)** | 
{
  "title": "회의 준비",
  "date": "2025-03-05",
  "importance": "low"
}
| **테스트 단계 (Steps to Reproduce)** |  
1. 캘린더 페이지로 이동 후
2. {
  "title": "회의 준비",
  "date": "2025-03-05",
  "importance": "low"
} 
입력 (title의 경우 사용자가 입력, date는 사용자가 선택, importance는 기본값) 
3. "Add Todo" 버튼 클릭 |
| **예상 결과 (Expected Result)** | 해당 날짜에 할일 등록 완료 |
| **실제 결과 (Actual Result)** | ✅ 할일 등록 완료 (Pass) |
| **테스트 상태 (Status)** | ✅ Pass |

---

## 📝 기능: 특정 날짜의 할 일 조회 (Get Todo)

| Test Case ID | TC002 |
|-------------|--------|
| **기능 (Feature)** | 특정 날짜의 할일 목록 조회 |
| **설명 (Description)** | 달력에서 날짜 선택 시, 기존에 등록된 할일 목록이 조회된다. |
| **입력값 (Test Input)** | 
{
  "date": "2025-03-05"
}
| **테스트 단계 (Steps to Reproduce)** |  
1. 캘린더 페이지로 이동 후
2. {
  "date": "2025-03-05"
} 
입력 (date는 사용자가 날짜 선택 시 자동 지정) 
| **예상 결과 (Expected Result)** | 해당 날짜에 등록된 할일 전체 목록 표시 |
| **실제 결과 (Actual Result)** | ✅ 할일 목록 정상 표시 (Pass) |
| **테스트 상태 (Status)** | ✅ Pass |

---

## 📝 기능: 할일 삭제 (Delete Todo)

| Test Case ID | TC003 |
|-------------|--------|
| **기능 (Feature)** | 특정 할일 삭제 |
| **설명 (Description)** | 특정 할일 우측 Delete 버튼 클릭 후 Yes 선택 시, 해당 할일이 삭제된다. |
| **입력값 (Test Input)** | 
{
  "id": "1"
}
| **테스트 단계 (Steps to Reproduce)** |  
1. 할일 목록에서
2. {
  "id": "1"
} 
입력 (id는 사용자가 선택한 삭제할 항목에 맞추어 자동 선택) 
| **예상 결과 (Expected Result)** | 선택한 할일 삭제 |
| **실제 결과 (Actual Result)** | ✅ 할일 정상 삭제 (Pass) |
| **테스트 상태 (Status)** | ✅ Pass |

---

## 📝 기능: 할일 완료 상태 변경 (Change Todo Status)

| Test Case ID | TC004 |
|-------------|--------|
| **기능 (Feature)** | 특정 할일 완료 상태 변경 |
| **설명 (Description)** | 특정 할일 좌측 체크박스 토글 시, 완료 여부가 on / off 된다. |
| **입력값 (Test Input)** | 
{
  "id": "1"
}
| **테스트 단계 (Steps to Reproduce)** |  
1. 할일 목록에서
2. {
  "id": "1"
} 
입력 (id는 사용자가 선택한 상태 변경 항목에 맞추어 자동 지정) 
| **예상 결과 (Expected Result)** | 선택한 할일 완료 여부 변경 |
| **실제 결과 (Actual Result)** | ✅ 할일 완료 여부 정상 변경 (Pass) |
| **테스트 상태 (Status)** | ✅ Pass |

---

## 📝 기능: 할일 우선순위 변경 (Change Todo Priority)

| Test Case ID | TC005 |
|-------------|--------|
| **기능 (Feature)** | 특정 할일 우선순위 변경 |
| **설명 (Description)** | 특정 할일 우측 Priority 버튼 클릭 시, 회색 -> 노란색 -> 빨간색 순으로 변하며 중요도가 0,1,2 순으로 순회하며 변한다. |
| **입력값 (Test Input)** | 
{
  "id": "1",
  "importance": "high"
}
| **테스트 단계 (Steps to Reproduce)** |  
1. 할일 목록에서
2. {
  "id": "1",
  "importance": "high"
}
입력 (id는 사용자가 선택한 상태 변경 항목에 맞추어 자동 선택, importance는 현재 우선순위 다음 level로 자동 세팅) 
| **예상 결과 (Expected Result)** | 선택한 할일 우선순위 변경 |
| **실제 결과 (Actual Result)** | ✅ 할일 우선순위 정상 변경 (Pass) |
| **테스트 상태 (Status)** | ✅ Pass |

---


## 📌 **테스트 결과 기록 방법**
- `✅ Pass` → 테스트 성공  
- `❌ Fail` → 테스트 실패 (버그 수정 필요)  
- `⚠️ Blocked` → 환경 문제로 테스트 불가능  

---

### 폴더구조
```
TaskMate_BackEnd/
├── .gradle/
├── .vscode/
├── bin/
├── build/
├── gradle/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/taskmate/taskmate/
│   │   │       ├── config/                            # Application configuration
│   │   │       ├── controller/                        # REST API controllers
│   │   │       │   ├── CustomErrorController.java     # Custom error page controller
│   │   │       │   ├── HomeController.java            # Homepage controller
│   │   │       │   └── TodoController.java            # Todo API controller
│   │   │       │   └── 
│   │   │       ├── entity/                            # Database entities
│   │   │       │   └── Todo.java                      # Todo entity class
│   │   │       ├── repository/                        # JPA repositories
│   │   │       │   └── TodoRepository.java            # Todo repository interface
│   │   │       ├── service/                           # Business logic services
│   │   │       │   └── TodoService.java               # Todo related service
│   │   │       └── TaskmateApplication.java           # Main application class
│   │   │
│   │   └── resources/
│   │       ├── static/                                # Static files (CSS, JS, etc.)
│   │       ├── templates/                             # Template files
│   │       │   ├── error.html                         # Error page
│   │       │   └── index.html                          # Main page
│   │       ├── application-dev.properties             # Development environment config
│   │       ├── application-prod.properties            # Production environment config
│   │       ├── application.properties                 # Common configuration file
│   │       ├── DDLScript.txt                          # Database setup
│   │       └── DMLScript.txt                          # Database sample data generation
│   │
│   └── test/
│       └── java/
│           └── com/taskmate/taskmate/
│
├── api.http                                       # API test HTTP request file
├── build.gradle                                   # Gradle build configuration
└── README.md                                      # Project documentation
```
