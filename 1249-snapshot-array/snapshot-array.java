
class SnapshotArray {
    // private HashMap<Integer, HashMap<Integer, Integer>> snapshotMap;
    // private int[] snapshotArray;
    // private int currentSnapId;

    // public SnapshotArray(int length) {
    // snapshotMap = new HashMap<>();
    // snapshotArray = new int[length];
    // currentSnapId = 0;
    // for (int i = 0; i < length; i++) {
    // snapshotMap.put(i, new HashMap<>());
    // }
    // }

    // public void set(int index, int val) {
    // snapshotArray[index] = val;
    // }

    // public int snap() {
    // for (int i = 0; i < snapshotArray.length; i++) {
    // snapshotMap.get(i).put(currentSnapId, snapshotArray[i]);
    // }
    // return currentSnapId++;
    // }

    // public int get(int index, int snap_id) {
    // return snapshotMap.get(index).get(snap_id);
    // }

    private List<List<int[]>> histories;
    private int snapId;

    public SnapshotArray(int length) {
        histories = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<int[]> initialHistory = new ArrayList<>();
            initialHistory.add(new int[] { -1, 0 });
            histories.add(initialHistory);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        histories.get(index).add(new int[] { snapId, val });
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> indexHistory = histories.get(index);
        int left = 0, right = indexHistory.size() - 1, pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (indexHistory.get(mid)[0] <= snap_id) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indexHistory.get(pos)[1];
    }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */