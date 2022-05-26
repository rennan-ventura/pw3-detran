package br.com.rennan.ventura.pw3detran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rennan.ventura.pw3detran.entity.Pessoa;
import br.com.rennan.ventura.pw3detran.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@GetMapping
	//Uma variação para mudar o status de retorno seria: @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Pessoa>> getAll(){
		pessoas = repository.findAll();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	//Uma variação para mudar o status de retorno seria: @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Pessoa> getById(@PathVariable Integer id){
		Optional<Pessoa> tipo = repository.findById(id);
		if (tipo.isPresent()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tipo.get());
		
	}
		
	@PostMapping	
	//Uma variação para mudar o status de retorno seria: @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
		repository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}
	
	@PutMapping("/{id}")
	//Uma variação para mudar o status de retorno seria: @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		
		boolean existe = repository.existsById(id);
		if(existe) {
			repository.save(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	//Uma variação para mudar o status de retorno seria: @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Pessoa> delete(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

