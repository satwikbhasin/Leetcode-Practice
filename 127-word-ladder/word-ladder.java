class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> seenWords = new HashSet<>();
        HashMap<Integer, HashSet<Character>> indexPossibilities = new HashMap<>();
        for (int i = 0; i < beginWord.length(); i++) {
            indexPossibilities.put(i, new HashSet<>());
            for (String word : wordList) {
                indexPossibilities.get(i).add(word.charAt(i));
            }
        }

        System.out.println(indexPossibilities);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        seenWords.add(beginWord);

        int conversions = 1;

        while (!queue.isEmpty()) {
            int breadth = queue.size();

            for (int j = 0; j < breadth; j++) {
                String currWord = queue.poll();

                if (currWord.toString().equals(endWord)) {
                    return conversions;
                }

                StringBuilder neighbor = new StringBuilder(currWord);
                for (int i = 0; i < currWord.length(); i++) {
                    char ogChar = currWord.charAt(i);
                    for (char c : indexPossibilities.get(i)) {
                        neighbor.setCharAt(i, c);
                        if(wordSet.contains(neighbor.toString()) && !seenWords.contains(neighbor.toString())){
                            seenWords.add(neighbor.toString());
                            queue.offer(neighbor.toString());
                        }
                    }
                    neighbor.setCharAt(i, ogChar);
                }
            }

            conversions++;
        }


        return 0;
    }
}