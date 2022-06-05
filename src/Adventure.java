import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Time;
import java.awt.event.*;

public class Adventure extends JFrame {
	//class properties.
	private static JPanel contentPane;
	private static JTextField txtNumberofDiscs;
	private JLabel lblDisc;
	private JLabel lblMove;
	private static JLabel lblNumOfMoves;
	//Default number of discs.
	private static int level = 1;
	private static JPanel panel;
	private static Robot press;
	private JLabel lblGameBackground;
	private String path;
	private JLabel lblVertical;
	private JLabel lblAdventureMode;
	private JLabel lblShadow;
	private JLabel lblBorder;
	private JLabel lblScrollSide;
	private JLabel lblBanner;
	private JLabel lblShadowleft;
	private JLabel lblFrame;
	private JLabel lblBanner1;
	private JLabel label;
	private JLabel lblExit;
	private static int score = 0;
	private static String name;
	private static JPanel pnlMap;
	
	//Method of getting score with return value of Integer.
	public static int getScore() {
		return score;
	}
	//Method of setting score with parameter of Integer value.
	public static void setScore(int scores) {
		score = scores;
	}
	

	public Adventure() {
		
		setTitle("Treasure of Hanoi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 580);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize();
		setVisible(true);
		try {
			press = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		//Properties of the Frame.
		getContentPane().setForeground(new Color(255, 204, 0));
		getContentPane().setBackground(new Color(102, 0, 0));
		setBackground(Color.WHITE);
		setBounds(100, 100, 1150, 580);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		//Change the display of mouse pointer to an image.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorimageNormal = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\fighercursor.png");
		Image cursorimageButton = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\gloves.png");
		Point point = new Point(0,0);
		Cursor cursorNormal = toolkit.createCustomCursor(cursorimageNormal, point, "Cursor");
		Cursor cursorButton = toolkit.createCustomCursor(cursorimageButton, point, "Cursor");
		
		this.setCursor(cursorNormal);
		//Jlabel that cointans image border for the game.
		lblBorder = new JLabel("");
		lblBorder.setBounds(-11, 0, 1172, 580);
		contentPane.add(lblBorder);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\border.png"; 
		ImageIcon Border = new ImageIcon(path); 
		Image imgBorder = Border.getImage(); 
		Image newBorder = imgBorder.getScaledInstance(lblBorder.getWidth(), lblBorder.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBorder= new ImageIcon(newBorder);
		lblBorder.setIcon(newImgBorder);
		
		//JLabel that acts button for exit.
		lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			//mouseEntered and mouseExited has an override method to make animation.
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBounds(89, 476, 61, 59);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBounds(89, 479, 61, 59);
			}
			//hides this frame and returns to the opening frame.
			//reset level to 1.
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				setVisible(false);
				level = 1;
			}
		});
		lblExit.setBounds(89, 479, 51, 49);
		contentPane.add(lblExit);
		path = "C:\\TreasureOfHanoiTheGame\\img\\faceCross.png"; 
		ImageIcon Exit = new ImageIcon(path); 
		Image imgExit = Exit.getImage(); 
		Image newExit = imgExit.getScaledInstance(lblExit.getWidth(), lblExit.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgExit = new ImageIcon(newExit);
		lblExit.setIcon(newImgExit);
		lblExit.setCursor(cursorButton);
		//Jlabel that acts as an separator with an image of pole with vines.
		lblVertical = new JLabel("");
		lblVertical.setBounds(159, -123, 74, 749);
		contentPane.add(lblVertical);
		path = "C:\\TreasureOfHanoiTheGame\\img\\verticalLine.png"; 
		ImageIcon Vertical = new ImageIcon(path); 
		Image imgVertical = Vertical.getImage(); 
		Image newVertical = imgVertical.getScaledInstance(lblVertical.getWidth(), lblVertical.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgVertical = new ImageIcon(newVertical);
		lblVertical.setIcon(newImgVertical);
		
		lblShadow = new JLabel("ADVENTURE MODE");
		lblShadow.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadow.setForeground(SystemColor.text);
		lblShadow.setFont(new Font("Clab Personal Use", Font.BOLD, 62));
		lblShadow.setBounds(237, 65, 837, 81);
		contentPane.add(lblShadow);
		
		lblAdventureMode = new JLabel("ADVENTURE MODE");
		lblAdventureMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdventureMode.setForeground(new Color(0, 0, 0));
		lblAdventureMode.setFont(new Font("Clab Personal Use", Font.BOLD, 62));
		lblAdventureMode.setBounds(237, 55, 837, 91);
		contentPane.add(lblAdventureMode);
		
		lblMove = new JLabel("Moves  Left ");
		lblMove.setForeground(SystemColor.textHighlightText);
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		lblMove.setFont(new Font("Clab Personal Use", Font.BOLD, 20));
		lblMove.setBounds(49, 231, 137, 32);
		getContentPane().add(lblMove);
		
		lblShadowleft = new JLabel("Moves  Left ");
		lblShadowleft.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadowleft.setForeground(SystemColor.activeCaptionText);
		lblShadowleft.setFont(new Font("Clab Personal Use", Font.BOLD, 20));
		lblShadowleft.setBounds(49, 227, 137, 36);
		contentPane.add(lblShadowleft);
		
		//Jlabel with banner image for decoration
		lblBanner1 = new JLabel("");
		lblBanner1.setBounds(53, 201, 122, 91);
		contentPane.add(lblBanner1);
		path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
		ImageIcon Banner1 = new ImageIcon(path); 
		Image imgBanner1 = Banner1.getImage(); 
		Image newBanner1 = imgBanner1.getScaledInstance(lblBanner1.getWidth(), lblBanner1.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBanner1 = new ImageIcon(newBanner1);
		lblBanner1.setIcon(newImgBanner1);
		
		//JLabel to display number of moves 
		lblNumOfMoves = new JLabel("0");
		lblNumOfMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfMoves.setForeground(SystemColor.activeCaptionText);
		lblNumOfMoves.setFont(new Font("Clab Personal Use", Font.BOLD, 56));
		lblNumOfMoves.setBounds(49, 260, 126, 81);
		getContentPane().add(lblNumOfMoves);
		
		//Jlabel with scroll image for decoration
		lblScrollSide = new JLabel("");
		lblScrollSide.setBounds(53, 240, 122, 101);
		contentPane.add(lblScrollSide);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollSide = new ImageIcon(path); 
		Image imgScrollSide = ScrollSide.getImage(); 
		Image newScrollSide = imgScrollSide.getScaledInstance(lblScrollSide.getWidth(), lblScrollSide.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollSide= new ImageIcon(newScrollSide);
		lblScrollSide.setIcon(newImgScrollSide);
		
		//Jlabel with banner image for decoration
		lblBanner = new JLabel("");
		lblBanner.setBounds(284, -21, 752, 222);
		contentPane.add(lblBanner);
		path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
		ImageIcon Banner = new ImageIcon(path); 
		Image imgBanner = Banner.getImage(); 
		Image newBanner = imgBanner.getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBanner = new ImageIcon(newBanner);
		lblBanner.setIcon(newImgBanner);
		
		//Jlabel with scroll image for decoration
		JLabel lblScroll = new JLabel("");
		lblScroll.setBounds(237, 44, 837, 91);
		contentPane.add(lblScroll);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScroll.getWidth(), lblScroll.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScroll.setIcon(newImgScrollBg);
		
		
		lblDisc = new JLabel("LEVEL");
		lblDisc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisc.setForeground(SystemColor.textHighlightText);
		lblDisc.setFont(new Font("Clab Personal Use", Font.BOLD, 32));
		lblDisc.setBounds(53, 89, 122, 36);
		getContentPane().add(lblDisc);
		
		label = new JLabel("LEVEL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.windowText);
		label.setFont(new Font("Clab Personal Use", Font.BOLD, 32));
		label.setBounds(53, 99, 122, 26);
		contentPane.add(label);
		
		txtNumberofDiscs = new JTextField();
		txtNumberofDiscs.setForeground(SystemColor.textHighlightText);
		txtNumberofDiscs.setOpaque(false);
		txtNumberofDiscs.setBorder(null);
		txtNumberofDiscs.setFont(new Font("Clab Personal Use", Font.BOLD, 50));
		txtNumberofDiscs.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumberofDiscs.setEditable(false);
		txtNumberofDiscs.setBounds(75, 124, 74, 58);
		getContentPane().add(txtNumberofDiscs);
		txtNumberofDiscs.setColumns(10);
		txtNumberofDiscs.setText("1");
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\violetLight.png";
		
		lblFrame = new JLabel("");
		lblFrame.setBounds(34, 11, 164, 558);
		contentPane.add(lblFrame);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Frame = new ImageIcon(path); 
		Image imgFrame = Frame.getImage(); 
		Image newFrame = imgFrame.getScaledInstance(lblFrame.getWidth(), lblFrame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgFrame= new ImageIcon(newFrame);
		lblFrame.setIcon(newImgFrame);
		
		//Method for showing the selected panel
		//Initializing panel as a new AdventureGamePlay with parameter of level.
		panel = new AdventureGamePlay(level);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.requestFocus(true);
			}
		});
		panel.setBounds(237, 108, 837, 426);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Background image of the game
		lblGameBackground = new JLabel("");
		lblGameBackground.setIcon(new ImageIcon("C:\\TreasureOfHanoiTheGame\\Gifs\\ezgif.com-resize.gif"));
		lblGameBackground.setBounds(0, 0, 1100, 580);
		contentPane.add(lblGameBackground);
		
		setVisible(true);
		panel.requestFocus(true);
	}

	//Method for updating the remaining moves.
	public static void updateRemainingMove(int remaining) {
		lblNumOfMoves.setText(String.valueOf(remaining));
	}
	//Method for increment of level and initializing panel as new AdventureGamePlay with paremeter of level
	public static void levelUp() {
		level++;
		txtNumberofDiscs.setText(""+level);
		contentPane.remove(panel);
		contentPane.validate();
		panel = new AdventureGamePlay(level);
		panel.grabFocus();
		panel.setBounds(237, 108, 840, 434);
		contentPane.add(panel,2,0);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.requestFocus(true);
		press.keyPress(KeyEvent.VK_SPACE);
	}
	public static void ShowMap() {
		int level = Integer.parseInt(txtNumberofDiscs.getText());
		MapAdventure map = new MapAdventure(level);
		map.setVisible(true);
	}
	
	
}
