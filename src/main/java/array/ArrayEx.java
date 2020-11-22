package array;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ArrayEx {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");
    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Seoul");

    public static void main(String[] args) {

        Object a = null;
        Object b = null;
        boolean equals = Objects.equals(a, b);
        System.out.println(equals);
    }

}
