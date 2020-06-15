package sanmoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{
	
	JPanel panel;
	Game game;
	int value;

	public Frame() {//フレームだけ
		//game=new Game();
		
		setForeground(Color.WHITE);
		setTitle("三目並べ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,480);
		setLocationRelativeTo(null);
		JPanel title = new Title(this);
		add(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	

}
