


// O(n^2 / 4) better than bubble sort, bubble sort need call swap, 3 step operation
public class InsertionSort {

    public void InsertionSort(int[] nums) {
        if(nums == null) {
            return;
        }
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        InsertionSort is = new InsertionSort();
        is.InsertionSort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}