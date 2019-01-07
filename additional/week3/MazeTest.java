package ss.additional.week3;
//Exercise 10.4
public class MazeTest {

	public static void main(String[] args) {
		new MazeTest();
		

	}
	
	public MazeTest() {
		Room room1 = new Room("A weapon room");
		Room room2 = new Room("A lunch hall");
		Room room3 = new Room("Throne room");
		Room room4 = new EnchantedRoom("A wizards room");
		Explorer pete = new Explorer(room1);
		Explorer wizard = new Wizard(room1);
		room1.connect(room2, room3);
		room2.connect(room1, room4);
		room3.connect(room1, room2);
		room4.connect(room2, room4);
		System.out.println(pete.location().description());
		System.out.println(wizard.location().description());
		pete.moveTo(room2);
		wizard.moveTo(room4);
		System.out.println(pete.location().description());
		System.out.println(wizard.location().description());
	}

}
