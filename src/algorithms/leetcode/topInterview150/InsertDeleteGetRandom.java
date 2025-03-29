package algorithms.leetcode.topInterview150;

import java.util.*;

public class InsertDeleteGetRandom {

    /*
    Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
    false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present,
    false otherwise.
    int getRandom() Returns a random element from the current set of elements
    (it's guaranteed that at least one element exists when this method is called).
    Each element must have the same probability of being returned.
    You must implement the functions of the class such that each function works in average O(1) time complexity.
     */


    private final Map<Integer, Integer> randomMap;
    private final List<Integer> randomList;
    private final Random random;


    public static void main(String[] args) {
        InsertDeleteGetRandom randomizedSet = new InsertDeleteGetRandom();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }

    public InsertDeleteGetRandom() {
        this.randomList = new ArrayList<>();
        this.randomMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (!this.randomMap.containsKey(val)) {
            this.randomList.add(val);
            this.randomMap.put(val, this.randomList.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!this.randomMap.containsKey(val)) {
            return false;
        }
        int indexOfElement = this.randomMap.get(val);
        int lastElement = this.randomList.get(this.randomList.size() - 1);
        this.randomList.set(indexOfElement, lastElement);
        this.randomMap.put(lastElement, indexOfElement);
        this.randomList.removeLast();
        this.randomMap.remove(val);

        return true;
    }

    public int getRandom() {
        int index = this.random.nextInt(this.randomList.size());
        return this.randomList.get(index);
    }
}
