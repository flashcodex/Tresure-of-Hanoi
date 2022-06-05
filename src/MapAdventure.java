import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
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
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapAdventure extends JFrame {
	//class properties
	private JPanel contentPane;
	private String path;
	private int level;
	private JLabel lblButtonOkay;

	
	public MapAdventure(int level) {
		//properties of the frame
		this.level = level;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(22, 25, 23));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorimageNormal = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\fighercursor.png");
		Image cursorimageButton = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\gloves.png");
		Point point = new Point(0,0);
		Cursor cursorNormal = toolkit.createCustomCursor(cursorimageNormal, point, "Cursor");
		Cursor cursorButton = toolkit.createCustomCursor(cursorimageButton, point, "Cursor");
		
		setCursor(cursorNormal);
		
		String level1 = "C:\\TreasureOfHanoiTheGame\\Map\\Level1.png"; 
		String level2 = "C:\\TreasureOfHanoiTheGame\\Map\\Level2.png"; 
		String level3 = "C:\\TreasureOfHanoiTheGame\\Map\\Level3.png"; 
		String level4 = "C:\\TreasureOfHanoiTheGame\\Map\\Level4.png"; 
		String level5 = "C:\\TreasureOfHanoiTheGame\\Map\\Level5.png"; 
		
		String[] Map = {level1, level2, level3, level4, level5};
		path = Map[level-1];
		
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
		lblButtonOkay.setBounds(68, 383, 78, 51);
		contentPane.add(lblButtonOkay);
		lblButtonOkay.setCursor(cursorButton);

		JLabel lblMap = new JLabel("");
		lblMap.setBounds(39, 27, 668, 433);
		contentPane.add(lblMap);
		path = Map[level-1];
		ImageIcon map = new ImageIcon(path);
		Image imgMap = map.getImage();
		Image newMap = imgMap.getScaledInstance(lblMap.getWidth(), lblMap.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newimgMap = new ImageIcon(newMap);
		lblMap.setIcon(newimgMap);
		
		JLabel lblScrollBg = new JLabel("");
		lblScrollBg.setBounds(-3, 1, 744, 495);
		contentPane.add(lblScrollBg);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScrollBg.getWidth(), lblScrollBg.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScrollBg.setIcon(newImgScrollBg);
		
		JLabel lblFrame = new JLabel("");
		lblFrame.setBounds(-200, -16, 1077, 540);
		contentPane.add(lblFrame);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Frame = new ImageIcon(path); 
		Image imgFrame = Frame.getImage(); 
		Image newFrame = imgFrame.getScaledInstance(lblFrame.getWidth(), lblFrame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgFrame = new ImageIcon(newFrame);
		lblFrame.setIcon(newImgFrame);

	}
}