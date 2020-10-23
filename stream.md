# Collectors 에서 제공하는 기능 세가지
1. 요약
```
counting
maxBy, minBy
summingInt, summingDouble, summingLong
averagingInt, averagingDouble, averagingLong  
joining
reducing
```
2. 그룹화
```java
groupingBy(Function function);
groupingBy(Function function, Collector collector);
groupingBy(Student::age, filtering(student -> student.level > 2, toList());
groupingBy(Student::age, mapping(Student::name, toList());
groupingBy(Student::age, flatMapi(Student::family, toList());
```
