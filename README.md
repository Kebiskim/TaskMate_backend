# CustomCalendar 컴포넌트

`CustomCalendar` 컴포넌트는 할 일을 관리할 수 있는 캘린더 인터페이스를 제공하는 React 컴포넌트입니다. 사용자는 할 일을 추가, 삭제, 우선순위 변경 및 완료 상태를 토글할 수 있습니다. 이 컴포넌트는 다크 모드를 지원하며 선택한 날짜의 할 일을 표시합니다.

## 주요 기능

- **할 일 추가**: 사용자가 선택한 날짜에 새로운 할 일을 추가할 수 있습니다.
- **할 일 삭제**: 기존 할 일을 삭제할 수 있습니다.
- **완료 상태 토글**: 할 일의 완료 상태를 토글할 수 있습니다.
- **우선순위 변경**: 할 일의 우선순위를 변경할 수 있습니다 (low, middle, high).
- **다크 모드**: `ThemeContext`를 기반으로 다크 모드를 지원합니다.
- **캘린더 탐색**: 사용자가 월별로 탐색하고 특정 날짜를 선택할 수 있습니다.
- **오늘로 이동**: 사용자가 오늘 날짜로 빠르게 이동할 수 있습니다.

## 소스 빌드 및 실행 방법

1. **레포지토리 클론**:
    ```sh
    git clone https://github.com/your-repo/custom-calendar.git
    cd custom-calendar
    ```

2. **의존성 설치**:
    ```sh
    npm install
    ```

3. **개발 서버 시작**:
    ```sh
    npm start
    ```

## 주요 컴포넌트 설명

### CustomCalendar

`CustomCalendar` 컴포넌트는 할 일을 관리할 수 있는 캘린더 인터페이스를 제공합니다. 이 컴포넌트는 다음과 같은 이유로 사용되었습니다:

- **사용자 친화적인 인터페이스**: 캘린더를 통해 날짜별로 할 일을 쉽게 관리할 수 있습니다.
- **다크 모드 지원**: `ThemeContext`를 통해 다크 모드를 지원하여 사용자 경험을 향상시킵니다.
- **할 일 관리 기능**: 할 일 추가, 삭제, 우선순위 변경 및 완료 상태 토글 기능을 제공합니다.

### ThemeContext

`ThemeContext`는 애플리케이션의 다크 모드 상태를 관리하는 컨텍스트입니다. 이 컨텍스트를 사용하여 다크 모드와 라이트 모드 간의 전환을 쉽게 구현할 수 있습니다.

```javascript
import React, { createContext, useState } from 'react';

export const ThemeContext = createContext();

export const ThemeProvider = ({ children }) => {
  const [darkMode, setDarkMode] = useState(false);

  return (
    <ThemeContext.Provider value={{ darkMode, setDarkMode }}>
      {children}
    </ThemeContext.Provider>
  );
};