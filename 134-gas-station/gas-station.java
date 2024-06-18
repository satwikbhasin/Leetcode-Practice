class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasStationCount = gas.length;
        int netGas = 0;
        int currGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gasStationCount; i++) {
            currGas += gas[i] - cost[i];
            netGas += gas[i] - cost[i];

            if (currGas < 0) {
                currGas = 0;
                startingStation = i + 1;
            }
        }

        return netGas < 0 ? -1 : startingStation;
    }
}