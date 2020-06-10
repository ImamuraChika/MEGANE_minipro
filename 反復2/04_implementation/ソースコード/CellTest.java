package hanpuku1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CellTest {
	
	@Test
	public void test1_1() {
		Cell cell=new Cell(1,3,Mark.NONE);
		cell.checkEmpty();
		
		boolean judge =true;
		boolean actual = cell.checkEmpty();
		assertThat(actual, is(judge));
	} 
	
	@Test
	public void test1_2() {
		Cell cell=new Cell(1,3,Mark.CIRCLE);
		cell.checkEmpty();
		
		boolean judge =false;
		boolean actual = cell.checkEmpty();
		assertThat(actual, is(judge));
	} 
	
	@Test
	public void test2_1() {
		Cell cell=new Cell(1,3,Mark.NONE);
		cell.setMark(Mark.CIRCLE);
		System.out.println(cell.getMark());
	} 

	@Test
	public void test3_1() {
		Cell cell=new Cell(1,3,Mark.CIRCLE);
		System.out.println(cell.getMark());
	} 
	
	@Test
	public void test3_2() {
		Cell cell=new Cell(1,3,Mark.NONE);
		System.out.println(cell.getMark());
	} 
}
