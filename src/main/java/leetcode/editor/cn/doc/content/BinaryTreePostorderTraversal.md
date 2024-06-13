<p>给你一棵二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>后序遍历 </strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/pre1.jpg" style="width: 127px; height: 200px;" /> 
<pre>
<strong>输入：</strong>root = [1,null,2,3]
<strong>输出：</strong>[3,2,1]
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
 <li>树中节点的数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>递归算法很简单，你可以通过迭代算法完成吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 1178, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 限时优惠；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

不要瞧不起二叉树的前中后序遍历。

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/fname.html?fname=二叉树总结) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，分别代表回溯算法和动态规划的底层思想。

本题用两种思维模式来解答，注意体会其中思维方式的差异。

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
    // 定义：输入一个节点，返回以该节点为根的二叉树的后序遍历结果
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        // 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
        auto left = postorderTraversal(root->left);
        auto right = postorderTraversal(root->right);
        res.insert(res.end(), left.begin(), left.end());
        res.insert(res.end(), right.begin(), right.end());
        res.push_back(root->val);
        return res;
    }

    /* 回溯算法思路 */
    vector<int> res;

    // 返回后序遍历结果
    vector<int> postorderTraversal2(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        res.push_back(root->val);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        # 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
        res += self.postorderTraversal(root.left)
        res += self.postorderTraversal(root.right)
        res.append(root.val)
        return res

    res = []

    def postorderTraversal2(self, root: TreeNode) -> List[int]:
        self.traverse(root)
        return self.res

    def traverse(self, root: TreeNode):
        if not root:
            return
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.res.append(root.val)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    /* 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的后序遍历结果
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    /* 回溯算法思路 */
    LinkedList<Integer> res = new LinkedList<>();

    // 返回后序遍历结果
    public List<Integer> postorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        res.add(root.val);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的后序遍历结果
func postorderTraversal(root *TreeNode) []int {
    res := []int{}
    if root == nil {
        return res
    }
    // 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
    res = append(res, postorderTraversal(root.Left)...)
    res = append(res, postorderTraversal(root.Right)...)
    res = append(res, root.Val)
    return res
}

// 回溯算法思路
func postorderTraversal2(root *TreeNode) []int {
    res := []int{}
    traverse(root, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    traverse(root.Left, res)
    traverse(root.Right, res)
    // 后序遍历位置
    *res = append(*res, root.Val)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    const res = [];
    /* 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的后序遍历结果
    if (root == null) {
        return res;
    }
    // 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
    res.push(...postorderTraversal(root.left));
    res.push(...postorderTraversal(root.right));
    res.push(root.val);

    /* 回溯算法思路 */
    /*LinkedList<Integer> res = new LinkedList<>();*/

    // 返回后序遍历结果
    // public List<Integer> postorderTraversal2(TreeNode root) {
    //     traverse(root);
    //     return res;
    // }

    // 二叉树遍历函数
    // void traverse(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     traverse(root.left);
    //     traverse(root.right);
    //     // 后序遍历位置
    //     res.add(root.val);
    // }

    return res;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_binary-tree-postorder-traversal" data="G6xHUZSs0deORNgmwckAaJXAk/Fq9FNQMtfjDd4p4sLXTvteDbCgRhd5QM1snUlP9pNuVFV/tUWMLU/tTZgoRLEEm1kr51J2p6pJy5aNB+KHU2ENk6YiSVnpwQ3xCWAbbL0jWMvBeSHXQYcUSf+//dJUBaZA/OpQWCJZYfi7Vu958yY3tE0BN1sAkLT3T4EhVBSKwLra1346Pim5CF9FRgRQ6AI51OGdqbCtE33ZMKhmfAmFt0B3xZ8YV3cT+N7dslZye3Rf8AfgzdOUI0k0UMxiLNPxOVIS72m7CAssCF7c2GdL/U6fZN6mf+vh7poS+/6th+/J3zBwUclTnxzqyOf6mj6T4T3zjo/ozyOSNK/w5nf/QztgJfu3HmVfC6+T2G+R2+Wa1Z6uUfDc5X5dpWTckkyB+3gWBUnLQJNAXTVWsB7uPtkr7lO3jGQVcZTEgwDHBVdcrDOC+tzF2Armk327mQrLQqVXGhqtV3bM4XSb1YQpJtSkGlWy6jHXXvD2t6+vbsthHvE1LZxGapu7FR9eh5bf5UGAFOk9M2r5KToFCbj2MTKLkKFGMxq8j/GPLFe55qyoqR+2kUiZM7HXL9mRRB60TIZ5dJZsGbGMBW3zZBhZawunP65+SuJK25FXuyU22JnC+MoH0vGOsYj15CBohUKOMI7Hd7jb6O6/e/OrZ/FKlwhDvPKN0aJVXtgyCZbczNSmOeJZK2n/CdxaDgbg8Juh+DUWmeK+0DUfZnB6DGcIAHK74sHlLnZt3ykWB01cTGQCxf/eox+PzPKHKERXI0zMM3k9A7pTRsoJ3RverbrMkZlyTXJnXGeSoOQvNQTqL4l4s0magubmigpTK167mFxCq9hUhUsVdMm+qITnZVUXa96RzDoYBScBo52Hm6fXdgbnuLYUDDzd2GqlA7PhNBPtNXLgDAFKu4Pv8MAgbzLG6N33CxnLaQbowCDl2GqlQ7PhEsHCNcrAGQLUjvD7KvLm5dO2HQqHxkpHzIY3ZPezPjNwhgDgZQYkT+bofY9B2Ayd9xjUZbmHBXtML3qqPaz8/nxPw+EAKs2wYdizYfrswBkCgBcakDyZw786XNFZRrYAijpszSlzwX/Cv04yERhjXstHQTiYbDT0xMZADnW6NgnowmQxpPaCuHBN8yy/rXOMpJ0gfjelZj2b+zokg63hNy32j7/wIvbA5rLdcuLieemAaK4gZAq3qek7UdhhdgPoTYfDGJmDt4KkdNTAgDMTa8v0xIivNU8DzpkHYCRRxB6qebk8PgcHpfZ9weSh0ekNYIjia/cmJE/mCHwQNoWSU2EDDLUd8FqvBz2Gjz5oINsRXIkErEBM05ne7AebD5w1GIgbbVhsJOuPYdTPAbHPEEbAusMGFl2ETFDpTkC2wIpRTmXMAITX2OLv/GaxqqnBBpxhu1AVY8RLTNZDybyoW7uH/Vqngpf2Ikj2XD2xiFfvPmAg0UpEWlUQXJDwFPPdWWcM5hQ30MVGsv4YJh0zIPYc8vmiy+8kZ1Ptleo5eudnBR4eZI4/YxhG8EU+8L6jFTaNGfzKWEGNVBsJjUrHef9zavV3skD6Lgj7PlkkojU4myFVzzzMf/lYmnrk+fEuSTDQIWWvw/dUuS1f0LwjH8d1sgRPWH2dQhiX8QAHp8YjUtmA1GjV9QaFeCbpOivMfbZSr5X1C72I3abT5iyCwJOy4uEndcjdldlc172D3qFmKtRf7jXsY+fwmaSjjRHnNym9rNf1fozH7U4rHPOKIymf4j2+H3/bdISPby3GkZQ7L7i9rwMyz3xKxuAgFL4lEMf7iozhaZq92C7ozsWZ1ta3eWrXNp0bM+15X/noMg7jfWnHx5jeSVW+1i2ZiSqQ0YePI6m1OpqTust5HUmlZaY1qQo2799Y2ssYh6QKRH9MUqG5gBa8yEKHLO36y3eLe64WZ1/14xSlDGqf3pSo+2f7fVGl+CP/VX6dZUXw4V76ofiQ9/Va5F5mu13gGVH3HFtIVjPdzhvCKG1u07rhd3/fZG4lwHBiFO4y6IajncuEUaa1+rFcwTGM3C2fyOtkxk2snpOxM7EwypmLTP7ktmfepkkGJh6rHeKVV4rFLQm3j7ycpmQlG1LPhRs7qw6jTC0LYK/yXiyeGspVG3OBZz3vwYdXx8cifmTbYC/4XyxhRsfsFTljkaXiqqALPMWR6IurQXWBp9AljN0UvWLplEXiyuE3nOKY5sO2u2kU8xeUKs+7tOOmXk9+S6HLUUOgD/rt54eQe+5x0LP+QJKlqQGrBvJiMe0Oy5APpaYBYc3V5CX8+a5JOAaEUwVVZ36P1xt1gFuCbuQ3X6oQNln2OaYLf1gP6KF0buMbQLaMaJ6MNeLgmUmoFO4NMFqGjE2p1FFyHfTtBTx1nU2bMuwzYKResLCtEf68V0nm2ZpQBsyi5NxLPzhN9WiA05moo4t8mHesc/SFoEqeOAnywIpj2vBFzqivO35/eQrIQO8rXvOLpYjJB71U3Tt5diA0ZQYqbbff6kB8CTz3jPA2Z6t8XO9S1TRwvHa43hd5Ymm4SoiC8cARIPkIts9P62SgZ95PNlZPxv728wN9Lie5NYUWejgUj8A962QLMLvLC4txTyTIYd/sLFXcZDQTBzdqhSwN18vracQgiWNbkzm/vd1LtLH7vMt+GW13YzS5l13QcOYvjIyHnYVd3UK00ErNKLX1f1ilK19d4LROfSz+Z7dR+3BFbsEhupC0A0EnLOy79j1/+etqmUMfK0ZGZy0C9LsQFnW5iMQ9KwY6UAz0nRjoIjG4J8RAh4eBvg4DXRoG91wY6LQw0DdhoAvC4N4HA50MBvoSBO4yMNBbYKBTwEDbn8FNfAZa8gw02BlolzO4+c1Ay5uBBjYD7WgGN5cZaBUz0PhloI3L4KYsUPt4GMe/QoW1W3Xj865I6sGeLCagaFERpKJqmziK4mYEJ/DgImaulkMsKGGB4gI2wBUsl6rgzA2sUTogwnJJCs6cwwaKK1guPcGZG1ijdMCCDXABywUmOHMFa5QOBLABTrBcRoIz57CB4hbW0IE6LBeL4MwlbKC4hTV0YITlkhCcOcEGiltYQweesCz8wVmrgq1ajERe976+GHxH4zwMZ3D4On2qfjsJfRGdKlI4HehBD0XNTwlDXRARrVJbVeNE5CAz62dWr3IMvx/rAVxM3ibs9nCWeWQtygqNv/aqaZ85SpDdOQbinZRoxwxxbmlfrMLFFI/Y31PPXnTvU/W0HJW3u7EjZOyXH8u7McmjYki/LrV+iKnzGA81dKYQJgRS1znwmoPjKBEHz/6TpYAyXj6dQ8xF/DWFQ5n3o2OoMBz/2n7+0ZuW1j5VvWsGCF2M1TS2tMhb3hFQdleALxwN2v60j5lPkdT2rOufh+FJMWZt5Q/RRu7moO7OxlthDv0uyX3GDoGrN8CJXRuNvtpP1r6kpCrX16BcpNBucUVmbVuQhpZ9kZSEK9P9yUHE5G6VKYpvFhbe+JysOR3XVEJ5vuWAsxnE84lZCJO9jwX/9SZV8o5wToeduMjBEUse8YqPSLwgCZgjrpDzdI8IsukNIpiI3JeZck5NqUhKBmJ+rE7trRdzsg6z/f/vygUsWrrsfqr5mZBqvRbUwvhay//mOK+tVJ/tot6mMpvyvBNY5pl8lIwev5LvSfP371KZciGf8J0x4BYp5VCbOiw9nL4UVcWEZlmvG4V1MYhWip40bg26UTDEJUpJetOEDeBBdm/+TW53RAI="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-postorder-traversal"></div></div>
</details><hr /><br />

</details>
</div>

