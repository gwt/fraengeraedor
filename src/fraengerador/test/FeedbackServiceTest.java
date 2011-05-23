package fraengerador.test;

import fraengerador.server.FeedbackServiceImpl;
import junit.framework.TestCase;

public class FeedbackServiceTest extends TestCase {
	public void testMail() {
		new FeedbackServiceImpl().sendFeedback("Foo");
	}
}
