package hanpuku1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Player {
	
	private String playerName;
	private Mark mark;
	
	public Player(Mark mark, String playerName) {
		this.mark = mark;
		this.playerName = playerName;
	}
	
	
	public int[] setGrid() {
		System.out.println("列と行を、半角スペースで区切って入力して下さい　（例 ： 2列目の3行目 → 2 3）");
		int[] ret = new int[2];
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			String[] numbersStr = input.split(" ");
			for(int i = 0; i < numbersStr.length; i++) {
				ret[i] = Integer.parseInt(numbersStr[i]);
			}
			return ret;
		}catch(Exception e) {
			ret[0] = -1;
			ret[1] = -1;
			return ret;
		}
	}

	public Mark getMark() {
		return mark;
	}
	
	public String getName(){
		return playerName;
	}

}
