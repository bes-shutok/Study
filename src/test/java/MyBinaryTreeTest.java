import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class MyBinaryTreeTest {

    MyBinaryTree t = new MyBinaryTree();


    @DataProvider
    private Object[] creatTreeData() {
        return new Object[]{
                new ArrayList<Integer>(),
                Collections.singletonList(3),
                //Arrays.asList(1,null,2,3),
                Arrays.asList(1,2),
                //Arrays.asList(1,null,2,3,null,4),
        };
    }

    @SuppressWarnings("fallthrough")
    @Test(dataProvider = "creatTreeData")
    public void testCreateTree(List<Integer> inputVals) {
        MyBinaryTree.TreeNode root = t.createBinaryTree(inputVals);
        if (inputVals.isEmpty())
            assertNull(root);
        else {
            if (inputVals.size() > 3 ) throw new UnsupportedOperationException();
            switch (inputVals.size()) {
                case 3:
                    assertEquals(root.right == null ? null : root.right.val, inputVals.get(2));
                case 2:
                    assertEquals(root.left == null ? null : root.left.val, inputVals.get(1));
                default:
                    assertEquals((Integer) root.val, inputVals.get(0));
            }
        }
    }

    @DataProvider
    private Object[][] binaryTies() {

        List<Integer> list1 = Arrays.asList(1,null,2,3);
        //Arrays.asList(1,null,2,3,null,4),


        return new Object[][]{
/*                {
                        null,
                        new ArrayList<Integer>()
                },
                {
                        t.new TreeNode(3),
                        Arrays.asList(3)
                },
                {
                        t.new TreeNode(1,t.new TreeNode(2),null),
                        Arrays.asList(1,2)
                },*/
                {
                        t.createBinaryTree(Arrays.asList(1,null,2,3,null,4)),
                        Arrays.asList(1,null,2,3,null,4)
                },
        };
    }

    @Ignore
    @Test(dataProvider = "binaryTies")
    public void testPreorderTraversal(MyBinaryTree.TreeNode root, List<Integer> expected) {
        assertEquals(t.preorderTraversal(root),expected);
    }
}