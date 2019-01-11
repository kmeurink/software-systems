package ss.week7;

public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }
    //P7.27:3 Synchronize a block of code inside the run 
    //to ensure the text is not modified during the same time.
    private static Object monitor = new Object();
    public void run() {
    	synchronized (monitor) {
    		while (!toe.equals("one")) {
    			try {
    				monitor.wait();
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    		}
			text = text.concat(toe);
			System.out.println(text);
			monitor.notifyAll();
    	} 
    }

    public static void main(String[] args) {
    	(new ConcatThread("one;")).start();
        (new ConcatThread("two;")).start();
    }
}
