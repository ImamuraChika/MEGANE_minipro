package hanpuku1;

public class Board { 
	private Mark mark = Mark.NONE;
	private Cell[][] cells = new Cell[3][3];
	private WinnerLine[] lines = new WinnerLine[8];

	//cellを9個つくる
	public Board() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cells[i][j] = new Cell(i+1, j+1, mark); 
			}
		}
		
		//横ライン
		lines[0] = new WinnerLine(cells[0][0], cells[0][1], cells[0][2]);
		lines[1] = new WinnerLine(cells[1][0], cells[1][1], cells[1][2]);
		lines[2] = new WinnerLine(cells[2][0], cells[2][1], cells[2][2]);
		
		//縦ライン
		lines[3] = new WinnerLine(cells[0][0], cells[1][0], cells[2][0]);
		lines[4] = new WinnerLine(cells[0][1], cells[1][1], cells[2][1]);
		lines[5] = new WinnerLine(cells[0][2], cells[1][2], cells[2][2]);
		
		//斜めライン
		lines[6] = new WinnerLine(cells[0][0], cells[1][1], cells[2][2]);
		lines[7] = new WinnerLine(cells[0][2], cells[1][1], cells[2][0]);
		
	}

	//入力された座標が範囲内かどうかチェック
	public boolean checkArea(int x, int y) {
		if((x >= 1 && x <= 3) && (y >= 1 && y <= 3)) {
			return true;
		}else {
			System.out.println("1~3の数値を入力してください。");
			return false;
		}
	}

	//盤情報を表示
	public void showBoard() {
		for(int i = 0; i < 3; i++) {
			System.out.println("-------");
			for(int j = 0; j < 3; j++) {
				System.out.print("|");
				mark = cells[i][j].getMark();
				if(mark == Mark.CIRCLE) {
					System.out.print("〇");
				}else if(mark == Mark.CROSS){
					System.out.print("×");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println("|");
		}
		System.out.println("-------");
	}

	//勝利ラインのチェック
	public boolean checkWinner() {
		int count = 0;
		boolean a;
		for(int i = 0; i < 8; i++) {
			a = lines[i].checkLine();
			if(a == true) count++;
		}
		if(count > 0) return true;
		else return false;
	}

	//入力された座標がかぶっているかどうか問い合わせる
	public boolean startCheckEmpty(int x, int y) {
		if(cells[x-1][y-1].checkEmpty()!=true) {
			System.out.println("既に置かれています");
		}
		return cells[x-1][y-1].checkEmpty();
	}

	//マークをセル内に置くように指示
	public void startSetMark(int x, int y, Mark mark) {
		cells[x-1][y-1].setMark(mark);
	}
	
	//ターン履歴のマークを表示
	public Mark getResult(int x, int y) {
		return cells[x-1][y-1].getMark();
	}
	
}