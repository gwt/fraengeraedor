package fraengerador.test;

import junit.framework.TestCase;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.HasValue;

import fraengerador.client.ApplicationPresenter;
import fraengerador.client.ApplicationPresenter.Display;

public class ApplicationPresenterTest extends TestCase {
	private ApplicationPresenter presenter;
	private final String test = "Die Brötchen, die wir am Montag gegessen haben sind auch schon etwas weich.";
	private ApplicationViewMock view;
	
	protected void setUp() throws Exception {
		view = new ApplicationViewMock(test);
		presenter = new ApplicationPresenter(view);

		assertEquals(test, view.getValue());
	}

	public void testTranslation() {
		presenter.updateTranslation();
		
		assertEquals("Die Weg, die ma am Mandi gassa ham sin a scho e weng lätschert.", view.target);
	}

	class ApplicationViewMock implements Display {
		public String source;
		public String target;

		public ApplicationViewMock(final String source) {
			this.source = source;
		}

		@Override
		public void setValue(String target) {
			this.target = target;
		}

		@Override
		public String getValue() {
			return source;
		}

		@Override
		public HasKeyUpHandlers get() {
			return null;
		}

		@Override
		public HasValue<String> getFeedbackText() {
			return null;
		}

		@Override
		public HasClickHandlers getSendButton() {
			return null;
		}
	}
}
