import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Quit extends JFrame {
	//class properties
	private JPanel contentPane;
	private String path;
	private JLabel lblNo;
	private JLabel lblYes;

	public Quit() {
		//properties of frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 239);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Change the display of mouse pointer to an image
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorimageNormal = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\fighercursor.png");
		Image cursorimageButton = toolkit.getImage("C:\\TreasureOfHanoiTheGame\\Cursor\\gloves.png");
		Point point = new Point(0,0);
		Cursor cursorNormal = toolkit.createCustomCursor(cursorimageNormal, point, "Cursor");
		Cursor cursorButton = toolkit.createCustomCursor(cursorimageButton, point, "Cursor");
		
		this.setCursor(cursorNormal);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 376, 214);
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Jlabel wih iamge for decorations
		JLabel lblCryingPirate = new JLabel("");
		lblCryingPirate.setIcon(new ImageIcon("C:\\TreasureOfHanoiTheGame\\Gifs\\ezgif.com-resize (1).gif"));
		lblCryingPirate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCryingPirate.setBounds(120, 11, 130, 90);
		panel.add(lblCryingPirate);
		
		//Jlabel act as display for YES button.
		JLabel lblYes_1 = new JLabel("YES");
		lblYes_1.addMouseListener(new MouseAdapter() {
			//music for the button when the mouse released the JLabel
			@Override
			public void mouseReleased(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenDark.png"; 
				ImageIcon ButtonYes = new ImageIcon(path); 
				Image imgButtonYes = ButtonYes.getImage(); 
				Image newButtonYes = imgButtonYes.getScaledInstance(lblYes.getWidth(), lblYes.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonYes = new ImageIcon(newButtonYes);
				lblYes.setIcon(newImgButtonYes);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenLight.png"; 
				ImageIcon ButtonYes = new ImageIcon(path); 
				Image imgButtonYes = ButtonYes.getImage(); 
				Image newButtonYes = imgButtonYes.getScaledInstance(lblYes.getWidth(), lblYes.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonYes = new ImageIcon(newButtonYes);
				lblYes.setIcon(newImgButtonYes);
			}
		});
		lblYes_1.setForeground(SystemColor.textHighlightText);
		lblYes_1.setFont(new Font("Clab Personal Use", Font.BOLD, 19));
		lblYes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYes_1.setBounds(75, 146, 93, 27);
		panel.add(lblYes_1);
		lblYes_1.setCursor(cursorButton);
		
		JLabel lblNo_1 = new JLabel("NO");
		lblNo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redDark.png"; 
				ImageIcon ButtonNo = new ImageIcon(path); 
				Image imgButtonNo = ButtonNo.getImage(); 
				Image newButtonNo= imgButtonNo.getScaledInstance(lblNo.getWidth(), lblNo.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonNo = new ImageIcon(newButtonNo);
				lblNo.setIcon(newImgButtonNo);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redLight.png"; 
				ImageIcon ButtonNo = new ImageIcon(path); 
				Image imgButtonNo = ButtonNo.getImage(); 
				Image newButtonNo= imgButtonNo.getScaledInstance(lblNo.getWidth(), lblNo.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImgButtonNo = new ImageIcon(newButtonNo);
				lblNo.setIcon(newImgButtonNo);
			}

		});
		lblNo_1.setForeground(SystemColor.textHighlightText);
		lblNo_1.setFont(new Font("Clab Personal Use", Font.BOLD, 19));
		lblNo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo_1.setBounds(198, 146, 93, 27);
		panel.add(lblNo_1);
		lblNo_1.setCursor(cursorButton);
		
		JLabel label = new JLabel("Are you sure you want to quit?");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Clab Personal Use", Font.BOLD, 22));
		label.setBounds(0, 91, 376, 44);
		panel.add(label);
		//Jlabel with image for button
		lblYes = new JLabel("");
		lblYes.setBounds(75, 91, 93, 137);
		panel.add(lblYes);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\greenLight.png"; 
		ImageIcon ButtonYes = new ImageIcon(path); 
		Image imgButtonYes = ButtonYes.getImage(); 
		Image newButtonYes = imgButtonYes.getScaledInstance(lblYes.getWidth(), lblYes.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonYes = new ImageIcon(newButtonYes);
		lblYes.setIcon(newImgButtonYes);
		
		//Jlabel with image for button
		lblNo = new JLabel("");
		lblNo.setBounds(198, 91, 93, 137);
		panel.add(lblNo);
		path = "C:\\TreasureOfHanoiTheGame\\ButtonAssets\\redLight.png"; 
		ImageIcon ButtonNo = new ImageIcon(path); 
		Image imgButtonNo = ButtonNo.getImage(); 
		Image newButtonNo= imgButtonNo.getScaledInstance(lblNo.getWidth(), lblNo.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonNo = new ImageIcon(newButtonNo);
		lblNo.setIcon(newImgButtonNo);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to quit?");
		lblAreYouSure.setFont(new Font("Clab Personal Use", Font.BOLD, 22));
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setBounds(0, 97, 376, 38);
		panel.add(lblAreYouSure);
		
		//Image of scroll for decoration.
		JLabel lblScroll = new JLabel("");
		lblScroll.setBounds(0, 0, 376, 214);
		panel.add(lblScroll);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScroll.getWidth(), lblScroll.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScroll.setIcon(newImgScrollBg);
		
		//Background image of the frame
		JLabel lblBg = new JLabel("");
		lblBg.setBounds(-57, -17, 516, 266);
		contentPane.add(lblBg);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Background = new ImageIcon(path); 
		Image imgBackground = Background.getImage(); 
		Image newBackground = imgBackground.getScaledInstance(lblBg.getWidth(), lblBg.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBackground = new ImageIcon(newBackground);
		lblBg.setIcon(newImgBackground);
	}
}
