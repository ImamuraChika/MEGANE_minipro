package hanpuku1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TurnTest {
//	@Test
//	public void Test1_1() {
//		Player p = new Player(Mark.CIRCLE, "先攻");
//		Board b = new Board();
//		Turn t = new Turn(p);
//		t.turnGrid(1,1);
//		b.startSetMark(1, 1, Mark.CIRCLE);
//		
//		t.showResult();
//		
//	}
	
	@Test
	public void Test1_1() {
		Player p = new Player(Mark.CIRCLE, "先攻");
		Player p2 = new Player(Mark.CROSS, "後攻");
		Board b = new Board();
		
		Turn t = new Turn(p);
		t.turnGrid(1,1);
		b.startSetMark(1, 1, Mark.CIRCLE);
		t.showResult();
		
		Turn t2 = new Turn(p2);
		t2.turnGrid(1,2);
		b.startSetMark(1, 2, Mark.CROSS);
		
		t2.showResult();
		
	}


}
