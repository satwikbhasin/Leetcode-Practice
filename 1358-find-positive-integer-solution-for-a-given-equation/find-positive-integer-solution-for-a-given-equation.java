/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 500; i++){
            for( int j = 500; j >= 1; j--){
                if(customfunction.f(i,j) == z){
                    List<Integer> innerList1 = new ArrayList<>();
                    innerList1.add(i);
                    innerList1.add(j);
                    ans.add(innerList1);
                    // List<Integer> innerList2 = new ArrayList<>();
                    // innerList2.add(j);
                    // innerList2.add(i);
                    // ans.add(innerList2);
                }
            }
        }
        return ans;
        // List<List<Integer>> ans = new ArrayList<>();
        // for (int i = 1; i <= 1000; i++){
        //     int left = 1;
        //     int right = 1000;
        //     while(left<=right){
        //         int mid = left + (right-left)/2;
        //         if(customfunction.f(left,mid) > z){
        //             right = mid - 1;
        //         } else if (customfunction.f(left,mid) < z) {
        //             left = mid + 1;
        //         } else {
        //             List<Integer> innerList = new ArrayList<>();
        //             innerList.add(left);
        //             innerList.add(mid);
        //             ans.add(innerList);
        //         }
        //     }
        // }
        // return ans;
    }
}