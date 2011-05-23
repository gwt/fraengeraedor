package fraengerador.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AsyncProvider {
	private static FeedbackServiceAsync service;
	
	public static void getAsync(final AsyncCallback<FeedbackServiceAsync> client) {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onSuccess() {
				if (null == service) {
					service = GWT.create(FeedbackService.class);
				}
				client.onSuccess(service);
			}

			@Override
			public void onFailure(Throwable reason) {
				client.onFailure(reason);
			}
		});
	}
}
