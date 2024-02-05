public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutive(answerKey, 'T', k), maxConsecutive(answerKey, 'F', k));
    }

    private int maxConsecutive(String answerKey, char target, int k) {
        int[] prefixSum = new int[answerKey.length()];
        int count = 0;

        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == target) {
                count++;
            }
            prefixSum[i] = count;
        }

        int result = 0;
        for(int i = 0; i < answerKey.length(); i++){
            System.out.println("For " + answerKey.charAt(i));
            int left = i;
            int right = prefixSum.length-1;
            int sol = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (((mid - i + 1) - ((prefixSum[mid] - prefixSum[i] + (answerKey.charAt(i) == target ? 1 : 0)))) <= k) {
                sol = mid - i + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result = Math.max(result, sol);
    }
    return result;
    }
}
