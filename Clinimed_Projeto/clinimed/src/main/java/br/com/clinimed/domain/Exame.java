package br.com.clinimed.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXAME")
public class Exame {
	
	@Id
	@SequenceGenerator(name = "EXAME", sequenceName = "SQ_TB_EXAME", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAME")
	@Column(name = "id_exame", nullable = false)
	private Long id;
	
	@Column(name = "ds_exame", length = 100, nullable = false)
	private String descricao;
	
	@Column(name = "nm_paciente", length = 100, nullable = false)
	private String nomePaciente;
	
    @Column(name = "dt_hora_ex", nullable = false)
    private LocalDate dtHoraExame;
	
	@ManyToOne
    @JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name = "id_medico")
	private Medico medico;

	public Exame() {
		super();
		
	}

	public Exame(Long id, String descricao, String nomePaciente, LocalDate dtHoraExame) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nomePaciente = nomePaciente;
		this.dtHoraExame = dtHoraExame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public LocalDate getDtHoraExame() {
		return dtHoraExame;
	}

	public void setDtHoraExame(LocalDate dtHoraExame) {
		this.dtHoraExame = dtHoraExame;
	}
	

}
