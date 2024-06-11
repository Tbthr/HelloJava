<div class="title__3Vvk"> 
 <p>运用所掌握的数据结构，设计和实现一个&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (Least Recently Used，最近最少使用) 缓存机制</a> 。</p> 
</div>

<p>实现 <code>LRUCache</code> 类：</p>

<ul> 
 <li><code>LRUCache(int capacity)</code> 以正整数作为容量&nbsp;<code>capacity</code> 初始化 LRU 缓存</li> 
 <li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li> 
 <li><code>void put(int key, int value)</code>&nbsp;如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>输出</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>解释</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= capacity &lt;= 3000</code></li> 
 <li><code>0 &lt;= key &lt;= 10000</code></li> 
 <li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li> 
 <li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶</strong>：是否可以在&nbsp;<code>O(1)</code> 时间复杂度内完成这两种操作？</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 146&nbsp;题相同：<a href="https://leetcode-cn.com/problems/lru-cache/">https://leetcode-cn.com/problems/lru-cache/</a>&nbsp;</p>

<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 双向链表</details><br>

<div>👍 107, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 限时优惠；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=OrIXps" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [146. LRU 缓存机制](/problems/lru-cache) 相同。

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 216 页。

要让 `put` 和 `get` 方法的时间复杂度为 `O(1)`，我们可以总结出 `cache` 这个数据结构必要的条件：

1、显然 `cache` 中的元素必须有时序，以区分最近使用的和久未使用的数据，当容量满了之后要删除最久未使用的那个元素腾位置。

2、我们要在 `cache` 中快速找某个 `key` 是否已存在并得到对应的 `val`；

3、每次访问 `cache` 中的某个 `key`，需要将这个元素变为最近使用的，也就是说 `cache` 要支持在任意位置快速插入和删除元素。

哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢，所以结合二者的长处，可以形成一种新的数据结构：哈希链表 `LinkedHashMap`：

![](https://labuladong.github.io/pictures/LRU算法/4.jpg)

至于 `put` 和 `get` 的具体逻辑，可以画出这样一个流程图：

![](https://labuladong.github.io/pictures/LRU算法/put.jpg)

根据上述逻辑写代码即可。

**详细题解：[算法就像搭乐高：带你手撸 LRU 算法](https://labuladong.online/algo/fname.html?fname=LRU算法)**

**标签：[数据结构](https://labuladong.online/algo/)，[设计](https://labuladong.online/algo/)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

class LRUCache {
    int cap;
    unordered_map<int, int> cache;
    list<int> keys;

public:
    LRUCache(int capacity) {
        this->cap = capacity;
    }

    int get(int key) {
        auto it = cache.find(key);
        if (it == cache.end()) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return it->second;
    }

    void put(int key, int val) {
        auto it = cache.find(key);
        if (it != cache.end()) {
            // 修改 key 的值
            it->second = val;
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this->cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = keys.front();
            keys.pop_front();
            cache.erase(oldestKey);
        }
        // 将新的 key 添加链表尾部
        keys.push_back(key);
        cache[key] = val;
    }

private:
    void makeRecently(int key) {
        int val = cache[key];
        // 删除 key，重新插入到队尾
        keys.remove(key);
        keys.push_back(key);
        cache[key] = val;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = {}

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        # 将 key 变为最近使用
        self.makeRecently(key)
        return self.cache[key]

    def put(self, key: int, val: int) -> None:
        if key in self.cache:
            # 修改 key 的值
            self.cache[key] = val
            # 将 key 变为最近使用
            self.makeRecently(key)
            return

        if len(self.cache) >= self.cap:
            # 链表头部就是最久未使用的 key
            oldest_key = next(iter(self.cache))
            self.cache.pop(oldest_key)

        # 将新的 key 添加链表尾部
        self.cache[key] = val

    def makeRecently(self, key: int) -> None:
        val = self.cache[key]
        # 删除 key，重新插入到队尾
        del self.cache[key]
        self.cache[key] = val
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

type LRUCache struct {
    cap  int
    cache map[int]int
}

// Constructor 创建一个 LRU Cache 实例
func Constructor(capacity int) LRUCache {
    return LRUCache{
        cap:  capacity,
        cache: make(map[int]int),
    }
}

// Get 获取一个 key 的值
func (this *LRUCache) Get(key int) int {
    if val, ok := this.cache[key]; ok {
        this.makeRecently(key)
        return val
    }
    return -1
}

// Put 插入一个 key/value
func (this *LRUCache) Put(key int, value int) {
    if _, ok := this.cache[key]; ok {
        this.cache[key] = value
        this.makeRecently(key)
        return
    }
    if len(this.cache) >= this.cap {
        this.removeLeastRecently()
    }
    this.cache[key] = value
}

// makeRecently 将一个元素标记为最近使用的
func (this *LRUCache) makeRecently(key int) {
    val := this.cache[key]
    delete(this.cache, key)
    this.cache[key] = val
}

// removeLeastRecently 移除最近未使用的元素
func (this *LRUCache) removeLeastRecently() {
    for k := range this.cache {
        delete(this.cache, k)
        break
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var LRUCache = function(capacity) {
  this.cap = capacity;
  this.cache = new Map();
};

LRUCache.prototype.get = function(key) {
  if (!this.cache.has(key)) {
    return -1;
  }
  // 将 key 变为最近使用
  this.makeRecently(key);
  return this.cache.get(key);
};

LRUCache.prototype.put = function(key, val) {
  if (this.cache.has(key)) {
    // 修改 key 的值
    this.cache.set(key, val);
    // 将 key 变为最近使用
    this.makeRecently(key);
    return;
  }

  if (this.cache.size >= this.cap) {
    // 链表头部就是最久未使用的 key
    const oldestKey = this.cache.keys().next().value;
    this.cache.delete(oldestKey);
  }
  // 将新的 key 添加链表尾部
  this.cache.set(key, val);
};

LRUCache.prototype.makeRecently = function(key) {
  const val = this.cache.get(key);
  // 删除 key，重新插入到队尾
  this.cache.delete(key);
  this.cache.set(key, val);
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 031. 最近最少使用缓存 🟠](/problems/OrIXps)

</details>
</div>



