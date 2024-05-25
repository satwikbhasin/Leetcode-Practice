class MyCalendar {

    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prevEvent = calendar.floorKey(start);
        Integer nextEvent = calendar.ceilingKey(start);
        if ((prevEvent == null || calendar.get(prevEvent) <= start) &&
                (nextEvent == null || end <= nextEvent)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */