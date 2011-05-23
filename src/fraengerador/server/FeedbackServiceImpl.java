package fraengerador.server;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fraengerador.client.FeedbackService;

public class FeedbackServiceImpl extends RemoteServiceServlet implements FeedbackService {
	private static final Logger log = Logger.getLogger(FeedbackServiceImpl.class.getName());
	private static final String EMAIL_FROM = "ingo.jaeckel@googlemail.com"; // fraengeraedor@fraengeraedor.appspot.com"; // "honeycrm.feedback@honeyyycrm.appspot.com";
	private static final String EMAIL_TO = "ingo.jaeckel@googlemail.com"; // "honeycrm-users@googlegroups.com";
	private static final long serialVersionUID = 9119624817628593056L;

	@Override
	public void sendFeedback(final String message) {
		log.fine("Start sending mail..");

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress(EMAIL_FROM, "Fraengeraedor"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_TO, "Ingo Jaeckel"));
			msg.setSubject("Fraengeraedor Erweiterung");
			msg.setText(message);
			Transport.send(msg);

			log.finest("sent email from " + EMAIL_FROM + " to " + EMAIL_TO);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}