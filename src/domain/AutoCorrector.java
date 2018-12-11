package domain;

import autocorrection.AutoCorrect;

/**
 * This class works with given .JAR file
 * and it searches words from words.txt
 * then tries to find something
 * similar. By the way, it has to have
 * same characters for this class to find it.
 *
 */
public class AutoCorrector implements IComponent {
	
	/**
	 * Reference to .JAR class
	 */
	private AutoCorrect autoCorrection;

	/**
	 * Initialize and load the words from .txt
	 */
	public AutoCorrector() {
		autoCorrection = new AutoCorrect();
		autoCorrection.initialize();
	}

	@Override
	public void operation(String s) {
		String[] words = s.split("\\W+");
		
		for (String word : words) {
			String result = autoCorrection.autoCorrect(word.trim());
			System.out.println("\n" + word + " -> " + result);
		}
	}
	
}
