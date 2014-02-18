package br.com.gigio.persistencewithhibernate.test;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.gigio.persistencewithhibernate.model.Aluno;

public class TestePersistencia {
	
private static EntityManager em = null;
	
	public static void main(String[] args) {
		
		em = (EntityManager) Persistence.createEntityManagerFactory("persistence-with-hibernate").createEntityManager();
		
		// Inicia uma transação
		em.getTransaction().begin();

		// ------------ Cria o primeiro Aluno ---------
		Aluno a1 = new Aluno();
		a1.setCurso("Computação");
		a1.setNome("João");

		Calendar dt = Calendar.getInstance();

		dt.set(Calendar.YEAR, 1983);
		dt.set(Calendar.MONTH, Calendar.AUGUST);
		dt.set(Calendar.DAY_OF_MONTH, 11);

		a1.setDataNascimento(dt.getTime());
		a1.setTemFies(true);

		// Até aqui o Aluno João ainda não foi
		// persistido no banco de dados
		em.persist(a1); // Aqui a entidade é persistida
		em.flush(); // Força uma sincronização imediata com o banco de dados

		// ------------ Cria o segundo Aluno ---------
		Aluno a2 = new Aluno();

		a2.setCurso("Computação");
		a2.setNome("Pedro");

		dt = Calendar.getInstance();

		dt.set(Calendar.YEAR, 1992);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);

		a2.setDataNascimento(dt.getTime());
		a2.setTemFies(false);
		a2.setQuantidadeReprovacoes(3);

		em.persist(a2);
		em.flush();

		System.out.println("Aluno 1 Id : " + a1.getId());
		System.out.println("Aluno 2 Id : " + a2.getId());

		// ------------ Consulta o objeto persistido ---------
		Query query = em
				.createQuery("Select a from Aluno a where a.id=:idaluno");
		
		
		query.setParameter("idaluno", a2.getId());
		Aluno retrieved2 = (Aluno) query.getSingleResult();
				
		// ------------ Update ---------

		a2.setQuantidadeReprovacoes(2);
		em.merge(a2);
		em.flush();

		System.out.println("Aluno 2 Id : " + a2.getId());
		System.out.println("Aluno 2 Nome : " + a2.getNome());
		System.out.println("Aluno 2 Curso : " + a2.getCurso());
		System.out.println("Aluno 2 FIES : " + retrieved2.getTemFies());

		// ------------ Removendo Entradas no banco ---------
		//em.remove(a1);
		//em.remove(a2);

		em.getTransaction().commit();
	}

}
