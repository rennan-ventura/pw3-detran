package br.com.rennan.ventura.pw3detran.controller;

import br.com.rennan.ventura.pw3detran.entity.Multa;
import br.com.rennan.ventura.pw3detran.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/multa")
public class MultaController {

    @Autowired
    private MultaRepository repository;
    List<Multa> multa = new ArrayList<Multa>();

    @GetMapping
    public ResponseEntity<List<Multa>> getAll(){
        multa = repository.findAll();
        return ResponseEntity.ok(multa);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Multa> findById(@PathVariable Integer id){
        Optional<Multa> multaOptional = repository.findById(id);
        if (multaOptional.isPresent()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(multaOptional.get());

    }

    @PostMapping
    public ResponseEntity<Multa> insert(@RequestBody Multa multa){
        repository.save(multa);
        return ResponseEntity.status(HttpStatus.CREATED).body(multa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Multa> update(@PathVariable Integer id, @RequestBody Multa multa){

        boolean existe = repository.existsById(id);
        if (existe) {
            repository.save(multa);
            ResponseEntity.status(HttpStatus.CREATED).body(multa);
        }
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Multa> delete(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

















