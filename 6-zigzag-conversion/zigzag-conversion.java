class Solution {
    public String convert(String s, int numRows) {
        if (numRows == s.length() || numRows == 1)
            return s;

        List<StringBuilder> arrays = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            arrays.add(new StringBuilder());
        }

        int currRow = 0;
        // 1 = down, -1 = up
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            arrays.get(currRow).append(s.charAt(i));

            currRow += direction;

            if (currRow == numRows - 1 || currRow == 0) {
                direction = (-1) * direction;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder array : arrays) {
            res.append(array.toString());
        }

        return res.toString();
    }
}