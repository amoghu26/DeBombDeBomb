import java.awt.event.*;        
import java.awt.*;

import javax.swing.*;

public class Replay implements ActionListener{

	JButton b1, b2;
	private JPanel p;

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b2){
			System.exit(0);
		}       
		else if(e.getSource()==b1){
			StartMenu m = new StartMenu();
			m.setupWindow();
		}
	}

	public void setupWindow(){ 
		p = new JPanel();

		p.setLayout(new GridLayout(1,2));


		b1 = new JButton("PLAY AGAIN!");
		b1.setFont(new Font("Serif", Font.BOLD, 70));
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.GREEN);
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.addActionListener(this);
		p.add(b1);

		b2 = new JButton("EXIT!");
		b2.setFont(new Font("Serif", Font.BOLD, 70));
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.RED);
		b2.setOpaque(true);
		b2.setBorderPainted(false);
		b2.addActionListener(this);
		p.add(b2);
	}

	public JPanel getPanel(){
		return p;

	}



}