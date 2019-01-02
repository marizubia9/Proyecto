
package LP;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Clase para enviar correos a los clientes 
 *
 * 
 *
  */
public class clsEnviarEmail
{
	static String emailDestino;
	
	public clsEnviarEmail(String email)
	{
		emailDestino=email;
	}
    /**
     * main 
     * @param 
     */
    public static void main(String[] args)
    {
       EnviarEmail();
    }
    
    /**
     * Método para enviar email
     */
    public static void EnviarEmail()
    {
    	 try
         {
             // Propiedades de la conexión
             Properties props = new Properties();
             props.setProperty("mail.smtp.host", "smtp.gmail.com");
             props.setProperty("mail.smtp.starttls.enable", "true");
             props.setProperty("mail.smtp.port", "587");
             props.setProperty("mail.smtp.user", "doalzu@gmail.com");
             props.setProperty("mail.smtp.auth", "true");

             // Preparamos la sesion
             Session session = Session.getDefaultInstance(props);

             // Construimos el mensaje
             MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress("doalzu@gmail.com"));
             message.addRecipient(
                 Message.RecipientType.TO,
                 new InternetAddress(emailDestino));
             message.setSubject("Hola");
             message.setText(
                 "Mensajito con Java Mail" + "de los buenos." + "poque si");

             // Lo enviamos.
             Transport t = session.getTransport("smtp");
             t.connect("doalzu@gmail.com", "doalzudoalzu98");
             t.sendMessage(message, message.getAllRecipients());

             // Cierre.
             t.close();
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
    }
}