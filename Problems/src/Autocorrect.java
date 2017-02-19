import java.util.Arrays;
import java.util.HashSet;

public class Autocorrect {
    public static final HashSet<String> vocab = new HashSet<>(Arrays.asList("apple", "pineapple", "banana", "cucumber"));
    public static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {
        String[] mispelled = {"adple", "addle", "aple", "apple"};
        for(String word : mispelled)
            System.out.printf("%s %s be auto-corrected%n", word, singleTypo(word) ? "can" : "can't");
    }

    /**
     * You have a list of words in English (your vocabulary). Describe a method for
     * determining if an arbitrary string can be changed to a word in your vocabulary
     * with a single character substitution.
     * Example vocab = ['apple', 'pineapple', 'banana', 'cucumber']
     * singleTypo('adple') # True
     * singleTypo('addle') # False
     * singleTypo('aple') # False
     * singleTypo(‘apple’) # False
     */
    public static boolean singleTypo(String word) {
        if(vocab.contains(word)) return false;
        int length = word.length();

        for(int i = 0; i < length; i++) {
            char character = word.charAt(i);
            for (int j = 0; j < 26; j++) {
                if(alphabet[j] != character) {
                    String corrected = word.substring(0,i) + alphabet[j] + word.substring(i+1,length);
                    if(vocab.contains(corrected)) return true;
                }
            }
        }
        return false;
    }
}