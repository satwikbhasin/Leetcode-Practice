class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        List<Integer> candlePositions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                candlePositions.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int qLeft = queries[i][0];
            int qRight = queries[i][1];

            int left = 0;
            int right = candlePositions.size() - 1;
            int leftMostCandle = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (candlePositions.get(mid) >= qLeft) {
                    leftMostCandle = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            left = 0;
            right = candlePositions.size() - 1;
            int rightMostCandle = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (candlePositions.get(mid) <= qRight) {
                    rightMostCandle = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (rightMostCandle != -1 && leftMostCandle != -1 && (rightMostCandle > leftMostCandle)) {
                answer[i] = (candlePositions.get(rightMostCandle) - candlePositions.get(leftMostCandle))
                        - (rightMostCandle - leftMostCandle);
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}