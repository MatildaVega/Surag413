package com.example.APPY_REST_G4.Servicios;

import com.example.APPY_REST_G4.Repositorio.IRepositorioSignoVital;
import com.example.APPY_REST_G4.modelos.Enfermedad;
import com.example.APPY_REST_G4.modelos.SignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignoVitalServicio {

     @Autowired
    IRepositorioSignoVital iRepositorioSignoVital;

     public SignoVital registrarSignoVital(SignoVital datosSignoVital) throws Exception{
         try {

             return iRepositorioSignoVital.save(datosSignoVital);

         }catch (Exception error ){

             throw new Exception(error.getMessage());
         }

     }
    public List<SignoVital> obtenerSignosVitales () throws Exception{
        try {
            return iRepositorioSignoVital.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}


