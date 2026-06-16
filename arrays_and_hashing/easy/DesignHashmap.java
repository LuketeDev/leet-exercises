package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.List;

public class DesignHashmap {
    // Inserts and reads in O(1) time
    class MyHashMap {
        class Node {
            int key;
            int value;

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        static final int BASE = 769;
        List<List<Node>> buckets;

        public MyHashMap() {
            buckets = new ArrayList<>(BASE);
            for (int i = 0; i < BASE; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        private int hash(int key) {
            // see DesignHashset
            return (key & 0x7FFFFFFF) % BASE;
        }

        public void put(int key, int value) {
            int index = hash(key);
            List<Node> bucket = buckets.get(index);
            for (Node node : bucket) {
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
            }
            bucket.add(new Node(key, value));
        }

        public int get(int key) {
            int index = hash(key);
            List<Node> bucket = buckets.get(index);
            for (Node node : bucket) {
                if (node.getKey() == key) {
                    return node.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            List<Node> bucket = buckets.get(index);
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).getKey() == key) {
                    bucket.remove(i);
                    return;
                }
            }
        }
    }

}
