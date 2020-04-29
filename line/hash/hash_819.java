


class Solution819 {
    /**
     * Notes:
     *     1. 1 <= paragraph.length <= 1000.
     *     2. 0 <= banned.length <= 100.
     *     3. 1 <= banned[i].length <= 10.
     *     4. The answer is unique, and written in lowercase
     *     5. paragraph only consists of letters, spaces, or the punctuation symbols `!?',;.`.
     *     6. There are no hyphens or hyphenated words.
     *     7. Words only consist of letters, never apostrophes or other punctuation symbols.
     *
     * Problem Analysis:
     *     1. The regular expression can use "[^0-9a-zA-Z]+", or "[ !?',;.]+", or "\\W+".
     *     2. If use `Collection.max`, `map.entrySet()` cannot be empty!
     *
     * Corner Cases:
     *     1. paragraph == null || banned == null; ---> return ""; // in fact this case doesn't need to handle, input guaranteed not null.
     *
     * Time:  O(n + m), assume paragraph length is `n`, banned length is `m`.
     * Space: O(n + m), set takes `m`, map at most takes `n`.
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null) {
            return "";
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s: banned) {
            set.add(s);
        }
        String[] words = paragraph.toLowerCase().split("\\W+");
        for (String word: words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Problem Analysis:
     *     1. Split words is same to problem 151.
     *     2. Use `spliter.indexOf(paragraph.charAt(i)) > -1` instead of `String.contains` method, this method input must a string.
     *
     * General Cases:
     *     1. s[i] in spliter && i == start + 1;     ---> start = i; // `start` follow `i`, pass all spliters.
     *     2. s[i] not in spliter && i == start + 1; ---> // do nothing, not move `start`
     *     3. s[i] in spliter && i > start + 1; ---> substring(start + 1, i); start = i;
     *     4. i == n && i > start + 1; ---> substring(start + 1, i); start = i; // just for combine cases, `start` move to `i` impacts nothing. 
     *     5. i == n && i == start + 1; ---> start = i; // just for combine cases, `start` move to `i` impacts nothing. 
     *     combine 1, 3, 4, 5
     *     1. i == n || s[i] in spliter;
     *         a. i > start + 1; ---> substring(start + 1, i); // this is case 3, 4
     *         ---> start = i;
     *
     * Corner Cases:
     *     1. paragraph == null || banned == null; ---> return ""; // in fact this case doesn't need to handle, input guaranteed not null.
     *
     * Time:  O(n + m), assume paragraph length is `n`, banned length is `m`.
     * Space: O(n + m), set takes `m`, map at most takes `n`.
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null) {
            return "";
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s: banned) {
            set.add(s);
        }

        int start = -1;
        String spliter = " !?',;.";
        for (int i = 0; i <= paragraph.length(); i++) {
            if (i == paragraph.length() || spliter.indexOf(paragraph.charAt(i)) > -1) {
                if (i > start + 1) {
                    String word = paragraph.substring(start + 1, i).toLowerCase();
                    if (!set.contains(word)) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
                start = i;
            }
        }

        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
