
public class CustomKey {
	
	private String type;
	private String name;
	private int extra;
	
	public CustomKey (String type, String name, String extra) {
		this.type = type;
		this.name = name;
		this.extra = Integer.parseInt(extra);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return type + ", " + name + ", " + extra;
	}
	
	public String getType() {
		return type;
	}
	
	public int getExtra() {
		return extra;
	}

}
