package sanmoku;

import java.util.ArrayList;
import java.util.List;

public class Game {

	List<Turn> turnList = new ArrayList<Turn>();
	
	private String winner;
	private Player nowPlayer;
	private Player p1;
	private Player p2;
	private Board board;


	public Game() {
		p1 =new Player(Mark.CIRCLE,"先攻");
		p2 =new Player(Mark.CROSS,"後攻");
		board=new Board();
	}

	public void start() {
		board.showBoard();
		nowPlayer=p1;
		Turn turn;

		while(true) {
			turn=new Turn(nowPlayer);
			//turn.startTurn();
			int x,y;
			do {
				int[] xy = nowPlayer.setGrid();
				y = xy[0];
				x = xy[1];
				turn.turnGrid(x,y);
			}while(false == board.checkArea(x,y) || false == board.startCheckEmpty(x,y)); 
			
			board.startSetMark(x,y,nowPlayer.getMark());
		
			board.showBoard();

			turnList.add(turn);

			if(board.checkWinner()) {
				winner=nowPlayer.getName();
				break;
			}

			if(turnList.size()>=9) {
				winner="引き分け";
				break;
			}

			changePlayer();

		}

		showWinner();
		System.out.println("<ターン履歴>");
		for(Turn t:turnList) {
			t.showResult();
		}

	}

	public void changePlayer() {
		if(turnList.size()%2==0) {
			nowPlayer=p1;
		}
		else {
			nowPlayer=p2;
		}
	}

	public void showWinner() {
		if(turnList.size()<=8)
			System.out.println("勝者:"+winner);
		else
			System.out.println(winner);
	}
	
}
