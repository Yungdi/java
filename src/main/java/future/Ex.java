package future;

import java.util.ArrayList;
import java.util.List;

public class Ex {

    public static void main(String[] args) {
//        String b = "FRANCE";
//        String a = "french";
//        List<String> strings = ofSubset(a);
//        List<String> strings1 = ofSubset(b);
//        int same = same(strings, strings1);
//
//        double v = (double) same / (strings.size() + strings1.size() - same) * 65536;
//        System.out.println((int) Math.abs(v));
        List<String> a = new ArrayList<>();
        a.add("hello");

    }

    private static int same(List<String> strings, List<String> strings1) {
        int count = 0;
        for (String string : strings) {
            if (strings1.contains(string))
                count++;
        }
        return count;
    }


    private static List<String> ofSubset(String a) {
        char[] chars = a.toCharArray();
        List<Character> filteredChars = new ArrayList<>();
        List<String> subset = new ArrayList<>();

        for (int i = 0; i < chars.length - 1; i++) {
            char aChar = chars[i];
            if (Character.isAlphabetic(aChar)) {
                filteredChars.add(Character.toLowerCase(aChar));
            }
        }

        for (int i = 0; i < filteredChars.size() - 1; i++) {
            String e = filteredChars.get(i) + "" + filteredChars.get(i + 1);
            subset.add(e);
        }
        return subset;
    }


}
