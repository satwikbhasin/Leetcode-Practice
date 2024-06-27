class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length)
            return -1;

        int length = gas.length;
        int netGas = 0;
        int currGas = 0;
        int startingStation = 0;

        for (int i = 0; i < length; i++) {
            currGas += gas[i] - cost[i];
            netGas += gas[i] - cost[i];

            if (currGas < 0) {
                currGas = 0;
                startingStation = i + 1;
            }

        }

        return netGas >= 0 ? startingStation : -1;
    }
}