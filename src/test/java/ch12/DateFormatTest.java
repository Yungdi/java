package ch12;

import java.text.DateFormat;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DateFormat 로 날짜 표현하기")
class DateFormatTest {

    @Test
    void testDateFormat() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        String format = dateFormat.format(date);
        System.out.println(format);
    }
}
