package chapter12;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;

public class InstantEx {

    public static void main(String[] args) {
        /**
         * 유닉스 시간은 시간을 나타내는 방식이다. 윤초는 포함하지 않는다. 윤초가 뭐지??
         * 동의어: 유닉스 타임스탬프
         * POSIX 시간이나 Epoch 시간으로도 불린다.
         * Epoch 는 시간을 측정하는 기준점이다
         * Instant 클래스: 기계의 날짜와 시간
         * Coordinated Universal Time
         * Unix Epoch Time (1970년 1월 1일 0시 0분 0초 UTC) 협정 세계 표준시
         * UTC는 그리니치 평균시(GMT)에 기반하므로 GMT로도 불리기도 하는데, UTC와 GMT는 초의 소숫점 단위에서만 차이가 나기 때문에 일상에서는 혼용된다. 기술적인 표기에서는 UTC가 사용된다.
         */
        System.out.println(Instant.ofEpochSecond(3L));
        System.out.println(Instant.ofEpochSecond(3L, 0L));
        System.out.println(Instant.ofEpochSecond(2L, 1_000_000_000L));
        System.out.println(Instant.ofEpochSecond(4L, 1_000_000_000L));
        System.out.println(Instant.ofEpochSecond(4L, 1_000_000_001L));
        // Instant 는 사람이 읽을 수 있는 시간 정보를 제공하지 않는다.
        try {
            int i = Instant.now().get(ChronoField.DAY_OF_MONTH);
        } catch (UnsupportedTemporalTypeException e) {
            e.printStackTrace();
        }
    }
}
