import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SuccessScreen extends JPanel implements ActionListener{

	private Image bg; 
	JPanel mainpanel = new JPanel(new CardLayout());
	Timer t = new Timer(3000, this);
	
	public void start(){
		t.start();
	}

	public void actionPerformed(ActionEvent e){
		CardLayout c = (CardLayout)mainpanel.getLayout();
		c.show(mainpanel, "Menu");
		
	}

	public void setupWindow(SuccessScreen p){
//		JFrame f = new JFrame("End Game");
		JLabel label = new JLabel("SUCCESS", JLabel.CENTER);
		Replay something = new Replay();
		something.setupWindow();
		label.setForeground(Color.BLACK);
		label.setText("<html><br/><br/>SUCCESS!<html>");
	    label.setFont(new Font("impact", Font.BOLD, 130));
	    p.add(label);
	    p.setBackground(Color.green);
	    mainpanel.add(p,"SuccessScreen");
	    mainpanel.add(something.getPanel(), "Menu");
//	    f.add(mainpanel);
//		f.setSize(1920, 1080);
//		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		

	}
	
	public JPanel getPanel(){
		return mainpanel;
	}

	public static void main(String [] args){
		SuccessScreen p = new SuccessScreen();
		p.setupWindow(p);
	}

}