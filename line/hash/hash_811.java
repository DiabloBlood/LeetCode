


public class Solution811 {
    /**
     * Notes:
     *     1. The length of cpdomains will not exceed 100.
     *     2. The length of each domain name will not exceed 100.
     *     3. Each address will have either 1 or 2 "." characters.
     *     4. The input count in any count-paired domain will not exceed 10000.
     *     5. The answer output can be returned in any order.
     *
     * Problem Analysis:
     *     1. Use `indexOf` method to find space char.
     *     2. Know the difference of method `substring(int beginIndex)` and method `substring(int beginIndex, int endIndex)`.
     *
     * Corner Cases:
     *     1. cpdomains == null; ----> return new ArrayList<>(); // otherwise `for (String cpdomain: cpdomains)` will throw
     *                                                              `NullPointerException`
     *     2. Suppose all the cpdomains string is valid.
     *
     * Time:  O(nm), assue cpdomains length is `n`, assume cpdomain avg length is `m`, then 2nd `indexOf` and 2nd for loop
     *               takes nearly `2m`.
     * Space: O(nm), there are `cn` level domain names, domain avg length is `m`.
     */

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s: cpdomains) {
            int idx = s.indexOf(' ');
            int count = Integer.parseInt(s.substring(0, idx));
            for (int i = s.length() - 1; i >= idx; i--) {
                if (i == idx || s.charAt(i) == '.') {
                    String key = s.substring(i + 1);
                    map.put(key, map.getOrDefault(key, 0) + count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    /**
     * If use `split` method of string.
     *
     * Problem Analysis:
     *     1. Small string we can directly use `split` method and `+` operator for string actions.
     *     2. String `split` method input is a regex, use `split("\\.")`.
     *
     * Corner Cases:
     *     1. cpdomains == null; ----> return new ArrayList<>(); // otherwise `for (String cpdomain: cpdomains)` will throw
     *                                                              `NullPointerException`
     *     2. Suppose all the cpdomains string is valid.
     *
     * Time:  O(n), assue cpdomains length is `n`, then all sub domains names at `cn` level, `c` is constant, since each domain
     *               just contains 1 or 2 "." characters.
     * Space: O(n), there are `cn` level domain names.
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] arr = cpdomain.split(" ");
            int count = Integer.parseInt(arr[0]);
            String[] domains = arr[1].split("\\.");
            String postfix = "";
            String key = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                key = domains[i] + postfix + key;
                map.put(key, map.getOrDefault(key, 0) + count);
                postfix = ".";
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
