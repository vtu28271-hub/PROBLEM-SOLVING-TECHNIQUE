import java.util.*;

class replacepattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (isMatch(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean isMatch(String word, String pattern) {

        HashMap<Character, Character> patternToWord = new HashMap<>();
        HashMap<Character, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Check pattern -> word
            if (patternToWord.containsKey(p)) {

                if (patternToWord.get(p) != w) {
                    return false;
                }

            } else {
                patternToWord.put(p, w);
            }

            // Check word -> pattern
            if (wordToPattern.containsKey(w)) {

                if (wordToPattern.get(w) != p) {
                    return false;
                }

            } else {
                wordToPattern.put(w, p);
            }
        }

        return true;
    }
}
