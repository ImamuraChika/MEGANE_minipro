package sanmoku;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Title extends JPanel {

	public int a;
	public JButton btnPvP,btnVsCpu;
	private final Frame frame;

	public Title(Frame f) {
		frame=f;
		setBackground(Color.BLACK);
		setLayout(null);
		
		btnPvP = new JButton("人間 vs 人間");
		btnPvP.setBounds(246, 192, 148, 46);
		add(btnPvP);
		btnPvP.setContentAreaFilled(false);
		btnPvP.setBorderPainted(false);
		btnPvP.setToolTipText("");
		btnPvP.setForeground(Color.WHITE);
		btnPvP.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnPvP.setBackground(new Color(0, 0, 0));
		btnPvP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameDisplay(frame));
				frame.validate();
				frame.repaint();
				frame.game=new Game(1);
			}
		});
		
		JButton btnVsCpu = new JButton("人間 vs CPU");
		btnVsCpu.setBounds(246, 273, 148, 46);
		add(btnVsCpu);
		btnVsCpu.setContentAreaFilled(false);
		btnVsCpu.setBorderPainted(false);
		btnVsCpu.setToolTipText("");
		btnVsCpu.setForeground(Color.WHITE);
		btnVsCpu.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnVsCpu.setBackground(new Color(0, 0, 0));
		btnVsCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameDisplay(frame));
				frame.validate();
				frame.repaint();
				frame.game=new Game(2);
			}
		});
		
		JButton button = new JButton("終了");
		button.setToolTipText("");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBackground(Color.BLACK);
		button.setBounds(246, 342, 148, 46);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel("三☆目☆並べ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(196, 64, 268, 82);
		add(lblNewLabel);

	}
}
