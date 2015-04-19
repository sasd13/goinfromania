package core.params;

public abstract class Params {
	
	private String name;
	
	protected Params() {
		this.name = "Settings";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void save();
	
	public abstract void reset();
}
