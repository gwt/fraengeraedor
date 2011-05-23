package fraengerador.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

import fraengerador.client.ApplicationPresenter.Display;

public class ApplicationView extends Composite implements Display {
	private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);

	interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationView> {
	}

	public ApplicationView() {
		initWidget(uiBinder.createAndBindUi(this));

		source.setText("Die Brötchen die wir Montag gegessen haben sind aber schon auch etwas weich");
		source.setFocus(true);
	}

	@UiField
	TextArea source;
	@UiField
	Label target;
	@UiField
	Button send;
	@UiField
	TextArea message;

	@Override
	public HasKeyUpHandlers get() {
		return source;
	}

	@Override
	public void setValue(final String value) {
		target.setText(value);
	}

	@Override
	public String getValue() {
		return source.getValue();
	}

	@Override
	public HasClickHandlers getSendButton() {
		return send;
	}
	
	@Override
	public HasValue<String> getFeedbackText() {
		return message;
	}
}
