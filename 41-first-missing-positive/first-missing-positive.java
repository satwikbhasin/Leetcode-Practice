class Solution {
    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        if (set.size() == 0)
            return 1;

        int missingPositive = 1;

        if (set.first() > 1) {
            return 1;
        }

        for (int num : set) {
            if (num != missingPositive) {
                return missingPositive;
            }
            missingPositive++;
        }

        return missingPositive;
    }
}