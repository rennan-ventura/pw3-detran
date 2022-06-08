package br.com.rennan.ventura.pw3detran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@NotNull
	@Column(name = "idPessoa")
	private int id;
	
	@NotNull
	@NotBlank
	@Length(max = 40)
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@NotBlank
	@Column(name = "endereco")
	private String endereco;
	

}
