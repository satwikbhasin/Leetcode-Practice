class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> indexes = map.get(nums[i]);
                for (int index : indexes) {
                    if(Math.abs(index - i) <= k) return true;
                }
                map.get(nums[i]).add(i);
            } else {
                map.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            }
        }

        return false;
    }
}