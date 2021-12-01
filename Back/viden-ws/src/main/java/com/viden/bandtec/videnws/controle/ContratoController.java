package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Contrato;
import com.viden.bandtec.videnws.repositorio.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoRepository repository;

    @PostMapping
    private ResponseEntity postContrato(@RequestBody Contrato novoContrato){
        repository.save(novoContrato);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/upload/{idContrato}")
    public ResponseEntity patchContrato(@PathVariable Integer idContrato,
                                        @RequestParam MultipartFile file) throws IOException {
        if(repository.existsById(idContrato)){
            Contrato contrato = repository.findById(idContrato).get();
            byte[] newFile = file.getBytes();
            contrato.setContrato(newFile);
            repository.save(contrato);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/download/{idContrato}")
    public ResponseEntity getContrato(@PathVariable Integer idContrato){
        if(repository.existsById(idContrato)){
            Contrato contrato = repository.findById(idContrato).get();
            return ResponseEntity.status(200).
                    header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + contrato.getQuemEnviou())
                    .contentType(MediaType.valueOf("plain/text")).contentLength(1).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
