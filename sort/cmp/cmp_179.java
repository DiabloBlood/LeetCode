


class Solution179 {
    /**
     * Problem pitfalls:
     *    1. All the numbers is non-negtive number.
     *    2. Sort case, `(s2 + s1).compareTo(s1 + s2)`.
     *    3. if nums is [0, 0, 0], result cannot be "000", should be "0".
     *    4. `s[0].equals("0")` may throw `ArrayIndexOutOfBoundsException`, so `nums.length == 0` corner case should be handled.
     * 
     * Time:  O(n*logn), first for loop O(n), sort O(n*logn), build result O(n).
     * Space: O(n), string array `s` takes O(n), stringbuilder takes O(n).
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (s[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str: s) {
            sb.append(str);
        }
        return sb.toString();
    }
}
