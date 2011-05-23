package fraengerador.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FeedbackServiceAsync {
	void sendFeedback(String feedback, AsyncCallback<Void> callback);
}
