class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        for (int n : nums) {
            elementCount.put(n, elementCount.getOrDefault(n, 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        int maxElement = -1;
        for (Map.Entry<Integer, Integer> element : elementCount.entrySet()) {
            if (element.getValue() > maxValue) {
                maxValue = element.getValue();
                maxElement = element.getKey();
            }
        }

        return maxElement;
    }
}