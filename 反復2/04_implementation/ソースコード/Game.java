package hanpuku1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {

	List<Turn> turnList = new ArrayList<Turn>();
	
	private String winner;
	private Player nowPlayer;
	private Player p1;
	private Player p2;
	private Board board;


	public Game() {
		boolean number = false;
		int num = 0;

		while(number == false) {
			System.out.println("１：人間 VS 人間  / ２：人間 VS CPU");
			System.out.println("１か２を入力して下さい");
			
			Scanner scan = new Scanner(System.in);
			num = scan.nextInt();
			if(num == 1 || num == 2) {
				number = true;
			}
		} 
		if(num == 1) {
			p1 =new Player(Mark.CIRCLE,"先攻");
			p2 =new Player(Mark.CROSS,"後攻");
			board=new Board();
		}else if (num == 2) {
			Random random = new Random();
	        int randomValue = random.nextInt(2);
	        if(randomValue == 0) {
	        	System.out.println("先攻は人間プレイヤー、後攻はCPUプレイヤーです。");
	        	p1 =new Player(Mark.CIRCLE,"人間");
				p2 =new CPU (Mark.CROSS,"CPU");
	        } else {
	        	System.out.println("先攻はCPUプレイヤー、後攻は人間プレイヤーです。");
	        	p1 =new CPU (Mark.CIRCLE,"CPU");
				p2 =new Player(Mark.CROSS,"人間");
	        }
			
			board=new Board();
		}
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
			}if(turnList.size()>=9) {
				winner="引き分け";
				break;
			}
			changePlayer();
		}				

		
		showWinner();
		System.out.println();
		
		System.out.println("");
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
