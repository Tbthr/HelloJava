/**
 * 请你设计并实现一个满足
 * LRU (最近最少使用) 缓存 约束的数据结构。
 * <p>
 * <p>
 * <p>
 * 实现
 * LRUCache 类：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
 * value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * <p>
 * <p>
 * <p>
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10⁵
 * 最多调用 2 * 10⁵ 次 get 和 put
 * <p>
 * <p>
 * Related Topics设计 | 哈希表 | 链表 | 双向链表
 * <p>
 * 👍 3178, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:LRU 缓存
class LruCache {
  public static void main(String[] args) {
//    LRUCache cache = new LRUCache(2);
//    cache.put(1,1);
//    cache.put(2,2);
//    System.out.println(cache.get(1));// 1
//    cache.put(3,3);
//    System.out.println(cache.get(2));// -1
//    cache.put(4,4);
//    System.out.println(cache.get(1));// -1
//    System.out.println(cache.get(3));// 3
//    System.out.println(cache.get(4));// 4
  }

  //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
    private final int capacity;
    private final Node head;
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    class Node {
      Integer key;
      Integer value;
      Node next;
      Node pre;

      public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
      }
    }

    public LRUCache(int capacity) {
      this.capacity = capacity;
      // 伪头节点
      this.head = new Node(-1, -1);
      head.next = head.pre = head;
    }

    public int get(int key) {
      Node node = getNode(key);
      return node != null ? node.value : -1;
    }

    private Node getNode(int key) {
      // 没找到直接返回
      if (!keyToNode.containsKey(key)) {
        return null;
      }

      Node node = keyToNode.get(key);
      // 把书拿出来放在最上面
      removeNode(node);
      pushFront(node);
      return node;
    }

    private void pushFront(Node node) {
      node.pre = head;
      node.next = head.next;
      node.pre.next = node;
      node.next.pre = node;
    }

    private void removeNode(Node node) {
      node.next.pre = node.pre;
      node.pre.next = node.next;
    }

    public void put(int key, int value) {
      Node node = getNode(key);
      // 书找到了，已经放在最上面了，直接返回值
      if (node != null) {
        node.value = value;
        return;
      }

      // 把新书放到最上面
      node = new Node(key, value);
      keyToNode.put(key, node);
      pushFront(node);

      // 如果放不下了，把最久没用的书丢掉
      if (keyToNode.size() > capacity) {
        Node backNode = head.pre;
        keyToNode.remove(backNode.key);
        removeNode(backNode);
      }
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}