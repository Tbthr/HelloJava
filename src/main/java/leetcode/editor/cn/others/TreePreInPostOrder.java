package leetcode.editor.cn.others;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Binary Tree Pre/In/Post Order Traversal
// https://labuladong.online/algo/data-structure/iterative-traversal-binary-tree/
public class TreePreInPostOrder {
  /**************************** 以下解法，利用栈的特性很巧妙地完成了前序、后序遍历 *******************************************/
  // 对于每个节点，先输出；再将右孩子、左孩子依次入栈；那么出栈顺序即为左、右；整体而言：中左右
  public List<Integer> preOrder1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      res.add(node.value); // pre

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return res;
  }

  // 参考前序遍历：将入栈顺序反一下，整体而言：中右左；将输出结果存起来，入栈res；出栈：左右中
  public List<Integer> postOrder1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> stack = new ArrayDeque<>();
    Deque<TreeNode> resInStack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      // 先把结果存起来，入栈顺序：中右左
      resInStack.push(node);

      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    // 出栈顺序：左右中
    while (!resInStack.isEmpty()) {
      res.add(resInStack.pop().value); // post
    }
    return res;
  }

  /**************************** 以下解法，均为模拟栈调用的过程 *******************************************/
  // 将树的左边界入栈，直到为空；弹出一个节点，输出，并将规则赋予其右子树执行
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop();
        res.add(cur.value); // in
        cur = cur.right;
      }
    }
    return res;
  }

  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      // 迭代访问节点的左孩子，并入栈
      while (cur != null) {
        res.add(cur.value); // pre
        stack.push(cur);
        cur = cur.left;
      }
      // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
      if (!stack.isEmpty()) {
        cur = stack.pop();
        cur = cur.right;
      }
    }
    return res;
  }
}


class Solution {
  // 模拟函数调用栈
  private final Deque<TreeNode> stack = new ArrayDeque<>();

  // 左侧树枝一撸到底
  private void pushLeftBranch(TreeNode p) {
    while (p != null) {
      /*******************/
      /** 前序遍历代码位置 **/
      /*******************/
      stack.push(p);
      p = p.left;
    }
  }

  public List<Integer> traverse(TreeNode root) {
    // 指向上一次遍历完的子树根节点
    TreeNode visited = new TreeNode(-1);
    // 开始遍历整棵树
    pushLeftBranch(root);

    while (!stack.isEmpty()) {
      TreeNode p = stack.peek();

      // p 的左子树被遍历完了，且右子树没有被遍历过
      if ((p.left == null || p.left == visited) && p.right != visited) {
        /*******************/
        /** 中序遍历代码位置 **/
        /*******************/
        // 去遍历 p 的右子树
        pushLeftBranch(p.right);
      }
      // p 的右子树被遍历完了
      if (p.right == null || p.right == visited) {
        /*******************/
        /** 后序遍历代码位置 **/
        /*******************/
        // 以 p 为根的子树被遍历完了，出栈
        // visited 指针指向 p
        visited = stack.pop();
      }
    }
    // 返回结果，此处略
    return null;
  }
}


class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }
}
