import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class GamePlay extends JPanel {

	public static DefaultTableModel modelClassic = OpeningFrame.modelClassic;
	public static Object[] rowsClassic = OpeningFrame.rowsClassic;
	public static int numofBlock;
	private Block initialize[] ;
	private int numOfMove = 0;
	//default value of move per block can increase depend on the number of block/s
	private int maxMove = 5;
	
	//Instantiation of constructing tower
	Stack tower1 = new Stack();
	Stack tower2 = new Stack();
	Stack tower3 = new Stack();
	//The first tower is selected by default
	boolean isTower1Selected = true;
	boolean isTower2Selected = false;
	boolean isTower3Selected = false;
	//for initializing the selected/carried block
	Block carriedBlock = null;
	//Initialization for timer
	public static Timer time;
	int i;
	private BufferedImage image;
	

	public GamePlay(int numOfBlock) {
	
		i = 1;
		this.numofBlock =  numOfBlock;
		maxMove = (int)(Math.pow(2, numofBlock)-1);
		TowerOfHanoi.updateMove(numOfMove);
		TowerOfHanoi.updateMaxMove(maxMove);
		//for Opacity of frame
		setBackground(new Color(0, 0, 0));
		setOpaque(false);
		//for declaring the controller
		addKeyListener(new ControlAdapter());
		//for focusing the red rectangle on every towers
		setFocusable(true);
		//setting the size of array of object
		initialize = new Block[numofBlock];
		//creating new Block object and store it in array
		int initialSize = 30;
		for(int i = 0 ; i<numofBlock ; i++) {
			initialize[i] = (new Block(initialSize));
			initialSize += 20;
		}
		//to reverse the position of block small to big
		for(int i = (numofBlock-1); i >=0 ; i--) {
			tower1.push(initialize[i]);
		}
		//Timer
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TowerOfHanoi.getLblTimeCount().setText(Integer.toString(i));
				i++;
			}
		});
	}
	@Override//Means overriding the parent class
	//For drawing/Painting of components
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
		try {
			image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\flag2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //draw the tower (Pirate flag)
		g.drawImage(image, 0, 50, 150, 300, this);
		g.drawImage(image, 300, 50, 150, 300, this);
		g.drawImage(image, 600, 50, 150, 300, this);
		
		
		try {
			
			if(numofBlock==3) 
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\level1.png")); // wood chest
			
			else if(numofBlock==4) 
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\level 2.png")); // iron chest
			
			else if(numofBlock==5) 
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\level3.png")); // silver chest
			
			else if(numofBlock==6) 
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\level4.png")); // silver violet chest
			
			else if(numofBlock==7) 
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\goldOpen.png")); // gold chest
			
			else
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\Chest collection\\silverOpen.png")); //default chest
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//draw the base (Treasure Chest)
		g.drawImage(image, 5, 300, 200, 120, this);
		g.drawImage(image, 305, 300, 200, 120, this);
		g.drawImage(image, 605, 300, 200, 120, this);
		
		
		g.setColor(new Color(255, 204, 153));
				
		//Drawing blocks
		tower1.drawBlocks(g, 60);//graphics, width
		tower2.drawBlocks(g, 360);
		tower3.drawBlocks(g, 660);
		
		//Carried block
		if(carriedBlock != null) {
			//Positioning of the blocks
			int xPos = 0;
			if(isTower1Selected) {
				xPos = 60 + (100 - carriedBlock.getLength())/2;
			}else if(isTower2Selected) {
				xPos = 360 + (100 - carriedBlock.getLength())/2;
			}else if(isTower3Selected) {
				xPos = 660 + (100 - carriedBlock.getLength())/2;
			}
			
			try {
				image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\gold.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(image, xPos, 15, (int)(carriedBlock.getLength()*1.5), 45, this);
			
		}
		
		//Indicates the selected tower
		g.setColor(Color.YELLOW);
		if(isTower1Selected) {
			g.drawRect(1, 50, 205, 370);
		}else if(isTower2Selected) {
			g.drawRect(301, 50, 205, 370);
		}else if(isTower3Selected) {
			g.drawRect(601, 50, 205, 370);
		}
	}
	//Method for the required move(check move)
	public void expectedMove() {
		if(tower3.count() == numofBlock) {
			time.stop();
			CongratsFrame congrats = new CongratsFrame();
			congrats.setInformation(TowerOfHanoi.getLblTimeCount().getText(), numOfMove, ComputeScore());
			congrats.setVisible(true);
			addToClassicLeaderBoard(OpeningFrame.Name ,numOfMove, TowerOfHanoi.getLblTimeCount().getText(),numofBlock, ComputeScore());
			TowerOfHanoi.Restart();
			time.stop();
			TowerOfHanoi.getLblTimeCount().setText("0");		
		}
	}
	//Virtual Keyboard listener/Controller
	public class ControlAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			//Selecting towers from right or left
			if(key == KeyEvent.VK_RIGHT) {
				if(isTower1Selected == true) {
					isTower2Selected = true;
					isTower1Selected = false;
				}else if(isTower2Selected == true) {
					isTower3Selected = true;
					isTower2Selected = false;
				}
			}
		    if(key == KeyEvent.VK_LEFT) {
				if(isTower2Selected == true) {
					isTower1Selected = true;
					isTower2Selected = false;
				}else if(isTower3Selected == true) {
					isTower2Selected = true;
					isTower3Selected = false;
				}
			}
			//for carrying the block
			//Popping
			if(key == KeyEvent.VK_UP) {
				time.start();
				if(carriedBlock == null) {
					if(isTower1Selected) 
						carriedBlock = tower1.pop();
					else if(isTower2Selected)
						carriedBlock = tower2.pop();
					else if(isTower3Selected) 
						carriedBlock = tower3.pop();
				}
			
			}
			//Pushing
			if(key == KeyEvent.VK_DOWN) {
				if(carriedBlock != null) {
					if(isTower1Selected) {
						//if the selected block is bigger than the first block
						if(tower1.peek() == null || tower1.peek().getLength() > carriedBlock.getLength()) {
							tower1.push(carriedBlock);
							carriedBlock = null;
							numOfMove++;
							TowerOfHanoi.updateMove(numOfMove);
							OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\goldDrop.wav");
						}
					}
					else if(isTower2Selected) {
						if(tower2.peek() == null || tower2.peek().getLength() > carriedBlock.getLength()) {
							tower2.push(carriedBlock);
							carriedBlock = null;
							numOfMove++;
							TowerOfHanoi.updateMove(numOfMove);
							OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\goldDrop.wav");
							}
						}
					else if(isTower3Selected) {
						if(tower3.peek() == null || tower3.peek().getLength() > carriedBlock.getLength()) {
							tower3.push(carriedBlock);
							carriedBlock = null;
							numOfMove++;
							TowerOfHanoi.updateMove(numOfMove);
							OpeningFrame.mouseMusic("C:\\TreasureOfHanoiTheGame\\SFXMusic\\goldDrop.wav");
						}
					}
					
				}
			}
			repaint();//For repainting or redrawing of objects while changing towers
			expectedMove();//Check move
		}
	}
	
	//Method for computing the score base on the maximum number of moves
	private int ComputeScore() {
		int Score = (((1000*maxMove)/numOfMove)* numofBlock)- (Integer.parseInt(TowerOfHanoi.lblTimeCount.getText())* numofBlock);
		return Score;
	}
	//Method for adding information to leader board
	public void addToClassicLeaderBoard(String name, int moves, String time,int disc, int coins) {
		
		if(modelClassic.getRowCount()<11)
			{
			rowsClassic[0]=name;
			rowsClassic[1]=moves;
			rowsClassic[2]=time;
			rowsClassic[3]=disc;
			rowsClassic[4]=coins;
			modelClassic.addRow(rowsClassic);

			}
		}

	
}
