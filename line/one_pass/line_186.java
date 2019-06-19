
/*
* Case Analysis:
* 1. s[i] == ' '; reverse(s, start, i - 1); start = i + 1;
* 2. i == len; reverse(s, start, i - 1);
*/


public class Solution186 {

    /*
    * Time complexity: O(2n)
    * Space complexity: O(1)
    */
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int len = s.length;
        reverse(s, 0, len - 1);
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(char[] s, int p, int q) {
        char temp = s[p];
        s[p] = s[q];
        s[q] = temp;
    }
}