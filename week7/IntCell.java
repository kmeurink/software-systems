package ss.week7;
//Exercise 7.20
public class IntCell {
    private int contents = 0;

    public synchronized void add(int amount) {
        contents = contents + amount;
    }
    public synchronized int get() {
        return contents;
    }

    public static void main(String[] args) {
    	//For loop to run the program 50 times
    			for (int i = 0; i < 50; i++) { 
    	IntCell cell = new IntCell();
        Adder a1 = new Adder(cell, 1);
        Adder a2 = new Adder(cell, 2);
        a1.start();
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    			}
    }
}

class Adder extends Thread {
    private IntCell cell;
    private int amount;

    public Adder(IntCell cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public void run() {
        cell.add(amount);
    }
}