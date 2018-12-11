package domain;

import data.FileManipulator;

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
