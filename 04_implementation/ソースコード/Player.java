package sanmoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Player {
	
	String[] position = {"1 1","1 2","1 3",
			"2 1","2 2","2 3",
			"3 1","3 2","3 3"};

List<String> list = new ArrayList<String>(Arrays.asList(position));
	
	private String playerName;
	private Mark mark;
	
	public Player(Mark mark, String playerName) {
		this.mark = mark;
		this.playerName = playerName;
	}

	public Mark getMark() {
		return mark;
	}
	
	public String getName(){
		return playerName;
	}
	
	public int[] setGrid() {
		int[] ret = new int[2];
		
		Random random = new Random();
		int randomValue = random.nextInt(list.size());
		
		String[] numbersStr;
		numbersStr = list.get(randomValue).split(" ");
		
		ret[0] = Integer.parseInt(numbersStr[0]);
		ret[1] = Integer.parseInt(numbersStr[1]);
		
		list.remove(randomValue);
		
		System.out.println(ret[0] + " " + ret[1]);
		
		return ret;
	}
	
	public void removeList(String x) {
		for(int i=0;i<list.size();i++) {
			if(x.equals(list.get(i))) {
				list.remove(i);
			}
		}
	}

}
