
import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape {
	
	private static int firstLevelSize;

	public HShape(int x, int y, Color c, int size) {
		super(x, y, c, size);
		// each HShape has seven children
		children = new HShape[7];
	}

	@Override
	public void draw(Graphics g) { 
		super.draw(g);
		// make a HShape by deviding the big square into nine small squares
		// s1   s2   s3
		// s4   s5   s6
		// s7   s8   s9
		// then fill seven of the nine small squares color
		
		// first level -> draw a basic HShape
		if (children[0] == null) {
			// length of the small square
			int length = size / 3;
			
			g.setColor(c);
			// s1
			g.fillRect(x, y, length, length); 
			// s3
			g.fillRect(x + length * 2, y, length, length); 
			// s4
			g.fillRect(x, y + length, length, length); 
			// s5
			g.fillRect(x + length, y + length, length, length); 
			// s6
			g.fillRect(x + length * 2, y + length, length, length); 
			// s7
			g.fillRect(x, y + length * 2, length, length); 
			// s9
			g.fillRect(x + length * 2, y + length * 2, length, length); 
		}
		
		// other levels -> draw its children
		else {
			for (Shape childShape : children) {
				if (childShape != null) {
					childShape.draw(g);
				}
			}
		}
		
	}
	
	public void createChildren() {
		int length = size / 3;
		// (x,y) is the coordinate of s1
		
		// childShape locates at s1 and s3
		for (int i = 0, newX = x; i < 2; i++, newX = length*2 + newX) { 
			children[i] = new HShape(newX, y, c, length);
		}
		
		// childShape locates at s4, s5, and s6
		for (int i = 2, newX = x; i < 5; i++, newX = length + newX) {
			children[i] = new HShape(newX, y + length, c, length);
		}
		// childShape locates at s7 and s9
		for (int i = 5, newX = x; i < 7; i++, newX = length*2 + newX) {
			children[i] = new HShape(newX, y + length * 2, c, length);
		}
	}
	
	public boolean reset() {
		 firstLevelSize = this.size;
		 return super.reset(); 
	}

	
	
	
	
	
	
	
	
	
	
	
}