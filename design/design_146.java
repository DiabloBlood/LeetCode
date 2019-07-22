


public class LRUCache {
    
    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<Integer, ListNode> map;
    private final int capacity;
    private ListNode head;
    private ListNode tail;
    
    public LRUCache(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode cur = map.get(key);
        remove(cur);
        addLast(cur);
        return cur.value;
    }
    , 6,
    public void set(int key, int value) {
        ListNode cur;
        if(!map.containsKey(key)) {
            cur = new ListNode(key, value);
        } else {
            cur = map.get(key);
            cur.value = value;
            remove(cur);
        }
        map.put(key, cur);
        addLast(cur);
        
        if(map.size() > capacity) {
            ListNode first = removeFirst();
            map.remove(first.key);
        }
    }
    
    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void addLast(ListNode node) {
        ListNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    
    private ListNode removeFirst() {
        if(head.next == tail) {
            return null;
        }
        ListNode temp = head.next;
        ListNode post = head.next.next;
        head.next = post;
        post.prev = head;
        return temp;
    }   
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */