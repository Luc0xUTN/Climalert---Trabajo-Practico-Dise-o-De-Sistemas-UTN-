package com.utn.ba.ddsi.climaalertapi.services.notificaciones;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendgridSender implements  SenderAdapter{
  private final SendGrid sendGrid;
  private final Email emisor;

  public SendgridSender(@Value("${sendgrid.api-key}") String apiKey,
                             @Value("${sendgrid.from-email}") String emisor) {
    this.emisor = new Email(emisor);
    this.sendGrid = new SendGrid(apiKey);
  }

  @Override
  public void enviar(String email,String tema, String mensaje) {
    Email receptor = new Email(email);

    Content content = new Content("text/plain", mensaje);

    Mail mail = new Mail(emisor, tema , receptor, content);

    Request request = new Request();

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");

    try {
      request.setBody(mail.build());

      Response res = this.sendGrid.api(request);

      if (res.getStatusCode() != 202) {
        System.out.print("No se pudo enviar correctamente la peticion de mail");
      }

    } catch (IOException exception) {
      System.out.print("Ocurrio un error a la hora de enviar un mail " + exception.getMessage());
    }
  }
}

