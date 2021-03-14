import java.awt.Component;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class Controller extends MouseAdapter {
	
	// four int to check whether position of the click is inside the square of HShape
	private final int HRIGHTX = 380;
	private final int HLEFTX = 50;
	private final int HHIGHY = 230;
	private final int HLOWY = 560;
	
	//maximum FibonacciSpiral level
	private final int FSMAXLEVEL = 10;
	
	//maximum HShape level
	private final int HMAXLEVEL = 5;
	
	private final int MINLEVEL = 1;
	
	private DrawingModel model;
	
	private JRadioButton increaseButton;
	private JRadioButton decreaseButton;
	
	public Controller(DrawingModel model, JRadioButton increase, JRadioButton decrease) {
		this.model = model;
		this.increaseButton = increase;
		this.decreaseButton = decrease;
	}
	
	// execute increase or decrease or reset when the user clicks
	@Override
	public void mouseClicked(MouseEvent e) {
		List<Shape> shapes = model.getShapes();
		Shape fibonacciSquare = shapes.get(0);
		Shape hShape = shapes.get(1);
		
		// if the user click resetButton which is the only JButton
		// execute the reset method 
		if (e.getComponent() instanceof JButton) {
			model.resetLevel();	
		} 
		// if the user clicks at the right part of the frame and selects the increaseButton
		// execute increase method of FibonacciSquare
		else if (e.getX() > HRIGHTX && increaseButton.isSelected()) {
			if (fibonacciSquare.getLevel() < FSMAXLEVEL) {
				model.increaseLevel(fibonacciSquare); 
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Maximum Level of Fibonacci Square!");
			}
		}
		// if the user clicks at the right part of the frame and selects the decreaseButton
		// execute decrease method of FibonacciSquare
		 else if (e.getX() > HRIGHTX && decreaseButton.isSelected()) {
			if (fibonacciSquare.getLevel() > MINLEVEL) {
				model.decreaseLevel(fibonacciSquare);
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Minimum Level of Fibonacci Square!");
			}
		} 
		// if the user clicks inside the square of HShape and selects the increaseButton
		// execute increase method of HShape
		else if (e.getX() > HLEFTX && e.getX() < HRIGHTX && e.getY() > HHIGHY && e.getY() < HLOWY && increaseButton.isSelected()) {
			if (hShape.getLevel() < HMAXLEVEL) {
				model.increaseLevel(hShape);
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Maximum Level of HShape!");
			}
		} 
		// if the user clicks inside the square of HShape and selects the decreaseButton
		// execute decrease method of HShape
		else if (e.getX() > HLEFTX && e.getX() < HRIGHTX && e.getY() > HHIGHY && e.getY() < HLOWY && decreaseButton.isSelected()) {
			if (hShape.getLevel() > MINLEVEL) {
					model.decreaseLevel(hShape);
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Minimum Level of HShape!");
			}
		}
	}
	
}