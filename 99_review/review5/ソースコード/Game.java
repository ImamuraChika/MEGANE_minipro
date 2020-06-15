package sanmoku;

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

	public Game(int num) {
		if(num == 1) {
			p1 =new Player(Mark.CIRCLE,"先攻");
			p2 =new Player(Mark.CROSS,"後攻");
			board=new Board();
		}else if (num == 2) {
			Random random = new Random();
			int randomValue = random.nextInt(1);
			if(randomValue == 0) {
				//System.out.println("先攻は人間プレイヤー、後攻はCPUプレイヤーです。");
				p1 =new Player(Mark.CIRCLE,"人間");
				p2 =new CPU (Mark.CROSS,"CPU");
			} else {
				//System.out.println("先攻はCPUプレイヤー、後攻は人間プレイヤーです。");
				p1 =new CPU (Mark.CIRCLE,"CPU");
				p2 =new Player(Mark.CROSS,"人間");
			}
		}
		nowPlayer=p1;
		board=new Board();
	}

	public void start(int x,int y) {
		
		Turn turn=new Turn(nowPlayer);

		board.startSetMark(x,y,nowPlayer.getMark());

		board.showBoard();
		
		passGrid(x,y,turn);

		turnList.add(turn);

	}
	
	public Player getNowPlayer() {
		return nowPlayer;
	}
	
	public boolean checkWinner() {
		if(board.checkWinner()) {
			winner=nowPlayer.getName();
			return true;
		}
		else {
			return false;
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

	public Mark getMark() {
		return nowPlayer.getMark();
	}
	
	public String getWinner() {
		return winner;
	}

	public void showWinner() {
		if(turnList.size()<=8)
			System.out.println("勝者:"+winner);
		else
			System.out.println(winner);
	}

	public void passGrid(int x,int y,Turn t) {
		t.turnGrid(x,y);
	}

	public void draw() {
		winner="引き分け";
	}

}
