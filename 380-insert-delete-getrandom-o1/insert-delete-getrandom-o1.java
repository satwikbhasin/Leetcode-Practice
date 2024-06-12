class RandomizedSet {
    Set<Integer> set;
    Random random;

    // O(1)
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.random = new Random();
    }

    // O(1)
    public boolean insert(int val) {
        if (this.set.contains(val)) {
            return false;
        } else {
            this.set.add(val);
            return true;
        }
    }

    // O(1)
    public boolean remove(int val) {
        if (this.set.contains(val)) {
            this.set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    // O(n)
    public int getRandom() {
        int randomIndexInSet = this.random.nextInt(this.set.size());
        int index = 0;
        for (int element : this.set) {
            if (index == randomIndexInSet) {
                return element;
            }
            index++;
        }

        return Integer.MIN_VALUE;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */