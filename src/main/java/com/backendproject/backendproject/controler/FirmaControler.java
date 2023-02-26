package com.backendproject.backendproject.controler;

import com.backendproject.backendproject.exceptions.ResourceNotFoundException;
import com.backendproject.backendproject.model.Firma;
import com.backendproject.backendproject.repositorio.FirmaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class FirmaControler {

    @Autowired
    private FirmaRepositorio repositorio;


    /**
     * Get All Firmas from DB
     * @return
     */
    @GetMapping("/firmas")
    public List<Firma> getAllFirmas(){
        return repositorio.findAll();
    }


    /**
     * ADD Firma in the DB
     * @param firma
     * @return
     */
    @PostMapping("/firmas")
    public Firma saveFirmas(@RequestBody Firma firma){
        return repositorio.save(firma);
    }


    /**
     * Get One Firma by ID to Modification
     * @param id
     * @return
     */
    @GetMapping("firmas/{id}")
    public ResponseEntity<Firma> getFirmaByID(@PathVariable Long id){
        Firma firma = repositorio.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("No existe la Firma con el ID: " + id));
        return ResponseEntity.ok(firma);
    }

    /**
     * Update Firma in the DB
     * @param id
     * @param firmaByFront
     * @return
     */
    @PutMapping("/firmas/{id}")
    public ResponseEntity<Firma> updateFirma(@PathVariable Long id, @RequestBody Firma firmaByFront){
        Firma firma = repositorio.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("No existe la Firma con el ID: " + id));

        firma.setTipo_firma(firmaByFront.getTipo_firma());
        firma.setRazon_social(firmaByFront.getRazon_social());
        firma.setRepresentante_legal(firmaByFront.getRepresentante_legal());
        firma.setEmpresa_acreditadora(firmaByFront.getEmpresa_acreditadora());
        firma.setFecha_emision(firmaByFront.getFecha_emision());
        firma.setFecha_vencimiento(firmaByFront.getFecha_vencimiento());
        firma.setRuta_rubrica(firmaByFront.getRuta_rubrica());
        firma.setCertificado_digital(firmaByFront.getCertificado_digital());


        Firma firmaUpdated = repositorio.save(firma);
        return ResponseEntity.ok(firmaUpdated);
    }


    /**
     * Delete one Firma in the DB
     * @param id
     * @return
     */
    @DeleteMapping("/firmas/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteFirma(@PathVariable Long id){
        Firma firma = repositorio.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("NO existe la Firma"));
        repositorio.delete(firma);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
