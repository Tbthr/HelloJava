<p>给定一个二叉树的根节点 <code>root</code> ，返回 <em>它的 <strong>中序</strong>&nbsp;遍历</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="height: 200px; width: 125px;" /> 
<pre>
<strong>输入：</strong>root = [1,null,2,3]
<strong>输出：</strong>[1,3,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 2093, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 限时优惠；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

不要瞧不起二叉树的遍历问题，前文 [我的刷题经验总结](https://labuladong.online/algo/fname.html?fname=算法心得) 说过，二叉树的遍历代码是动态规划和回溯算法的祖宗。

动态规划思路的核心在于明确并利用函数的定义分解问题，中序遍历结果的特点是 `root.val` 在中间，左右子树在两侧：

![](https://labuladong.github.io/pictures/二叉树系列2/1.jpeg)

回溯算法的核心很简单，就是 `traverse` 函数遍历二叉树。

本题就分别用两种不同的思路来写代码，注意体会两种思路的区别所在。

**标签：[二叉树](https://labuladong.online/algo/)**

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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    /* 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == NULL) {
            return res;
        }
        vector<int> left = inorderTraversal(root->left);
        res.insert(res.end(), left.begin(), left.end());
        res.push_back(root->val);
        vector<int> right = inorderTraversal(root->right);
        res.insert(res.end(), right.begin(), right.end());
        return res;
    }

    /* 回溯算法思路 */
    vector<int> res;

    // 返回前序遍历结果
    vector<int> inorderTraversal2(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        res.push_back(root->val);
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        """动态规划思路
        定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
        """
        res = []
        if not root:
            return res
        res += self.inorderTraversal(root.left)
        res.append(root.val)
        res += self.inorderTraversal(root.right)
        return res
    
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        """回溯算法思路"""
        self.res = []
        self.traverse(root)
        return self.res
    
    def traverse(self, root: TreeNode):
        """二叉树遍历函数"""
        if not root:
            return
        self.traverse(root.left)
        # 中序遍历位置
        self.res.append(root.val)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    /* 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /* 回溯算法思路 */
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
func inorderTraversal(root *TreeNode) []int {
    res := []int{}
    if root == nil {
        return res
    }
    res = append(res, inorderTraversal(root.Left)...)
    res = append(res, root.Val)
    res = append(res, inorderTraversal(root.Right)...)
    return res
}

// 回溯算法思路
func inorderTraversal2(root *TreeNode) []int {
    res := []int{}
    // 二叉树遍历函数
    var traverse func(node *TreeNode)
    traverse = func(node *TreeNode) {
        if node == nil {
            return
        }
        traverse(node.Left)
        // 中序遍历位置
        res = append(res, node.Val)
        traverse(node.Right)
    }

    traverse(root)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

var inorderTraversal = function(root) {
    let res = new LinkedList();
    if (root === null) {
        return res;
    }
    res.addAll(inorderTraversal(root.left));
    res.add(root.val);
    res.addAll(inorderTraversal(root.right));
    return res;
};

var inorderTraversal2 = function(root) {
    let res = new LinkedList();
    if (root === null) {
        return res;
    }
    
    traverse(root);
    return res;
};

const traverse = function(root, res) {
    if (root === null) {
        return;
    }
    traverse(root.left, res);
    // 中序遍历位置
    res.add(root.val);
    traverse(root.right, res);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_binary-tree-inorder-traversal" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-inorder-traversal"></div></div>
</details><hr /><br />

</details>
</div>

