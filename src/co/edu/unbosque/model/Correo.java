package co.edu.unbosque.model;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {

	private String host;
	private final String user;
	private final String password;

	public Correo() {
		host = "smtp.gmail.com";
		user = "buseche@unbosque.edu.co";
		password = "bshcsrmvccqcdoxn";
	}

	public void start(String to, String cod, String name) {

	// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

	//	 Compose the message
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Codigo de verificación");
			message.setText("Hola, "+name+"\r\n"
					+ " \r\n"
					+ "De acuerdo con la solicitud, te enviamos el codigo de verificación.\r\n"
					+ " \r\n"
					+ "•	\r\n"
					+ "Facultad de ingenieria: "+cod+".\r\n"
					+ " \r\n"
					+ "•	\r\n"
					+ "Es personal e intransferible. Ingrese el codigo para finalizar la inscripción y activar su cuenta.\r\n"
					+ " ");

		//	send the message
			Transport.send(message);
			System.out.println(cod);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}