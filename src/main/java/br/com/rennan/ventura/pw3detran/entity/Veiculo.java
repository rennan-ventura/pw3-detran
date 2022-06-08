package br.com.rennan.ventura.pw3detran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@NotNull
	@Column(name = "idVeiculo")
	private int id;
	
	@NotNull
	@Column(name = "renavam")
	private String renavam;
	
	@NotNull
	@Length(max = 7)
	@Column(name = "placa")
	private String placa;
	
	@NotNull
	@NotBlank
	@Column(name = "modelo")
	private String modelo;
	
	@NotNull
	@PastOrPresent
	@Column(name = "ano")
	private int ano;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "proprietario")
	private Pessoa proprietario;

}
