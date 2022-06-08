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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import br.com.rennan.ventura.pw3detran.enums.EstadoMultaEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "multa")
public class Multa {
	
	@Id
	@NotNull
	@Column(name = "idMulta")
	private int id;
	
	@NotNull
	@PastOrPresent
	@Column(name = "dataAplicacao")
	private Date aplicacao;
	
	@NotNull
	@Future
	@Column(name = "vencimento")
	private Date vencimento;
	
	@NotNull
	@Column(name = "estadoMulta")
	@Enumerated(EnumType.STRING)
	private EstadoMultaEnum estadoMulta;
	
	@NotNull
	@Column(name = "orgao")
	private String orgao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "veiculo")
	private Veiculo veiculo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "condutor")
	private Pessoa condutor;

}
