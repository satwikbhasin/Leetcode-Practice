class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        List<String> revList = new ArrayList<>();
        while (!stack.isEmpty()) {
            revList.add(stack.pop());
        }

        if(revList.isEmpty()){
            return "/";
        }

        StringBuilder canonicalPath = new StringBuilder();
        for (int i = revList.size() - 1; i >= 0; i--) {
            canonicalPath.append("/");
            canonicalPath.append(revList.get(i));
        }

        return canonicalPath.toString();
    }
}