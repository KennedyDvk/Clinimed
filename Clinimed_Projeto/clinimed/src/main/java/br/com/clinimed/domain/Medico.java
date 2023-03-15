package br.com.clinimed.domain;

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
@Table(name = "TB_MEDICO")
public class Medico {
	
	@Id
	@SequenceGenerator(name = "MEDICO", sequenceName = "SQ_TB_MEDICO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICO")
	@Column(name = "id_medico", nullable = false)
	private Long id;
	
	@Column(name = "nm_medico", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "nr_cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name = "ds_email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "nr_telefone", length = 20, nullable = false)
	private String telefone;
	
	@Column(name = "ds_especialidade", length = 100, nullable = false)
	private String especialidade;

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consulta;
	
	@OneToMany(mappedBy = "medico")
	private List<Exame> exame;

	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(Long id, String nome, String cpf, String email, String telefone, String especialidade,
			List<Consulta> consulta, List<Exame> exame) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.especialidade = especialidade;
		this.consulta = consulta;
		this.exame = exame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
