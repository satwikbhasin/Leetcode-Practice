class MedianFinder {
    PriorityQueue<Integer> smallerPile = new PriorityQueue<Integer>((a, b) -> (b - a));
    PriorityQueue<Integer> biggerPile = new PriorityQueue<Integer>();

    public MedianFinder() {
    }

    public void addNum(int num) {

        if (smallerPile.isEmpty() || num < smallerPile.peek()) {
            smallerPile.add(num);
        } else {
            biggerPile.add(num);
        }

        if (smallerPile.size() > biggerPile.size() + 1) {
            biggerPile.add(smallerPile.poll());
        } else if (biggerPile.size() > smallerPile.size()) {
            smallerPile.add(biggerPile.poll());
        }
    }

    public double findMedian() {
        if (smallerPile.size() == biggerPile.size()) {
            return (smallerPile.peek() + biggerPile.peek()) / 2.0;
        } else {
            return smallerPile.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */