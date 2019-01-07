package ss.additional.week2;

public class Intersection {
	private TrafficSignal ewSignal;
	private TrafficSignal nsSignal;
	
	public Intersection() {
		ewSignal = new TrafficSignal();
		nsSignal = new TrafficSignal();
		ewSignal.set(0);
		nsSignal.set(2);
	}
	
	public void change() {
		if (nsSignal.light() == TrafficSignal.GREEN) {
			nsSignal.change();
		} else if (ewSignal.light() == TrafficSignal.GREEN) {
			ewSignal.change();
		} else {
			nsSignal.change();
			ewSignal.change();
		}
	
	}
	
	public int ewLight() {
		return ewSignal.light();
	}
	
	public int nsLight() {
		return nsSignal.light();
	}
	
}
