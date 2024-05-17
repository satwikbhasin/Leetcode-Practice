class Solution {
    private boolean dfs(int[] matchsticks, int index, int[] sides, int possibleSideLength) {
        if (index == matchsticks.length) {
            return sides[0] == possibleSideLength && sides[1] == possibleSideLength && 
                   sides[2] == possibleSideLength && sides[3] == possibleSideLength;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= possibleSideLength) {
                sides[i] += matchsticks[index];
                if (dfs(matchsticks, index + 1, sides, possibleSideLength)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
            // Optimization: If this matchstick can't be placed in the current empty side,
            // there's no point in trying to place it in the next empty side.
            if (sides[i] == 0) break;
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int perimeter = 0;
        for (int matchstick : matchsticks) {
            perimeter += matchstick;
        }

        if (perimeter % 4 != 0) {
            return false;
        }

        int possibleSideLength = perimeter / 4;

        Integer[] matchsticksInteger = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);

        Arrays.sort(matchsticksInteger, Collections.reverseOrder());

        return dfs(matchsticks, 0, new int[4], possibleSideLength);
    }
}
