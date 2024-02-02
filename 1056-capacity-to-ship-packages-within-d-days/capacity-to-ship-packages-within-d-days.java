// B R U T E F O R C E
// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
//         int maxWeight = 0;
//         int sumOfWeights = 0;

//         for(int i = 0; i < weights.length; i++){
//             sumOfWeights += weights[i];
//             if(weights[i] >= maxWeight)
//                 maxWeight = weights[i];
//         }

//         if(days == 1)
//             return sumOfWeights;

//         System.out.println("maxWeight initially: " + maxWeight);
//         int counter = 0;
//         for(int i = 0; i < days; i++){
//             System.out.println("Day " + (i + 1));
//             int weightForTheDay = 0;
//             for(int j = counter; j < weights.length; j++){
//             if(weightForTheDay > maxWeight){
//                 System.out.println("Case 1");
//                 break;
//             }
//             else if(weightForTheDay <= maxWeight) {
//                 if(Math.abs(days - i) <= Math.abs(weights.length - j)){
//                 weightForTheDay += weights[j];
//                 counter++;
//                 }
//                 System.out.println("Total Weight: " + weightForTheDay);
//             }
//         }
//         if(maxWeight < weightForTheDay){
//             maxWeight = weightForTheDay;
//         }
//         System.out.println("maxWeight: " + maxWeight);
//         }
//         return maxWeight;
//     }
// }

// B I N A R Y   S E A R C H
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int daysNeeded = 1;
            int currentWeight = 0;

            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }

            if (daysNeeded <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
