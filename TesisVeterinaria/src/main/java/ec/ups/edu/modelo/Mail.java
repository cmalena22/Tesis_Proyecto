package ec.ups.edu.modelo;


import java.util.Date;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named
@RequestScoped
public class Mail {

	private String to;
	private String from;
	private String subject;
	private String descr;
	private String username;
	private String password;
	private String smtp;
	private int port;
	
	public Mail() {
		this.to = null;
		this.from = "correo@gmail.com";
		this.subject = null;
		this.descr = null;
		this.username = "correo@gmail.com";
		this.password = "password";
		this.smtp = "smtp.gmail.com";
		this.port = 25;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public void enviarEmail() {
		Properties props = null;
		Session session = null;
		MimeMessage message = null;
		Address fromAddress = null;
		Address toAddress = null;
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable",  "true");
		props.put("mail.smtp.host", smtp);
		props.put("mail.smtp.port", port);
		
		session = Session.getInstance(props,new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
	}
	
	public static void sendPlainTextEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
// *** BEGIN CHANGE
        properties.put("mail.smtp.user", userName);

        // creates a new session, no Authenticator (will connect() later)
        Session session = Session.getDefaultInstance(properties);
// *** END CHANGE

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setText(message);

// *** BEGIN CHANGE
        // sends the e-mail
        Transport t = session.getTransport("smtp");
        t.connect(userName, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
// *** END CHANGE

    }
	
}
