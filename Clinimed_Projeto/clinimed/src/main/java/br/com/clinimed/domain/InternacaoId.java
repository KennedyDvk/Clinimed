package br.com.clinimed.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

public class InternacaoId implements Serializable{
	
	@Column(name = "id_paciente")
	@JoinColumn(name = "id_paciente")	
    private Long idPaciente;
    
    @Column(name = "id_medico")
    @JoinColumn(name = "id_medico")
    private Long id;

	public InternacaoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternacaoId(Long idPaciente, Long id) {
		super();
		this.idPaciente = idPaciente;
		this.id = id;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
