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

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() == t.length()) {
            return false;
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);
        
        for (int i = 0; i < s.length(); i++) {
            if(mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                System.out.println(mapS[s.charAt(i)]);
                System.out.println(mapS[t.charAt(i)]);
                return false;
            }
            mapS[s.charAt(i)] = i;
            mapT[t.charAt(i)] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.isIsomorphic("egg", "add"));
        // for (int i = 1; i <= 50; i++) {
        //     String cur = test.countAndSay(i);
        //     int curLen = cur.length();
        //     System.out.print(String.valueOf(curLen) + ", " + String.valueOf(curLen - prev));
        //     System.out.println();
        //     prev = curLen;
        // }
        // int result = test.lengthOfLongestSubstring("abba");
        // System.out.println(result);
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(1, 1);
        // System.out.println(map.values() instanceof Iterator);
    }
}












