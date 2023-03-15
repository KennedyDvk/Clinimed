package br.com.clinimed.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PACIENTE")
public class Paciente  {
	
	@Id
	@SequenceGenerator(name = "PACIENTE", sequenceName = "SQ_TB_PACIENTE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PACIENTE")
	@Column(name = "id_paciente", nullable = false)
	private Long idPaciente;
	
	@Column(name = "nm_paciente", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "nr_cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name = "nr_telefone", length = 20, nullable = false)
	private String telefone;
	
	@Column(name = "ds-endereco", length = 100, nullable = false)
	private String endereco;
	
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dtNascimento;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consulta;
	
	@OneToMany(mappedBy = "paciente")
	private List<Exame> exame;
	
	

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(Long idPaciente, String nome, String cpf, String telefone, String endereco, LocalDate dtNascimento,
			List<Consulta> consulta, List<Exame> exame) {
		super();
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dtNascimento = dtNascimento;
		this.consulta = consulta;
		this.exame = exame;
	}

	public Long getidPaciente() {
		return idPaciente;
	}

	public void setidPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public List<Exame> getExame() {
		return exame;
	}

	public void setExame(List<Exame> exame) {
		this.exame = exame;
	}

}
