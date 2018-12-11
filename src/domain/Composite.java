package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class which may have list of
 * components. Its responsibility is 4th
 * choice.
 *
 */
public class Composite implements IComponent {
	
	private List<IComponent> componentList;
	
	private String searchCharacters;
	
	public Composite() {
		componentList = new ArrayList<IComponent>();
	}

	@Override
	public void operation(String s) {
		String[] words = s.split("\\W+");
		String[] containing = new String[words.length];
		int index = 0;
		
		for (String word : words) {
			if (word.indexOf(searchCharacters) != -1) {
				System.out.println(word + ",");
				containing[index] = word;
				index++;
			}
		}
		
		if (index > 0) {
			IComponent counter = getCounter();
			if (counter != null) {
				counter.operation(String.join(" ", containing));
			}
		}
		else {
			System.out.println("Nothing was found!\n");
		}
	}
	
	private IComponent getCounter() {
		for (IComponent component : componentList) {
			if (component instanceof Counter) {
				return component;
			}
		}
		return null;
	}
	
	public void setSearchCharacters(String s) {
		this.searchCharacters = s;
	}
	
	public void addComponent(IComponent component) {
		componentList.add(component);
	}
	
	public void removeComponent(IComponent component) {
		componentList.remove(component);
	}
	
}
