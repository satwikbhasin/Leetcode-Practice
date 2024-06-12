class Solution {
    private void getRoman(int x, StringBuilder result) {
        if (x == 0)
            return;

        if (x >= 1000) {
            result.append("M");
            getRoman(x - 1000, result);
        } else if (x >= 900) {
            result.append("CM");
            getRoman(x - 900, result);
        } else if (x >= 500) {
            result.append("D");
            getRoman(x - 500, result);
        } else if (x >= 400) {
            result.append("CD");
            getRoman(x - 400, result);
        } else if (x >= 100) {
            result.append("C");
            getRoman(x - 100, result);
        } else if (x >= 90) {
            result.append("XC");
            getRoman(x - 90, result);
        } else if (x >= 50) {
            result.append("L");
            getRoman(x - 50, result);
        } else if (x >= 40) {
            result.append("XL");
            getRoman(x - 40, result);
        } else if (x >= 10) {
            result.append("X");
            getRoman(x - 10, result);
        } else if (x >= 9) {
            result.append("IX");
            getRoman(x - 9, result);
        } else if (x >= 5) {
            result.append("V");
            getRoman(x - 5, result);
        } else if (x >= 4) {
            result.append("IV");
            getRoman(x - 4, result);
        } else if (x >= 1) {
            result.append("I");
            getRoman(x - 1, result);
        }
    }

    public String intToRoman(int num) {
        StringBuilder solution = new StringBuilder();
        getRoman(num, solution);
        return solution.toString();
    }
}
