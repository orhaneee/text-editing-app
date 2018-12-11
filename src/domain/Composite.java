package domain;

import java.util.ArrayList;
import java.util.List;

public class Composite implements IComponent {
	
	private List<IComponent> componentList;
	
	public Composite() {
		componentList = new ArrayList<IComponent>();
	}

	@Override
	public void operation(String s) {
		// TODO Auto-generated method stub
		
	}
	
}
