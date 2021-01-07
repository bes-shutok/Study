import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HashSetFunctionsTest {

    int[] nums1, nums2, result;
    HashSetFunctions f = new HashSetFunctions();

    @Ignore
    @Test
    public void testIntersection() {
        nums1 = new int[] {1,2,2,1};
        nums2 = new int[] {2,2};
        result = new int[] {2};

        Assert.assertEquals(f.intersection4(nums1,nums2),result);
    }

    @Test
    public void testHappyNumber() {
        Assert.assertTrue(f.isHappy2(19));
        Assert.assertFalse(f.isHappy2(2));
        Assert.assertTrue(f.isHappy2(7));
    }
}