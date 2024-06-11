/**
 * 运用所掌握的数据结构，设计和实现一个 LRU (Least Recently Used，最近最少使用) 缓存机制 。
 * <p>
 * <p>
 * 实现 LRUCache 类：
 * <p>
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时
 * ，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
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
 * <p>
 * <p>
 * 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * Related Topics设计 | 哈希表 | 链表 | 双向链表
 * <p>
 * 👍 107, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

import java.util.LinkedHashMap;

//java:LRU 缓存
class OrIXps {
  public static void main(String[] args) {
//        Solution solution = new OrIXps().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;


    class Node {
      private final Integer key;
      private final Integer value;

      Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
      }
    }

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
      if (!cache.containsKey(key)) {
        return -1;
      }

      Integer value = cache.get(key);
      makeRecently(key);
      return value;
    }

    private void makeRecently(int key) {
      Integer value = cache.remove(key);
      cache.put(key, value);
    }

    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        // 更新值并置为最新
        cache.put(key, value);
        makeRecently(key);
        return;
      }

      cache.put(key, value);
      if (cache.size() > capacity) {
        Integer first = cache.keySet().iterator().next();
        cache.remove(first);
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