package pattern;

import lombok.Data;

@Data
public abstract class Channel {
	
	Capability cap;
	
	public Capability setCapability(Capability cap) {
		
		return this.cap = cap;
	}
	
	
	public void login() {
		cap.login();
	}

	public void getCurrentWindow() {
		cap.getCurrentWindow();
	}
	
	public void shopping() {
		
		cap.shopping();
	}
	
	
	
}
