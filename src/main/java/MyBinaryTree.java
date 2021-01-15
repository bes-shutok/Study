import java.util.ArrayList;
import java.util.HashMap;
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

    @SuppressWarnings("AssignmentToForLoopParameter")
    public TreeNode createBinaryTree(List<Integer> treeVals) {
        if (treeVals.isEmpty()) return null;
        int cap = treeVals.size();
        TreeNode root = new TreeNode(treeVals.get(0));
        TreeNode left, right, cur = root;
        for (int i = 1; i < cap; i++) {
            left = null;
            right = null;
            if (treeVals.get(i) != null)
                left = new TreeNode(treeVals.get(i));
            else if (cap > i+1  && treeVals.get(++i) != null)
                right = new TreeNode(treeVals.get(i));
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

    /*
    * Runtime: 0 ms
    * Memory Usage: 37.5 MB
    * */
    public List<Integer>  preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer>  preorderValues = new ArrayList<>();
        HashMap<TreeNode, TreeNode> seen = new HashMap<>();
        seen.put(root,null);
        preorderValues.add(root.val);
        traversePO(root, seen, preorderValues);
        return preorderValues;
    }

    private void traversePO(TreeNode cur, HashMap<TreeNode, TreeNode> seen, List<Integer> preorderValues) {
        if (cur.left != null && !seen.containsKey(cur.left)) {
            preorderValues.add(cur.left.val);
            seen.put(cur.left,cur);
            traversePO(cur.left, seen, preorderValues);
        }
        if (cur.right != null && !seen.containsKey(cur.right)) {
            preorderValues.add(cur.right.val);
            seen.put(cur.right,cur);
            traversePO(cur.right, seen, preorderValues);
        }
        if (seen.get(cur) != null) traversePO(seen.get(cur), seen, preorderValues);
    }


    /*
     * Runtime: 0 ms
     * Memory Usage: 37.5 MB
     * */
    public List<Integer>  preorderTraversalWithNulls(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer>  preorderValues = new ArrayList<>();
        HashMap<TreeNode, TreeNode> seen = new HashMap<>();
        seen.put(root,null);
        preorderValues.add(root.val);
        traversePOWithNulls(root, seen, preorderValues);
        while (preorderValues.get(preorderValues.size()-1) == null)
            preorderValues.remove(preorderValues.size()-1);
        return preorderValues;
    }

    private void traversePOWithNulls(TreeNode cur, HashMap<TreeNode, TreeNode> seen, List<Integer> preorderValues) {
        if (cur.left != null && !seen.containsKey(cur.left)) {
            preorderValues.add(cur.left.val);
            seen.put(cur.left,cur);
            traversePOWithNulls(cur.left, seen, preorderValues);
        } else if (cur.left == null) preorderValues.add(null);
        if (cur.right != null && !seen.containsKey(cur.right)) {
            preorderValues.add(cur.right.val);
            seen.put(cur.right,cur);
            traversePOWithNulls(cur.right, seen, preorderValues);
        } else if (cur.right == null) preorderValues.add(null);
        if (seen.get(cur) != null) traversePOWithNulls(seen.get(cur), seen, preorderValues);
    }
}
