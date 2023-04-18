package pattern;

public class ChannelFactory {
	enum channelTypeEnum {
		API,
		UI;
	}
	public Channel getChannel(String channelType) {

		CapabilityFactory.channelTypeEnum channel;

		if(channelType.equalsIgnoreCase("UI"))
			channel = CapabilityFactory.channelTypeEnum.UI;
		else
			channel = CapabilityFactory.channelTypeEnum.API;


		switch (channel) {
		case API:

			return new Api();
		case UI:
			return new Ui();

		default:
			return null;
		}
	}

}
