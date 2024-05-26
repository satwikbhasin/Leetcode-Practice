class Solution {
    private int findK(int[] nums1, int[] nums2, int aStart, int aEnd, int bStart, int bEnd, int k) {
        if (aEnd < aStart) {
            return nums2[k - aStart];
        }

        if (bEnd < bStart) {
            return nums1[k - bStart];
        }

        int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
        int aValue = nums1[aIndex], bValue = nums2[bIndex];

        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return findK(nums1, nums2, aStart, aEnd, bIndex + 1, bEnd, k);
            } else {
                return findK(nums1, nums2, aIndex + 1, aEnd, bStart, bEnd, k);
            }
        } else {
            if (aValue > bValue) {
                return findK(nums1, nums2, aStart, aIndex - 1, bStart, bEnd, k);
            } else {
                return findK(nums1, nums2, aStart, aEnd, bStart, bIndex - 1, k);
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if (n % 2 == 0) {
            return (double) (findK(nums1, nums2, 0, n1 - 1, 0, n2 - 1, n / 2)
                    + findK(nums1, nums2, 0, n1 - 1, 0, n2 - 1, n / 2 - 1)) / 2;
        } else {
            return findK(nums1, nums2, 0, n1 - 1, 0, n2 - 1, n / 2);
        }
    }
}