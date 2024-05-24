class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;
        int insertIndex = m + n - 1;

        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[insertIndex] = nums1[ptr1];
                insertIndex--;
                ptr1--;
            } else {
                nums1[insertIndex] = nums2[ptr2];
                insertIndex--;
                ptr2--;
            }
        }

        while (ptr2 >= 0) {
            nums1[insertIndex] = nums2[ptr2];
            insertIndex--;
            ptr2--;
        }

    }
}
