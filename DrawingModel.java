import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();
	private Shape[] newShapes;
	
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	public void updateAll() {
		for (View v : views) {
			v.update(this);
		}
	}

	public void addShape(Shape s) {
		shapes.add(s);
		updateAll();
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public Shape[] newGetShapes() {
		return newShapes;
	}
	
	public boolean increaseLevel(Shape shape) {
		boolean check = shape.increaseLevel();
		updateAll();
		return check;
	}
	
	public boolean decreaseLevel(Shape shape) {
		boolean check = shape.decreaseLevel();
		updateAll();
		return check;
	}
	
	public void resetLevel() {
		for (Shape s : shapes) {
			s.reset();
		}
		for (View view : views) {
			view.update(this);
		}
	}



	
	
	
}