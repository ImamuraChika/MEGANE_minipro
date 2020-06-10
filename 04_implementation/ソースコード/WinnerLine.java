package hanpuku1;

public class WinnerLine {

	private Cell[] cell = new Cell[3];

	public WinnerLine(Cell c1, Cell c2, Cell c3) {
		cell[0] = c1;
		cell[1] = c2;
		cell[2] = c3;
	}

	public boolean checkLine(){
		for(int i=0;i<=2;i++) {
			if(cell[i].checkEmpty()==true) {
				return false;
			}
		}
		if(cell[0].getMark()==Mark.CIRCLE && 
				cell[1].getMark()==Mark.CIRCLE &&
				cell[2].getMark()==Mark.CIRCLE) {
			return true;
		}
		else if(cell[0].getMark()==Mark.CROSS && 
				cell[1].getMark()==Mark.CROSS &&
				cell[2].getMark()==Mark.CROSS) {
			return true;
		}
		else {
			return false;
		}
	}
}
