import java.util.*;

public class HashTableFunctions {

    /*
    * Runtime: 3 ms
    * Memory Usage: 43.1 MB
    * */
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) return false;
        char[] hLine = new char[9];
        for (int i = 0; i < 9; i++) {
            if (board[i].length != 9 || !isValideLine(board[i],0,9)) return false;
            for (int j = 0; j < 9; j++) {
                hLine[j] = board[j][i];
            }
            if (!isValideLine(hLine,0,9)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!validateSquare(board,i*3,j*3,3)) return false;
            }
        }
        return true;
    }

    private boolean validateSquare(char[][] board, int xStartIdx, int yStartIdx, int squareLength) {
        List<Character> numbers = new ArrayList<>();
        for (int i = xStartIdx; i < xStartIdx + squareLength; i++) {
            for (int j = yStartIdx; j < yStartIdx+squareLength; j++) {
                char aChar = board[i][j];
                if (aChar != '.') {
                    if (numbers.contains(aChar))
                        return false;
                    else
                        numbers.add(aChar);
                }
            }
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isValideLine(char[] chars, int startIdx, int lineLength) {
        List<Character> numbers = new ArrayList<>();
        for (int i = startIdx; i < lineLength; i++) {
            char aChar = chars[i];
            if (aChar != '.') {
                if (numbers.contains(aChar))
                    return false;
                else
                    numbers.add(aChar);
            }
        }
        return true;
    }

    /*
    * Runtime: 7 ms
    * Memory Usage: 43.5 MB
    * */
    public boolean isValidSudoku2(char[][] board) {
        if (board.length != 9) return false;
        Map<Integer, Integer> boardMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            if (board[i].length != 9) return false;
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.')
                    boardMap.put(i*9 + j, Character.getNumericValue(c));
            }
        }
        return validateBoard(boardMap);
    }


    @SuppressWarnings("ConfusingElseBranch")
    private boolean validateBoard(Map<Integer, Integer> boardMap) {
        Map<Integer, List<Integer>> mapOfLists = new HashMap<>();
        for (int i = 0; i <= 10; i++) {
            mapOfLists.put(i, new ArrayList<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (boardMap.containsKey(i * 9 + j)) {
                    Integer val = boardMap.get(i * 9 + j);
                    if (mapOfLists.get(9).contains(val))
                        return false;
                    else
                        mapOfLists.get(9).add(val);
                    if (mapOfLists.get(i / 3 + (j / 3) * 3).contains(val))
                        return false;
                    else
                        mapOfLists.get(i / 3 + (j / 3) * 3).add(val);
                }
                if (boardMap.containsKey(i + j * 9)) {
                    Integer val = boardMap.get(i + j * 9);
                    if (mapOfLists.get(10).contains(val))
                        return false;
                    else
                        mapOfLists.get(10).add(val);
                }
            }
            mapOfLists.get(9).clear();
            mapOfLists.get(10).clear();
        }
        return true;
    }

    /*
     * Runtime: 5 ms
     * Memory Usage: 41.6 MB
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<String> anagramList;
        for (String s : strs) {
            String hash = hash(s);
            if (!anagramMap.containsKey(hash))
                anagramList = new ArrayList<>();
            else
                anagramList = anagramMap.get(hash);
            anagramList.add(s);
            anagramMap.put(hash, anagramList);
        }
        return new ArrayList<>(anagramMap.values());
    }

    private String hash(String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        return String.valueOf(sorted);
    }

    /*
     * Runtime: 5 ms
     * Memory Usage: 44.4 MB
     * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int min = k + 1;
        Map<Integer, Integer> numsMapped = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numsMapped.containsKey(num)) {
                int diff = i - numsMapped.get(num);
                if (min > diff) min = diff;
            }
            numsMapped.put(num, i);
        }
        return min <= k;
    }

    public int[] intersectSorted(int[] nums1, int[] nums2) {
        List<Integer> sortedList = new ArrayList<>();
        int k = 0, j = 0;
        while (k < nums1.length && j < nums2.length) {
            int i1 = nums1[k];
            int i2 = nums2[j];
            if (i1 == i2) {
                sortedList.add(i1);
                k++;
                j++;
            } else if (i1 < i2) k++;
            else j++;
        }
        if (sortedList.isEmpty()) //noinspection ZeroLengthArrayAllocation
            return new int[]{};
        int[] intersectionArray = new int[sortedList.size()];
        for (int i = 0; i < intersectionArray.length; i++) {
            intersectionArray[i] = sortedList.get(i);
        }
        return intersectionArray;
    }

    /*
     * Runtime: 2 ms
     * Memory Usage: 38.9 MB
     * */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> mapNums2 = new HashMap<>();
        List<Integer> intersectionList = new ArrayList<>();
        for (int x : nums2) {
            if (mapNums2.containsKey(x))
                mapNums2.put(x, mapNums2.get(x) + 1);
            else
                mapNums2.put(x, 1);
        }
        for (int x : nums1) {
            if (mapNums2.containsKey(x)) {
                intersectionList.add(x);
                int count = mapNums2.get(x);
                if (count == 1)
                    mapNums2.remove(x);
                else
                    mapNums2.put(x, --count);
            }
        }
        int[] intersectionArray = new int[intersectionList.size()];
        for (int i = 0; i < intersectionArray.length; i++) {
            intersectionArray[i] = intersectionList.get(i);
        }
        return intersectionArray;
    }


    /*
     * Runtime: 15 ms
     * Memory Usage: 39.9 MB
     * */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charIndices = new HashMap<>();
        ArrayList<Character> uniqueChars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charIndices.containsKey(c)) {
                charIndices.put(c, i);
                uniqueChars.add(c);
            } else {
                int idx = uniqueChars.indexOf(c);
                if (idx >= 0) uniqueChars.remove(idx);
            }
        }
        if (!uniqueChars.isEmpty()) return charIndices.get(uniqueChars.get(0));
        return -1;
    }

    /*
     * Runtime: 14 ms
     * Memory Usage: 39.4 MB
     * */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> charIndices = new HashMap<>();
        ArrayList<Character> uniqueChars = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!charIndices.containsKey(c)) {
                charIndices.put(chars[i], i);
                uniqueChars.add(c);
            } else {
                int idx = uniqueChars.indexOf(c);
                if (idx >= 0) uniqueChars.remove(idx);
            }
        }
        if (!uniqueChars.isEmpty()) return charIndices.get(uniqueChars.get(0));
        return -1;
    }

    /*
     * Runtime: 18 ms
     * Memory Usage: 39.7 MB
     * */
    public int firstUniqChar3(String s) {
        Map<Character, Integer> charIndices = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!charIndices.containsKey(c)) {
                charIndices.put(chars[i], i);
            } else charIndices.put(chars[i], -1);
        }
        for (char c : charIndices.keySet()) {
            int idx = charIndices.get(c);
            if (idx >= 0) return idx;
        }
        return -1;
    }

    /*
     * Runtime: 0 ms
     * Memory Usage: 39.4 MB
     * */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) return new int[]{map.get(num), i};
            map.put(nums[i], i);
        }
        //noinspection ZeroLengthArrayAllocation
        return new int[]{};
    }

    /*
     * Runtime: 88 ms
     * Memory Usage: 39.1 MB
     * */
    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> commonRestaurants = new LinkedHashMap<>();
        List<String> cr = new ArrayList<>();
        int min = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            for (int j = 0; j < list1.length; j++) {
                if (s.equals(list1[j])) {
                    int sum = i + j;
                    if (sum < min) min = sum;
                    commonRestaurants.put(s, sum);
                }
            }
        }
        for (String s : commonRestaurants.keySet()) {
            if (commonRestaurants.get(s) == min) cr.add(s);
        }
        //noinspection ZeroLengthArrayAllocation
        return cr.toArray(new String[]{});
    }

    /*
     * Runtime: 84 ms
     * Memory Usage: 39.6 MB
     * */
    public String[] findRestaurant3(String[] list1, String[] list2) {
        ArrayList<String> list = new ArrayList<>();
        Map<Integer, ArrayList<String>> commonRestaurants = new HashMap<>();
        int min = list1.length + list2.length - 2;
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            for (int j = 0; j < list1.length; j++) {
                if (s.equals(list1[j])) {
                    int sum = i + j;
                    if (sum < min) min = sum;
                    list = commonRestaurants.containsKey(sum) ? commonRestaurants.get(sum) : new ArrayList<>();
                    list.add(s);
                    commonRestaurants.put(sum, list);
                }
            }
        }
        //noinspection ZeroLengthArrayAllocation
        return commonRestaurants.get(min).toArray(new String[]{});
    }

    /*
     * Runtime: 4 ms
     * Memory Usage: 39.6 MB
     * */
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) return findRestaurant(list2, list1);

        HashMap<String, Integer> list1OrderedMap = new HashMap<>();
        for (int j = 0; j < list1.length; j++) list1OrderedMap.put(list1[j], j);

        int min = list1.length + list2.length - 2;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < list2.length && i <= min; i++) {
            String s = list2[i];
            if (!list1OrderedMap.containsKey(s)) continue;

            int sum = i + list1OrderedMap.get(s);
            if (sum > min) continue;

            if (sum < min) {
                list.clear();
                min = sum;
            }
            list.add(s);
        }
        //noinspection ToArrayCallWithZeroLengthArrayArgument
        return list.toArray(new String[list.size()]);
    }

    /*
     * Runtime: 4 ms
     * Memory Usage: 39 MB
     *
     * */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] charS = s.toCharArray(), charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) map.put(charS[i], charT[i]);

        if (new HashSet<>(map.values()).size() < map.size()) return false;

        for (int i = 0; i < charS.length; i++) charS[i] = map.get(charS[i]);
        return Arrays.equals(charS, charT);
    }

    /*
     * Runtime: 6 ms
     * Memory Usage: 38.8 MB
     *
     * */
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))) return false;
            map.put(s.charAt(i), t.charAt(i));
        }
        for (int i = 0; i < chars.length; i++) chars[i] = map.get(chars[i]);
        return String.valueOf(chars).equals(t);
    }

    /*
     * Runtime: 23 ms
     * Memory Usage: 45.4 MB
     *
     * */
    public boolean isIsomorphic3(String s, String t) {
        HashMap<Integer, Integer> mapS = new HashMap<>();
        HashMap<Integer, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(i, s.indexOf(s.charAt(i), i + 1));
            mapT.put(i, t.indexOf(t.charAt(i), i + 1));
        }
        return mapS.equals(mapT);
    }

    /*
     * Runtime: 13 ms
     * Memory Usage: 39 MB
     *
     * */
    public boolean isIsomorphic4(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i), i + 1) != t.indexOf(t.charAt(i), i + 1)) return false;
        }
        return true;
    }

}
