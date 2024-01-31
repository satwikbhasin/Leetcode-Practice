class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            int flag = -1;
            int left = 0;
            int right = arr2.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (Math.abs(arr1[i] - arr2[mid]) <= d) {
                    flag = 1;
                    break;
                } else if (arr1[i] < arr2[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (flag == -1) {
                count++;
            }
        }
        return count;
    }
}
