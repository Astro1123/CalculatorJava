package area;

public class ShapeStruct {
	public double len;
	public double area;
	public int shape;
   	
   	public ShapeStruct ShapeStruct() {
		ShapeStruct sstruct = new ShapeStruct();
		sstruct.len = 0.0;
		sstruct.area = 0.0;
		sstruct.shape = 0;
		return sstruct;
	   	}
}