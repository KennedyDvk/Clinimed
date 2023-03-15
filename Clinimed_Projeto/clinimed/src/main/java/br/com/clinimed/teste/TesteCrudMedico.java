package br.com.clinimed.teste;


import java.util.List;

import br.com.clinimed.domain.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TesteCrudMedico {

	public static void main(String[] args) {
			
		// Obtendo um EntityManagerFactory a partir da unidade de persistência configurada no persistence.xml
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinimed");
				
				// Obtendo um EntityManager a partir do EntityManagerFactory
				EntityManager em = emf.createEntityManager();
			
		// Criando uma instância da classe Paciente
		Medico medico = new Medico();
		medico.setNome("Kennedy Cesar Pimentel");
		medico.setCpf("123.456.789-00");
		medico.setEmail("Kennedy@clinimed.com.br");
		medico.setTelefone("(11) 99999-9999");
		medico.setEspecialidade("Ortopedista");
		
		
		try {
			// Iniciando uma transação
			em.getTransaction().begin();
			
			// Salvando a instância da classe Paciente no banco de dados
			em.persist(medico);
			
			// Finalizando a transação
			em.getTransaction().commit();
				
			// Consultando o paciente recém-salvo
			Query query = em.createQuery("SELECT p FROM Medico p WHERE p.nome = :nome");
			query.setParameter("nome", "Kennedy Cesar Pimentel");
			List<Medico> medicos = query.getResultList();
				
			if (!medicos.isEmpty()) {
				// Atualizando o paciente encontrado
				Medico medicoAtualizado = medicos.get(0);
				medicoAtualizado.setTelefone("(11) 33111-8888");
				
				// Iniciando outra transação
	//			em.getTransaction().begin();
					
				 //Atualizando o paciente no banco de dados
	//			em.merge(medicoAtualizado);
					
				 //Finalizando a transação
	//			em.getTransaction().commit();
					
				// Consultando o paciente atualizado
				medicoAtualizado = em.find(Medico.class, medicoAtualizado.getId());
				System.out.println("Medico atualizado: " + medicoAtualizado);
					
	//			 Excluindo o paciente atualizado
	//			em.getTransaction().begin();
	//			em.remove(medicoAtualizado);
	//			em.getTransaction().commit();
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
