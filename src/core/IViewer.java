package core;


public interface IViewer {

	public static final int FRAME_DIM_SMALL = 200;
	public static final int FRAME_DIM_MEDIUM = 350;
	public static final int FRAME_DIM_LARGE = 500;
	
	public static final int BUTTON_DIM_WIDTH = 74;
	public static final int BUTTON_DIM_HEIGHT = 26;
	
	public void bind(IViewable viewable);
}
