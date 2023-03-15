package br.com.clinimed.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONSULTA")
@IdClass(ConsultaId.class)
public class Consulta implements Serializable {
	
	@Id
	@SequenceGenerator(name = "CONSULTA", sequenceName = "SQ_TB_CONSULTA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSULTA")
	@Column(name = "id_consulta", nullable = false)
	private Long id;
	
	@Id
	@JoinColumn(name = "id_paciente")
	@ManyToOne(optional = false)
	private Paciente paciente;
	
	@Id
	@JoinColumn(name = "id_medico")
	@ManyToOne(optional = false)
	private Medico medico;
	
	@OneToMany(mappedBy = "consulta")
	private List<Internacao> internacao;

    @Column(name = "dt_hora_consulta", nullable = false)
    private LocalDate dtHoraConsulta;
	
	@Column(name = "ds_sintomas", length = 100, nullable = false)
	private String sintomas;
	
	@Column(name = "ds_diagnostico", length = 100, nullable = false)
	private String diagnostico;
	
	@Column(name = "ds_prescricoes", length = 100, nullable = false)
	private String prescricoes;
	
	@Column(name = "vl_consulta", nullable = false)
	private double valor;

	public Consulta() {
		super();
		
	}

	public Consulta(Paciente paciente, Medico medico, List<Internacao> internacao, LocalDate dtHoraConsulta,
			String sintomas, String diagnostico, String prescricoes, double valor) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.internacao = internacao;
		this.dtHoraConsulta = dtHoraConsulta;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.prescricoes = prescricoes;
		this.valor = valor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Internacao> getInternacao() {
		return internacao;
	}

	public void setInternacao(List<Internacao> internacao) {
		this.internacao = internacao;
	}

	public LocalDate getDtHoraConsulta() {
		return dtHoraConsulta;
	}

	public void setDtHoraConsulta(LocalDate dtHoraConsulta) {
		this.dtHoraConsulta = dtHoraConsulta;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getPrescricoes() {
		return prescricoes;
	}

	public void setPrescricoes(String prescricoes) {
		this.prescricoes = prescricoes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
