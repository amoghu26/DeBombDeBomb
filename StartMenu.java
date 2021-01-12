import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartMenu implements ActionListener{
	
	private JLabel b1;
	
	private JPanel mainpanel;
	mainPanel m = new mainPanel();
	
	private JButton b2, b3, b4 = new JButton("EXIT");
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b4){
			System.exit(0);
		}
		else if (e.getSource() == b2){
			CardLayout c = (CardLayout) mainpanel.getLayout();
			c.show(mainpanel, "menu");

		}
	}         

	public void setupWindow(){
		mainpanel = new JPanel();
		mainpanel.setLayout(new CardLayout());
		JFrame f = new JFrame("DEBOMB THE BOMB");
		JPanel p = new JPanel(new GridLayout(1,2));
		JPanel j = new JPanel(new GridLayout(2,1));															
		JPanel p2 = new JPanel(new GridLayout(2,2));
		JPanel v = new JPanel(new GridLayout(2,1));
		
		m.setUp(m);

		Font Sans = new Font(Font.SANS_SERIF,Font.BOLD, 100);
		Font Sans2 = new Font(Font.SERIF,Font.BOLD, 150);
		JLabel l = new JLabel("<html>Instructions: <br>"
				+ "1. Click Play<br/>"
				+ "2. answer the problem displayed on the top <br/>"
				+ "left corner of the screen using the buttons in the<br/>"
				+ "bottom right. <br/>"
				+ "3. Answer questions displayed in the same place using the <br/>"
				+ "textfield in the bottom right. <br/>"
				+ "4. Answer the true or false question using the true and false <br/>"
				+ "buttons<br/>"
				+ "5. Press terminate using the large terminate button based on the <br/>"
				+ "instructions in the top right<br/>"
				+ "6. If time runs out or if you answer a question wrong, you lose<br/>"
				+ "7. Play again or exit</html>");

		l.setFont(l.getFont().deriveFont(30f));
		b1 = new JLabel("<html>DEBOMB<br/> DE BOMB", JLabel.CENTER);
		b1.setFont(Sans2);
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.YELLOW);
		p2.add(b4);
		v.add(b1);
		v.add(l);
		b4.setForeground(Color.RED);
		b4.setFont(Sans);

		p.add(v);
		p.add(j);

		b2 = new JButton("START");
		b2.addActionListener(this);
		b2.setFont(Sans);
		b2.setForeground(Color.GREEN);

		j.add(b2);
		j.add(b4);
		
		b3 = new JButton("EXIT");
		b4.addActionListener(this);
		b3.setFont(Sans);
		b3.setForeground(Color.RED);

		mainpanel.add(p, "start");
		mainpanel.add(m.getPanel(), "menu");
		f.add(mainpanel);
		f.setSize(1440, 1000);
		f.setAlwaysOnTop(true);
		f.setResizable(false);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setUndecorated(true);
		f.setSize(1920,1080);
		f.setLocationRelativeTo(null); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	public JPanel getPanel(){
		return mainpanel;
	}
	
	public static void main(String [] args){
		StartMenu fw = new StartMenu();
		fw.setupWindow();
	}
}