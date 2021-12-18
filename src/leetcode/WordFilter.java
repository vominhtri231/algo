package leetcode;

public class WordFilter {
    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.startsWith(prefix) && word.endsWith(suffix)) {
                return i;
            }
        }

        return -1;
    }
}
