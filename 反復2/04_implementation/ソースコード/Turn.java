package hanpuku1;

public class Turn {
	private int x;
	private int y;
	
	private Player player;
	
	public Turn(Player player){
		this.player = player;
	}
	
//	public void startTurn() {
//		
//		do {
//			int[] xy = this.player.setGrid();
//			this.x = xy[0];
//			this.y = xy[1];
//		}while(true == board.checkArea(this.x,this.y) && true == board.startCheckEmpty(this.x,this.y)); 
//		
//		board.startSetMark(this.x,this.y,this.player.getMark());
//	}
	
	public void turnGrid(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void showResult() {
		
		String m="";
		
		Mark mk=player.getMark();
		if (mk == Mark.CIRCLE) {
			m="〇";
		} else if (mk == Mark.CROSS) {
			m= "×";
		} else if (mk == Mark.NONE) {
			m =" ";
		}
	
		System.out.println(this.player.getName() + ":(" + this.y + "," + this.x + ") " + m);
		
	}
}
