package fraengerador.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Fraengerador implements EntryPoint {
	public void onModuleLoad() {
		final ApplicationView display = new ApplicationView();
		RootLayoutPanel.get().add(display);
		new ApplicationPresenter(display);
	}
}
