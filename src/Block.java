
public class Block {
	//class properties
	private int length;
	private String type;
	private Block next;

	//Methods of the class
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Block getNext() {
		return next;
	}
	public void setNext(Block next) {
		this.next = next;
	}
	
	//class constructors
	public Block(int length) {
		this.length = length;
		this.type = "gold";
		this.next = null;
	}
	public Block(int length , String type) {
		this.length = length;
		this.type = type;
		this.next = null;
	}
}
