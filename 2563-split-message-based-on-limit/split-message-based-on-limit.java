// class Solution {
//     boolean canFit(int possibleParts, int totalLength, int limit) {
//         int sizeOfPart = String.valueOf(possibleParts).length();
//         int possibleMessageLength = 0;
//         for (int i = sizeOfPart - 1; i >= 0; i--) {
//             int currentPowOf10 = (int) Math.pow(10, i);
//             int currentPowParts = possibleParts % currentPowOf10 + 1;
//             possibleParts -= currentPowParts;
//             possibleMessageLength += currentPowParts * (limit - 3 - (i + 1) * 2);
//         }
//         return possibleMessageLength * possibleParts >= totalLength;
//     }

//     public String[] splitMessage(String message, int limit) {
//         int totalLength = message.length();

//         int parts = -1;

//         int low = 1, high = totalLength;
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             if (canFit(mid, totalLength, limit)) {
//                 parts = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         if (parts == -1) {
//             return new String[0];
//         }

//         System.out.println("parts: " + parts);

//         String[] results = new String[parts];
//         int startIndex = 0;

//         for (int i = 1; i <= parts; i++) {
//             int sizeOfPart = String.valueOf(i).length(); // Use i instead of parts
//             int suffixLength = 3 + sizeOfPart * 2; // Calculate the suffix length
//             int actualLimit = limit - suffixLength;

//             // Calculate the end index for the current part
//             int endIndex = Math.min(startIndex + actualLimit, totalLength);

//             // Extract the substring for the current part
//             String partContent = message.substring(startIndex, endIndex);

//             // Append the suffix to the current part
//             StringBuilder part = new StringBuilder();
//             part.append(partContent)
//                     .append('<').append(i).append('/').append(parts).append('>');

//             // Store the part in the result array
//             results[i - 1] = part.toString();

//             // Update the start index for the next part
//             startIndex = endIndex;
//         }

//         return results;
//     }
// }


class Solution {
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        int sa = 0;
        String[] ans = new String[0];
        for (int k = 1; k <= n; ++k) {
            int lk = (k + "").length();
            sa += lk;
            int sb = lk * k;
            int sc = 3 * k;
            if (limit * k - (sa + sb + sc) >= n) {
                int i = 0;
                ans = new String[k];
                for (int j = 1; j <= k; ++j) {
                    String tail = String.format("<%d/%d>", j, k);
                    String t = message.substring(i, Math.min(n, i + limit - tail.length())) + tail;
                    ans[j - 1] = t;
                    i += limit - tail.length();
                }
                break;
            }
        }
        return ans;
    }
}