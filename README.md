# AOPlecture


Spring framework의 AOP를 사용해보는 실습  
[참조: jojoldu님의 블로그](https://jojoldu.tistory.com/69?category=635883 "이동")

- 웹 서비스의 구현이 아닌 AOP의 등장 배경을 이해하고 짧게 실습하는 것이 목적이다.
- JAVA: 8
- IDE: IntelliJ
- Spring: Spring Boot 2.1.7
- Build: Gradle 5.2.1
- Junit: 4
- DB: H2

### 개선 절차

1. 문제 상황 및 상속을 통한 개선
2. Dependency Injection을 통한 개선
3. AOP소개 ~ 개선
4. AOP 개선(2)

### AOP 용어

- Target: 부가기능을 부여할 대상, 핵심 기능이며 여기에서는 Service이다
- Aspect: 부가기능의 모듈 (객체지향에서의 Object에 대응한다)
    - Aspect는 Advice와 Pointcut으로 이루어져있다.
    - Advice: 실질적 부가기능을 담은 구현체, Aspect가 무엇을 언제할지 정의한다.
    - Pointcut: 부가기능이 적용될 메소드를 선정하는 방법, 조인포인트를 선별하는 기능을 정의한 모듈
- JoinPoint: Advice가 적용될 수 있는 위치
    - Spring에서는 쉽게 method라 생각할 수 있다.
- Proxy: 타겟의 요청을 대신 받아주는 Wrapping object
    - 타겟 메소드 실행전 선처리, 실행후 후처리
- Introduction: 타겟 클래스에 코드 변경 없이 신규 메소드나 멤버변수 추가하는 기능
- Weaving: 지정된 객체에 Aspect를 적용하여 새로운 Proxy 객체를 생성하는 과정

다음은 AOP 컨셉을 적용한 코드를 확인해봅니다.  

---
**Performance.java**
```java

// Aspect로 Performance를 지정합니다.
@Aspect
public class Performance {

    // Advice - when: 타겟 호출 전/후(@Around), what: 시간 측정(calctime method)
    // Pointcut specifier - execution
    // Target spec - com.~~~.getBoards()
    @Around("execution(* com.practice.aoplec.service.board.BoardService.getBoards(..))")
    public Object calculationPerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            // proceed를 Advice 기능 사이에서 수행합니다.
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : "+ (end-start));
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }
        return result;
    }
}

```
