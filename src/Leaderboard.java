import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JTabbedPane;

public class Leaderboard extends JFrame {
	//Class properties
	private JPanel contentPane;
	private String path;
	private JLabel lblExit;
	private JTable tblClassic;
	private JTable tblAdventure;
	private JTable tblGoldandSilver;
	
	public static DefaultTableModel modelClassic = OpeningFrame.modelClassic;
	public static DefaultTableModel modelAdventure = OpeningFrame.modelAdventure;
	public static DefaultTableModel modelGoldSilver = OpeningFrame.modelGoldSilver;
	private JPanel pnlContent;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public Leaderboard() {
		//Properties of Frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setBounds(100, 100, 1100, 579);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
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
		//tabbedPane for the selection of Leaderboard
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(255, 235, 205));
		tabbedPane.setFont(new Font("Century Gothic", Font.BOLD, 18));
		tabbedPane.setBounds(68, 168, 962, 342);
		contentPane.add(tabbedPane);
		
		pnlContent = new JPanel();
		tabbedPane.addTab("Classic", new ImageIcon("C:\\TreasureOfHanoiTheGame\\img\\Gold-Cart-icon.png"), pnlContent, null);
		pnlContent.setBackground(new Color(250, 250, 210));
		pnlContent.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(250, 250, 210), new Color(250, 250, 210), new Color(222, 184, 135), new Color(210, 180, 140)));
		pnlContent.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 5, 776, 321);
		pnlContent.add(scrollPane);
		
		tblClassic = new JTable(modelClassic);
		tblClassic.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setViewportView(tblClassic);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(250, 250, 210), new Color(250, 250, 210), new Color(222, 184, 135), new Color(210, 180, 140)));
		panel.setBackground(new Color(250, 250, 210));
		tabbedPane.addTab("Adventure", new ImageIcon("C:\\TreasureOfHanoiTheGame\\img\\Pirate-Ship-icon.png"), panel, null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(4, 4, 776, 322);
		panel.add(scrollPane_1);
		//Declaration of Table for Adventure's Scores with parameter of Table model
		tblAdventure = new JTable(modelAdventure);
		tblAdventure.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane_1.setViewportView(tblAdventure);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(250, 250, 210), new Color(250, 250, 210), new Color(222, 184, 135), new Color(210, 180, 140)));
		panel_1.setBackground(new Color(250, 250, 210));
		tabbedPane.addTab("Gold and Silver", new ImageIcon("C:\\TreasureOfHanoiTheGame\\img\\Gold-Bar-icon.png"), panel_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(3, 5, 777, 321);
		panel_1.add(scrollPane_2);
		//Declaration of Table for Gold and Silver's Scores with parameter of Table model
		tblGoldandSilver = new JTable(modelGoldSilver);
		tblGoldandSilver.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane_2.setViewportView(tblGoldandSilver);
		
       
		
		JLabel lblLeaderboard = new JLabel("LEADERBOARD");
		lblLeaderboard.setForeground(new Color(255, 255, 255));
		lblLeaderboard.setFont(new Font("Clab Personal Use", Font.BOLD, 35));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(406, 119, 316, 40);
		contentPane.add(lblLeaderboard);
		
		JLabel lblShadow = new JLabel("LEADERBOARD");
		lblShadow.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadow.setForeground(new Color(0, 0, 0));
		lblShadow.setFont(new Font("Clab Personal Use", Font.BOLD, 35));
		lblShadow.setBounds(406, 108, 316, 57);
		contentPane.add(lblShadow);
		
		//JLabel with image for decorations
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(316, 49, 491, 172);
		contentPane.add(lblBanner);
		path = "C:\\TreasureOfHanoiTheGame\\img\\banner.png"; 
		ImageIcon Banner = new ImageIcon(path); 
		Image imgBanner = Banner.getImage(); 
		Image newBanner = imgBanner.getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBanner = new ImageIcon(newBanner);
		lblBanner.setIcon(newImgBanner);
		//JLabel that acts as button for Exit 
		lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			//mouseEntered and mouseExited has override method for animation.
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBounds(977, 23, 53, 46);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBounds(977, 26, 53, 46);
			}
			//Music when mouse released
			//hide this frame and open Opening Frame
			@Override
			public void mouseReleased(MouseEvent e) {
				
				OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				setVisible(false);
				OpeningFrame  frmOpening = new OpeningFrame();
				frmOpening.setVisible(true);
			}
		});
		lblExit.setBounds(977, 26, 53, 46);
		contentPane.add(lblExit);
		path = "C:\\TreasureOfHanoiTheGame\\img\\faceCross.png"; 
		ImageIcon Exit = new ImageIcon(path); 
		Image imgExit = Exit.getImage(); 
		Image newExit = imgExit.getScaledInstance(lblExit.getWidth(), lblExit.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgExit = new ImageIcon(newExit);
		lblExit.setIcon(newImgExit);
		lblExit.setCursor(cursorButton);
		//JLabel with Image for decorations.
		JLabel lblTrophy = new JLabel("");
		lblTrophy.setBounds(499, 36, 118, 91);
		contentPane.add(lblTrophy);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldTrophy.png"; 
		ImageIcon Trophy = new ImageIcon(path); 
		Image imgTrophy = Trophy.getImage(); 
		Image newTrophy = imgTrophy.getScaledInstance(lblTrophy.getWidth(), lblTrophy.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgTrophy = new ImageIcon(newTrophy);
		lblTrophy.setIcon(newImgTrophy);
		//JLabel with Image for decorations.
		JLabel lblSilverTrophy = new JLabel("");
		lblSilverTrophy.setBounds(413, 59, 95, 80);
		contentPane.add(lblSilverTrophy);
		path = "C:\\TreasureOfHanoiTheGame\\img\\silver_trophy.png"; 
		ImageIcon SilverTrophy = new ImageIcon(path); 
		Image imgSilverTrophy = SilverTrophy.getImage(); 
		Image newSilverTrophy = imgSilverTrophy.getScaledInstance(lblSilverTrophy.getWidth(), lblSilverTrophy.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgSilverTrophy = new ImageIcon(newSilverTrophy);
		lblSilverTrophy.setIcon(newImgSilverTrophy);
		//JLabel with Image for decorations.
		JLabel lblBronzeTrophy = new JLabel("");
		lblBronzeTrophy.setBounds(609, 59, 95, 80);
		contentPane.add(lblBronzeTrophy);
		path = "C:\\TreasureOfHanoiTheGame\\img\\bronze_trophy.png";
		ImageIcon BronzeTrophy = new ImageIcon(path); 
		Image imgBronzeTrophy = BronzeTrophy.getImage(); 
		Image newBronzeTrophy = imgBronzeTrophy.getScaledInstance(lblBronzeTrophy.getWidth(), lblBronzeTrophy.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBronzeTrophy = new ImageIcon(newBronzeTrophy);
		lblBronzeTrophy.setIcon(newImgBronzeTrophy);
		
		JLabel lblScrollBg = new JLabel("");
		lblScrollBg.setBounds(38, 133, 1028, 413);
		contentPane.add(lblScrollBg);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\Scroll.png"; 
		ImageIcon ScrollBg = new ImageIcon(path); 
		Image imgScrollBg = ScrollBg.getImage(); 
		Image newScrollBg = imgScrollBg.getScaledInstance(lblScrollBg.getWidth(), lblScrollBg.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgScrollBg = new ImageIcon(newScrollBg);
		lblScrollBg.setIcon(newImgScrollBg);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(-162, -13, 1427, 609);
		contentPane.add(lblBackground);
		path = "C:\\TreasureOfHanoiTheGame\\BackgroundImg\\frame1.png"; 
		ImageIcon Background = new ImageIcon(path); 
		Image imgBackground = Background.getImage(); 
		Image newBackground = imgBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgBackground = new ImageIcon(newBackground);
		lblBackground.setIcon(newImgBackground);
		
		Sorters();
	}
	//Method for sorting all the table on load.
	private void Sorters() {
		RowSorter<TableModel> sorterClassic = new TableRowSorter<TableModel>(modelClassic);
		RowSorter<TableModel> sorterAdventure = new TableRowSorter<TableModel>(modelAdventure);
		RowSorter<TableModel> sorterGS = new TableRowSorter<TableModel>(modelGoldSilver);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
        
        List<RowSorter.SortKey> sortKeys1 = new ArrayList<RowSorter.SortKey>();
        sortKeys1.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        
        List<RowSorter.SortKey> sortKeys2 = new ArrayList<RowSorter.SortKey>();
        sortKeys2.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        
        sorterClassic.setSortKeys(sortKeys);
	    tblClassic.setRowSorter(sorterClassic);
	    
	    sorterGS.setSortKeys(sortKeys2);
	    tblGoldandSilver.setRowSorter(sorterGS);
	    
	    sorterAdventure.setSortKeys(sortKeys1);
	    tblAdventure.setRowSorter(sorterAdventure);
		
	}

	
}
