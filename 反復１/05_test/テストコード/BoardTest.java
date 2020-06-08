package hanpuku1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BoardTest {
	private Mark mark = Mark.Null;

	@Test
	public void Test1_1() {
		Board b = new Board();
		boolean a;
		a = b.checkArea(1, 1);

		assertThat(a, is(true));
	}

	@Test
	public void Test1_2() {
		Board b = new Board();
		boolean a;
		a = b.checkArea(0, 4);

		assertThat(a, is(false));
	}

	@Test
	public void Test2_1() {
		Board b = new Board();
		b.showBoard();
	}

	@Test
	public void Test2_2() {
		Board b = new Board();
		b.startSetMark(2, 2, Mark.CIRCLE);
		b.startSetMark(2, 1, Mark.CROSS);
		b.startSetMark(1, 1, Mark.CIRCLE);
		b.startSetMark(3, 1, Mark.CROSS);
		b.startSetMark(3, 3, Mark.CIRCLE);
		b.showBoard();
	}
	
	@Test
	public void Test3_1() {
		Board b = new Board();
		b.startSetMark(1, 1, Mark.CIRCLE);
		Mark m = b.getResult(1, 1);
		
		assertThat(m, is(Mark.CIRCLE));
		
	}

	@Test
	public void Test4_1() {
		Board b = new Board();
		b.startSetMark(1, 1, Mark.CIRCLE);
		b.startSetMark(2, 1, Mark.CROSS);
		b.startSetMark(3, 1, Mark.CIRCLE);
		b.startSetMark(2, 3, Mark.CROSS);
		b.startSetMark(3, 3, Mark.CIRCLE);
		b.startSetMark(2, 3, Mark.CROSS);
		b.startSetMark(1, 3, Mark.CIRCLE);
		b.startSetMark(1, 2, Mark.CROSS);
		b.startSetMark(2, 2, Mark.CIRCLE);
		boolean a = b.checkWinner();
		
		assertThat(a, is(true));
	}
	
	@Test
	public void Test4_2() {
		Board b = new Board();
		boolean a = b.checkWinner();
		assertThat(a, is(false));
	}

}
