package sanmoku;

public enum Mark {
	CIRCLE, CROSS, NONE;

	public String toString(Mark mark) {
		
		Mark m=mark;
		String str = " ";
		
		if (m == Mark.CIRCLE) {
			return "〇";
		} else if (m == Mark.CROSS) {
			return "×";
		} else if (m == Mark.NONE) {
			return " ";
		}
		return str;
	}
	
	//mark.toString(mark);
}
