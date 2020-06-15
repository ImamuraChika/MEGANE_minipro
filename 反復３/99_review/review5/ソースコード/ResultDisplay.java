package sanmoku;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultDisplay extends JPanel {
	
	private final Frame frame;
	private JTextField winPlayer;
	private JTextArea turnHistory;

	public ResultDisplay(Frame f) {
		setBackground(Color.BLACK);
		frame=f;
		setLayout(null);
		
		winPlayer = new JTextField();//上
		winPlayer.setEditable(false);
		winPlayer.setForeground(Color.WHITE);
		winPlayer.setBackground(Color.BLACK);
		winPlayer.setBounds(224, 10, 237, 48);
		add(winPlayer);
		winPlayer.setColumns(10);
		//勝者をテキストに入れる
		winPlayer.setText("勝者 : "+frame.game.getWinner());
		winPlayer.setHorizontalAlignment(JTextField.CENTER);
		winPlayer.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		
		turnHistory = new JTextArea(1,1);//下
		turnHistory.setForeground(Color.WHITE);
		turnHistory.setFont(new Font("MS UI Gothic", Font.PLAIN, 12));
		turnHistory.setBackground(Color.BLACK);
		turnHistory.setColumns(10);
		turnHistory.setBounds(224, 68, 237, 313);
		add(turnHistory);
		
		JButton btnNewButton = new JButton("もう一度");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.game=new Game(1);
				frame.getContentPane().add(new GameDisplay(frame));
				frame.validate();
				frame.repaint();
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		btnNewButton.setBounds(193, 405, 117, 35);
		add(btnNewButton);
		
		JButton button = new JButton("タイトルへ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new Title(frame));
				frame.validate();
				frame.repaint();
			}
		});
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		button.setBounds(373, 405, 117, 35);
		add(button);
		//ターン履歴をテキストに入れる。
		showResult();
		
		
		
	}
	
	public void showResult() {
		int[] xy;
		Player tp;
		String markString;
		turnHistory.append("<ターン履歴>\n");
		for(Turn t:frame.game.turnList) {
			xy=t.getGrid();
			tp=t.getPlayer();
			markString=markJudge(tp.getMark());
			turnHistory.append(xy[0]+"   "+xy[1]+"   "+markString+"\n");
			turnHistory.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		}
	}
	
	public String markJudge(Mark m) {
		if (m == Mark.CIRCLE) {
			return "〇";
		}
		else{
			return "×";
		}
	}
}
