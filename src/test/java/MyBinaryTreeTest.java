import org.testng.annotations.DataProvider;
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
    private Object[][] binaryTriesFromPreorderTraversalListWithNulls() {

        return new Object[][]{
                {
                        t.binaryTreeFromPrOListWithNulls(new ArrayList<>()),
                        new ArrayList<>()
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Collections.singletonList(3)),
                        Collections.singletonList(3)
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, 2)),
                        Arrays.asList(1, 2)
                        /*
                        *   1
                        *  /
                        * 2
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4)),
                        Arrays.asList(1, null, 2, 3, null, 4)
                        /*
                        *    1
                        *     \
                        *      2
                        *     /
                        *    3
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, 2, 3, null, 4, null, null, 5)),
                        Arrays.asList(1, 2, 3, null, 4, null, null, 5)
                        /*
                        *       1
                        *      /
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4, null, null,5)),
                        Arrays.asList(1, null, 2, 3, null, 4, null, null, 5)
                        /*
                        *    1
                        *     \
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },
        };
    }

    @Test(dataProvider = "binaryTriesFromPreorderTraversalListWithNulls")
    public void testCreateBinaryTreeFromPreorderTraversalListWithNulls(MyBinaryTree.TreeNode root, List<Integer> expected) {
        List<Integer>  actual = t.preorderTraversalWithNulls(root);
        assertEquals(actual,expected);
    }

    @DataProvider
    private Object[][] binaryTriesFromPreorderTraversalWithNulls() {

        return new Object[][]{
                {
                        t.binaryTreeFromPrOListWithNulls(new ArrayList<>()),
                        new ArrayList<>()
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Collections.singletonList(3)),
                        Collections.singletonList(3)
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, 2)),
                        Arrays.asList(1, 2)
                        /*
                        *   1
                        *  /
                        * 2
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4)),
                        Arrays.asList(1, 2, 3, 4)
                        /*
                        *    1
                        *     \
                        *      2
                        *     /
                        *    3
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, 2, 3, null, 4, null, null, 5)),
                        Arrays.asList(1, 2, 3, 4, 5)
                        /*
                        *       1
                        *      /
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4, null, null, 5)),
                        Arrays.asList(1, 2, 3, 4, 5)
                        /*
                        *    1
                        *     \
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },
        };
    }

    @Test(dataProvider = "binaryTriesFromPreorderTraversalWithNulls")
    public void testPreorderTraversal(MyBinaryTree.TreeNode root, List<Integer> expected) {
        List<Integer>  actual = t.preorderTraversal(root);
        assertEquals(actual,expected);
    }


    @DataProvider
    private Object[][] binaryTriesFromInorderTraversalWithNulls() {

        return new Object[][]{
                {
                        t.binaryTreeFromPrOListWithNulls(new ArrayList<>()),
                        new ArrayList<>()
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Collections.singletonList(3)),
                        Collections.singletonList(3)
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1,2)),
                        Arrays.asList(2,1)
                        /*
                        *   1
                        *  /
                        * 2
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4)),
                        Arrays.asList(1,3,4,2)
                        /*
                        *    1
                        *     \
                        *      2
                        *     /
                        *    3
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, 2, 3, null, 4, null, null, 5)),
                        Arrays.asList(3,4,2,5,1)
                        /*
                        *       1
                        *      /
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },
                {
                        t.binaryTreeFromPrOListWithNulls(Arrays.asList(1, null, 2, 3, null, 4, null, null, 5)),
                        Arrays.asList(1,3,4,2,5)
                        /*
                        *    1
                        *     \
                        *      2
                        *     / \
                        *    3   5
                        *     \
                        *      4
                        *
                        * */
                },

        };
    }

    @Test(dataProvider = "binaryTriesFromInorderTraversalWithNulls")
    public void testInorderTraversal(MyBinaryTree.TreeNode root, List<Integer> expected) {
        List<Integer>  actual = t.inorderTraversal(root);
        assertEquals(actual,expected);
    }
}