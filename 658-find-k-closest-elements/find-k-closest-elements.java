class Solution {
    public class Element {
        int val;
        int distanceToX;
        int index;

        public Element(int val, int x, int index) {
            this.val = val;
            this.distanceToX = Math.abs(val - x);
            this.index = index;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Element> pq = new PriorityQueue<>((b, a) -> {
            if (a.distanceToX == b.distanceToX)
                return a.val - b.val;
            else
                return a.distanceToX - b.distanceToX;
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Element(arr[i], x, i));
            if (pq.size() > k)
                pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().val);
        }

        Collections.sort(result);

        return result;
    }
}
