class Solution {
    public int getClosenessToX(int var, int x) {
        return Math.abs(var - x);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search to find the position of x or the closest position
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }

        int posOfX = left;
        left = posOfX - 1;
        right = posOfX;

        while (right - left - 1 < k) {
            if (left == -1) {
                right += 1;
                continue;
            } else if (right == arr.length) {
                left -= 1;
                continue;
            }

            if (getClosenessToX(arr[left], x) <= getClosenessToX(arr[right], x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
