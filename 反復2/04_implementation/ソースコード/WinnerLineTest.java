package hanpuku1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class WinnerLineTest {
	Cell[][] cell=new Cell[3][3];
	@Before
	public void Setup() {
	}

	@Test
	public void test1_1() {
		cell[0][0]=new Cell(1,1,Mark.CIRCLE);
		cell[0][1]=new Cell(1,2,Mark.CIRCLE);
		cell[0][2]=new Cell(1,3,Mark.CIRCLE);

		WinnerLine winnerLine
		=new WinnerLine(cell[0][0],cell[0][1],cell[0][2]);

		boolean judge =true;
		boolean actual = winnerLine.checkLine();
		assertThat(actual, is(judge));
	} 
	
	@Test
	public void test1_2() {
		cell[0][0]=new Cell(1,1,Mark.CIRCLE);
		cell[0][1]=new Cell(1,2,Mark.CIRCLE);
		cell[0][2]=new Cell(1,3,Mark.NONE);

		WinnerLine winnerLine
		=new WinnerLine(cell[0][0],cell[0][1],cell[0][2]);

		boolean judge =false;
		boolean actual = winnerLine.checkLine();
		assertThat(actual, is(judge));
	} 
	
	@Test
	public void test1_3() {
		cell[0][0]=new Cell(1,1,Mark.CIRCLE);
		cell[0][1]=new Cell(1,2,Mark.CROSS);
		cell[0][2]=new Cell(1,3,Mark.CIRCLE);

		WinnerLine winnerLine
		=new WinnerLine(cell[0][0],cell[0][1],cell[0][2]);

		boolean judge =false;
		boolean actual = winnerLine.checkLine();
		assertThat(actual, is(judge));
	} 
	
	@Test
	public void test1_4() {
		cell[0][0]=new Cell(1,1,Mark.CROSS);
		cell[0][1]=new Cell(1,2,Mark.CROSS);
		cell[0][2]=new Cell(1,3,Mark.CROSS);

		WinnerLine winnerLine
		=new WinnerLine(cell[0][0],cell[0][1],cell[0][2]);

		boolean judge =true;
		boolean actual = winnerLine.checkLine();
		assertThat(actual, is(judge));
	} 
}


