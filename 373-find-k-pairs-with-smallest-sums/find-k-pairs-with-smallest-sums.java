class Solution {
    class Pair {
        List<Integer> pair;
        int sum;

        public Pair(int x, int y) {
            pair = new ArrayList<>();
            pair.add(x);
            pair.add(y);
            this.sum = x + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair1 = (Pair) o;
            return pair.equals(pair1.pair);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pair);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> sol = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return sol;

        PriorityQueue<Pair> pairPQ = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                Pair curr = new Pair(nums1[i], nums2[j]);
                if (pairPQ.size() < k || curr.sum < pairPQ.peek().sum) {
                    pairPQ.offer(curr);
                    if (pairPQ.size() > k) {
                        pairPQ.poll();
                    }
                } else {
                    break;
                }

            }
        }

        while (!pairPQ.isEmpty()) {
            sol.add(pairPQ.poll().pair);
        }

        return sol;
    }
}
