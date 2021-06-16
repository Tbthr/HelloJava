//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 32 👎 0

package leetcode.editor.cn.others;

import java.util.HashMap;

//Java：LRU缓存
public class LruCacheLcci {
    public static void main(String[] args) {
        LRUCache cache = new LruCacheLcci().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class Node {
            private Node pre;
            private Node next;
            private Integer key;
            private Integer value;

            Node() {
            }

            Node(Integer key, Integer item) {
                this.key = key;
                this.value = item;
            }
        }

        HashMap<Integer, Node> map;
        Node head;
        Node tail;
        int size;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                Node node1 = new Node(key, value);
                map.put(key, node1);
                addToHead(node1);
                if (map.size() > size) {
                    Node node2 = removeTail();
                    map.remove(node2.key);
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        public void addToHead(Node node) {
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }

        public void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public Node removeTail() {
            Node node = tail.pre;
            remove(node);
            return node;
        }
    }
}