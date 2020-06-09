package sanmoku;

public class Cell {
	
	private int x,y;
	private Mark mark;
	
	public Cell(int x,int y,Mark mark) {//mark
		this.x=x;
		this.y=y;
		this.mark=mark;
	}
	
	public boolean checkEmpty() {
		if(this.mark==mark.NONE) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setMark(Mark mark){
		this.mark=mark;
	}
	
	public Mark getMark() {
		return mark;
	}
}
