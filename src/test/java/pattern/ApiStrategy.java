package pattern;

import pages.ApiLoginPage;

public class ApiStrategy implements Capability{
	
	
	ApiLoginPage api = new ApiLoginPage();

	public void login() {
		
				api.getToken();
		
	}

	public void getCurrentWindow() {
		// TODO Auto-generated method stub
		System.out.println("Api current window called");
	}

	public void shopping() {
		// TODO Auto-generated method stub
		
	}
	
	

}
