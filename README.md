# Generics
```java
List list = new ArrayList<Integer>(); // raw used
```
List -> List<Integer> 변환이 가능한 이유: 자바5이전의 코드를 호한하기 위해서

type parameter
  - method level
  - class level
    static variable or method 는 사용될 수 없다. why? 인스턴스 생성 시점에 type parameter 가 결정됨
method, class level 의 type parameter 는 한 곳에서 혼용해서 사용 가능
```java
public interface Generics<T> {
    <R> R test(T t);
}
```

bounded type parameter

intersection types

type inference