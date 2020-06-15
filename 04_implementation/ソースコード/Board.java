package sanmoku;

public class Board { 
	private Mark mark = Mark.NONE;
	private Cell[][] cell = new Cell[3][3];
	private WinnerLine[] winnerline = new WinnerLine[8];

	//cellを9個つくる
	public Board() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cell[i][j] = new Cell(i+1, j+1, mark); 
			}
		}
		
		//横ライン
		winnerline[0] = new WinnerLine(cell[0][0], cell[0][1], cell[0][2]);
		winnerline[1] = new WinnerLine(cell[1][0], cell[1][1], cell[1][2]);
		winnerline[2] = new WinnerLine(cell[2][0], cell[2][1], cell[2][2]);
		
		//縦ライン
		winnerline[3] = new WinnerLine(cell[0][0], cell[1][0], cell[2][0]);
		winnerline[4] = new WinnerLine(cell[0][1], cell[1][1], cell[2][1]);
		winnerline[5] = new WinnerLine(cell[0][2], cell[1][2], cell[2][2]);
		
		//斜めライン
		winnerline[6] = new WinnerLine(cell[0][0], cell[1][1], cell[2][2]);
		winnerline[7] = new WinnerLine(cell[0][2], cell[1][1], cell[2][0]);
		
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
				mark = cell[i][j].getMark();
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
			a = winnerline[i].checkLine();
			if(a == true) count++;
		}
		if(count > 0) return true;
		else return false;
	}

	//入力された座標がかぶっているかどうか問い合わせる
	public boolean startCheckEmpty(int x, int y) {
		if(cell[x-1][y-1].checkEmpty()!=true) {
			System.out.println("すでにマークがセットされています。違う座標を入力してください");
		}
		return cell[x-1][y-1].checkEmpty();
	}

	//マークをセル内に置くように指示
	public void startSetMark(int x, int y, Mark mark) {
		cell[x-1][y-1].setMark(mark);
	}
	
	//ターン履歴のマークを表示
	public Mark getResult(int x, int y) {
		return cell[x-1][y-1].getMark();
	}
	
}