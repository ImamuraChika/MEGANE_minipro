package hanpuku1;

public class CPUTest {

	public static void main(String[] args){
		CPU cpu=new CPU(Mark.CIRCLE, "CPU");
		for(int j=0;j<9;j++) {
			int[] ret=cpu.setGrid();
			for(int i:ret) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
