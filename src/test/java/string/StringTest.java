package string;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void testInputNullInArray() {
        String[] array = {null};
        List<String> list = new ArrayList<>();
        System.out.println(array[0]);
        list.add(null);
        System.out.println(list.get(0));
    }
}
