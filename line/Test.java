import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;




public class Test {

    public String countAndSay(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        StringBuilder prev = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int start = 0;
            int len = prev.length();
            for (int j = 0; j <= len; j++) {
                if (j == len || prev.charAt(j) != prev.charAt(start)) {
                    cur.append(j - start).append(prev.charAt(start));
                    start = j;
                }
            }
            prev = cur;
        }
        return prev.toString();
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        final int notFound = -1;
        int[] map = new int[128];
        Arrays.fill(map, notFound);

        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != notFound && start < map[c]) {
                start = map[c] + 1;
            }
            map[c] = i;
            max = Integer.max(i - start + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Test test = new Test();
        //String result = test.countAndSay(20);
        //int result = test.lengthOfLongestSubstring("abba");
        //System.out.println(result);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map.values() instanceof Iterator);
    }
}