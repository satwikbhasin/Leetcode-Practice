class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> sol = new ArrayList<Integer>();

        for(int i = 0; i < arr1.length; i++){
            boolean flag1 = false;
            boolean flag2 = false;

            int left = 0;
            int right  = arr2.length - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(arr2[mid] > arr1[i])
                    right = mid - 1;
                else if(arr2[mid] < arr1[i])
                    left = mid + 1;
                else {
                    flag1 = true;
                    break;
                }
            }

            left = 0;
            right  = arr3.length - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(arr3[mid] > arr1[i])
                    right = mid - 1;
                else if(arr3[mid] < arr1[i])
                    left = mid + 1;
                else {
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2)
                sol.add(arr1[i]);
        }
        return sol;
    }
}