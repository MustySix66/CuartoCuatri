package com.sendmail;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Clase que representa un destinatario
class Destinatario {
    private String nombre;
    private String correo;
    private String genero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

@RestController
public class EnviarCorreoMasivo {

    @Autowired
    private JavaMailSender mailSender;

    // Clase para recibir los datos en formato JSON
    static class CorreoRequest {
        private List<Destinatario> destinatarios;
        private String genero;

        public List<Destinatario> getDestinatarios() {
            return destinatarios;
        }

        public void setDestinatarios(List<Destinatario> destinatarios) {
            this.destinatarios = destinatarios;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }
    }

    // Mapea la solicitud HTTP POST a la ruta "enviarCorreoMasivo"
    @PostMapping("enviarCorreoMasivo")
    public ResponseEntity<?> enviarCorreoMasivo(@RequestBody CorreoRequest request) {
        // Filtrar la lista de destinatarios en función del género especificado
        List<Destinatario> destinatariosFiltrados = request.getDestinatarios().stream()
            .filter(d -> d.getGenero().equalsIgnoreCase(request.getGenero()))
            .collect(Collectors.toList());

        try {
            // Iterar sobre cada destinatario filtrado
            for (Destinatario destinatario : destinatariosFiltrados) {
                // Crear un objeto SimpleMailMessage para configurar los detalles del correo
                SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(destinatario.getCorreo());
                email.setFrom("teDeRamoBlanco@gmail.com"); 
                email.setSubject("Correo masivo de prueba");
                email.setText("Hola " + destinatario.getNombre() + ", este es para el genero "+destinatario.getGenero()+"."); // Establecer el contenido del correo

                // Enviar el correo electrónico utilizando el objeto JavaMailSender
                mailSender.send(email);
            }

            // Retornar una respuesta HTTP 200 OK si los correos se enviaron con éxito
            return new ResponseEntity<>("Correos enviados exitosamente", HttpStatus.OK);

        } catch (Exception e) {
            // Si ocurre algún error, imprimir el seguimiento de la pila y devolver una respuesta HTTP 500
            e.printStackTrace();
            return new ResponseEntity<>("Error al enviar los correos: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
