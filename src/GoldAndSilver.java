import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Time;
import java.awt.event.*;

public class GoldAndSilver extends JFrame {

	private static JPanel contentPane;
	private JTextField txtNumberofDiscs;
	private JLabel lblDisc;
	private JLabel lblMove;
	public static JLabel lblTimeCount;
	private JLabel lblMinumumMoves;
	private static JLabel lblNumOfMinimumMoves;
	private static JLabel lblNumOfMoves;
	//Default number of discs
	private static int numberofBlock = 3;
	private static JPanel panel;
	private static Robot press;
	private JLabel lblGameBackground;
	private JLabel lblButtonIncrease;
	private JLabel lblButtonDecrease;
	private String path;
	private JLabel lblVertical;
	private JLabel lblButtonRestart;
	private JLabel lblRestart;
	private static String name;
	private JLabel lblBorder;
	private JLabel label;
	private JLabel lblScroll;
	private JLabel label_1, lblScroll2, lblFrame1, lblQuit_1, lblQuit, lblFrame, lblClassic;
	private JLabel label_4;
	public GoldAndSilver() {
		setTitle("Treasure of Hanoi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 580);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize();
		try {
			press = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		//properties of the Frame
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
		
		//Jlabel with image for decoration
		lblBorder = new JLabel("");
		lblBorder.setBounds(-25, 0, 1195, 580);
		contentPane.add(lblBorder);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\border.png"; 
		ImageIcon Border = new ImageIcon(path); 
		Image imgBorder = Border.getImage(); 
		Image newBorder = imgBorder.getScaledInstance(lblBorder.getWidth(), lblBorder.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBorder= new ImageIcon(newBorder);
		lblBorder.setIcon(newImgBorder);
		//Jlabel with image for decoration
		lblVertical = new JLabel("");
		lblVertical.setBounds(168, -122, 83, 749);
		contentPane.add(lblVertical);
		path = "C:\\TreasureOfHanoiTheGame\\img\\verticalLine.png"; 
		ImageIcon Vertical = new ImageIcon(path); 
		Image imgVertical = Vertical.getImage(); 
		Image newVertical = imgVertical.getScaledInstance(lblVertical.getWidth(), lblVertical.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgVertical = new ImageIcon(newVertical);
		lblVertical.setIcon(newImgVertical);
		
		lblDisc = new JLabel("Disc");
		lblDisc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisc.setForeground(SystemColor.textHighlightText);
		lblDisc.setFont(new Font("Clab Personal Use", Font.BOLD, 32));
		lblDisc.setBounds(38, 59, 151, 36);
		getContentPane().add(lblDisc);
		
		label = new JLabel("Disc");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.controlText);
		label.setFont(new Font("Clab Personal Use", Font.BOLD, 32));
		label.setBounds(38, 65, 151, 36);
		contentPane.add(label);
		//Jlabel acts a button for increase of disc.
		lblButtonIncrease = new JLabel("");
		lblButtonIncrease.addMouseListener(new MouseAdapter() {
			//Music with changing of image on mouse release.
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click2.wav");
				numberofBlock = Integer.parseInt(txtNumberofDiscs.getText());
				//checker if numbers of block is less than 7
				//if yes it will increase by 1.
				if(numberofBlock<7)
				numberofBlock++;
				txtNumberofDiscs.setText(String.valueOf(numberofBlock));
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\buttonGreen.png"; 
				ImageIcon ButtonIncrease = new ImageIcon(path); 
				Image imgButtonIncrease = ButtonIncrease.getImage(); 
				Image newButtonIncrease = imgButtonIncrease.getScaledInstance(lblButtonIncrease.getWidth(), lblButtonIncrease.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newButtonInc = new ImageIcon(newButtonIncrease);
				lblButtonIncrease.setIcon(newButtonInc);
			}
			//Image of the Jlabel will return to its original image
			@Override
			public void mousePressed(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\sqrDarkGreen.png"; 
				ImageIcon ButtonIncrease = new ImageIcon(path); 
				Image imgButtonIncrease = ButtonIncrease.getImage(); 
				Image newButtonIncrease = imgButtonIncrease.getScaledInstance(lblButtonIncrease.getWidth(), lblButtonIncrease.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newButtonInc = new ImageIcon(newButtonIncrease);
				lblButtonIncrease.setIcon(newButtonInc);
			}
		});
		lblButtonIncrease.setBounds(35, 132, 83, 62);
		contentPane.add(lblButtonIncrease);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\buttonGreen.png"; 
		ImageIcon ButtonIncrease = new ImageIcon(path); 
		Image imgButtonIncrease = ButtonIncrease.getImage(); 
		Image newButtonIncrease = imgButtonIncrease.getScaledInstance(lblButtonIncrease.getWidth(), lblButtonIncrease.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newButtonInc = new ImageIcon(newButtonIncrease);
		lblButtonIncrease.setIcon(newButtonInc);
		//Jlabel acts a button for decrease of disc.
		lblButtonDecrease = new JLabel("");
		lblButtonDecrease.addMouseListener(new MouseAdapter() {
			//Music with changing of image on mouse release.
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click2.wav");
				numberofBlock = Integer.parseInt(txtNumberofDiscs.getText());
				//checker if numbers of block is greater than 3
				//if yes it will decrease by 1.
				if(numberofBlock>3)
				numberofBlock--;
				txtNumberofDiscs.setText(String.valueOf(numberofBlock));
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\sqrDarkRedLight.png"; 
				ImageIcon ButtonDecrease = new ImageIcon(path); 
				Image imgButtonDecrease = ButtonDecrease.getImage(); 
				Image newButtonDecrease = imgButtonDecrease.getScaledInstance(lblButtonDecrease.getWidth(), lblButtonDecrease.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newButtonDec = new ImageIcon(newButtonDecrease);
				lblButtonDecrease.setIcon(newButtonDec);
			}
			//Image of the Jlabel will return to its original image
			@Override
			public void mousePressed(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\sqrDarkRedcopy.png"; 
				ImageIcon ButtonDecrease = new ImageIcon(path); 
				Image imgButtonDecrease = ButtonDecrease.getImage(); 
				Image newButtonDecrease = imgButtonDecrease.getScaledInstance(lblButtonDecrease.getWidth(), lblButtonDecrease.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newButtonDec = new ImageIcon(newButtonDecrease);
				lblButtonDecrease.setIcon(newButtonDec);
			}
		});
		lblButtonDecrease.setBounds(106, 132, 83, 62);
		contentPane.add(lblButtonDecrease);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\sqrDarkRedLight.png"; 
		ImageIcon ButtonDecrease = new ImageIcon(path); 
		Image imgButtonDecrease = ButtonDecrease.getImage(); 
		Image newButtonDecrease = imgButtonDecrease.getScaledInstance(lblButtonDecrease.getWidth(), lblButtonDecrease.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newButtonDec = new ImageIcon(newButtonDecrease);
		lblButtonDecrease.setIcon(newButtonDec);
		
		txtNumberofDiscs = new JTextField();
		txtNumberofDiscs.setForeground(SystemColor.desktop);
		txtNumberofDiscs.setOpaque(false);
		txtNumberofDiscs.setBorder(null);
		txtNumberofDiscs.setFont(new Font("Clab Personal Use", Font.BOLD, 46));
		txtNumberofDiscs.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumberofDiscs.setEditable(false);
		txtNumberofDiscs.setBounds(41, 92, 148, 55);
		getContentPane().add(txtNumberofDiscs);
		txtNumberofDiscs.setColumns(10);
		txtNumberofDiscs.setText(String.valueOf(numberofBlock));
		
		//JLabel with image for decoration
		lblScroll = new JLabel("");
		lblScroll.setBounds(38, 76, 145, 128);
		contentPane.add(lblScroll);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScroll.getWidth(), lblScroll.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScroll.setIcon(newImgScrollBg);
		
		lblMove = new JLabel("MOVES");
		lblMove.setForeground(SystemColor.textHighlightText);
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		lblMove.setFont(new Font("Clab Personal Use", Font.BOLD, 23));
		lblMove.setBounds(35, 213, 157, 32);
		getContentPane().add(lblMove);
		
		//JLabel that acts as button for Restart.
		lblRestart = new JLabel("RESTART");
		lblRestart.addMouseListener(new MouseAdapter() {
			//Music with changing of image on mouse release.
			@Override
			public void mouseReleased(MouseEvent e) {
				Restart(); 
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\violetLight.png"; 
				ImageIcon ButtonRestart = new ImageIcon(path); 
				Image imgButtonRestart = ButtonRestart.getImage(); 
				Image newButtonRestart = imgButtonRestart.getScaledInstance(lblButtonRestart.getWidth(), lblButtonRestart.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonRestart = new ImageIcon(newButtonRestart);
				lblButtonRestart.setIcon(newImgButtonRestart);
			}
			//JLabel image will return to its original image.
			@Override
			public void mousePressed(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\violetDark.png"; 
				ImageIcon ButtonRestart = new ImageIcon(path); 
				Image imgButtonRestart = ButtonRestart.getImage(); 
				Image newButtonRestart = imgButtonRestart.getScaledInstance(lblButtonRestart.getWidth(), lblButtonRestart.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonRestart = new ImageIcon(newButtonRestart);
				lblButtonRestart.setIcon(newImgButtonRestart);
			}
		});
		label_1 = new JLabel("MOVES");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(SystemColor.infoText);
		label_1.setFont(new Font("Clab Personal Use", Font.BOLD, 23));
		label_1.setBounds(35, 215, 157, 36);
		contentPane.add(label_1);
		
		lblRestart.setForeground(SystemColor.text);
		lblRestart.setFont(new Font("Clab Personal Use", Font.BOLD, 23));
		lblRestart.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestart.setBounds(54, 421, 129, 55);
		contentPane.add(lblRestart);
		
		//JLabel with image for decoration
		lblButtonRestart = new JLabel("");
		lblButtonRestart.setBounds(44, 355, 145, 184);
		contentPane.add(lblButtonRestart);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\violetLight.png"; 
		ImageIcon ButtonRestart = new ImageIcon(path); 
		Image imgButtonRestart = ButtonRestart.getImage(); 
		Image newButtonRestart = imgButtonRestart.getScaledInstance(lblButtonRestart.getWidth(), lblButtonRestart.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonRestart = new ImageIcon(newButtonRestart);
		lblButtonRestart.setIcon(newImgButtonRestart);
		
		//JLabel for displaying the numbers of Moves.
		lblNumOfMoves = new JLabel("0");
		lblNumOfMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfMoves.setForeground(SystemColor.activeCaptionText);
		lblNumOfMoves.setFont(new Font("Clab Personal Use", Font.BOLD, 56));
		lblNumOfMoves.setBounds(35, 243, 157, 62);

		getContentPane().add(lblNumOfMoves);
		
		
		lblMinumumMoves = new JLabel("Minumum Moves :");
		lblMinumumMoves.setForeground(SystemColor.textText);
		lblMinumumMoves.setFont(new Font("Clab Personal Use", Font.BOLD, 38));
		lblMinumumMoves.setBounds(261, 73, 340, 43);
		getContentPane().add(lblMinumumMoves);
		
		//JLabel for displaying the minimun numbers of Moves.
		lblNumOfMinimumMoves = new JLabel("7");
		lblNumOfMinimumMoves.setForeground(SystemColor.infoText);
		lblNumOfMinimumMoves.setFont(new Font("Clab Personal Use", Font.BOLD, 41));
		lblNumOfMinimumMoves.setBounds(610, 68, 98, 59);
		getContentPane().add(lblNumOfMinimumMoves);
		
		/*
		 * setLblCongrats(new JLabel(""));
		 * getLblCongrats().setHorizontalAlignment(SwingConstants.CENTER);
		 * getLblCongrats().setForeground(new Color(255, 204, 0));
		 * getLblCongrats().setFont(new Font("Clab Personal Use", Font.BOLD, 36));
		 * getLblCongrats().setBounds(442, 26, 172, 27);
		 * getContentPane().add(getLblCongrats());
		 */
		//JLabel with image for decoration
		lblScroll2 = new JLabel("");
		lblScroll2.setBounds(38, 222, 151, 79);
		contentPane.add(lblScroll2);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg2 = new ImageIcon(path); 
		Image imgScrollBg2 = ScrollBg2.getImage(); 
		Image newScrollBg2 = imgScrollBg2.getScaledInstance(lblScroll2.getWidth(), lblScroll2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg2 = new ImageIcon(newScrollBg2);
		lblScroll2.setIcon(newImgScrollBg2);
		
		//JLabel with image for decoration
		lblFrame1 = new JLabel("");
		lblFrame1.setBounds(237, 55, 494, 79);
		contentPane.add(lblFrame1);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg4 = new ImageIcon(path); 
		Image imgScrollBg4 = ScrollBg4.getImage(); 
		Image newScrollBg4 = imgScrollBg4.getScaledInstance(lblFrame1.getWidth(), lblFrame1.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg4 = new ImageIcon(newScrollBg4);
		lblFrame1.setIcon(newImgScrollBg4);
		//Initialization of panel as new Gold and Silver Game Play with parameters of number of block and name.
		panel = new GoldAndSilverGamePlay(numberofBlock,name);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.requestFocus(true);
			}
		});
		//JLabel that acts as an button for Quit
		lblQuit_1 = new JLabel("QUIT");
		lblQuit_1.addMouseListener(new MouseAdapter() {
			//Changes image when mouse is pressed 
			@Override
			public void mousePressed(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldDark.png"; 
				ImageIcon ButtonClassic = new ImageIcon(path); 
				Image imgButtonClassic = ButtonClassic.getImage(); 
				Image newButtonClassic = imgButtonClassic.getScaledInstance(lblQuit.getWidth(), lblQuit.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
				lblQuit.setIcon(newImgButtonClassic);
			}
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//music for the button when the mouse released the JLabel
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				//initializing the number of block to its original count and restarts the game
				numberofBlock = 3;
				Restart();
				setVisible(false);
				//changes image to its original image.
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldLight.png"; 
				ImageIcon ButtonClassic = new ImageIcon(path); 
				Image imgButtonClassic = ButtonClassic.getImage(); 
				Image newButtonClassic = imgButtonClassic.getScaledInstance(lblQuit.getWidth(), lblQuit.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
				lblQuit.setIcon(newImgButtonClassic);
			}
		});
			lblQuit_1.setForeground(SystemColor.textHighlightText);
			lblQuit_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuit_1.setFont(new Font("Clab Personal Use", Font.BOLD, 24));
			lblQuit_1.setBounds(54, 480, 122, 55);
			contentPane.add(lblQuit_1);
			//JLabel with image for decorations
			lblQuit = new JLabel("");
			lblQuit.setBounds(44, 414, 145, 184);
			contentPane.add(lblQuit);
			path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldLight.png"; 
			ImageIcon ButtonClassic = new ImageIcon(path); 
			Image imgButtonClassic = ButtonClassic.getImage(); 
			Image newButtonClassic = imgButtonClassic.getScaledInstance(lblQuit.getWidth(), lblQuit.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
			lblQuit.setIcon(newImgButtonClassic);
			
			lblClassic = new JLabel("GOLD & SILVER");
			lblClassic.setForeground(SystemColor.textHighlightText);
			lblClassic.setFont(new Font("Cooper Black", Font.BOLD, 27));
			lblClassic.setHorizontalAlignment(SwingConstants.CENTER);
			lblClassic.setBounds(828, 59, 249, 68);
			contentPane.add(lblClassic);
			
			label_4 = new JLabel("GOLD & SILVER");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setForeground(SystemColor.desktop);
			label_4.setFont(new Font("Cooper Black", Font.BOLD, 27));
			label_4.setBounds(828, 59, 249, 79);
			contentPane.add(label_4);
			//JLabel with image for decorations
			JLabel lblBanner = new JLabel("");
			lblBanner.setBounds(811, -12, 276, 216);
			contentPane.add(lblBanner);
			path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
			ImageIcon Banner = new ImageIcon(path); 
			Image imgBanner = Banner.getImage(); 
			Image newBanner = imgBanner.getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon newImgBanner = new ImageIcon(newBanner);
			lblBanner.setIcon(newImgBanner);
		
		panel.setBounds(237, 108, 840, 434);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//JLabel with image for decorations
		lblFrame = new JLabel("");
		lblFrame.setBounds(10, 11, 217, 569);
		contentPane.add(lblFrame);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Frame = new ImageIcon(path); 
		Image imgFrame = Frame.getImage(); 
		Image newFrame = imgFrame.getScaledInstance(lblFrame.getWidth(), lblFrame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgFrame= new ImageIcon(newFrame);
		lblFrame.setIcon(newImgFrame);
		//JLabel with image for decorations
		lblGameBackground = new JLabel("");
		lblGameBackground.setIcon(new ImageIcon("C:\\TreasureOfHanoiTheGame\\Gifs\\ezgif.com-resize.gif"));
		lblGameBackground.setBounds(21, 0, 1150, 580);
		contentPane.add(lblGameBackground);
		
		setVisible(true);
		panel.requestFocus(true);
	}
	
	//Method for updating the move that accepts parameter of Integer value
	public static void updateMove(int numberOfMove) {
		lblNumOfMoves.setText(String.valueOf(numberOfMove));
	}
	//Method for updating the maximum move that accepts parameter of Integer value
	public static void updateMaxMove(int maxMove) {
		lblNumOfMinimumMoves.setText(String.valueOf(maxMove));
	}
	//Method for restarting the game
	public static void Restart() {
		contentPane.remove(panel);
		contentPane.validate();
		panel = new GoldAndSilverGamePlay(numberofBlock,name);
		panel.grabFocus();
		panel.setBounds(237, 108, 840, 434);
		contentPane.add(panel,2,0);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.requestFocus(true);
		press.keyPress(KeyEvent.VK_SPACE);
	}
	
	//Getter for lblTimeCount
	public static JLabel getLblTimeCount() {
		return lblTimeCount;
	}
	//Setter for lblTimeCount
	public static void setLblTimeCount(JLabel lblTimeCount) {
		GoldAndSilver.lblTimeCount = lblTimeCount;
	}
}
