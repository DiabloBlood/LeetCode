import java.util.Arrays;



/**
 * A max heap.
 */
public class Heap {

    private int size;
    private int[] array;

    public Heap(int[] a) {
        size = a.length;
        array = a;
        heapify();
    }

    public void sort() {
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = poll();
        }
    }

    private void heapify() {
        for (int i = size - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private int poll() {
        int min = array[0];
        array[0] = array[--size];
        siftDown(0);
        return min;
    }

    private void siftDown(int hole) {
        int temp = array[hole];
        int half = size / 2;
        while (hole < half) {
            int child = hole * 2 + 1;   // left child
            int right = child + 1;
            if (right < size && array[child] < array[right]) {
                child = right;          // if right child is large, change to right child
            }
            if (temp >= array[child]) {
                break;
            }
            array[hole] = array[child];
            hole = child;
        }
        array[hole] = temp;
    }

    public static void main(String[] args) {
        int[] array = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        Heap heap = new Heap(array);
        heap.sort();
        System.out.println(Arrays.toString(array));
    }
}
