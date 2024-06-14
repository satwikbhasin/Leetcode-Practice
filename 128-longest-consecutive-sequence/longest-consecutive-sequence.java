class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

// O(n) Time, O(n) Space
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 0;

//         HashSet<Integer> nums_set = new HashSet<>();

//         for (int num : nums) {
//             nums_set.add(num);
//         }

//         int longestSeq = 0;
//         for (int num : nums) {
//             if (!nums_set.contains(num - 1)) {
//                 int currStreak = 1;
//                 int currNum = num;

//                 while (nums_set.contains(currNum + 1)) {
//                     currStreak++;
//                     currNum++;
//                 }

//                 longestSeq = Math.max(longestSeq, currStreak);

//             }
//         }

//         return longestSeq;
//     }
// }

// O(n * logn) Time, O(log n) Space
// class Solution {
// public int longestConsecutive(int[] nums) {
// if (nums == null || nums.length == 0)
// return 0;

// Arrays.sort(nums);

// int longestSeq = 1;
// int currStreak = 1;
// boolean streakStarted = false;
// for (int i = 1; i < nums.length; i++) {
// if (nums[i] != nums[i - 1]) { // handle duplicates
// boolean streakMaker = nums[i] - nums[i - 1] == 1 || nums[i] == nums[i - 1];
// if (streakMaker && !streakStarted) { // start streak
// streakStarted = true;
// currStreak = 2;
// } else if (streakMaker && streakStarted) { // streak going on
// currStreak++;
// } else if (!streakMaker && streakStarted) { // break streak
// longestSeq = Math.max(longestSeq, currStreak);
// streakStarted = false;
// currStreak = 1;
// }
// }
// }

// longestSeq = Math.max(longestSeq, currStreak);

// return longestSeq;
// }
// }