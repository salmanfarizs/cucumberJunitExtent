package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pattern.Capability;
import pattern.CapabilityFactory;
import pattern.Channel;
import pattern.ChannelFactory;

public class CommonSteps {

	Channel channeltype;
	
	@Given("Set channel {string}")
	public void setChannel(String channel){
		
		
		 channeltype = new ChannelFactory().getChannel(channel);
		
		Capability cap = new CapabilityFactory().getStrategy(channel);
		
		channeltype.setCapability(cap);
		
		
	}
	
	@Then("Login into Application")
	public void login() {
		
		
		channeltype.login();
		channeltype.getCurrentWindow();
		
		
	}
	
	
	@And("perform amazon shopping")
	public void shopping() {
		
		
		channeltype.shopping();
		
		
	}
	
	
	
	
	
	
}
