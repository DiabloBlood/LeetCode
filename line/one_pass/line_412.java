


class Solution412 {
    /**
     * Notes:
     *     1. When i == 15, string is "FizzBuzz".
     *
     * Corner Cases:
     *     1. n < 1; ---> return new ArrayList<>(); // invalid input.
     *
     * Time:  O(n), the size of input number `n`
     * Space: O(1), string builder will be GC after each round of for loop.
     */
    public List<String> fizzBuzz(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            String s = sb.length() == 0 ? String.valueOf(i) : sb.toString();
            result.add(s);
        }
        return result;
    }

    /**
     * Follow up: if have so many rule, how to avoid write to many if-else?
     *
     * Corner Cases:
     *     1. n < 1; ---> return new ArrayList<>(); // invalid input.
     *
     * Time:  O(n), the size of input number `n`
     * Space: O(1), string builder will be GC after each round of for loop.
     */
    private class Rule {
        int num;
        String str;
        Rule (int _num, String _str) {
            num = _num;
            str = _str;
        }
    }
    public List<String> fizzBuzz(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule(3, "Fizz"));
        rules.add(new Rule(5, "Buzz"));
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Rule rule: rules) {
                if (i % rule.num == 0) {
                    sb.append(rule.str);
                }
            }
            String s = sb.length() == 0 ? String.valueOf(i) : sb.toString();
            result.add(s);
        }
        return result;
    }
}
