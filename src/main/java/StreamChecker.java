import java.util.LinkedList;
import java.util.TreeSet;


// Hint: Put the words into a trie, and manage a set of pointers within that trie.

// Submission Result: Time Limit Exceeded
public class StreamChecker {
        TreeSet<String> wordsTree = new TreeSet<>();
        LinkedList<String>
                list = new LinkedList<>(), list2 = new LinkedList<>();
        int maxWordLength = 0;
        Boolean found;
        String word;

        StreamChecker(String[] words) {
            for (String s : words) {
                word = s;
                wordsTree.add(word);
                if (word.length() > maxWordLength) {
                    maxWordLength = word.length();
                }
            }
        }

        boolean query(char letter) {
            found = false;
            list2 = new LinkedList<>();
            word = "" + letter;
            list2.add(word);
            if (wordsTree.contains(word)) {
                found = true;
            }
            while (!list.isEmpty()) {
                word = list.remove() + "" + letter;
                if (!found && wordsTree.contains(word)) {
                    found = true;
                }
                if (word.length() == maxWordLength) continue;
                list2.add(word);
            }
            list = list2;
            return found;
        }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */

    public static void main(String[] args) {
        StreamChecker t = new StreamChecker( new String[] {"cd","f","kl"});
        System.out.println(t.query('a'));
        System.out.println(t.query('b'));
        System.out.println(t.query('c'));
        System.out.println(t.query('d'));
    }
}
