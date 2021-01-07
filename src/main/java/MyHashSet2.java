import java.util.Arrays;
import java.util.List;

/*Runtime: 16 ms
Memory Usage: 51 MB*/
class MyHashSet2 {
    List<Integer> list;

int numberOfBuckets, maxCapacity;
int[][] values;
int[] cap;

public static void main(String[] args) {
    MyHashSet2 hashSet = new MyHashSet2();
    hashSet.add(1);
    hashSet.add(2);
    System.out.println(hashSet.toString());
    System.out.println("Should be true: " + hashSet.contains(1));    // returns true
    System.out.println("Should be false: " + hashSet.contains(3));    // returns false (not found)
    hashSet.add(2);
    System.out.println("Should be true: " + hashSet.contains(2));    // returns true
    hashSet.remove(2);
    System.out.println("Should be false: " + hashSet.contains(2));    // returns false (already removed)
    System.out.println(hashSet.toString());
}

/** Initialize your data structure here. */
public MyHashSet2() {
    numberOfBuckets = 100;
    maxCapacity = 10_000;
    values = new int[numberOfBuckets][maxCapacity];
    cap = new int[numberOfBuckets];
}

public void add(int key) {
    int bucket = calculateHash(key);
    int i = searchBucket(key, bucket);
    if (i == -1) values[bucket][cap[bucket]++] = key;
}

public void remove(int key) {
    int bucket = calculateHash(key);
    int i = searchBucket(key, bucket);
    if (i >= 0) {
        while (i + 1 < cap[bucket]) {
            values[bucket][i] = values[bucket][i+1];
            i++;
        }
        cap[bucket]--;
    }
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    int bucket = calculateHash(key);
    int result = searchBucket(key, bucket);
    return result >= 0;
}

@Override
public String toString() {
    return "MyHashSet{" +
            "hashValue=" + numberOfBuckets +
//                ", values=" + Arrays.toString(values) +
            ", cap=" + Arrays.toString(cap) +
            '}';
}

private int searchBucket(int key, int bucket) {
    for (int i = 0; i < cap[bucket]; i++) {
        if (values[bucket][i] == key) return i;
    }
    return -1;
}

private int calculateHash(int key) {
    return key % numberOfBuckets;
}

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */