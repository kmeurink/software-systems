package ss.additional.week3;

public class TestEmployee {
	private Employee pete = new Employee(40);
	private PayCalculator fixPay = new FixedPay(25.00);
	private PayCalculator overPay = new VarPay(25.00, 30, 1.5);
	
	public static void main(String[] args) {
		new TestEmployee();
	}
	
	public TestEmployee() {
		System.out.println(pete.pay(fixPay));
		System.out.println(pete.pay(overPay));
	}

}
