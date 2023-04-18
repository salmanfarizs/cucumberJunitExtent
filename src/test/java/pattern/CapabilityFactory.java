package pattern;

public class CapabilityFactory {

	enum channelTypeEnum {
		API,
		UI;
	}
	public Capability getStrategy(String channelType) {

		channelTypeEnum channel;
		
		if(channelType.equalsIgnoreCase("UI"))
			channel = channelTypeEnum.UI;
		else
			channel = channelTypeEnum.API;
		
		switch (channel) {
		case API:

			return new ApiStrategy();

		case UI:

			return new UiStrategy();

		default:
			break;
		}
		return null;

	}

}
