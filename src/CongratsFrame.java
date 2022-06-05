import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CongratsFrame extends JFrame {
	//class properties
	private JPanel contentPane;
	private String path;
	private JLabel lblNumberOfCoins;
	private JLabel lblNumberOfMoves;
	private JLabel lblNumberOfTime;
	private JLabel lblButtonOkay;
	private JLabel lblTime;
	private JLabel lblTime_1;

	
	public CongratsFrame() {
		//properties of the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		
		JLabel lblCoins = new JLabel("COINS : ");
		lblCoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoins.setForeground(Color.WHITE);
		lblCoins.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		lblCoins.setBounds(89, 296, 113, 59);
		contentPane.add(lblCoins);
		
		JLabel label_2 = new JLabel("COINS : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(SystemColor.activeCaptionText);
		label_2.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		label_2.setBounds(89, 296, 113, 65);
		contentPane.add(label_2);
		
		//JLabel to display number of coins.
		lblNumberOfCoins = new JLabel("0");
		lblNumberOfCoins.setForeground(Color.BLACK);
		lblNumberOfCoins.setFont(new Font("Cooper Black", Font.PLAIN, 37));
		lblNumberOfCoins.setBounds(193, 296, 143, 59);
		contentPane.add(lblNumberOfCoins);
		
		JLabel lblMoves = new JLabel("MOVES :");
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setForeground(Color.WHITE);
		lblMoves.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		lblMoves.setBounds(89, 252, 100, 59);
		contentPane.add(lblMoves);
		
		JLabel label_1 = new JLabel("MOVES :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(SystemColor.activeCaptionText);
		label_1.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		label_1.setBounds(89, 262, 100, 45);
		contentPane.add(label_1);
		
		//JLabel to display number of moves.
		lblNumberOfMoves = new JLabel("0");
		lblNumberOfMoves.setForeground(Color.BLACK);
		lblNumberOfMoves.setFont(new Font("Cooper Black", Font.PLAIN, 42));
		lblNumberOfMoves.setBounds(212, 252, 80, 59);
		contentPane.add(lblNumberOfMoves);
		
		lblTime = new JLabel("TIME  : ");
		lblTime.setForeground(new Color(255, 255, 255));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		lblTime.setBounds(109, 207, 87, 59);
		contentPane.add(lblTime);
		
		//JLabel to display time.
		lblNumberOfTime = new JLabel("0");
		lblNumberOfTime.setForeground(SystemColor.activeCaptionText);
		lblNumberOfTime.setFont(new Font("Cooper Black", Font.PLAIN, 42));
		lblNumberOfTime.setBounds(212, 207, 93, 59);
		contentPane.add(lblNumberOfTime);
		
		lblTime_1 = new JLabel("TIME  : ");
		lblTime_1.setForeground(SystemColor.desktop);
		lblTime_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1.setFont(new Font("Cooper Black", Font.PLAIN, 23));
		lblTime_1.setBounds(109, 207, 87, 65);
		contentPane.add(lblTime_1);
		
		JLabel lblVictory_1 = new JLabel("VICTORY!");
		lblVictory_1.setForeground(new Color(255, 215, 0));
		lblVictory_1.setFont(new Font("Cooper Black", Font.BOLD, 34));
		lblVictory_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictory_1.setBounds(89, 138, 203, 45);
		contentPane.add(lblVictory_1);
		
		JLabel label = new JLabel("VICTORY!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(46, 139, 87));
		label.setFont(new Font("Cooper Black", Font.BOLD, 36));
		label.setBounds(89, 131, 203, 59);
		contentPane.add(label);
		
		//Jlabel with Image for decoration
		JLabel lblVictory = new JLabel("");
		lblVictory.setBounds(56, 41, 266, 177);
		contentPane.add(lblVictory);
		path = "C:\\TreasureOfHanoiTheGame\\img\\logo_2.png"; 
		ImageIcon Victory = new ImageIcon(path); 
		Image imgVictory = Victory.getImage(); 
		Image newVictory = imgVictory.getScaledInstance(lblVictory.getWidth(), lblVictory.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgVictory = new ImageIcon(newVictory);
		lblVictory.setIcon(newImgVictory);
		
		//Jlabel with Image for decoration
		JLabel lblTrophy = new JLabel("");
		lblTrophy.setBounds(99, 372, 56, 59);
		contentPane.add(lblTrophy);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldTrophy.png"; 
		ImageIcon buttonTrophy = new ImageIcon(path); 
		Image imgButtonTrophy = buttonTrophy.getImage(); 
		Image newButtonTrophy = imgButtonTrophy.getScaledInstance(lblTrophy.getWidth(), lblTrophy.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonTrophy = new ImageIcon(newButtonTrophy);
		lblTrophy.setIcon(newImgButtonTrophy);
		//Jlabel with Image for decoration
		JLabel lblTrophy1 = new JLabel("");
		lblTrophy1.setBounds(153, 356, 70, 75);
		contentPane.add(lblTrophy1);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldTrophy.png"; 
		ImageIcon buttonTrophy1 = new ImageIcon(path); 
		Image imgButtonTrophy1 = buttonTrophy1.getImage(); 
		Image newButtonTrophy1 = imgButtonTrophy1.getScaledInstance(lblTrophy1.getWidth(), lblTrophy1.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonTrophy1 = new ImageIcon(newButtonTrophy1);
		lblTrophy1.setIcon(newImgButtonTrophy1);
		//Jlabel with Image for decoration
		JLabel lblTrophy2 = new JLabel("");
		lblTrophy2.setBounds(222, 372, 56, 59);
		contentPane.add(lblTrophy2);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldTrophy.png"; 
		ImageIcon buttonTrophy2 = new ImageIcon(path); 
		Image imgButtonTrophy2 = buttonTrophy2.getImage(); 
		Image newButtonTrophy2 = imgButtonTrophy2.getScaledInstance(lblTrophy2.getWidth(), lblTrophy2.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonTrophy2 = new ImageIcon(newButtonTrophy2);
		lblTrophy2.setIcon(newImgButtonTrophy2);
		//Jlabel with Image for decoration
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(66, 311, 247, 177);
		contentPane.add(lblBanner);
		path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
		ImageIcon Banner = new ImageIcon(path); 
		Image imgBanner = Banner.getImage(); 
		Image newBanner = imgBanner.getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBanner = new ImageIcon(newBanner);
		lblBanner.setIcon(newImgBanner);
		//Jlabel with Image for decoration
		JLabel lblScrollBg = new JLabel("");
		lblScrollBg.setBounds(56, 181, 266, 239);
		contentPane.add(lblScrollBg);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScrollBg.getWidth(), lblScrollBg.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScrollBg.setIcon(newImgScrollBg);
		//JLabel that acts as Okay button  
		lblButtonOkay = new JLabel("");
		lblButtonOkay.addMouseListener(new MouseAdapter() {
			//music for the button when the mouse released the JLabel
			//hides the frame
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				setVisible(false);
			}
		});
		lblButtonOkay.setBounds(299, 425, 56, 52);
		contentPane.add(lblButtonOkay);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Start.png"; 
		ImageIcon buttonStartIcon = new ImageIcon(path); 
		Image imgButtonStartIcon = buttonStartIcon.getImage(); 
		Image newButtonStartIcon = imgButtonStartIcon.getScaledInstance(lblButtonOkay.getWidth(), lblButtonOkay.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonStartIcon = new ImageIcon(newButtonStartIcon);
		lblButtonOkay.setIcon(newImgButtonStartIcon);
		//Jlabel with Image for decoration
		JLabel lblFrame = new JLabel("");
		lblFrame.setBounds(-136, -12, 649, 539);
		contentPane.add(lblFrame);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame2.png"; 
		ImageIcon Background = new ImageIcon(path); 
		Image imgBackground = Background.getImage(); 
		Image newBackground = imgBackground.getScaledInstance(lblFrame.getWidth(), lblFrame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBackground = new ImageIcon(newBackground);
		lblFrame.setIcon(newImgBackground);
		
	}
	//Method for displaying the information that accepts parameters of String and two Integer values
	public void setInformation(String time , int moves , int coins) {
		if(time == null) {
			lblTime.setVisible(false);
			lblTime_1.setVisible(false);
			lblNumberOfTime.setVisible(false);	
		}
		else 
			lblNumberOfTime.setText(time);	
		
		lblNumberOfMoves.setText(String.valueOf(moves));
		lblNumberOfCoins.setText(String.valueOf(coins));
	}
}