package py.com.copaco.core.backend.mail;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;

/**
 * @author Mauro Vera
 * @since 1.0
 * @version 2.0 feb 2, 2015
 * 
 * @author Lila Perez
 * @since 2.0
 * @version 29/06/2015
 */

@Stateless
public class MailSender {

	@Resource(mappedName = "java:jboss/mail/Default")
	private Session mailSession;

	@Inject
	private EntityManager em;

	/**
	 * Enviar un mail: método para enviar mail.
	 * @param sSubject: asunto del mail.
	 * @param sMailTo: dirección de correo destino. 
	 * @param sMailCc: dirección de correo destino a los que se le envia copia.
	 * @param mailFrom: dirección de correo fuente.
	 * @param sMailText: cuerpo del mail en formato de texto plano.
	 * @param textHtml: Texto en formato html.
	 * @param adjunto: archivo adjunto a enviar.
	 * @throws MessagingException. */
	public void enviarMail(String sSubject, String sMailTo, String sMailCc, String mailFrom,
			String sMailText, String textHtml, String adjunto)
			throws MessagingException {
		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(sSubject);
		message.setFrom(new InternetAddress(mailFrom));
		
		/** destinatarios*/
		message.addRecipients(Message.RecipientType.TO, sMailTo);
		/** con copia*/
		if (sMailCc != null && !sMailCc.isEmpty()){
			message.addRecipients(Message.RecipientType.CC, sMailCc);
		}
		
		setFileAsAttachment(message, adjunto, sMailText, textHtml);
		message.saveChanges();
		Transport.send(message);
	}

	/**
	 * Set a file as an attachment. Uses JAF FileDataSource.
	 * @param msg: mensaje al cual se le adjunta.
	 * @param filename: file name.
	 * @param cuerpo: cuerpo que acompaña al archivo en el caso de que sea texto plano.
	 * @param html: texto en formato html.
	 * @throws MessagingException. */
	public void setFileAsAttachment(Message msg, String filename, String cuerpo, String html)
			throws MessagingException {
		/** Multipart para el mensaje*/
		Multipart mp = new MimeMultipart();
		
		/** Para texto plano*/
		if (cuerpo != null && !cuerpo.isEmpty()){
			MimeBodyPart p1 = new MimeBodyPart();
			p1.setText(cuerpo);
			mp.addBodyPart(p1);
		}
		
		/** Para texto con formato html*/
		if (html != null && !html.isEmpty()){
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(html, "text/html");
			mp.addBodyPart(htmlPart);
		}

		/** Para archivos adjuntos*/
		if (filename != null && !filename.isEmpty()){
			MimeBodyPart p2 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(filename);
			p2.setDataHandler(new DataHandler(fds));
			p2.setFileName(fds.getName());
			mp.addBodyPart(p2);
		}
		// Set Multipart as the message's content
		msg.setContent(mp);
	}

	/**
	 * Retorna los destinatarios a los cuales se va a enviar el mensaje en una
	 * lista de InternetAdress
	 * @param modulo: es el modulo de la tabla configuración.
	 * @param nombre: campo nombre de la tabla configuración.
	 * @throws AddressException. */
	public InternetAddress[] destinatarios(String modulo, String nombre)
			throws AddressException {

		ArrayList<InternetAddress> lista = new ArrayList<InternetAddress>();
		InternetAddress[] listaArr = null;

		List<String> result = em
				.createNamedQuery("configuracion.modulo.value", String.class)
				.setMaxResults(1).setParameter("modulo", modulo)
				.setParameter("nombre", nombre).getResultList();

		if (result.isEmpty())
			System.out.println("no existe el valor requerido");
		else {

			String var = result.get(0);

			for (String retval : var.split(",")) {
				System.out.println(retval);
				lista.add(new InternetAddress(retval));
			}
			/* convertir a InternetArray */
			listaArr = new InternetAddress[lista.size()];
			listaArr = lista.toArray(listaArr);
		}
		return listaArr;
	}

}
