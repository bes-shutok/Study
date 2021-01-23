import java.util.*;

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

    /**
     * @param treeVals should follow Pre-order Traversal algorithm (with null when no left child, e.g. {1,null,2})
     * @return the root node of the binary tree
     */
    @SuppressWarnings("AssignmentToForLoopParameter")
    public TreeNode binaryTreeFromPrOListWithNulls(List<Integer> treeVals) {
        if (treeVals.isEmpty()) return null;
        Stack<TreeNode> stack = new Stack<>();
        int cap = treeVals.size();
        TreeNode root = new TreeNode(treeVals.get(0));
        TreeNode cur = root;

        for (int i = 1; i < cap; i++) {
            if (treeVals.get(i) != null) {
                cur.left = new TreeNode(treeVals.get(i));
                stack.push(cur);
                cur = cur.left;
            } else {
                mustHaveNextValue(cap, i+1);
                cur.left = null;
                if (treeVals.get(i + 1) != null) {
                    cur.right = new TreeNode(treeVals.get(++i));
                    cur = cur.right;
                } else {
                    cur.right = null;
                    mustHaveNextValue(cap, i+2);
                    cur = stack.pop();
                    cur.right = new TreeNode(treeVals.get(i+2));
                    i = i + 2;
                }
            }
        }
        return root;
    }

    private void mustHaveNextValue(int cap, int i) {
        if (cap == i) {
            throw new UnsupportedOperationException("supplied list is malformed, last element cannot be null");
        }
    }

    /**
     * @param treeVals should follow Pre-order Traversal algorithm (with null when no left child, e.g. {1,null,2})
     * @return the root node of the binary tree
     */
    @SuppressWarnings("AssignmentToForLoopParameter")
    public TreeNode binaryTreeFromPrOListWithNulls2(List<Integer> treeVals) {
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
            cur = getNextRootPreOrder(cur);
            if (cur == null) cur = root;
        }
        return root;
    }

    private TreeNode getNextRootPreOrder(TreeNode cur) {
        if (cur.left != null) return cur.left;
        if (cur.right != null) return cur.right;
        return null;
    }

    /*        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        }
    */

    /*
    * Runtime: 0 ms
    * Memory Usage: 37.4 MB
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> inorderValues = new ArrayList<>();
        traverseInorder(root, inorderValues);
        return inorderValues;
    }

    private void traverseInorder(TreeNode cur, List<Integer> inorderValues) {
        if (cur.left != null) traverseInorder(cur.left, inorderValues);
        inorderValues.add(cur.val);
        if (cur.right != null) traverseInorder(cur.right, inorderValues);
    }

    /*
     * Runtime: 0 ms
     * Memory Usage: 37.1 MB
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> preorderValues = new ArrayList<>();
        traversePreorder(root, preorderValues);
        return preorderValues;
    }

    private void traversePreorder(TreeNode cur, List<Integer> preorderValues) {
        preorderValues.add(cur.val);
        if (cur.left != null ) traversePreorder(cur.left, preorderValues);
        if (cur.right != null) traversePreorder(cur.right, preorderValues);
    }

    /*
     * Runtime: 0 ms
     * Memory Usage: 37.2 MB
     * */
    public List<Integer> preorderTraversal3(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }

    /*
    * Runtime: 0 ms
    * Memory Usage: 37.5 MB
    * */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer>  preorderValues = new ArrayList<>();
        HashMap<TreeNode, TreeNode> seen = new HashMap<>();
        seen.put(root,null);
        preorderValues.add(root.val);
        traversePreorder2(root, seen, preorderValues);
        return preorderValues;
    }

    private void traversePreorder2(TreeNode cur, HashMap<TreeNode, TreeNode> seen, List<Integer> preorderValues) {
        if (cur.left != null && !seen.containsKey(cur.left)) {
            preorderValues.add(cur.left.val);
            seen.put(cur.left,cur);
            traversePreorder2(cur.left, seen, preorderValues);
        }
        if (cur.right != null && !seen.containsKey(cur.right)) {
            preorderValues.add(cur.right.val);
            seen.put(cur.right,cur);
            traversePreorder2(cur.right, seen, preorderValues);
        }
        if (seen.get(cur) != null) traversePreorder2(seen.get(cur), seen, preorderValues);
    }


    public List<Integer> preorderTraversalWithNulls(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                result.add(cur.val);
                if (cur.right != null)
                    stack.push(cur.right);
                else
                    stack.push(null);
                if (cur.left != null)
                    stack.push(cur.left);
                else
                    stack.push(null);
            } else {
                result.add(null);
            }
        }

        return removeTrailingNulls(result);
    }

    private List<Integer> removeTrailingNulls(List<Integer> result) {
        while (result.get(result.size()-1) == null)
            result.remove(result.size()-1);
        return result;
    }

    public List<Integer>  preorderTraversalWithNulls2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer>  preorderValues = new ArrayList<>();
        HashMap<TreeNode, TreeNode> seen = new HashMap<>();
        seen.put(root,null);
        preorderValues.add(root.val);
        traversePOWithNulls(root, seen, preorderValues);
        return removeTrailingNulls(preorderValues);
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
