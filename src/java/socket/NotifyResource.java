/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import javax.faces.application.FacesMessage;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author ANTHONY MARTINEZ
 */
@PushEndpoint("/notity")
public class NotifyResource {
    
      @OnMessage(encoders = {JSONEncoder.class})
      public FacesMessage onMenssage(FacesMessage mensaje){
          return mensaje;
      }
}
