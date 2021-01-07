import org.testng.annotations.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyHashMapTest {

    private MyHashMap map;

    private void createMapWithManyKV(int kvNumber) {
        for (int i = 0; i < kvNumber; i++) {
            map.put(i,i);
        }
    }

    private void notFound(int i) {
        assertEquals(map.get(i), -1);
    }

    @Test
    void simpleMapTest() {
        map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(map.get(1), 1);
        notFound(3);

        map.put(2, 1);          // update the existing value
        assertEquals(map.get(2), 1);

        map.remove(2);          // remove the mapping for 2
        notFound(2);            // returns -1 (not found)
    }

    @Test
    void canPutLotsOfValuesAnfGetThemBack() {
        map = new MyHashMap();
        int kvNumber = 1000;
        createMapWithManyKV(kvNumber);
        for (int i = 0; i < kvNumber; i++) {
            assertEquals(map.get(i),i);
        }
    }

}
