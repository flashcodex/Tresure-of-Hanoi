import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModeFrame extends JFrame {
	//class Frame
	private JPanel contentPane;
	private String path;
	private JLabel lblButtonClassic;
	private JLabel lblButtonAdventure;
	private JLabel lblButtonGoldSilver;
	private JLabel lblClassic;
	private JLabel lblAdventure;
	private JLabel lblGoldandSilver;

	
	public ModeFrame() {
		//properties of Frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Change mouse pointer with an image
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorimageNormal = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\fighercursor.png");
		Image cursorimageButton = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\gloves.png");
		Point point = new Point(0,0);
		Cursor cursorNormal = toolkit.createCustomCursor(cursorimageNormal, point, "Cursor");
		Cursor cursorButton = toolkit.createCustomCursor(cursorimageButton, point, "Cursor");
		
		this.setCursor(cursorNormal);
		//JLabel that acts as a button for Exit
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			//mouseEntered and mouseExited has override method that makes animation
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBounds(481, 25, 49, 45);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBounds(481, 27, 49, 45);
			}
			//music when mouse released and hides the frame
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				setVisible(false);
			}
		});
		lblExit.setBounds(481, 27, 49, 45);
		contentPane.add(lblExit);
		path = "C:\\TreasureOfHanoiTheGame\\img\\faceCross.png"; 
		ImageIcon Exit = new ImageIcon(path); 
		Image imgExit = Exit.getImage(); 
		Image newExit = imgExit.getScaledInstance(lblExit.getWidth(), lblExit.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgExit = new ImageIcon(newExit);
		lblExit.setIcon(newImgExit);
		lblExit.setCursor(cursorButton);
		
		JLabel lblGameMode = new JLabel("GAME MODE");
		lblGameMode.setForeground(Color.WHITE);
		lblGameMode.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 42));
		lblGameMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameMode.setBounds(151, 161, 266, 34);
		contentPane.add(lblGameMode);
		
		JLabel lblShadowGame = new JLabel("GAME MODE");
		lblShadowGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadowGame.setForeground(new Color(178, 34, 34));
		lblShadowGame.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 42));
		lblShadowGame.setBounds(151, 156, 266, 34);
		contentPane.add(lblShadowGame);
		//JLabel with image for decoration
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(101, 109, 365, 157);
		contentPane.add(lblBanner);
		path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
		ImageIcon Banner = new ImageIcon(path); 
		Image imgBanner = Banner.getImage(); 
		Image newBanner = imgBanner.getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBanner = new ImageIcon(newBanner);
		lblBanner.setIcon(newImgBanner);
		//JLabel with image for decoration
		JLabel lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon("C:\\TreasureOfHanoiTheGame\\Gifs\\CrabsChest.gif"));
		lblGif.setBounds(151, 32, 256, 163);
		contentPane.add(lblGif);
		
		//JLabel that acts as button for Classic 
		lblClassic = new JLabel("CLASSIC");
		lblClassic.addMouseListener(new MouseAdapter() {
			//music and change of image for animation when mouse entered the JLabel
			@Override
			public void mouseEntered(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldDark.png"; 
				ImageIcon ButtonClassic = new ImageIcon(path); 
				Image imgButtonClassic = ButtonClassic.getImage(); 
				Image newButtonClassic = imgButtonClassic.getScaledInstance(lblButtonClassic.getWidth(), lblButtonClassic.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
				lblButtonClassic.setIcon(newImgButtonClassic);
			}
			//change of image to original image.
			@Override
			public void mouseExited(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldLight.png"; 
				ImageIcon ButtonClassic = new ImageIcon(path); 
				Image imgButtonClassic = ButtonClassic.getImage(); 
				Image newButtonClassic = imgButtonClassic.getScaledInstance(lblButtonClassic.getWidth(), lblButtonClassic.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
				lblButtonClassic.setIcon(newImgButtonClassic);
			}
			//music when mouse released and opens Tower of Hanoi frame
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				TowerOfHanoi frmTowerOfHanoi = new TowerOfHanoi();
				frmTowerOfHanoi.setVisible(true);
				setVisible(false);
			}
		});
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 27));
		lblClassic.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassic.setBounds(196, 232, 177, 34);
		contentPane.add(lblClassic);
		lblClassic.setCursor(cursorButton);
		
		//JLabel that acts as button for Adventure 
		lblAdventure = new JLabel("ADVENTURE");
		lblAdventure.addMouseListener(new MouseAdapter() {
			//music and change of image for animation when mouse entered the JLabel
			@Override
			public void mouseEntered(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenDark.png"; 
				ImageIcon ButtonAdventure = new ImageIcon(path); 
				Image imgButtonAdventure = ButtonAdventure.getImage(); 
				Image newButtonAdventure = imgButtonAdventure.getScaledInstance(lblButtonAdventure.getWidth(), lblButtonAdventure.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonAdventure = new ImageIcon(newButtonAdventure);
				lblButtonAdventure.setIcon(newImgButtonAdventure);
			}
			//change of image to original image.
			@Override
			public void mouseExited(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenLight.png"; 
				ImageIcon ButtonAdventure = new ImageIcon(path); 
				Image imgButtonAdventure = ButtonAdventure.getImage(); 
				Image newButtonAdventure = imgButtonAdventure.getScaledInstance(lblButtonAdventure.getWidth(), lblButtonAdventure.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonAdventure = new ImageIcon(newButtonAdventure);
				lblButtonAdventure.setIcon(newImgButtonAdventure);
			}
			//music when mouse released and opens Adveture frame
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				Adventure frmAdventure = new Adventure();
				OpeningFrame frmOpeningFrame = new OpeningFrame();
				frmOpeningFrame.setVisible(false);
				frmAdventure.setVisible(true);
				setVisible(false);
			}
		});
		lblAdventure.setForeground(new Color(255, 255, 255));
		lblAdventure.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 26));
		lblAdventure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdventure.setBounds(195, 293, 181, 32);
		contentPane.add(lblAdventure);
		lblAdventure.setCursor(cursorButton);
		
		//JLabel that acts as button for Gold and Silver 
		lblGoldandSilver = new JLabel("GOLD AND SILVER");
		lblGoldandSilver.addMouseListener(new MouseAdapter() {
			//music and change of image for animation when mouse entered the JLabel
			@Override
			public void mouseEntered(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redDark.png"; 
				ImageIcon ButtonGoldSilver = new ImageIcon(path); 
				Image imgButtonGoldSilver = ButtonGoldSilver.getImage(); 
				Image newButtonGoldSilver = imgButtonGoldSilver.getScaledInstance(lblButtonGoldSilver.getWidth(), lblButtonGoldSilver.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonGoldSilver = new ImageIcon(newButtonGoldSilver);
				lblButtonGoldSilver.setIcon(newImgButtonGoldSilver);
			}
			//change of image to original image.
			@Override
			public void mouseExited(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redLight.png"; 
				ImageIcon ButtonGoldSilver = new ImageIcon(path); 
				Image imgButtonGoldSilver = ButtonGoldSilver.getImage(); 
				Image newButtonGoldSilver = imgButtonGoldSilver.getScaledInstance(lblButtonGoldSilver.getWidth(), lblButtonGoldSilver.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonGoldSilver = new ImageIcon(newButtonGoldSilver);
				lblButtonGoldSilver.setIcon(newImgButtonGoldSilver);
			}
			//music when mouse released and opens Gold And Silver frame
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				GoldAndSilver frmGoldAndSilver = new GoldAndSilver();
				OpeningFrame frmOpeningFrame = new OpeningFrame();
				frmOpeningFrame.setVisible(false);
				frmGoldAndSilver.setVisible(true);
				setVisible(false);
			}
		});
		lblGoldandSilver.setForeground(new Color(255, 255, 255));
		lblGoldandSilver.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 21));
		lblGoldandSilver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldandSilver.setBounds(201, 355, 169, 30);
		contentPane.add(lblGoldandSilver);
		lblGoldandSilver.setCursor(cursorButton);
		//JLabel with image for decorations
		lblButtonClassic = new JLabel("");
		lblButtonClassic.setBounds(179, 176, 212, 149);
		contentPane.add(lblButtonClassic);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\goldLight.png"; 
		ImageIcon ButtonClassic = new ImageIcon(path); 
		Image imgButtonClassic = ButtonClassic.getImage(); 
		Image newButtonClassic = imgButtonClassic.getScaledInstance(lblButtonClassic.getWidth(), lblButtonClassic.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonClassic = new ImageIcon(newButtonClassic);
		lblButtonClassic.setIcon(newImgButtonClassic);
		//JLabel with image for decorations
		lblButtonAdventure = new JLabel("");
		lblButtonAdventure.setBounds(179, 236, 212, 149);
		contentPane.add(lblButtonAdventure);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenLight.png"; 
		ImageIcon ButtonAdventure = new ImageIcon(path); 
		Image imgButtonAdventure = ButtonAdventure.getImage(); 
		Image newButtonAdventure = imgButtonAdventure.getScaledInstance(lblButtonAdventure.getWidth(), lblButtonAdventure.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonAdventure = new ImageIcon(newButtonAdventure);
		lblButtonAdventure.setIcon(newImgButtonAdventure);
		//JLabel with image for decorations
		lblButtonGoldSilver = new JLabel("");
		lblButtonGoldSilver.setBounds(179, 297, 212, 149);
		contentPane.add(lblButtonGoldSilver);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redLight.png"; 
		ImageIcon ButtonGoldSilver = new ImageIcon(path); 
		Image imgButtonGoldSilver = ButtonGoldSilver.getImage(); 
		Image newButtonGoldSilver = imgButtonGoldSilver.getScaledInstance(lblButtonGoldSilver.getWidth(), lblButtonGoldSilver.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonGoldSilver = new ImageIcon(newButtonGoldSilver);
		lblButtonGoldSilver.setIcon(newImgButtonGoldSilver);
		//JLabel with image for decorations
		JLabel lblScroll = new JLabel("");
		lblScroll.setBounds(83, 27, 396, 426);
		contentPane.add(lblScroll);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScroll.getWidth(), lblScroll.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScroll.setIcon(newImgScrollBg);
		path = "C:\\TreasureOfHanoiTheGame\\img\\leaderBoardFrame.png"; 
		//JLabel with image for decorations
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(-85, -13, 731, 514);
		contentPane.add(lblBackground);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Background = new ImageIcon(path); 
		Image imgBackground = Background.getImage(); 
		Image newBackground = imgBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBackground = new ImageIcon(newBackground);
		lblBackground.setIcon(newImgBackground);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);	
	}
}
