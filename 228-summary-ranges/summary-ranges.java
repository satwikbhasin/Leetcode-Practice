class Solution {
    private void addRangeToSolution(int start, int end, List<String> sol) {
        StringBuilder range = new StringBuilder();
        range.append(start);
        if (start != end) {
            range.append("->");
            range.append(end);
        }
        sol.add(range.toString());
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> sol = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return sol;

        int rangeStart = nums[0];
        int rangeEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                rangeEnd = nums[i];
            } else {
                addRangeToSolution(rangeStart, rangeEnd, sol);
                rangeStart = nums[i];
                rangeEnd = nums[i];
            }
        }

        addRangeToSolution(rangeStart, rangeEnd, sol);

        return sol;

    }
}