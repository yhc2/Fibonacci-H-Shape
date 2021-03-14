import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class MainClass {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			createGraphics();
		});
	}
	
	/**
	 * Does some ish hoe
	 */
	private static void createGraphics() {
		
		//create a frame and a model
		JFrame frame = new JFrame("Homework 4");
		frame.setSize(1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingModel model = new DrawingModel();

		// create a view to the frame and the model
		DrawingView v = new DrawingView();
		model.addView(v);
		frame.add(v);
		
		// create a panel at top to put the button
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		frame.add(northPanel, BorderLayout.NORTH);
		
		// button to increase the level
		JRadioButton increaseButton = new JRadioButton("Increase",true);
		northPanel.add(increaseButton);
						
		// button to decrease the level
		JRadioButton decreaseButton = new JRadioButton("Decrease");
		northPanel.add(decreaseButton);
						
		// Create a button group to put the buttons together
		// thus the user can only choose one radioButton at one time
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(increaseButton);
		buttons.add(decreaseButton);
						
		// button to reset the level
		JButton resetButton = new JButton ("Reset");
		northPanel.add(resetButton);

		
		// Combine the model and view with the controller
		Controller controller = new Controller(model, increaseButton, decreaseButton);
		resetButton.addMouseListener(controller);
		v.addMouseListener(controller);
		
		
		// create the FibonacciSquare and add it to the model
		Shape f = new FibonacciSquare(1100, 510, Color.gray, 1, 1);
		model.addShape(f);
	
		// create the HShape and add it to the model
		Shape h = new HShape(50, 230, Color.orange, 330);
		model.addShape(h);
		
		// create the text to the model
	    TextViewer text = new TextViewer();
		model.addView(text);
		

		
		frame.setVisible(true);

	}
}