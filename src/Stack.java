import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Stack {
	private Block headBlock;
	private BufferedImage image;
	GamePlay gameplay;
	
	public Block getHeadBlock() {
		return headBlock;
	}
	public void setHeadBlock(Block headBlock) {
		this.headBlock = headBlock;
	}
	//Method for adding block
	public void push(Block block){
		if(headBlock == null) {
			headBlock = block;
		}else {
			Block currentBlock = headBlock;
			while(currentBlock.getNext() != null) {
				currentBlock = currentBlock.getNext();
			}
		    currentBlock.setNext(block);
		}
	}
	//Method for removing/carrying block
	public Block pop(){
		Block popBlock = null;
		if(count() == 1) {
			popBlock = headBlock;
			headBlock = null;
		}
		else if(count() > 1){
			Block currentBlock = headBlock;
			for(int i = 1; i < count()-1; i++) {
				currentBlock = currentBlock.getNext();
			}
			popBlock = currentBlock.getNext();
			currentBlock.setNext(null);
		}
		return popBlock;
	}
    //Method for Getting block
	public Block peek(){
		if(count() > 0) {
			Block currentBlock = headBlock;
			while(currentBlock.getNext() != null) { 
				currentBlock = currentBlock.getNext();
			}
			return currentBlock;
		}else {
			return null;
		}
	}
	//Method for counting blocks in a stack
	public int count() {
		int counter = 0;
		Block currentBlock = headBlock;
		while(currentBlock != null) {
			counter++;
			currentBlock = currentBlock.getNext();
		}
		return counter;
	}
	
	public Block getBlockAt(int index) {
		Block currentBlock = headBlock;
		for(int i = 1 ; i < index; i++) {
			currentBlock = currentBlock.getNext();
		}
		return currentBlock;
	}
	
	//Drawing discs
	public void drawBlocks(Graphics g, int x) {
		Block currentBlock = headBlock;
		for(int i = 0; i < count(); i++) {
			int xPos = x + (int)(100-(currentBlock.getLength()*1.5))/2;
			int yPos = 315 - (i*20);
			
			if(currentBlock.getType().contentEquals("gold")) {
				try {
					image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\gold.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				try {
					image = ImageIO.read(new File ("C:\\TreasureOfHanoiTheGame\\object\\silver.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			g.drawImage(image, xPos, yPos, (int)(currentBlock.getLength()*1.5), 45, gameplay);
			currentBlock = currentBlock.getNext();
		}
	}
}
