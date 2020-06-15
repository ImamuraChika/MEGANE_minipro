package sanmoku;

public class Turn {
	private int x;
	private int y;
	
	private Player player;
	
	public Turn(Player player){
		this.player = player;
	}
	
	public void turnGrid(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public int[] getGrid(){
		int[] xy = new int[2];
		xy[0]=this.x;
		xy[1]=this.y;
		return xy;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
