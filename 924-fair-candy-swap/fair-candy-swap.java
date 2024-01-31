class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(bobSizes);
        int aliceSum = 0;
        int bobSum = 0;
        int[] answer = new int[2];
        
        for(int i = 0; i<aliceSizes.length; i++){
            aliceSum += aliceSizes[i];
        }

        for(int i = 0; i<bobSizes.length; i++){
            bobSum += bobSizes[i];
        }

        for(int i = 0; i < aliceSizes.length; i++){
            int left = 0;
            int right = bobSizes.length - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if((aliceSum - aliceSizes[i] + bobSizes[mid]) > (bobSum - bobSizes[mid] + aliceSizes[i])){
                    right = mid - 1;
                } else if((aliceSum - aliceSizes[i] + bobSizes[mid]) < (bobSum - bobSizes[mid] + aliceSizes[i])){
                    left = mid + 1;
                } else {
                    answer[0] = aliceSizes[i];
                    answer[1] = bobSizes[mid];
                    break;
                }
            }
        }

        return answer;
    }
}