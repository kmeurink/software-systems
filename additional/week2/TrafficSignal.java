package ss.additional.week2;

public class TrafficSignal {
	
	//Named constants:
	public static final int GREEN = 0;
	public static final int YELLOW = 1;
	public static final int RED = 2;
	private int light;
	//Constructors:
	public TrafficSignal() {
		this.light = GREEN;
	}
	
	//Queries:
	public int light() {
		return this.light;
	}
	
	//Commands:
	public void change() {
		this.light = (this.light + 1) % 3;
	}
	
	public void set(int option) {
		this.light = option;
	}
}
