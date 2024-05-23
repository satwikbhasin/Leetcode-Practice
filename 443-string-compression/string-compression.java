class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int write = 0;

        for (int read = 0; read < chars.length;) {
            char currentChar = chars[read];
            int groupLength = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                groupLength++;
            }

            chars[write++] = currentChar;

            if (groupLength > 1) {
                String countStr = String.valueOf(groupLength);
                System.out.println("Group Length: " + countStr);
                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }

        }

        return write;
    }
}