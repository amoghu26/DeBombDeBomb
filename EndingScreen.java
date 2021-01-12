import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class EndingScreen extends JPanel implements ActionListener{

	private Image bg;
	JPanel mainPanel = new JPanel();
	private Timer t;
	EndingScreen p;
	Replay r;
	Replay m;
	JMenu file = new JMenu("file");

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == t){
			CardLayout c = (CardLayout) mainPanel.getLayout();
			c.show(mainPanel, "start");
			t.stop();
		}

		else if(e.getSource() == r.b1){
			CardLayout c = (CardLayout) mainPanel.getLayout();
			c.show(mainPanel, "menu");
		}
		if(e.getSource() == r.b2)
			System.exit(0);
	}
	public EndingScreen(){
		ImageIcon i = new ImageIcon("src/hb.jpg");
		bg = i.getImage();

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bg, 0 ,0, 1920, 1080, null);
	}
   
	public void setupWindow(EndingScreen p){
		mainPanel.setLayout(new CardLayout());
		r = new Replay();
		r.setupWindow();                
		t = new Timer(2500, this);
		m = new Replay();
		m.setupWindow();

		JFrame f = new JFrame("End Game");
		JLabel label = new JLabel("YOU DIED!", JLabel.CENTER);
		label.setForeground(Color.BLACK);
		Font font = new Font("Impact", Font.BOLD, 140);

		label.setFont(font);
		label.setText("<html><br/><br/>YOU DIED!<html>");

		this.p = p;

		this.p.add(label);
		this.p.add(label);
		mainPanel.add(this.p,"end");

		mainPanel.add(r.getPanel(),"start");
		mainPanel.add(m.getPanel(), "menu");
//		f.setSize(1920, 1080);
//		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.add(mainPanel);
//		f.setVisible(true);
		r.b1.addActionListener(this);
		r.b2.addActionListener(this);

	}
	public JPanel getPanel(){
		return mainPanel;
	}
	public void start(){
		t.start();
	}
//	public static void main(String [] args){
//		EndingScreen p = new EndingScreen();
//		p.setupWindow(p);
//	}
}