package core;

public interface IParameterizable extends IViewable {

	public void setDefault();
	
	@Override
	public IViewer show();
}
