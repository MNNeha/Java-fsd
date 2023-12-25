package practise;

import java.util.regex.Pattern;

public class RegularExp {

	public static void main(String[] args) {
		 // Sample string
        String text = "The big brown fox jumps over the lazy dog";

        // Pattern to match words containing 'o'
        String pattern = ".*b.*";

        // Check if the text matches the pattern
        boolean isMatch = Pattern.matches(pattern, text);

        // Display the result
        if (isMatch) {
            System.out.println("The text contains a word with 'b'.");
        } else {
            System.out.println("No word with 'b' found in the text.");
        }

	}

}
