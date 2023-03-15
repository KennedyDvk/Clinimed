package br.com.clinimed.teste;

import java.time.LocalDate;
import java.util.List;

import br.com.clinimed.domain.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class TesteCrudPaciente {

	public static void main(String[] args) {
		
		// Obtendo um EntityManagerFactory a partir da unidade de persistência configurada no persistence.xml
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinimed");
				
				// Obtendo um EntityManager a partir do EntityManagerFactory
				EntityManager em = emf.createEntityManager();
		
		// Criando uma instância da classe Paciente
		Paciente paciente = new Paciente();
		paciente.setNome("Kennedy Cesar Pimentel");
		paciente.setCpf("123.456.789-00");
		paciente.setTelefone("(11) 99999-9999");
		paciente.setEndereco("Rua do seu Chefe, 0");
		LocalDate dtNascimento = LocalDate.of(1991, 4, 6);
		paciente.setDtNascimento(dtNascimento);
		
		try {
			// Iniciando uma transação
			em.getTransaction().begin();
			
			// Salvando a instância da classe Paciente no banco de dados
			em.persist(paciente);
			
			// Finalizando a transação
			em.getTransaction().commit();
			
			// Consultando o paciente recém-salvo
			Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.nome = :nome");
			query.setParameter("nome", "Kennedy Cesar Pimentel");
			List<Paciente> pacientes = query.getResultList();
			
			if (!pacientes.isEmpty()) {
				// Atualizando o paciente encontrado
				Paciente pacienteAtualizado = pacientes.get(0);
				pacienteAtualizado.setTelefone("(11) 33111-8888");
				
				// Iniciando outra transação
				//em.getTransaction().begin();
				
				// Atualizando o paciente no banco de dados
				//em.merge(pacienteAtualizado);
				
				// Finalizando a transação
				//em.getTransaction().commit();
				
				// Consultando o paciente atualizado
				pacienteAtualizado = em.find(Paciente.class, pacienteAtualizado.getidPaciente());
				//System.out.println("Paciente atualizado: " + pacienteAtualizado);
				
				// Excluindo o paciente atualizado
				//em.getTransaction().begin();
				//em.remove(pacienteAtualizado);
				//em.getTransaction().commit();
			}
			
		} catch (Exception e) {
			// Desfazendo a transação em caso de erro
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// Fechando o EntityManager
			em.close();
		}
		
		// Fechando o EntityManagerFactory
		emf.close();
	}

}
