


public class QuickSort {

    public int[] partition(int[] array, int start, int end) {
        int front = start - 1;
        int back = end + 1;
        int pivot = array[end];
        int i = start;
        while(i < back) {
            if(array[i] < pivot) {
                front++;
                swap(array, front, i);
                i++;
            } else if (array[i] == pivot) {
                i++;
            } else {
                back--;
                swap(array, back, i);
            }
        }
        return new int[]{front, back};
    }


    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    private void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort ss = new QuickSort();
        //int[] array = {85, 6, 57, 60, 83, 73, 72};
        int[] array = {5, 5, 5, 5, 5};
        //ss.printArray(array);
        int[] result = ss.partition(array, 0, array.length - 1);
        //ss.printArray(result);
        //ss.printArray(array);
    }
}