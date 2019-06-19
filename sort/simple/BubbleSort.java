// bubble sort is stable sort
// O(n^2 / 2)
public class BubbleSort {

    // outer for means the times of sort
    // inner for means swap elements of one time
    public void BubbleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j++) {
                if(nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    // outer for means solve one location every time
    // inner for means bubble to right, make the largest to corresponding location
    public void BubbleSort2(int[] nums) {
        if(nums == null) {
            return;
        }
        for(int i = nums.length - 1; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                if(nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp; 
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        BubbleSort bs = new BubbleSort();
        bs.BubbleSort2(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}