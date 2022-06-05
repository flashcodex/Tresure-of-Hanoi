import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;

public class OpeningFrame extends JFrame {
	//class properties
	private JPanel contentPane;
	private String path;
	private JLabel lblBg;
	private JLabel lblLogo;
	private JLabel lblStart;
	private JLabel lblAbout;
	private JLabel lblInstruction;
	private JLabel lblPlayGame;
	private JLabel lblInstructionWord;
	private JLabel lblAboutWord;
	private JLabel lblLeaderboardButton;
	private JLabel lblLeaderboard;
	private JLabel lblOF;
	private JLabel lblShadowOf;
	private JLabel lblGoldCoin;
	private JLabel lblHan;
	private JLabel lblI;
	private JLabel lblShadow;
	private JLabel lblShadowHan;
	private JLabel lblSilverCoin;
	private JLabel lblTrophy;
	private JLabel lblStartIcon;
	private JLabel lblInstructionIcon;
	private JLabel lblAboutIcon;
	private JLabel lblExitButton;
	private JLabel lblExit;
	private JLabel lblExitIcon;
	private JLabel lblSettings;
	private JLabel lblTreasureShadow;
	private JLabel lblEnterYourName;
	private JLabel lblSignBoard;
	private JLabel lblTreasure;
	public static  JTextField txtName;
	private JLabel lblButtonOkay;
	private Quit frmQuit;
	public static String Name;
	
	//Overriding the return value of each column to make the leaderboard show the descending order base on integer value
	public static DefaultTableModel modelClassic = new DefaultTableModel(){
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return Integer.class;
                case 2:
                    return Integer.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;
                default:
                    return String.class;
            }
        }
    };
	
	public static DefaultTableModel modelGoldSilver = new DefaultTableModel(){
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
    
            default:
                return String.class;
            }
        }
    };
    
    public static DefaultTableModel modelAdventure = new DefaultTableModel(){
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return Integer.class;
                default:
                    return String.class;
            }
        }
    };
    //Declaration and initialization of the rows for each table model
    static Object[] rowsClassic = new Object[5];
	static Object[] rowsAdventure = new Object[2];
	static Object[] rowsGoldSilver = new Object[4];
   
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningFrame frame = new OpeningFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpeningFrame() {
		//Music for the game
		backgroundMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\BGMusic2.wav");
		
		//Properties of the Frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\TreasureOfHanoiTheGame\\img\\tiltedGoldCoin.png"));
		setTitle("Tower of Hanoi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, SystemColor.windowText, SystemColor.menuText, SystemColor.textText, null));
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
		
		//JtextField for typing the name/nickname of the User
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setForeground(SystemColor.controlText);
		txtName.setFont(new Font("Clab Personal Use", Font.PLAIN, 15));
		txtName.setBackground(new Color(255, 250, 205));
		txtName.setBounds(338, 71, 280, 37);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setVisible(false);
		
		//JLabel that acts as a button
		lblButtonOkay = new JLabel("");
		lblButtonOkay.addMouseListener(new MouseAdapter() {
			//mouseEntered and mouseExit has an override method that will show an animation where it move slightly.
			@Override
			public void mouseEntered(MouseEvent e) {
				lblButtonOkay.setBounds(631, 64, 48, 39);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblButtonOkay.setBounds(631, 68, 48, 39);
			}
			//mouseReleased another frame about Modes of the game and hides the pop up question about user's name
			@Override
			public void mouseReleased(MouseEvent e) {
				Name = txtName.getText();
				lblButtonOkay.setVisible(false);
				txtName.setVisible(false);
				txtName.setText(null);
				lblEnterYourName.setVisible(false);
				lblSignBoard.setVisible(false);
				ModeFrame frmGameMode = new ModeFrame();
				frmGameMode.setVisible(true);
				lblEnterYourName.setVisible(false);
				lblSignBoard.setVisible(false);
				txtName.setVisible(false);
				lblButtonOkay.setVisible(false);
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				
			}
		});
		lblButtonOkay.setVisible(false);
		lblButtonOkay.setBounds(631, 68, 48, 39);
		contentPane.add(lblButtonOkay);
		path = "C:\\TreasureOfHanoiTheGame\\img\\faceCheck.png"; 
		ImageIcon ButtonOkay = new ImageIcon(path); 
		Image imgButtonOkay = ButtonOkay.getImage(); 
		Image newButtonOkay = imgButtonOkay.getScaledInstance(lblButtonOkay.getWidth(), lblButtonOkay.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonOkay = new ImageIcon(newButtonOkay);
		lblButtonOkay.setIcon(newImgButtonOkay);
		lblButtonOkay.setCursor(cursorButton);
		
		//JLabel for displaying the word Enter your name
		lblEnterYourName = new JLabel("Enter your name");
		lblEnterYourName.setVisible(false);
		lblEnterYourName.setFont(new Font("Clab Personal Use", Font.PLAIN, 15));
		lblEnterYourName.setForeground(SystemColor.infoText);
		lblEnterYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourName.setBounds(355, 47, 297, 26);
		contentPane.add(lblEnterYourName);
		
		
		//Jlabel that contains the image of signBoard where JLabel and JTextField is placed to ask the name of the user
		lblSignBoard = new JLabel("");
		lblSignBoard.setBounds(313, 0, 388, 122);
		lblSignBoard.setVisible(false);
		contentPane.add(lblSignBoard);
		path = "C:\\TreasureOfHanoiTheGame\\img\\signBoard.png"; 
		ImageIcon SignBoard = new ImageIcon(path); 
		Image imgSignBoard = SignBoard.getImage(); 
		Image newSignBoard = imgSignBoard.getScaledInstance(lblSignBoard.getWidth(), lblSignBoard.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgSignBoard = new ImageIcon(newSignBoard);
		lblSignBoard.setIcon(newImgSignBoard);
		
		//Seperator between the game title and menu of the game
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.inactiveCaption);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(417, -8, 3, 594);
		contentPane.add(separator);
		
		lblTreasure = new JLabel("TREASURE");
		lblTreasure.setFont(new Font("Clab Personal Use", Font.BOLD, 71));
		lblTreasure.setForeground(new Color(255, 51, 0));
		lblTreasure.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreasure.setBounds(0, 197, 418, 74);
		contentPane.add(lblTreasure);
		
		lblTreasureShadow = new JLabel("TREASURE");
		lblTreasureShadow.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreasureShadow.setForeground(SystemColor.textHighlightText);
		lblTreasureShadow.setFont(new Font("Clab Personal Use", Font.BOLD, 71));
		lblTreasureShadow.setBounds(0, 190, 418, 81);
		contentPane.add(lblTreasureShadow);
		
		//JLabel that cotains an image of a coin that acts as Letter O of the word OF.
		lblSilverCoin = new JLabel("");
		lblSilverCoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSilverCoin.setBounds(133, 250, 73, 78);
		contentPane.add(lblSilverCoin);
		path = "C:\\TreasureOfHanoiTheGame\\img\\silverCoin.png"; 
		ImageIcon buttonSilver = new ImageIcon(path); 
		Image imgButtonSilver = buttonSilver.getImage(); 
		Image newButtonSilver = imgButtonSilver.getScaledInstance(lblSilverCoin.getWidth(), lblSilverCoin.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImgButtonSilver = new ImageIcon(newButtonSilver);
		lblSilverCoin.setIcon(newImgButtonSilver);
		
		lblOF = new JLabel("OF");
		lblOF.setHorizontalAlignment(SwingConstants.CENTER);
		lblOF.setForeground(new Color(255, 51, 0));
		lblOF.setFont(new Font("Clab Personal Use", Font.BOLD, 97));
		lblOF.setBounds(84, 260, 232, 98);
		contentPane.add(lblOF);
		
		lblShadowOf = new JLabel("OF");
		lblShadowOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadowOf.setForeground(SystemColor.textHighlightText);
		lblShadowOf.setFont(new Font("Clab Personal Use", Font.BOLD, 97));
		lblShadowOf.setBounds(84, 250, 232, 108);
		contentPane.add(lblShadowOf);
		
		lblHan = new JLabel("HAN");
		lblHan.setForeground(new Color(255, 51, 0));
		lblHan.setFont(new Font("Clab Personal Use", Font.BOLD, 83));
		lblHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHan.setBounds(33, 347, 231, 86);
		contentPane.add(lblHan);
		
		lblShadowHan = new JLabel("HAN");
		lblShadowHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadowHan.setForeground(SystemColor.textHighlightText);
		lblShadowHan.setFont(new Font("Clab Personal Use", Font.BOLD, 83));
		lblShadowHan.setBounds(33, 335, 231, 98);
		contentPane.add(lblShadowHan);
		
		//JLabel that cotains an image of a coin that acts as Letter O of the word HANOI.
		lblGoldCoin = new JLabel("");
		lblGoldCoin.setBounds(242, 341, 74, 70);
		contentPane.add(lblGoldCoin);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldCoin.png"; 
		ImageIcon buttonGold = new ImageIcon(path); 
		Image imgButtonGold = buttonGold.getImage(); 
		Image newButtonGold = imgButtonGold.getScaledInstance(lblGoldCoin.getWidth(), lblGoldCoin.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonGold = new ImageIcon(newButtonGold);
		lblGoldCoin.setIcon(newImgButtonGold);
		
		lblI = new JLabel("I");
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setForeground(new Color(255, 51, 0));
		lblI.setFont(new Font("Clab Personal Use", Font.BOLD, 89));
		lblI.setBounds(280, 349, 111, 90);
		contentPane.add(lblI);
		
		lblShadow = new JLabel("I");
		lblShadow.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadow.setForeground(SystemColor.textHighlightText);
		lblShadow.setFont(new Font("Clab Personal Use", Font.BOLD, 89));
		lblShadow.setBounds(280, 339, 111, 97);
		contentPane.add(lblShadow);
		
		//lblLeaderboard and lblLeaderboardButton is the button for the LeaderBoard Frame
		lblLeaderboard = new JLabel("LEADERBOARD");
		lblLeaderboard.addMouseListener(new MouseAdapter() {
			//JLabel image changes when mouse entered to make animation 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblLeaderboard.isFocusable() == true) {
					lblLeaderboard.setFont(new Font("Clab Personal Use", Font.BOLD, 35));
					path = "C:\\TreasureOfHanoiTheGame\\img\\greenButton.png"; 
					ImageIcon button1 = new ImageIcon(path); 
					Image imgButton1 = button1.getImage(); 
					Image newButton1 = imgButton1.getScaledInstance(lblLeaderboardButton.getWidth(), lblLeaderboardButton.getHeight(),Image.SCALE_SMOOTH); 
					ImageIcon newImgButton1 = new ImageIcon(newButton1);
					lblLeaderboardButton.setIcon(newImgButton1);
					//music for the button when the mouse entered the JLabel
					mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				}
			}
			//JLabel image returns to original image when mouse exited to make animation 
			@Override
			public void mouseExited(MouseEvent e) {
				lblLeaderboard.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
				path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
				ImageIcon button1 = new ImageIcon(path); 
				Image imgButton1 = button1.getImage(); 
				Image newButton1 = imgButton1.getScaledInstance(lblLeaderboardButton.getWidth(), lblLeaderboardButton.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newImgButton1 = new ImageIcon(newButton1);
				lblLeaderboardButton.setIcon(newImgButton1);
			}
			//Leaderboard opens in mouseReleased and hides this frame
			@Override
			public void mouseReleased(MouseEvent e) {
				//music for the button when the mouse clicked the JLabel
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				Leaderboard frmLeaderboard = new Leaderboard();
				frmLeaderboard.setVisible(true);
				setVisible(false);
			}
		});
		lblLeaderboard.setForeground(Color.WHITE);
		lblLeaderboard.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(616, 289, 288, 57);
		contentPane.add(lblLeaderboard);
		lblLeaderboard.setCursor(cursorButton);
		
		
		//Jlabel that acts an button
		lblLeaderboardButton = new JLabel("");
		lblLeaderboardButton.setBounds(584, 283, 354, 59);
		contentPane.add(lblLeaderboardButton);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
		ImageIcon button1 = new ImageIcon(path); 
		Image imgButton1 = button1.getImage(); 
		Image newButton1 = imgButton1.getScaledInstance(lblLeaderboardButton.getWidth(), lblLeaderboardButton.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButton1 = new ImageIcon(newButton1);
		lblLeaderboardButton.setIcon(newImgButton1);
		lblLeaderboardButton.setCursor(cursorButton);
		
		//Icon of trophy for design
		lblTrophy = new JLabel("");
		lblTrophy.setBounds(530, 289, 51, 49);
		contentPane.add(lblTrophy);
		path = "C:\\TreasureOfHanoiTheGame\\img\\goldTrophy.png"; 
		ImageIcon buttonTrophy = new ImageIcon(path); 
		Image imgButtonTrophy = buttonTrophy.getImage(); 
		Image newButtonTrophy = imgButtonTrophy.getScaledInstance(lblTrophy.getWidth(), lblTrophy.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonTrophy = new ImageIcon(newButtonTrophy);
		lblTrophy.setIcon(newImgButtonTrophy);
		
		//Icon of start for design
		lblStartIcon = new JLabel("");
		lblStartIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartIcon.setBounds(527, 157, 51, 47);
		contentPane.add(lblStartIcon);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Start.png"; 
		ImageIcon buttonStartIcon = new ImageIcon(path); 
		Image imgButtonStartIcon = buttonStartIcon.getImage(); 
		Image newButtonStartIcon = imgButtonStartIcon.getScaledInstance(lblStartIcon.getWidth(), lblStartIcon.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonStartIcon = new ImageIcon(newButtonStartIcon);
		lblStartIcon.setIcon(newImgButtonStartIcon);
		
		//Icon of Instruction for design
		lblInstructionIcon = new JLabel("");
		lblInstructionIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructionIcon.setBounds(528, 220, 51, 49);
		contentPane.add(lblInstructionIcon);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Plus.png"; 
		ImageIcon buttonInstructionIcon = new ImageIcon(path); 
		Image imgButtonInstructionIcon = buttonInstructionIcon.getImage(); 
		Image newButtonInstructionIcon = imgButtonInstructionIcon.getScaledInstance(lblInstructionIcon.getWidth(), lblInstructionIcon.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonInstructionIcon = new ImageIcon(newButtonInstructionIcon);
		lblInstructionIcon.setIcon(newImgButtonInstructionIcon);
		
		//Icon of about for design
		lblAboutIcon = new JLabel("");
		lblAboutIcon.setBounds(531, 355, 51, 49);
		contentPane.add(lblAboutIcon);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Heart.png"; 
		ImageIcon buttonAboutIcon = new ImageIcon(path); 
		Image imgButtonAboutIcon = buttonAboutIcon.getImage(); 
		Image newButtonAboutIcon = imgButtonAboutIcon.getScaledInstance(lblAboutIcon.getWidth(), lblAboutIcon.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonAboutIcon = new ImageIcon(newButtonAboutIcon);
		lblAboutIcon.setIcon(newImgButtonAboutIcon);
		
		//lblPlayGame and lblStart is for the button for starting the game
		lblPlayGame = new JLabel("PLAY GAME");
		lblPlayGame.setCursor(cursorButton);
		
		lblPlayGame.addMouseListener(new MouseAdapter() {
			//JLabel image changes when mouse entered to make animation 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblPlayGame.isFocusable() == true) {
					lblPlayGame.setFont(new Font("Clab Personal Use", Font.BOLD, 38));
					path = "C:\\TreasureOfHanoiTheGame\\img\\greenButton.png"; 
					ImageIcon buttonStart = new ImageIcon(path); 
					Image imgButtonStart = buttonStart.getImage(); 
					Image newButtonStart = imgButtonStart.getScaledInstance(lblStart.getWidth(), lblStart.getHeight(),Image.SCALE_SMOOTH); 
					ImageIcon newImgButtonStart = new ImageIcon(newButtonStart);
					lblStart.setIcon(newImgButtonStart);
					//music for the button when the mouse entered the JLabel
					mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				}
			}
			//JLabel image returns to original image when mouse exited to make animation 
			@Override
			public void mouseExited(MouseEvent e) {
				lblPlayGame.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
				path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
				ImageIcon buttonStart = new ImageIcon(path); 
				Image imgButtonStart = buttonStart.getImage(); 
				Image newButtonStart = imgButtonStart.getScaledInstance(lblStart.getWidth(), lblStart.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newImgButtonStart = new ImageIcon(newButtonStart);
				lblStart.setIcon(newImgButtonStart);
			}
			//Pop up the question about user's name
			@Override
			public void mouseReleased(MouseEvent e) {
				//music for the button when the mouse clicked the JLabel
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				lblEnterYourName.setVisible(true);
				lblSignBoard.setVisible(true);
				txtName.setVisible(true);
				lblButtonOkay.setVisible(true);
			}
		});
		lblPlayGame.setForeground(Color.WHITE);
		lblPlayGame.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
		lblPlayGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayGame.setBounds(622, 156, 271, 60);
		contentPane.add(lblPlayGame);
		
		//lblInstructionWord and lblInstruction acts as the button for the Instrution
		lblInstructionWord = new JLabel("INSTRUCTION");
		lblInstructionWord.addMouseListener(new MouseAdapter() {
			//JLabel image changes when mouse entered to make animation 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblInstructionWord.isFocusable() == true) {
					lblInstructionWord.setFont(new Font("Clab Personal Use", Font.BOLD, 37));
					path = "C:\\TreasureOfHanoiTheGame\\img\\greenButton.png"; 
					ImageIcon button2 = new ImageIcon(path); 
					Image imgButton2 = button2.getImage(); 
					Image newButton2 = imgButton2.getScaledInstance(lblInstruction.getWidth(), lblInstruction.getHeight(),Image.SCALE_SMOOTH); 
					ImageIcon newImgButton2 = new ImageIcon(newButton2);
					lblInstruction.setIcon(newImgButton2);
					//music for the button when the mouse entered the JLabel
					mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				}
			}
			//JLabel image returns to original image when mouse exited to make animation 
			@Override
			public void mouseExited(MouseEvent e) {
				lblInstructionWord.setFont(new Font("Clab Personal Use", Font.BOLD, 36));
				path = "C:\\TreasureOfHanoiTheGame\\img\\Button2.png"; 
				ImageIcon button2 = new ImageIcon(path); 
				Image imgButton2 = button2.getImage(); 
				Image newButton2 = imgButton2.getScaledInstance(lblInstruction.getWidth(), lblInstruction.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newImgButton2 = new ImageIcon(newButton2);
				lblInstruction.setIcon(newImgButton2);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//music for the button when the mouse clicked the JLabel
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				InstructionAndAboutUs frmInstruction = new InstructionAndAboutUs(1);
				frmInstruction.setVisible(true);
			}
		});
		lblInstructionWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructionWord.setForeground(Color.WHITE);
		lblInstructionWord.setFont(new Font("Clab Personal Use", Font.BOLD, 36));
		lblInstructionWord.setBounds(616, 226, 288, 54);
		lblInstructionWord.setCursor(cursorButton);
		contentPane.add(lblInstructionWord);
		
		
		//lblAboutWord and lblAbout acts as the button for the About
		lblAboutWord = new JLabel("ABOUT");
		lblAboutWord.setCursor(cursorButton);
		lblAboutWord.addMouseListener(new MouseAdapter() {
			//JLabel image changes when mouse entered to make animation 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblAboutWord.isFocusable() == true) {
					lblAboutWord.setFont(new Font("Clab Personal Use", Font.BOLD, 36));
					path = "C:\\TreasureOfHanoiTheGame\\img\\greenButton.png"; 
					ImageIcon button3 = new ImageIcon(path); 
					Image imgButton3 = button3.getImage(); 
					Image newButton3 = imgButton3.getScaledInstance(lblAbout.getWidth(), lblAbout.getHeight(),Image.SCALE_SMOOTH); 
					ImageIcon newImgButton3 = new ImageIcon(newButton3);
					lblAbout.setIcon(newImgButton3);
					//music for the button when the mouse entered the JLabel

					mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				}
			}
			//JLabel image returns to original image when mouse exited to make animation 
			@Override
			public void mouseExited(MouseEvent e) {
				lblAboutWord.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
				path = "C:\\TreasureOfHanoiTheGame\\img\\Button3.png"; 
				ImageIcon button3 = new ImageIcon(path); 
				Image imgButton3 = button3.getImage(); 
				Image newButton3 = imgButton3.getScaledInstance(lblAbout.getWidth(), lblAbout.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newImgButton3 = new ImageIcon(newButton3);
				lblAbout.setIcon(newImgButton3);
			}
			//music for the button when the mouse clicked the JLabel
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
				InstructionAndAboutUs frmAboutUs = new InstructionAndAboutUs(2);
				frmAboutUs.setVisible(true);
				
			}
		});
		lblAboutWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutWord.setForeground(Color.WHITE);
		lblAboutWord.setFont(new Font("Clab Personal Use", Font.BOLD, 34));
		lblAboutWord.setBounds(612, 359, 290, 52);
		contentPane.add(lblAboutWord);
		
		//JLabel that display as an button 
		lblStart = new JLabel("");
		lblStart.setBounds(580, 152, 354, 59);
		contentPane.add(lblStart);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
		ImageIcon buttonStart = new ImageIcon(path); 
		Image imgButtonStart = buttonStart.getImage(); 
		Image newButtonStart = imgButtonStart.getScaledInstance(lblStart.getWidth(), lblStart.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonStart = new ImageIcon(newButtonStart);
		lblStart.setIcon(newImgButtonStart);
		lblStart.setCursor(cursorButton);
		
		//JLabel that display as an button 
		lblInstruction = new JLabel("");
		lblInstruction.setBounds(582, 217, 354, 59);
		contentPane.add(lblInstruction);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Button2.png"; 
		ImageIcon button2 = new ImageIcon(path); 
		Image imgButton2 = button2.getImage(); 
		Image newButton2 = imgButton2.getScaledInstance(lblInstruction.getWidth(), lblInstruction.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButton2 = new ImageIcon(newButton2);
		lblInstruction.setIcon(newImgButton2);
		lblInstruction.setCursor(cursorButton);
		
		//JLabel that display as an button 
		lblAbout = new JLabel("");
		lblAbout.setBounds(586, 351, 354, 59);
		contentPane.add(lblAbout);
		lblAbout.setCursor(cursorButton);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Button3.png"; 
		ImageIcon button3 = new ImageIcon(path); 
		Image imgButton3 = button3.getImage(); 
		Image newButton3 = imgButton3.getScaledInstance(lblAbout.getWidth(), lblAbout.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButton3 = new ImageIcon(newButton3);
		lblAbout.setIcon(newImgButton3);
		
		//lblExit and lblExitButton acts an button for quit frame
		lblExit = new JLabel("EXIT");
		lblExit.addMouseListener(new MouseAdapter() {
			//JLabel image changes when mouse entered to make animation 
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblExit.isFocusable() == true) {
					lblExit.setFont(new Font("Clab Personal Use", Font.BOLD, 38));
					path = "C:\\TreasureOfHanoiTheGame\\img\\greenButton.png"; 
					ImageIcon buttonExit = new ImageIcon(path); 
					Image imgButtonExit = buttonExit.getImage(); 
					Image newButtonExit = imgButtonExit.getScaledInstance(lblExitButton.getWidth(), lblExitButton.getHeight(),Image.SCALE_SMOOTH); 
					ImageIcon newImgButtonExit = new ImageIcon(newButtonExit);
					lblExitButton.setIcon(newImgButtonExit);
					//music for the button when the mouse entered the JLabel
					mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\hover.wav");
				}
			}
			//JLabel image returns to original image when mouse exited to make animation 
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setFont(new Font("Clab Personal Use", Font.BOLD, 36));
				path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
				ImageIcon buttonExit = new ImageIcon(path); 
				Image imgButtonExit = buttonExit.getImage(); 
				Image newButtonExit = imgButtonExit.getScaledInstance(lblExitButton.getWidth(), lblExitButton.getHeight(),Image.SCALE_SMOOTH); 
				ImageIcon newImgButtonExit = new ImageIcon(newButtonExit);
				lblExitButton.setIcon(newImgButtonExit);
			}
			//Opens Quit frame on mouse Clicked
			@Override
			public void mouseClicked(MouseEvent e) {
				frmQuit = new Quit();
				frmQuit.setVisible(true);
				//music for the button when the mouse clicked the JLabel
				mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\click.wav");
			}
		});
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Clab Personal Use", Font.BOLD, 36));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(623, 422, 275, 56);
		contentPane.add(lblExit);
		
		//Jlabel that acts an button
		lblExitButton = new JLabel("");
		lblExitButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitButton.setBounds(587, 414, 354, 59);
		contentPane.add(lblExitButton);
		lblExitButton.setCursor(cursorButton);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Button.png"; 
		ImageIcon buttonExit = new ImageIcon(path); 
		Image imgButtonExit = buttonExit.getImage(); 
		Image newButtonExit = imgButtonExit.getScaledInstance(lblExitButton.getWidth(), lblExitButton.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonExit = new ImageIcon(newButtonExit);
		lblExitButton.setIcon(newImgButtonExit);
		lblExit.setCursor(cursorButton);
		
		//Icon of exit for design
		lblExitIcon = new JLabel("");
		lblExitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitIcon.setBounds(532, 419, 51, 49);
		contentPane.add(lblExitIcon);
		path = "C:\\TreasureOfHanoiTheGame\\img\\Cross.png"; 
		ImageIcon buttonExitIcon = new ImageIcon(path); 
		Image imgButtonExitIcon = buttonExitIcon.getImage(); 
		Image newButtonExitIcon = imgButtonExitIcon.getScaledInstance(lblExitIcon.getWidth(), lblExitIcon.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newImgButtonExitIcon = new ImageIcon(newButtonExitIcon);
		lblExitIcon.setIcon(newImgButtonExitIcon);
		
		
		//Logo of the game for design
		lblLogo = new JLabel("");
		lblLogo.setBounds(5, 169, 408, 286);
		contentPane.add(lblLogo);
		path = "C:\\TreasureOfHanoiTheGame\\img\\icon1.png"; 
		ImageIcon logo = new ImageIcon(path); 
		Image imgLogo = logo.getImage(); 
		Image newLogo = imgLogo.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon newIcon = new ImageIcon(newLogo);
		lblLogo.setIcon(newIcon);
		
		//Background of the game for design
		lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 1068, 579);
		contentPane.add(lblBg);
		lblBg.setIcon(new ImageIcon("C:\\TreasureOfHanoiTheGame\\Gifs\\pirate.gif"));
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Initialization of columns of each table model 
		//and setting the columns as column identifiers for the table model
		Object[] columnsClassic= { "Name",  "Moves", "Time","Disc","Coins"};
		modelClassic.setColumnIdentifiers(columnsClassic);
		Object[] columnsGS= { "Name",  "Moves","Disc","Coins"};
		modelGoldSilver.setColumnIdentifiers(columnsGS);
		Object[] columnsAdven= { "Name", "Coins", };
		modelAdventure.setColumnIdentifiers(columnsAdven);
		
		
	}
	//Method for Background Music of the game that accepts String value
	private void backgroundMusic(String filename) {
		try
		{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
	}
	//Method for mouse Music of the game that accepts String value
	public static void mouseMusic(String filename) {
		try
		{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
	}
	
}
