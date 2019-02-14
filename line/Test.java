


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

    public static void main(String[] args) {
        Test test = new Test();
        String result = test.countAndSay(20);
        System.out.println(result);
    }
}