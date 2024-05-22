class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((b, a) -> (a.getValue() - b.getValue()));
        HashMap<Character, Integer> taskFrequencies = new HashMap<>();
        for (char task : tasks) {
            taskFrequencies.put(task, taskFrequencies.getOrDefault(task, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : taskFrequencies.entrySet()) {
            pq.add(entry);
        }

        int minIntervals = 0;
        List<Character> interval = new ArrayList<>();
        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> forNextCoolingCycle = new ArrayList<>();
            int i = 0;

            while (i <= n) {
                if (!pq.isEmpty()) {
                    Map.Entry<Character, Integer> currentChar = pq.poll();
                    char name = currentChar.getKey();
                    int count = currentChar.getValue();
                    currentChar.setValue(count - 1);

                    interval.add(name);
                    minIntervals++;

                    if (currentChar.getValue() > 0) {
                        forNextCoolingCycle.add(currentChar);
                    }
                } else if (!forNextCoolingCycle.isEmpty()) {
                    interval.add(null);
                    minIntervals++;
                }

                if (pq.isEmpty() && forNextCoolingCycle.isEmpty()) {
                    break;
                }
                i++;
            }

            pq.addAll(forNextCoolingCycle);
        }

        return minIntervals;
    }
}