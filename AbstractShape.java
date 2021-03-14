import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractShape implements Shape{
	protected int x;
	protected int y;
	protected int size;
	protected Color c;
	// an array to store the children shapes
	protected Shape[] children;
//	protected int newX;
//	protected int newY;
	// level of the shape
	protected static int level = 0;
	
	
	public AbstractShape(int x, int y, Color c, int size) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.size = size;
	}


	public void draw(Graphics g) {
		g.setColor(c);
	}
	
	public boolean increaseLevel() {
		boolean check = false;
		// if the children array is null, then create children and return true 
		if (children[0] == null) {
			createChildren();
		return true;
		} 
		// if the shape has children (when it's not first level), then increase the level
		for (Shape s: children) {
			check = s.increaseLevel();
		}	
		return check;
	}
	
	// decrease level if the shape is not the first level 
	public boolean decreaseLevel() {
		if (children[0]!=null) {
			for (int i = 0; i < children.length; i++) {
				if ((children[i]).decreaseLevel()) {
					children[i] = null;
					return false;
				}
			}
		}
		return !(children[0]!=null);
	}


		
	// return the level of the shape
	public int getLevel() {
		// count recursively until there's no children (in the most current level)
		if (children[0] == null) {
			return 1;
		}
		return 1 + children[0].getLevel();
	}
	
	// return the size of the shape
	public int getSize() {
		return size;
		
	}
	
	public boolean reset() {
		for (int i = 0; i< children.length; i++) {
			children[i] = null;
		}
		return true;
	}

	
	
	
	// return the information of the shape
	public String toString() {
			return String.format("Type: %s, Location: (%d,%d), Color: %s, Level: %d \n", this.getClass(), x, y, c, getLevel());
	

	}
	

}