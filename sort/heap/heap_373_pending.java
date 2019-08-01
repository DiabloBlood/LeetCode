


class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k < 1) {
            return new ArrayList<>();
        }
        
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        /**
         * 1. idx1 < n - 1 && idx2 < n - 1;
         * 2. idx1 == n - 1 && idx2 < n - 1 && !flag2; idx1 = 0; idx2++; flag1 = true;
         * 3. idx1 == n - 1 && idx2 < n - 1 && flag2 && sw; idx2++;
         * 4. idx1 == n - 1 && idx2 < n - 1 && flag2 && !sw; idx2 = 0; sw = true;
         * 5. idx1 < n - 1 && idx2 == n - 1 && !flag1; idx2 = 0; idx1++; flag2 = true;
         * 6. idx1 < n - 1 && idx2 == n - 1 && flag1 && sw; idx1++;
         * 7. idx1 < n - 1 && idx2 == n - 1 && flag1 && !sw; idx1 = 0; sw = true;
         * 8. idx1 == n - 1 && idx2 == n - 1; break;
         */
        
        int idx1 = 0;
        int idx2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean sw = false;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[idx1]);
            pair.add(nums2[idx2]);
            result.add(pair);

            if (idx1 == n1 - 1 && idx2 == n2 - 1) {
                break;
            }
            
            if (idx1 < n1 - 1 && idx2 < n2 - 1) {
                if (nums1[idx1] + nums2[idx2 + 1] < nums1[idx1 + 1] + nums2[idx2]) {
                    idx2++;
                } else {
                    idx1++;
                }
            } else if (idx1 == n1 - 1 && idx2 < n2 - 1) {
                if (!flag2) {
                    idx1 = 0;
                    idx2++;
                    flag1 = true;
                } else if (!sw) {
                    idx2 = 0;
                    sw = true;
                } else {
                    idx2++;
                }
            } else if (idx1 < n1 - 1 && idx2 == n2 - 1) {
                if (!flag1) {
                    flag2 = true;
                } else if (!sw) {
                    idx1 = 0;
                    sw = true;
                } else {
                    idx1++;
                }
            }
             
            System.out.println(idx1);
            System.out.println(idx2);
            System.out.println();
        }
        return result;
    }
}