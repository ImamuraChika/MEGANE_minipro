package sanmoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CPU extends Player{
	
	String[] position = {"1 1","1 2","1 3",
					"2 1","2 2","2 3",
					"3 1","3 2","3 3"};
	
	List<String> list = new ArrayList<String>(Arrays.asList(position));
	
	public CPU(Mark mark,String playerName){
		super(mark,playerName);
	}
	
	@Override
	public int[] setGrid(){
		int[] ret = new int[2];
		
		Random random = new Random();
		int randomValue = random.nextInt(list.size());
		
		String[] numbersStr;
		numbersStr = list.get(randomValue).split(" ");
		
		ret[0] = Integer.parseInt(numbersStr[0]);
		ret[1] = Integer.parseInt(numbersStr[1]);
		
		list.remove(randomValue);
		
		return ret;
	}
	
}
