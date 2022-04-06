package br.com.rennan.ventura.pw3detran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@Column(name = "idVeiculo")
	private int id;
	
	@Column(name = "renavam")
	private String renavam;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "ano")
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "nome")
	private Pessoa proprietario;

}
