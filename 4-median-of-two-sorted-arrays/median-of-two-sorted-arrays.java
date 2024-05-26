class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int medianIndex1 = (totalLength - 1) / 2;
        int medianIndex2 = totalLength / 2;

        int i = 0, j = 0;
        int count = 0;
        int median1 = 0, median2 = 0;

        while (i < m || j < n) {
            int currentValue;
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                currentValue = nums1[i];
                i++;
            } else {
                currentValue = nums2[j];
                j++;
            }

            if (count == medianIndex1) {
                median1 = currentValue;
            }
            if (count == medianIndex2) {
                median2 = currentValue;
                break;
            }
            count++;
        }

        if (totalLength % 2 == 0) {
            return (median1 + median2) / 2.0;
        } else {
            return median2;
        }
    }
}
