import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;



public class Test {
    public List<String> numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<StringBuilder> prev = new ArrayList<>();
        List<StringBuilder> next = new ArrayList<>();
        prev.add(new StringBuilder());

        if (s.charAt(0) != '0') {
            int value = s.charAt(0) - '0';
            char c = (char)(value - 1 + 'A');
            next.add(new StringBuilder(c + ""));
        }

        for (int i = 1; i < s.length(); i++) {
            List<StringBuilder> cur = new  ArrayList<>();
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: prev) {
                    sb.append(c);
                    cur.add(sb);
                }
            }
            if (s.charAt(i) != '0') {
                value = s.charAt(i) - '0';
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: next) {
                    StringBuilder copy = new StringBuilder(sb);
                    copy.append(c);
                    cur.add(copy);
                }
            }
            prev = next;
            next = cur;
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb: next) {
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Test t = new Test();
        String s = "1821";
        //[RU, AHU, RBA, AHBA]
        System.out.println(t.numDecodings(s));
    }
}
