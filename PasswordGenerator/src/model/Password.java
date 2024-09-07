package model;

public class Password {
	
	private String key;
	
	public Password() {
		
	}

	public Password(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return key;
	}
	
	

}
