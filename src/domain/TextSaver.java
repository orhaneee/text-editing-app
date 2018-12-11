package domain;

import data.FileManipulator;

/**
 * Saves the text to file system
 * with the help of FileManipulator class.
 *
 */
public class TextSaver implements IComponent {

	public TextSaver() {}
	
	@Override
	public void operation(String s) {
		if (s.length() > 0 && s != null) {
			FileManipulator fileManipulator = new FileManipulator();
			fileManipulator.writeToFile(s);
		}
	}

}
