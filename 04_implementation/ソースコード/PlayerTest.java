package hanpuku1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class PlayerTest {


	@Test
	public void testgetName_1() {
		Player player = new Player(Mark.CIRCLE, "先攻");
		String actualName = player.getName();
		//String expected_name = "先攻";
		System.out.println(actualName);
		//assertThat(actualName, is(expected_name));
	}
	
	@Test
	public void testsetGrid_2() {
		Player player = new Player(Mark.CIRCLE, "先攻");
		int[] expected_setGrid = {1,1};
		int[] actual = player.setGrid();
		assertThat(actual[0], is(expected_setGrid[0]));
		assertThat(actual[1], is(expected_setGrid[1]));
	}
	
}
