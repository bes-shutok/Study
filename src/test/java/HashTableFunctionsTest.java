import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class HashTableFunctionsTest {

    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }

    }

    HashTableFunctions f = new HashTableFunctions();

    @Ignore
    @Test
    void twoSumsTest() {
        int[] nums, result;
        int target;
        nums = new int[]{3, 3};
        result = new int[]{0, 1};
        target = 6;
        Assert.assertEquals(f.twoSum(nums, target), result);

        nums = new int[]{3, 2, 4};
        result = new int[]{1, 2};
        target = 6;
        Assert.assertEquals(f.twoSum(nums, target), result);

        nums = new int[]{2, 7, 11, 15};
        result = new int[]{0, 1};
        target = 9;
        Assert.assertEquals(f.twoSum(nums, target), result);
    }

    @Ignore
    @Test
    void isIsomorphicTest() {
        assertTrue(f.isIsomorphic("egg", "add"));
        assertFalse(f.isIsomorphic("foo", "bar"));
        assertTrue(f.isIsomorphic("paper", "title"));
        assertFalse(f.isIsomorphic("ab", "aa"));
    }


    @DataProvider
    private Object[][] restaurants() {
        return new Object[][]{
                {
                        new String[]{"KFC"},
                        new String[]{"KFC"},
                        new String[]{"KFC"}
                },
                {
                        new String[]{"KFC", "test"},
                        new String[]{"KFC"},
                        new String[]{"KFC"}
                },
                {
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"}
                },
                {
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KNN", "KFC", "Burger King", "Tapioca Express", "Shogun"},
                        new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"}
                },
        };
    }

    @Ignore
    @Test(dataProvider = "restaurants")
    public void testFindRestaurant(String[] list1, String[] list2, String[] result) {
        assertEquals(f.findRestaurant(list1, list2), result);
    }


    @DataProvider
    private Object[] stringProvider() {
        return new Object[][]{
                {"test", 1},
                {"leetcode", 0}
        };
    }

    @Ignore
    @Test(dataProvider = "stringProvider")
    public void testFirstUniqChar(String string, int idx) {
        assertEquals(f.firstUniqChar(string), idx);
    }

    @DataProvider
    private Object[][] arraysToIntersect() {
        return new Object[][]{
                {
                        new int[]{2, 2, 3},
                        new int[]{2, 2},
                        new int[]{2, 2}
                },
                {
                        new int[]{2, 2, 3},
                        new int[]{2},
                        new int[]{2}
                },
                {
                        new int[]{2},
                        new int[]{2, 2, 3},
                        new int[]{2}
                },
                {
                        new int[]{0, 2, 3, 5},
                        new int[]{0, 3, 5},
                        new int[]{0, 3, 5},
                },
                {
                        new int[]{0, 2, 3, 5},
                        new int[]{0, 3, 5},
                        new int[]{5, 3, 0}
                },
        };
    }

    @Ignore
    @Test(dataProvider = "arraysToIntersect")
    public void testIntersect(int[] arr1, int[] arr2, int[] result) {
        Arrays.sort(result);
        int[] actual = f.intersect(arr1, arr2);
        Arrays.sort(actual);
        assertEquals(actual, result);
    }

    @Ignore
    @Test(dataProvider = "arraysToIntersect")
    public void testIntersectSorted(int[] arr1, int[] arr2, int[] result) {
        Arrays.sort(result);
        int[] actual = f.intersectSorted(arr1, arr2);
        assertEquals(actual, result);
    }

    @DataProvider
    private Object[][] nearbyDuplicatesData() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3, 1},
                        3,
                        true
                },
                {
                        new int[]{1, 2, 3, 1, 2, 3},
                        2,
                        false
                },
        };
    }

    @Ignore
    @Test(dataProvider = "nearbyDuplicatesData")
    public void testContainsNearbyDuplicate(int[] arr, int k, boolean result) {
        assertEquals(f.containsNearbyDuplicate(arr, k), result);
    }

    @DataProvider
    private Object[][] stringsForAnagram() {
        String[] arr1 = new String[] {"a"};
        List<String> list1 = Arrays.asList(arr1);
        List<List<String>> listOfLists1 = new ArrayList<>();
        listOfLists1.add(list1);

        return new Object[][] {
                {
                        new String[] {"a"},listOfLists1
                },
                {
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        Lists.newArrayList(
                                Lists.newArrayList("ate", "eat", "tea"),
                                Lists.newArrayList("bat"),
                                Lists.newArrayList("nat", "tan")
                        )
                }
                ,
                {
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        Lists.newArrayList(
                                Lists.newArrayList("eat", "tea", "ate"),
                                Lists.newArrayList("bat"),
                                Lists.newArrayList("nat", "tan")
                        )
                }
                ,
                {
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        Lists.newArrayList(
                                Lists.newArrayList("bat"),
                                Lists.newArrayList("eat", "tea", "ate"),
                                Lists.newArrayList("nat", "tan")
                        )
                }
        };
    }
    @Ignore
    @Test(dataProvider = "stringsForAnagram")
    public void testGroupAnagrams(String[] str, List<List<String>> result) {
        Arrays.sort(str);
        for (List<String> strings : result) {
            Collections.sort(strings);
        }
        Collections.sort(result, new ListComparator<>());
        List<List<String>> actual = f.groupAnagrams(str);
        for (List<String> strings : actual) {
            Collections.sort(strings);
        }
        Collections.sort(actual, new ListComparator<>());
        assertEquals(actual, result);
    }

    @DataProvider
    Object[][] sudokuVariants() {
        return new Object[][] {
                {
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        true
                },
                {
                        new char[][]{
                                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                },
                {
                        new char[][]{
                                {'5', '3', '.', '.', '8', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                },
                {
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '5', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                },
        };
    }

    @Test(dataProvider = "sudokuVariants")
    public void testIsValidSudoku(char[][] board, boolean valid) {
        assertEquals(f.isValidSudoku(board), valid);
    }

}