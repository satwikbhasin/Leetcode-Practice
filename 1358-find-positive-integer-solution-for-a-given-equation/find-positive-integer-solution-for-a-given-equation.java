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

        // B R U T E F O R C E [O(n^2)]
        // List<List<Integer>> ans = new ArrayList<>();
        // for (int i = 1; i <= 1000; i++){
        //     if(customfunction.f(i,1) > z){
        //         return ans;
        //     }
        //     for( int j = 1; j <= 1000; j++){
        //         int sol = customfunction.f(i,j);
        //         if(sol == z){
        //             List<Integer> innerList1 = new ArrayList<>();
        //             innerList1.add(i);
        //             innerList1.add(j);
        //             ans.add(innerList1);
        //         }
        //         if(sol > z){
        //             break;
        //         }
        //     }
        // }
        // return ans;

        // B I N A R Y   S E A R C H [O(nlogn)]
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++){
            int left = 1;
            int right = 1000;
            while(left<=right){
                int mid = left + (right-left)/2;
                int sol = customfunction.f(i,mid);
                if(sol > z){
                    right = mid - 1;
                } else if (sol < z) {
                    left = mid + 1;
                } else {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(i);
                    innerList.add(mid);
                    ans.add(innerList);
                    break;
                }
            }
        }
        return ans;
    }
}