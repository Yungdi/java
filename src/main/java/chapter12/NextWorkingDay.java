package chapter12;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        int dayOfWeek = temporal.get(ChronoField.DAY_OF_WEEK);
        if (dayOfWeek == 5) {
            return temporal.plus(3L, ChronoUnit.DAYS);
        } else if (dayOfWeek == 6) {
            return temporal.plus(2L, ChronoUnit.DAYS);
        } else {
            return temporal.plus(1L, ChronoUnit.DAYS);
        }
    }
}
