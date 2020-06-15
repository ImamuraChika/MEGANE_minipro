package sanmoku;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class GameDisplay extends JPanel {

	private final Frame frame;
	JButton[][] button=new JButton[3][3];
	private int i,j;

	public GameDisplay(Frame f) {
		frame=f;

		setBackground(Color.BLACK);
		setLayout(null);

		for(i=0;i<=2;i++) {
			for(j=0;j<=2;j++) {
				button[i][j] = new JButton(" ");
				button[i][j].setFont(new Font("MS UI Gothic", Font.BOLD, 50));
				button[i][j].setBounds(190+100*i,120+100*j,90,90);
				button[i][j].setBorderPainted(false);
				button[i][j].setForeground(Color.WHITE);
				add(button[i][j]);
			
				final int x = i+1;
				final int y = j+1;
				button[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						Player p;
						p=frame.game.getNowPlayer();
						pushed(x,y);
						p.removeList("x y");
						frame.game.changePlayer();
						if(frame.game.getNowPlayer() instanceof CPU) {
							pushed();
							frame.game.changePlayer();
						}
					}
				});

			}
		}//ここまでボタン生成
		

	}
	
	public void pushed() {
		int grid[]=new int[2];
		Player p;
		p=frame.game.getNowPlayer();
		//grid=p.setGrid();
		do {
			grid=p.setGrid();
		}while(button[grid[0]-1][grid[1]-1].isSelected());
		pushed(grid[0],grid[1]);
	}

	public void pushed(int x ,int y) {

		button[x-1][y-1].setEnabled(false);
		button[x-1][y-1].setText(markJudge(frame.game.getMark()));
		frame.game.start(y, x);

		if(frame.game.checkWinner()) {//勝者判定
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new ResultDisplay(frame));
			frame.validate();
			frame.repaint();
		}
		if(frame.game.turnList.size()>=9) {//引き分け判定
			frame.game.draw();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new ResultDisplay(frame));
			frame.validate();
			frame.repaint();
		}
	}
	
	

	//	public void pushed(int x ,int y) {
	//		button[x-1][y-1].setEnabled(false);
	//		button[x-1][y-1].setText(markJudge(frame.game.getMark()));
	//		frame.game.start(x, y);
	//		if(frame.game.checkWinner()) {//勝者判定
	//			frame.getContentPane().removeAll();
	//			frame.getContentPane().add(new ResultDisplay(frame));
	//			frame.validate();
	//			frame.repaint();
	//		}
	//		if(frame.game.turnList.size()>=9) {//引き分け判定
	//			frame.game.draw();
	//			frame.getContentPane().removeAll();
	//			frame.getContentPane().add(new ResultDisplay(frame));
	//			frame.validate();
	//			frame.repaint();
	//		}
	//	}

	public String markJudge(Mark m) {
		if (m == Mark.CIRCLE) {
			return "〇";
		}
		else{
			return "×";
		}
	}

}
//if(frame.game.getNowPlayer() instanceof Player) {
//	button[x-1][y-1].setEnabled(false);
//	button[x-1][y-1].setText(markJudge(frame.game.getMark()));
//	frame.game.start(x, y);
//}
//else {
//	int grid[]=new int[2];
//	CPU p;
//	p=(CPU) frame.game.getNowPlayer();
//	grid=p.setGrid();
//	pushed
//
//}