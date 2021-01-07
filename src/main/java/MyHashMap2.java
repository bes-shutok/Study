/*
        All keys and values will be in the range of [0, 1000000].
        The number of operations will be in the range of [1, 10000].
        Please do not use the built-in HashMap library.
*/

class MyHashMap2 {

    int numberOfBuckets, maxCapacity;
    int[][][] keyValues;
    int[] cap;

    /** Initialize your data structure here. */
    public MyHashMap2() {
        numberOfBuckets = 100; // number of buckets
        maxCapacity = 10_000; // max number of natural numbers in each bucket
        keyValues = new int[numberOfBuckets][maxCapacity][2];
        cap = new int[numberOfBuckets];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = calculateHash(key);
        int i = findIndexInBucket(key, bucket);
        if (i == -1) {
            keyValues[bucket][cap[bucket]][0] = key;
            keyValues[bucket][cap[bucket]++][1] = value;
        } else keyValues[bucket][i][1] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = calculateHash(key);
        int result = findIndexInBucket(key, bucket);
        if (result >= 0) result = keyValues[bucket][result][1];
        return result;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = calculateHash(key);
        int i = findIndexInBucket(key, bucket);
        if (i >= 0) {
            while (i < (cap[bucket] - 1)) {
                keyValues[bucket][i][0] = keyValues[bucket][i+1][0];
                keyValues[bucket][i][1] = keyValues[bucket][i+1][1];
                i++;
            }
            cap[bucket]--;
        }
    }

    private int findIndexInBucket(int key, int bucket) {
        for (int i = 0; i < cap[bucket]; i++) {
            if (keyValues[bucket][i][0] == key) return i;
        }
        return -1;
    }

    private int calculateHash(int key) {
        return key % numberOfBuckets;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */