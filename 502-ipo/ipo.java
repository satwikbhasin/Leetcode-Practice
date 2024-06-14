class Solution {
    private class Project {
        int profit;
        int capitalRequired;

        public Project(int profit, int capitalRequired) {
            this.profit = profit;
            this.capitalRequired = capitalRequired;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int totalProjects = profits.length;

        PriorityQueue<Project> minCapitalPQ = new PriorityQueue<>((a, b) -> (a.capitalRequired - b.capitalRequired));
        PriorityQueue<Project> maxProfitPQ = new PriorityQueue<>((a, b) -> (b.profit - a.profit));

        for (int i = 0; i < totalProjects; i++) {
            minCapitalPQ.offer(new Project(profits[i], capital[i]));
        }

        int currentCapital = w;
        int projectsDone = 0;

        while (projectsDone < k) {
            while (!minCapitalPQ.isEmpty() && minCapitalPQ.peek().capitalRequired <= currentCapital) {
                maxProfitPQ.offer(minCapitalPQ.poll());
            }

            if (maxProfitPQ.isEmpty()) {
                break;
            }

            Project selectedProject = maxProfitPQ.poll();
            currentCapital += selectedProject.profit;
            projectsDone++;
        }

        return currentCapital;
    }
}
