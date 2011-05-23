package fraengerador.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("feedback")
public interface FeedbackService extends RemoteService {
	public void sendFeedback(String feedback);
}