# ExactSize 어노테이션 사용법

`@ExactSize`는 파라미터 또는 필드의 문자열 길이가 지정한 값과 정확히 일치하는지 검증하는 커스텀 어노테이션입니다.  
[jakarta.validation.constraints](https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary) 패키지의 `@Size` 어노테이션을 기반으로 작성하였으며, `min`, `max`가 동일한 상황에서 `@Size`를 대체하기 위해 개발되었습니다.

## 주요 특징
- 문자열의 길이가 지정한 값과 정확히 일치할 때만 유효합니다.
- `@NotNull`과 함께 사용하면 null 값도 검증할 수 있습니다.
- 파라미터, 필드, 제네릭 타입 등 다양한 위치에 적용할 수 있습니다.

## 사용 예시

```java
@RestController
public class SampleController {
    // 파라미터가 5글자인지 검증
    @GetMapping("/api/sample")
    public String sample(@RequestParam @ExactSize(5) String code) {
        return "code: " + code;
    }
}
```

```java
public class SampleDTO {
    @ExactSize(6)
    private String yearMonth; // 반드시 6글자여야 함 (예: 202401)
}
```

## 동작 방식
- 값이 null인 경우는 유효한 값으로 간주합니다. (null 검증은 @NotNull로 별도 처리)
- 값의 길이가 지정한 값과 다르면 검증 오류 메시지가 반환됩니다.
- 기본 메시지: `값은 반드시 {value}자여야 합니다.`

## 참고
- 여러 필드에 중복 적용이 가능합니다.
- 커스텀 메시지는 `message` 속성으로 지정할 수 있습니다.
