package br.com.clinimed.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_INTERNACAO")
public class Internacao {
	
	@Id
	@SequenceGenerator(name = "INTERNACAO", sequenceName = "SQ_TB_INTERNACAO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INTERNACAO")
	@Column(name = "id_internacao", nullable = false)
	private Long id;
	
	@Column(name = "dt_inicio")
	private LocalDate dtInicio;
	
	@Column(name = "dt_fim")
	private LocalDate dtFim;
	
	@Column(name = "ds_quarto", length = 100, nullable = false)
	private String quarto;
	
	 @ManyToOne
	 @JoinColumns({
		 @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente"),
		 @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
	    })
	 private Consulta consulta;
	
	
	

	public Internacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Internacao(Long id, LocalDate dtInicio, LocalDate dtFim, String quarto, Consulta consulta) {
		super();
		this.id = id;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.quarto = quarto;
		this.consulta = consulta;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}

	public String getQuarto() {
		return quarto;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
