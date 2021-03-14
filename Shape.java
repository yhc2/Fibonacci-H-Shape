import java.awt.Graphics;

public interface Shape {

	void draw(Graphics g);

	boolean increaseLevel();

	boolean decreaseLevel();

	int getLevel();

	void createChildren();

	boolean reset();



	

}
