package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashset {
    // Solution 1 with O(n) time, not how a hashset should be
    class _MyHashSet {
        List<Integer> values;

        public _MyHashSet() {
            this.values = new ArrayList<>();
        }

        public void add(int key) {
            if (values.stream().noneMatch(i -> i == key))
                values.add(key);

        }

        public void remove(int key) {
            values.remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            return values.contains(key);
        }
    }

    // Solution 2 using buckets containing small lists for roughly O(1) time
    class MyHashSet {
        static final int BASE = 769;
        List<List<Integer>> buckets;

        public MyHashSet() {
            buckets = new ArrayList<>(BASE);
            for (int i = 0; i < BASE; i++) {
                buckets.add(new LinkedList<>());
            }
        }

        private int hash(int key) {
            // Math.abs(key) may fail with Integer.MIN_VALUE, so we use bitwise AND.
            // '& 0x7FFFFFFF' removes sign bit, making hash always positive
            return (key & 0x7FFFFFFF) % BASE;
        }

        public void add(int key) {
            int index = hash(key);
            List<Integer> bucket = buckets.get(index);
            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            int index = hash(key);
            List<Integer> bucket = buckets.get(index);
            bucket.remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int index = hash(key);
            List<Integer> bucket = buckets.get(index);
            return bucket.contains(key);
        }
    }
}
