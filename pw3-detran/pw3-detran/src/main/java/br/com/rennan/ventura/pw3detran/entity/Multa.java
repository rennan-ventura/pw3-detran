package br.com.rennan.ventura.pw3detran.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.rennan.ventura.pw3detran.enums.EstadoMultaEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "multa")
public class Multa {
	
	@Id
	@Column(name = "idMulta")
	private int id;
	
	@Column(name = "dataAplicacao")
	private Date aplicacao;
	
	@Column(name = "vencimento")
	private Date vencimento;
	
	@Column(name = "estadoMulta")
	@Enumerated(EnumType.STRING)
	private EstadoMultaEnum estadoMulta;
	
	@Column(name = "orgao")
	private String orgao;
	
	@ManyToOne
	@JoinColumn(name = "veiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "condutor")
	private Pessoa condutor;

}
