package br.com.rennan.ventura.pw3detran.controller;

import br.com.rennan.ventura.pw3detran.entity.Veiculo;
import br.com.rennan.ventura.pw3detran.repository.VeiculoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;
    List<Veiculo> veiculo = new ArrayList<Veiculo>();

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll(){
        veiculo = repository.findAll();
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getById(@PathVariable Integer id){
        Optional<Veiculo> veiculoOptional = repository.findById(id);
        if (veiculoOptional.isPresent()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(veiculoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculo){
        repository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Integer id, @RequestBody Veiculo veiculo){
        boolean existe = repository.existsById(id);
        if (existe){
            repository.save(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
