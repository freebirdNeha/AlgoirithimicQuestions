import java.util.HashMap;

/**
 *
 * @author neha.bassi
 */

class LRUNode {
    int key;
    int value;
    LRUNode pre;
    LRUNode post;
    
    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    int capacity;
    HashMap<Integer, LRUNode> map;
    LRUNode head = null;
    LRUNode end = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
     
    public int get(int key) {
        if(map.containsKey(key)) {
            LRUNode node = map.get(key);
            this.remove(node);
            this.setHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        LRUNode node;
        if(map.containsKey(key)) {
            node = map.get(key);
        } else {
            node = new LRUNode(key, value);
            map.put(key, node);
        }
        this.remove(node);
        this.setHead(node);
    }
    
    public void remove(LRUNode node) {
        if(!map.containsKey(node.key)) {
            return;
        }
        if(node.pre == null) {
            head = node.post;
        } else {
            node.pre.post = node.post;
        }
        
        if(node.post == null) {
            end = node.pre;
        } else {
            node.post.pre = node.pre;
        }
    }
    
    public void setHead(LRUNode node) {
        if(head == null) {
            head = node;
            end = node;
            return;
        }
        node.post = head;
        head.pre = node;
        head = node;
    }
}
