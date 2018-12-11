package domain;

import autocorrection.AutoCorrect;

public class AutoCorrector implements IComponent {
	
	private AutoCorrect autoCorrection;

	public AutoCorrector() {
		autoCorrection = new AutoCorrect();
		autoCorrection.initialize();
	}

	@Override
	public void operation(String s) {
		String[] words = s.split("\\W+");
		
		for(String word : words) {
			String result = autoCorrection.autoCorrect(word.trim());
			System.out.println("\n" + word + " -> " + result);
		}
	}
	
}
