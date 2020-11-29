package ch12;

import java.util.Calendar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calendar 클래스 사용")
class CalendarTest {

    @Test
    @DisplayName("0 부터 시작하는 Month")
    void testUseCalendar() {
        // 현재 시점으로 생성되는 날짜
        // Month 는 0 ~ 11 , 0 부터 시작
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        System.out.println(calendar);
        Assertions.assertThat(month)
            .as("check month")
            .isEqualTo(10);
    }
}
