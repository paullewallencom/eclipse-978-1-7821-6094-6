package messageprovider;
import helloworldplugin.IMessageProvider;


public class MyMessageProvider implements IMessageProvider {

	@Override
	public String getHelloMessage() {
		return "Hello world from MessageProvider";
	}
	

}
