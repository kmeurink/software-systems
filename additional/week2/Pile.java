package ss.additional.week2;
//Exercise 5.2
public class Pile {
	
	public static void main(String[] args) {
		Pile pile = new Pile();
		
		pile.remove(11);
	}

	
	
	public int sticks;
	
	public Pile() {
		sticks = 10;
	}
	
	//@requires number >= 0 && number <= sticks(); 
	//@ensures sticks() == \old(sticks()) - number;
	public void remove(int number) {
		assert number >= 0 && number <= this.sticks;
		this.sticks = this.sticks - number;
	}
	
	/*@pure*/public int sticks() {
		return this.sticks;
	}
}
