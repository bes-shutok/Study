import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    public TreeNode createBinaryTree(List<Integer> treeVals) {
        if (treeVals.isEmpty()) return null;
        int cap = treeVals.size();
        TreeNode root = new TreeNode(treeVals.get(0));
        TreeNode left, right, cur = root;
        for (int i = 1; i < cap; i+=2) {
            left = null;
            right = null;
            if (treeVals.get(i) != null)
                left = new TreeNode(treeVals.get(i));
            if (cap > i+1  && treeVals.get(i+1) != null)
                right = new TreeNode(treeVals.get(i+1));
            cur.left = left;
            cur.right = right;
            cur = getNextRoot(cur);
            if (cur == null) cur = root;
        }
        return root;
    }

    private TreeNode getNextRoot(TreeNode cur) {
        if (cur.left != null) return cur.left;
        if (cur.right != null) return cur.right;
        return null;
    }

/*        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        }*/

    public List<Integer>  preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer>  preorderValues = new ArrayList<>();
        preorderValues.add(root.val);

        TreeNode cur = root;
        while (!cur.equals(findEndNodePO(cur))) {
            cur = findEndNodePO(cur);
            preorderValues.add(cur.val);
        }
        return preorderValues;
    }

    private TreeNode findEndNodePO(TreeNode root) {
        if (root.left != null)
            return findEndNodePO(root.left);
        else if (root.right != null)
            return findEndNodePO(root.right);
        else return root;
    }

}
