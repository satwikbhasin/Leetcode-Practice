class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> sol = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return sol;

        int rangeStart = nums[0];
        int rangeEnd = nums[0];
        StringBuilder range = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                rangeEnd = nums[i];
            } else {
                range.append(rangeStart);
                if (rangeStart < rangeEnd) {
                    range.append("->");
                    range.append(rangeEnd);
                }
                sol.add(range.toString());
                range.setLength(0);
                rangeStart = nums[i];
                rangeEnd = nums[i];
            }
        }

        if (rangeStart == rangeEnd) {
            range.append(rangeStart);
            sol.add(range.toString());
        } else {
            range.append(rangeStart);
            if (rangeStart < rangeEnd) {
                range.append("->");
                range.append(rangeEnd);
            }
            sol.add(range.toString());
        }

        return sol;

    }
}