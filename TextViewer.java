public class TextViewer implements View {
	
//	private DrawingModel model;
	
	@Override
	public void update(DrawingModel model) {
		
		// this.model = model;
		
		// print out the information of each shape
		if (model.getShapes() != null) {
		
			for (Shape s: model.getShapes()) {
			
				System.out.println(s);
			}
			System.out.println("\n");
		}
	}
}