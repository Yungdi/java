package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class ConventionalDateEx {

    public static void main(String[] args) {
        // 자바 1.0
        // 문제:
        // - 1900년을 기준으로 하는 오프셋, 0으로 시작하는 달 인덱스
        // - toString 직관적이지 않음
        Date date = new Date(117, 8, 21);
        System.out.println(date);
        // 자바 1.1:
        // Calendar: Date 의 대안
        // 문제
        // - 달 인덱스 0부터 시작하는 건 여전
        // - Date 와 Calendar 중 어떤 걸 써야할 지 혼동 야기
        // - DateFormat 의 일부 기능은 Date 에서만 동작
        Calendar calendar = Calendar.getInstance();
        // DateFormat
        // - not thread safe
        // - 두 스레드가 하나의 Formatter 를 사용할 수 없음
        // Date 와 Calendar 는 모두 가변 클래스
        // 가변 클래스 설계는 유지보수를 어렵게 한다.
        // 개발자들이 부실한 날짜와 시간 라이브러리 때문에 Joda-Time 같은 서드파티 라이브러리를 사용하게 됨

    }
}
