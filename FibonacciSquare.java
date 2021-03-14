import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {
	// modify the size of square to make it bigger to see
	static final int modify = 10; 
	// quadrant of fibonacci square
	private int quadrant;
	// nth fibonacci number
	private int n;
	// dimesions of arc
	private int arcWidth;
	private int arcHeight;
	
	// store the fibonacci number into an array
	// only create an array of twenty elements because
	// the max size of FibonacciSquare is 10
	private static int[] fibonacciNumber = new int[20];

	public FibonacciSquare(int x, int y, Color c, int n, int q) {
		super(x, y, c, modify*fibonacci(n)); // modify*f(n) is the real size for drawing
		quadrant = q;
		this.n = n;
		arcWidth = size * 2;
		arcHeight = size * 2;
		// each FibonacciSquare may have one children
		children = new FibonacciSquare[1];
	}
	
	@Override
	public void draw(Graphics g) {
		// set the color of the shape
		super.draw(g);
		// draw a square
		g.drawRect(x, y, size, size);
		
		// draw the arc in specific quadrant
		switch (quadrant) {
		case 1:
			g.drawArc(x - size, y,  arcWidth,  arcHeight, 0, 90);
			break;
		case 2:
			g.drawArc(x, y, arcWidth, arcHeight, 90, 90);
			break;
		case 3:
			g.drawArc(x, y-size, arcWidth, arcHeight, 180, 90);
			break;
		default: // 4
			g.drawArc(x - size, y-size, arcWidth, arcHeight, 270, 90);
			break;
		}
		// if the shape has children
		// then also draw its children
		if (children[0] != null) {
			children[0].draw(g);
		}
	}

	// return fibonacci number
	// base case -> f1 = f2 = 1
	private static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			fibonacciNumber[n] = 1;
			return 1;
		} else {
			int f = fibonacci(n - 1) + fibonacci(n - 2);
			fibonacciNumber[n] = f;
			return f;
		}
		
	}
	
	// return next quadrant
	private int getNextQuadrant(int quadrant) {
		
		if (quadrant == 4) {
			quadrant = 1;
		} else {
			quadrant++;
		}
		return quadrant;
	}
	
	public void createChildren() {
		children = new FibonacciSquare[1];
		int nextQuadrant = getNextQuadrant(quadrant);
		int newX = x, newY = y, nextN = n + 1, newSize = modify *fibonacci(nextN);
		switch (nextQuadrant) {
		case 1:
			newX = newX - modify * fibonacci(n-1);
			newY = newY - newSize;
			break;
		case 2:
			newX = newX - newSize;
			newY = y;
			break;
		case 3:
			newX = x;
			newY = newY + size;
			break;
		case 4:
			newX = newX + size;
			newY = newY - modify * fibonacci(n-1);
			break;
		}
		// set the children with new coordinate and quadrant
		children[0] = new FibonacciSquare(newX, newY, c, nextN,  nextQuadrant);
	}
	
	
	public boolean reset() {
		fibonacciNumber[0] = this.size;
		 return super.reset(); 
	}	
	
	
}