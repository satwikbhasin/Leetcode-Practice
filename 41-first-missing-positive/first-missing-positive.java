// O(n) Time, O(1) Space
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
}

// O(n) Time, O(n) Space
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         boolean[] seen = new boolean[nums.length + 1];

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0 && nums[i] <= nums.length) {
//                 seen[nums[i]] = true;
//             }
//         }

//         for (int i = 1; i < seen.length; i++) {
//             if (!seen[i])
//                 return i;
//         }

//         return nums.length + 1;
//     }
// }