
package LP;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 static String concepto;
	 private final static Logger LOGGER = Logger.getLogger("LP.EnviarEmail");

	
	public clsEnviarEmail(String email, String conc)
	{
		concepto=conc;
		emailDestino=email;
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
             message.setSubject("DOALZU");
             if(concepto.equals("Registrarse"))
             {
            	 LOGGER.log(Level.INFO, "Entra en registrarse.");
            	 message.setText(
                         "Gracias por crear una cuenta de DOALZU.");
             }
             if(concepto.equals("Pagar"))
             {
            	 LOGGER.log(Level.INFO, "Entra en pagar.");
            	 message.setText(
                         "Su pago se ha realizado correctamente. Muchísimas gracias!");
             }
             

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
    
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para
	// no sobreescribir
	static {
		try {
		LOGGER.addHandler(new FileHandler(clsAnyadirCarrito.class.getName()
		+ ".log.xml", ANYADIR_A_FIC_LOG));
		} catch (SecurityException | IOException e) {
		LOGGER.log(Level.SEVERE, "Error en creación fichero log");
		}
		}
    
}