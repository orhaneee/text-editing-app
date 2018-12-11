package domain;

/**
 * Counts lines, words, paragraphs and characters
 * in a given string.
 *
 */
public class Counter implements IComponent {
	
	public Counter() {}

	@Override
	public void operation(String s) {
		if (s.length() > 0 && s != null) {
			System.out.println("In given text:\n"
					+ "There are " + countParagraphs(s) + " paragraphs,\n"
					+ countLines(s) + " lines,\n"
					+ countWords(s) + " words,\n"
					+ countCharacters(s) + " characters.\n");
		}
	}
	
	private int countWords(String s) {
	    int wordCount = 0;

	    boolean word = false;
	    int endOfLine = s.length() - 1;

	    for (int i = 0; i < s.length(); i++) {
	        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
	            word = true;
	        } else if (!Character.isLetter(s.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}
	
	private int countParagraphs(String s) {
		return s.split("[!?.:]+").length;
	}
	
	private int countCharacters(String s) {
		return s.length();
	}
	
	private int countLines(String s) {
		   String[] lines = s.split("\r\n|\r|\n");
		   return  lines.length;
	}
	
}
