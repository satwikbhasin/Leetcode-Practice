import java.util.*;

class Solution {
    private class Line {
        private int emptySpaces;
        private List<String> words;
        private int maxWidth;
        private int wordCount;

        public Line(int maxWidth) {
            this.maxWidth = maxWidth;
            this.words = new ArrayList<>();
            this.wordCount = 0;
            this.emptySpaces = maxWidth;
        }

        public void addWord(String word) {
            this.words.add(word);
            this.emptySpaces -= word.length();
            this.wordCount++;
        }

        public int getWordCount() {
            return this.wordCount;
        }

        public String justify(boolean isLastLine) {
            StringBuilder sb = new StringBuilder();
            if (isLastLine || this.wordCount == 1) {
                for (String word : this.words) {
                    sb.append(word);
                    if (sb.length() < this.maxWidth) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < this.maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaces = this.emptySpaces / (this.wordCount - 1);
                int extraSpaces = this.emptySpaces % (this.wordCount - 1);
                for (int i = 0; i < this.wordCount; i++) {
                    sb.append(this.words.get(i));
                    if (i < this.wordCount - 1) {
                        for (int j = 0; j < spaces; j++) {
                            sb.append(" ");
                        }
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            return sb.toString();
        }

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        HashMap<Integer, Line> map = new HashMap<>();

        int listNo = 1;
        int currWidth = words[0].length();
        map.put(listNo, new Line(maxWidth));
        map.get(listNo).addWord(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (currWidth + words[i].length() + map.get(listNo).getWordCount() <= maxWidth) {
                currWidth += words[i].length();
                map.get(listNo).addWord(words[i]);
            } else {
                listNo++;
                map.put(listNo, new Line(maxWidth));
                map.get(listNo).addWord(words[i]);
                currWidth = words[i].length();
            }
        }

        for (int i = 1; i <= listNo; i++) {
            boolean isLastLine = (i == listNo);
            Line line = map.get(i);
            String justifiedLine = line.justify(isLastLine);
            lines.add(justifiedLine);
        }

        return lines;
    }
}
