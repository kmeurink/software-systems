package ss.additional.week3;

public class CellDivisionCounter extends AbstractCounter {
	//Named constants:
	
	//Constructors:
	public CellDivisionCounter() {
		super.setCount(1);
	}
	
	//Queries:
	
	
	//Commands:
	public void increase() {
		super.setCount(super.count() * 2);
	}
}
