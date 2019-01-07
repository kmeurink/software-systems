package ss.additional.week3;

public class StandardCounter extends AbstractCounter {
	//Named constants:
	
	//Constructors:
	
	public StandardCounter() {
		super.setCount(0);
		
	}

	//Queries:
	
	
	//Commands:
	public void increase() {
		super.setCount(super.count() + 1);
	}
}
