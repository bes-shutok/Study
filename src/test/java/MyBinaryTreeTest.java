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
    private Object[][] binaryTriesFromPreOrderTraversalListWithNulls() {

        return new Object[][]{
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(new ArrayList<>()),
                        new ArrayList<>()
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Collections.singletonList(3)),
                        Collections.singletonList(3)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,2)),
                        Arrays.asList(1,2)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,null,2,3,null,4)),
                        Arrays.asList(1,null,2,3,null,4)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,2,3,null,4,null,null, 5)),
                        Arrays.asList(1,2,3,null,4,null,null, 5)
                },
        };
    }

    //@Ignore
    @Test(dataProvider = "binaryTriesFromPreOrderTraversalListWithNulls")
    public void testCreateBinaryTreeFromPreOrderTraversalListWithNulls(MyBinaryTree.TreeNode root, List<Integer> expected) {
        List<Integer>  actual = t.preOrderTraversalWithNulls(root);
        assertEquals(actual,expected);
    }

    @DataProvider
    private Object[][] binaryTriesFromPreOrderTraversalWithNulls() {

        return new Object[][]{
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(new ArrayList<>()),
                        new ArrayList<>()
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Collections.singletonList(3)),
                        Collections.singletonList(3)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,2)),
                        Arrays.asList(1,2)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,null,2,3,null,4)),
                        Arrays.asList(1,2,3,4)
                },
                {
                        t.createBinaryTreeFromPreOrderTraversalListWithNulls(Arrays.asList(1,null,2,3,null,4,null,null, 5)),
                        Arrays.asList(1,2,3,4,5)
                },
        };
    }

    //@Ignore
    @Test(dataProvider = "binaryTriesFromPreOrderTraversalWithNulls")
    public void testPreOrderTraversal(MyBinaryTree.TreeNode root, List<Integer> expected) {
        List<Integer>  actual = t.preOrderTraversal(root);
        assertEquals(actual,expected);
    }

}