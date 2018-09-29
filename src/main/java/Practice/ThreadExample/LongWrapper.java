package Practice.ThreadExample;

public class LongWrapper {
	
	private long l;
	private Object key;
	
	public LongWrapper(long l) {
		this.l =l;
	}

	long getValue() {
		return l;
	}
	
	public void incremnetValue() {
		synchronized(key) {
			l = l +1;
		}

	}
}
