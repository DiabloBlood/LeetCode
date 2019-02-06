import java.util.Arrays;
import java.util.Collections;


class Sort_274 {

    public int hIndex(int[] citations) {
        if(citations == null) {
            return -1;
        }
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(true) {
            int mid = partition(citations, left, right);
        }
    }

    // cannot pass test case [1]
    public int hIndex2(int[] citations) {
        if(citations == null) {
            return 0;
        }
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if(i + 1 < citations[i]) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex3(int[] citations) {
        if(citations == null) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = n - 1; i >= 0; i++) {
        }
        return 0;
    }

    private int partition(int[] citations, int left, int right) {
        return -1;
    }

    public static void main(String[] args) {
        Sort_274 ss = new Sort_274();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(ss.hIndex3(citations));
        System.out.println(Arrays.toString(citations));
    }
}