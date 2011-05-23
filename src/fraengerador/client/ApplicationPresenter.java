package fraengerador.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;

public class ApplicationPresenter {
	public interface Display extends TakesValue<String> {
		HasKeyUpHandlers get();

		HasValue<String> getFeedbackText();

		HasClickHandlers getSendButton();
	}

	private final Display display;
	private final Translator translator;

	public ApplicationPresenter(final Display display) {
		this.display = display;
		this.translator = new Translator();

		if (GWT.isClient()) { // This check avoids the setup when we are in testing.
			display.get().addKeyUpHandler(new KeyUpHandler() {
				@Override
				public void onKeyUp(KeyUpEvent event) {
					updateTranslation();
				}
			});
			display.getSendButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					AsyncProvider.getAsync(new AsyncCallback<FeedbackServiceAsync>() {
						@Override
						public void onSuccess(final FeedbackServiceAsync feedbackService) {
							final String feedback = display.getFeedbackText().getValue();

							feedbackService.sendFeedback(feedback, new AsyncCallback<Void>() {
								@Override
								public void onSuccess(Void result) {
									display.getFeedbackText().setValue(feedback + "\nFeedback erfolgreich gesendet.");
								}

								@Override
								public void onFailure(Throwable caught) {
									display.getFeedbackText().setValue(feedback + "\nFehler beim Senden.");
								}
							});
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Internetverbindung überprüfen! Beim Nachladen des JavaScript Codes ist ein Fehler aufgetreten.");
						}
					});
				}
			});
		}
		updateTranslation();
	}

	public void updateTranslation() {
		display.setValue(translator.translate(display.getValue()));
	}
}
