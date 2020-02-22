


public class Solution125 {
    /**
     * Notes:
     *     1. We define empty string as valid palindrome.
     *     2. Ignore cases, any character is not letter or digit should be skipped.
     *
     * General Cases:
     *     1. !isLetterOrDigit(s[i]); ---> i++;
     *     2. isLetterOrDigit(s[i]) && !isLetterOrDigit(s[j]); ---> j--;
     *     3. isLetterOrDigit(s[i]) && isLetterOrDigit(s[j]) && lower(s[i]) != lower(s[j]); ---> return false;
     *     4. isLetterOrDigit(s[i]) && isLetterOrDigit(s[j]) && lower(s[i]) == lower(s[j]); ---> // do nothing.
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `int j = s.length() - 1;` will throw `NullPointerException`.
     *     2. s == length(); ---> // doesn't need to handle, will skip while loop and return true.
     *
     * Time:  O(n), best is O(1), worst is O(n) such as string ",,,,,,,,".
     * Space: O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
