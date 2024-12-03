package com.example.APPY_REST_G4.controladores;

import com.example.APPY_REST_G4.Servicios.PacienteServicio;
import com.example.APPY_REST_G4.modelos.Paciente;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente")
public class PacienteControlador {
    @Autowired
    PacienteServicio pacienteServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Paciente datos) {

        try {

       return ResponseEntity
               .status(HttpStatus.OK)
               .body(pacienteServicio.registrarPaciente(datos));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obtener() throws Exception{
        try {
           return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pacienteServicio.obtenerPacientes());
        }catch (Exception error){
           return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
