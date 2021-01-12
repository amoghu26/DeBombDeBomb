import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.util.Random;

public class mainPanel extends JPanel implements ActionListener, KeyListener{

	int randomizerEND;
	String[] terminate = {"Click when there's a multiple\n of 4 on the clock","Click when there's a multiple\n of 5 on the clock","Click when there's a multiple\n of 6 on the clock"};
	String [] trueQuestion = {"Java was named after a cup of coffee","Java is owned by Oracle","You cannot name a variable true or false"};
	String[] falseQuestion = {"There are 10 bits in a byte","Java can only run on Mac and Windows","Java was created by Bill Gates"};
	int question;
	JButton stop;
	int replay;
	String[] multiplication;
	int[] multiplicationAnswers;
	String[] addition;
	int[] additionAnswers;
	JPanel organizer;
	String[] level;
	int actualScore;
	int actualTime;
	int counter;
	JFrame frame1;
	JLabel field;
	int runTwice;
	JPanel bomb;
	int randomizerTF;
	JLabel time, problem;	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem exit;
	JMenuItem home;
	JMenu lifeStat;
	int question1;
	JPanel specs;
	JPanel[] p = new JPanel[4];
	JPanel mainPanel;
	JPanel cards;
	EndingScreen m;
	SuccessScreen success;
	Timer win;

	int officialRand;

	int tempRand;

	int randNum1, randNum2;

	JPanel smallOpanel;
	JPanel p1_1, p2_2;
	JButton tru, fals;
	JLabel score;
	JLabel difficulty;
	int lives;
	Timer tm;
	JTextField typing;
	JPanel main;
	JTextField tb;
	int probRand1, probRand2;
	int AnswerTYPE;
	JButton []mc;

	JButton fat;

	JButton[] calc = new JButton[12];

	JPanel gameover;
	//////////////
	public void setUpProblemMC(){
		int num = 0;
		int i;
		int j;
		for( i = 2; i<=9; i++){
			for( j = 2; j<=9; j++){
				multiplication[num] =i+"x"+j;
				num++;
			}
		}

		num = 0;
		for( i = 2; i<=9; i++){
			for( j = 2; j<=9; j++){
				multiplicationAnswers[num] = i*j;
				num++;

			}
		}


	}

	public void setUpProblemTYPING(){
		int num1 = 0;
		int i1;
		int j1;
		for( i1 = 2; i1<=9; i1++){
			for( j1 = 2; j1<=9; j1++){
				addition[num1] =i1+"+"+j1;
				//System.out.println(addition[num1]);

				num1++;
			}
		}

		num1 = 0;
		for( i1 = 2; i1<=9; i1++){
			for( j1 = 2; j1<=9; j1++){
				additionAnswers[num1] = i1+j1;
				//System.out.println(additionAnswers[num1]);

				num1++;
			}
		}


	}

	public mainPanel() {
		win = new Timer(2000,this);
		multiplication = new String[80];
		multiplicationAnswers = new int[80];
		addition = new String[80];
		additionAnswers = new int[80];
		setUpProblemMC();
		setUpProblemTYPING();
		field = new JLabel();
		organizer = new JPanel();
		int i;
		mc = new JButton[4];
		//frame1 = new JFrame();
		main = new JPanel();
		bomb = new JPanel();
		success = new SuccessScreen();
		success.setupWindow(success);

		level = new String[4];

		level[0] = "De Bomb";
		level[1] = "Wireless";
		level[2] = "the I";
		level[3] = "AirBomb";

		stop = new JButton();

		specs = new JPanel();		
		exit = new JMenuItem();
		home = new JMenuItem();

		specs.setBackground(Color.LIGHT_GRAY);
		menu = new JMenu();
		menuBar = new JMenuBar();

		lifeStat = new JMenu();

		actualTime = 46;
		mc= new JButton[4];

		actualScore = 0;

		for(i = 0; i<mc.length; i++){
			mc[i] = new JButton();
			mc[i].addActionListener(this);
			mc[i].setFont(mc[i].getFont().deriveFont(50f));
		}

		for(i = 0; i<calc.length-3; i++){
			calc[i] = new JButton(""+(i+1));
			calc[i].setFont(calc[i].getFont().deriveFont(20f));
		}

		calc[10] = new JButton("0");
		calc[9] = new JButton("");
		calc[11] = new JButton("Enter");

		calc[10].setFont(calc[10].getFont().deriveFont(20f));
		calc[11].setFont(calc[11].getFont().deriveFont(20f));


		tru = new JButton("True");
		fals = new JButton("False");

		for(i = 0; i<p.length; i++){
			p[i] = new JPanel();
			p[i].setBackground(Color.BLACK);
		}

		p1_1 = new JPanel();
		p2_2 = new JPanel();

		lives = 1;
		counter = 0;
		fat = new JButton("CLICK ("+counter + ")");

		typing = new JTextField();
		time = new JLabel("" + actualTime);
		problem = new JLabel("");
		score = new JLabel("Score: " + score);
		difficulty = new JLabel("Difficulty: ");
		tm = new Timer(1000 , this);
		tm.start();

	}
	////////////////
	public static void main(String[] args) {
		StartMenu m = new StartMenu();
		m.setupWindow();
	}
	///////////////
	public int numGen(){

		tempRand = (int)(Math.random()*48);

		return tempRand;
	}
	/////////////////
	public void setUp(mainPanel bomb) {
		int i;
		cards = new JPanel(new CardLayout());
		mainPanel = new JPanel(new GridLayout(1,2));
		m = new EndingScreen();
		m.setupWindow(m);
		//		frame1.setTitle("Debomb De Bomb");
		//		frame1.setSize(1500,1000);
		//		frame1.setLocation(0,0);
		//		frame1.setLayout(new GridLayout(1,2));
		bomb.setLayout(new GridLayout(3,2));
		bomb.add(time);
		bomb.add(problem);
		score.setText("Score: " + actualScore);

		time.setFont(time.getFont().deriveFont(140f));
		problem.setFont(problem.getFont().deriveFont(140f));

		menu.setText("File");
		home.setText("Menu");
		exit.setText("Exit");

		fat.addActionListener(this);

		randNum1 = numGen();
		randNum2 = numGen();

		lifeStat.setText("Lives: " + lives);

		newQuestionMC();
		newAnswer();

		//p[0].add(field);
		for(i = 0; i<calc.length; i++){
			calc[i].setEnabled(false);
		}

		tru.setEnabled(false);
		fals.setEnabled(false);
		typing.setEnabled(false);
		fat.setEnabled(false);

		for(i = 0; i<calc.length; i++){
			organizer.add(calc[i]);
		}

		organizer.setLayout(new GridLayout(4,3));
		//p[0].add(organizer);
		stop.setText("TERMINATE");
		stop.setFont(stop.getFont().deriveFont(60f));
		stop.addActionListener(this);
		p[0].add(stop);

		calc[9].setEnabled(false);
		p[0].setLayout(new GridLayout(1,1));

		p[1].setLayout(new GridLayout(1,2));
		tru.setFont(tru.getFont().deriveFont(65f));
		fals.setFont(fals.getFont().deriveFont(65f));
		tru.addActionListener(this);
		fals.addActionListener(this);
		p[1].add(tru);
		p[1].add(fals);

		p[2].setLayout(new GridLayout(2,2));

		p[2].add(mc[0]);
		p[2].add(mc[1]);
		p[2].add(mc[2]);
		p[2].add(mc[3]);


		p[3].setLayout(new GridLayout(1,2));

		specs.setBackground(Color.CYAN);

		fat.setFont(fat.getFont().deriveFont(30f));
		p1_1.setLayout(new GridLayout(1,1));
		p1_1.add(fat);

		typing.setFont(typing.getFont().deriveFont(120f));

		typing.addActionListener(this);		
		p2_2.setLayout(new GridLayout(1,1));
		p2_2.add(typing);

		p[3].setBackground(Color.BLACK);
		p1_1.setBackground(Color.BLACK);
		p2_2.setBackground(Color.BLACK);
		p[0].setBackground(Color.BLACK);

		p[3].add(p1_1);
		p[3].add(p2_2);

		for(i = 0; i<p.length; i++){
			bomb.add(p[i]);
		}
		stop.setEnabled(false);
		home.addActionListener(this);
		exit.addActionListener(this);

		menu.add(home);
		menu.add(exit);

		menuBar.add(menu);
		menuBar.add(lifeStat);

		score.setLocation(10, 10);
		difficulty.setLocation(10,40);

		score.setFont(score.getFont().deriveFont(60f));
		difficulty.setFont(difficulty.getFont().deriveFont(60f));
		specs.setLayout(new GridLayout(2,1));
		specs.add(score);
		specs.add(difficulty);


		typing.setBackground(Color.GRAY);


		organizer.setBackground(Color.BLACK);

		bomb.setBackground(new Color(90, 67, 20));
		mainPanel.add(specs);
		mainPanel.add(bomb);

		//		cards.add(x.getPanel(), "StartMenu");
		cards.add(mainPanel,"MAIN");
		cards.add(m.getPanel(),"Menu");
		cards.add(success.getPanel(),"success");

		//
		//		frame1.add(cards);
		//		frame1.setJMenuBar(menuBar);
		//
		//		frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
		//		frame1.setVisible(true);
	}
	/////////////
	public void newQuestionMC(){
		int i;
		problem.setFont(problem.getFont().deriveFont(140f));
		int question = numGen();
		problem.setText(multiplication[question]);
		officialRand = (int)(Math.random()*4);
		mc[officialRand].setText(""+multiplicationAnswers[question]);


	}

	public void newQuestionTYP(){
		//System.out.println("In new QuestionTYP");
		int i;
		question1 = numGen();
		problem.setText(addition[question1]);

		AnswerTYPE = additionAnswers[question1];

	}

	public void newQuestionEND(){
		Random random = new Random();
		randomizerEND = random.nextInt(3);

		problem.setFont(problem.getFont().deriveFont(15f));
		problem.setText("" + terminate[randomizerEND]);

	}

	public void newQuestionTF(){
		Random rng = new Random();


		randomizerTF = rng.nextInt(2);


		if(randomizerTF==0){
			problem.setText(falseQuestion[rng.nextInt(3)]);
		}
		else if(randomizerTF==1){
			problem.setText(trueQuestion[rng.nextInt(3)]);
		}

	}

	public void newAnswer(){

		if(officialRand==0){
			mc[1].setText("" + multiplicationAnswers[numGen()]);
			mc[2].setText("" + multiplicationAnswers[numGen()]);
			mc[3].setText("" + multiplicationAnswers[numGen()]);

		}
		else if(officialRand==1){
			mc[0].setText("" + multiplicationAnswers[numGen()]);
			mc[2].setText("" + multiplicationAnswers[numGen()]);
			mc[3].setText("" + multiplicationAnswers[numGen()]);

		}
		else if(officialRand==2){
			mc[1].setText("" + multiplicationAnswers[numGen()]);
			mc[0].setText("" + multiplicationAnswers[numGen()]);
			mc[3].setText("" + multiplicationAnswers[numGen()]);

		}
		else if(officialRand==3){
			mc[1].setText("" + multiplicationAnswers[numGen()]);
			mc[2].setText("" + multiplicationAnswers[numGen()]);
			mc[0].setText("" + multiplicationAnswers[numGen()]);

		}
	}


	/////////////
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e);
		int i;
		if(e.getSource()==home){
			//System.out.println("home");
		}
		else if(e.getSource()==exit){
			System.exit(0);
		}

		else if(e.getSource()==stop){
			if(randomizerEND==1){
				if(actualTime%5==0){
					actualScore+=50;
					score.setText("Score: " + actualScore);
					stop.setEnabled(false);
					p[0].setBackground(Color.GREEN);

					time.setText("DEBO");
					time.setFont(time.getFont().deriveFont(135f));
					problem.setText("MBED");
					problem.setFont(time.getFont().deriveFont(131f));

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "success");

					success.start();
					//					win.start();
					//					try {
					//						Thread.sleep(1000);
					//					} catch (InterruptedException e1) {

					tm.stop();

				}
				else{
					gameOver();
				}
			}
			else if(randomizerEND==2){
				if(actualTime%6==0){
					actualScore+=50;
					score.setText("Score: " + actualScore);
					stop.setEnabled(false);
					p[0].setBackground(Color.GREEN);

					time.setText("DEBO");
					time.setFont(time.getFont().deriveFont(135f));
					problem.setText("MBED");
					problem.setFont(time.getFont().deriveFont(131f));

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "success");

					success.start();
				}
				else{
					gameOver();
				}
			}
			else if(randomizerEND==0){
				if(actualTime%4==0){
					actualScore+=50;
					score.setText("Score: " + actualScore);
					stop.setEnabled(false);
					p[0].setBackground(Color.GREEN);
					tm.stop();

					time.setText("DEBO");
					time.setFont(time.getFont().deriveFont(135f));
					problem.setText("MBED");
					problem.setFont(time.getFont().deriveFont(131f));

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "success");

					success.start();
				}
				else{
					gameOver();
				}
			}

		}

		else if(e.getSource()==tru){

			if(randomizerTF==0){
				gameOver();
			}
			else if(randomizerTF==1){
				replay++;
				if(replay<2){
					actualScore+=50;
					newQuestionTF();
					score.setText("Score: " + actualScore);
				}
				else if(replay>1){
					tru.setEnabled(false);
					fals.setEnabled(false);
					for(i = 0; i<calc.length; i++){
						calc[i].setEnabled(true);
					}
					calc[9].setEnabled(false);
					p[1].setBackground(Color.GREEN);
					stop.setEnabled(true);
					newQuestionEND();
				}

			}
		}
		else if(e.getSource()==fals){
			replay++;

			if(randomizerTF==0){
				if(replay<2){

					actualScore+=50;
					newQuestionTF();

					score.setText("Score: " + actualScore);
				}
				else if(replay>1){

					tru.setEnabled(false);
					fals.setEnabled(false);
					for(i = 0; i<calc.length; i++){
						calc[i].setEnabled(true);
					}

					calc[9].setEnabled(false);
					p[1].setBackground(Color.GREEN);
					stop.setEnabled(true);
					newQuestionEND();
				}
			}			
			else if(randomizerTF==1){
				gameOver();
			}
		}

		else if(e.getSource()==fat){
			counter++;
			fat.setText("Click (" + counter + ")");
			if(counter == additionAnswers[question1]){
				//System.out.println("Correct in fat");
				actualScore+=50;
				fat.setEnabled(false);
				tru.setEnabled(true);
				fals.setEnabled(true);
				newQuestionTF();
				problem.setFont(problem.getFont().deriveFont(17f));
				for(i = 0;i<mc.length; i++){
					mc[i].setEnabled(false);
				}
				p1_1.setBackground(Color.GREEN);

				score.setText("Score: " + actualScore);
			}
		}


		else if(e.getSource()==mc[0]){
			if(officialRand==0){
				//System.out.println("Correct in mc0");
				actualScore+=50;
				for(int j = 0;j<mc.length; j++){
					mc[j].setEnabled(false);
				}
				score.setText("Score: " + actualScore);
				newQuestionTYP();
				p[2].setBackground(Color.GREEN);
				typing.setEnabled(true);
				typing.requestFocus();
				p2_2.setBackground(Color.BLUE);

			}

			else if(officialRand==1||officialRand==2||officialRand==3){
				//System.out.println("GAME in mc0");
				gameOver();
			}
		}

		else if(e.getSource()==mc[1]){
			if(officialRand==1){
				//System.out.println("Correct in mc1");
				actualScore+=50;
				p[2].setBackground(Color.GREEN);

				for(i = 0;i<mc.length; i++){
					mc[i].setEnabled(false);
				}
				score.setText("Score: " + actualScore);
				newQuestionTYP();
				typing.setEnabled(true);
				typing.requestFocus();
				p2_2.setBackground(Color.BLUE);

			}
			else if(officialRand==0||officialRand==2||officialRand==3){
				//System.out.println("GAME in mc1");
				gameOver();
			}
		}
		else if(e.getSource()==mc[2]){
			if(officialRand==2){
				actualScore+=50;		
				System.out.println("Correct in mc2");
				p[2].setBackground(Color.GREEN);

				for(i = 0;i<mc.length; i++){
					mc[i].setEnabled(false);
				}
				score.setText("Score: " + actualScore);
				newQuestionTYP();
				typing.setEnabled(true);
				typing.requestFocus();
				p2_2.setBackground(Color.BLUE);

			}
			else if(officialRand==1||officialRand==0||officialRand==3){
				//System.out.println("GAME in mc2");
				gameOver();
			}
		}
		else if(e.getSource()==mc[3]){
			if(officialRand==3){
				actualScore+=50;
				//System.out.println("Correct in mc3");
				p[2].setBackground(Color.GREEN);
				for(i = 0;i<mc.length; i++){
					mc[i].setEnabled(false);
				}
				score.setText("Score: " + actualScore);
				newQuestionTYP();
				typing.setEnabled(true);
				typing.requestFocus();

				p2_2.setBackground(Color.BLUE);
			}
			else if(officialRand==1||officialRand==2||officialRand==0){
				System.out.println("GAME in mc3");
				gameOver();
			}
		}

		else if(e.getSource()==typing){
			if(typing.getText().equals(Integer.toString(additionAnswers[question1]))){

				actualScore+=50;
				System.out.println("Correct in typing");
				typing.setEnabled(false);
				fat.setEnabled(true);
				score.setText("Score: " + actualScore);
				typing.setText("");
				runTwice++;
				newQuestionTYP();
				if(runTwice<2){
					tru.setEnabled(false);
					fals.setEnabled(false);
					typing.setEnabled(true);
					fat.setEnabled(false);
					for(i = 0; i<mc.length; i++){
						mc[i].setEnabled(false);
					}
					p2_2.setBackground(Color.GREEN);


				}
				else if(runTwice>2){

					tru.setEnabled(false);
					fals.setEnabled(false);
					typing.setEnabled(false);
					fat.setEnabled(true);
					fat.requestFocus();
					typing.setBackground(Color.BLACK);

					for(i = 0; i<mc.length; i++){
						mc[i].setEnabled(false);
					}

				}
			}
			else{
				//System.out.println(additionAnswers[question1]);
				System.out.println("Wrong in typing");
				gameOver();
			}
		}

		else if(actualTime<=0){
			gameOver();
		}
		else if(actualTime>=0){
			actualTime--;
			time.setText("" + actualTime);
		}
	}



	/////////////
	public void gameOver(){
		int i;
		time.setText("GAME");	
		time.setFont(time.getFont().deriveFont(120f));
		problem.setFont(problem.getFont().deriveFont(120f));
		problem.setText("OVER");
		lives = 0;
		for(i = 0; i<mc.length; i++){
			mc[i].setEnabled(false);
		}
		for(i = 0; i<calc.length; i++){
			calc[i].setEnabled(false);
		}
		tru.setEnabled(false);
		fals.setEnabled(false);
		typing.setEnabled(false);
		fat.setEnabled(false);
		stop.setEnabled(false);
		lifeStat.setText("Lives: " + lives);
		tm.stop();

		CardLayout v = (CardLayout) cards.getLayout();
		v.show(cards, "Menu");
		m.start();


	}
	public JPanel getPanel(){
		return cards;
	}

	public void keyPressed(KeyEvent e) {

	}
	public void keyTyped(KeyEvent e) {

	}
	public void keyReleased(KeyEvent e) {

	}

}