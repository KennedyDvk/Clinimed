package br.com.clinimed.domain;

import java.util.Objects;

public class ConsultaId {
	
	private Long paciente;
	
	private Long medico;

	public ConsultaId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsultaId(Long paciente, Long medico) {
		super();
		this.paciente = paciente;
		this.medico = medico;
	}

	public Long getPaciente() {
		return paciente;
	}

	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}

	public Long getMedico() {
		return medico;
	}

	public void setMedico(Long medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(medico, paciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaId other = (ConsultaId) obj;
		return Objects.equals(medico, other.medico) && Objects.equals(paciente, other.paciente);
	}

}
