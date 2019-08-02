


/**
 * LeetCod 295. Find Median from Data Stream
 */

/**
 * Analysis:
 *    1. maxHeap holds the small number parts, minHeap holds the large number parts.
 *    2. After addNum(), maxHeap.size() == minHeap.size() or maxHeap.size() == minHeap.size() + 1
 *
 * Time:  O(logn) add, O(1) find
 * Space: O(n)
 */
class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // Negotiate with interviewer that if this corner case should be handled.
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0.0;
        }
        return maxHeap.size() == minHeap.size() ? (0.0 + maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
    }
}