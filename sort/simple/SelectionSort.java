


// O(n^2 / 2) better than bubble sort, since only swap one time 
public class SelectionSort {

    public void SelectionSort(int[] nums) {
        if(nums == null) {
            return;
        }
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            int smallest = i;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            swap(nums, smallest, i);
        }
    }

    public void SelectionSort2(int[] nums) {
        if(nums == null) {
            return;
        }
        int n = nums.length;
        for(int i = n - 1; i >= 1; i--) {
            int largest = i;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] > nums[largest]) {
                    largest = j;
                }
            }
            swap(nums, largest, i);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        SelectionSort ss = new SelectionSort();
        ss.SelectionSort2(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}