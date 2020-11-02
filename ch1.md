# 1 자바 8, 9, 10, 11: 무슨 일이 일어나고 있는가?
## 1.1 역사의 흐름은 무엇인가?
__자바의 변화__
- 람다와 스트림을 이용하면 자연어에 가깝게 코드를 구현할 수 있다.
```java
// as-is
Collections.sort(inventory, new Comparator<Apple>() {
  public int compare(Apple a1, Apple a2) {
    return a1.getWeight.compareTo(a2.getWeight());
  }
});
// to-be
inventory.sort(Collectors.comparing(Apple::getWeight));
```
- 단순한 병렬처리 방식 (parallel stream)
- 메서드에 코드를 전달하는 기법 (동작 파라미터화)
## 1.2 왜 아직도 자바는 변화하는가?
변화하지 않는 언어는 도태됨  
개발자가 원하는 방식으로 변화  
__자바 8 설계의 밑바탕을 이루는 세 가지 프로그래밍 개념__
- 스트림 처리
스트림이란 한 번에 한 개씩 만들어지는 연속적인 데이터 항목들의 모임  
스트림 API 를 사용해서 동작 파이프 라인 구성 가능  
- 동작 파라미터화로 메서드에 코드 전달하기
함수형 인터페이스를 파라미터로 전달  
- 병렬성과 공유 가변 데이터
no shared mutable data, method 전달 가능
## 1.3 자바 함수
- 메서드를 인자로 전달할 수 있음(메서드 참조)  
- 람다(익명 함수)  
- 동작을 전달
## 1.4 스트림
- 내부 반복
- 필터링(filter)
- 추출(map)
- 그룹화(grouping)
- 포킹(paraell)
## 1.5 디폴트 메서드와 자바 모듈
- 디폴트 메서드: 인터페이스를 쉽게 바꿀 수 있게 해줌
- 모듈: 컴포넌트를 구축하는 새로운 방식
## 1.6 함수형 프로그래밍에서 가져온 다른 유용한 아이디어
- NPE 예외 방지(Optional)
- 패턴 매칭 활용
