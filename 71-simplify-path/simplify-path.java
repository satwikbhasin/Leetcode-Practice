class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.addLast(directory);
            }
        }

        StringBuilder canonicalPath = new StringBuilder();
        for (String directory : deque) {
            canonicalPath.append("/").append(directory);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}