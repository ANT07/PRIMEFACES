/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Persona;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author ANTHONY MARTINEZ
 */
@Named(value = "personaBean")
@RequestScoped
public class PersonaBean {

    /**
     * Creates a new instance of PersonaBean
     */
    private Persona persona = new Persona();
    private static List<Persona> personas = new ArrayList<>();

    public  List<Persona> getPersonas() {
        return personas;
    }

    public  void setPersonas(List<Persona> personas) {
        PersonaBean.personas = personas;
    }
    
    public void agregar(ActionEvent e){
        personas.add(persona);
        this.notificarPush();
    }
    
    public void notificarPush(){
        String summary = "Nuevo elemento";
        String detail = "Se agrego otro elemento";
        String channel = "/notify";
        
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(channel, new FacesMessage(summary, detail));
    }
    public void listar(){
        Persona persona = new Persona();
        persona.setNombre("Anthony");
        persona.setEdad(1);
        personas.add(persona);
        
        persona = new Persona();
        persona.setNombre("Jose");
        persona.setEdad(34);
        personas.add(persona);
        
        persona = new Persona();
        persona.setNombre("Rocio");
        persona.setEdad(20);
        personas.add(persona);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
