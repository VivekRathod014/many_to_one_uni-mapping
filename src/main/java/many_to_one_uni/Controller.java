package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vivek");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("vikram");
		person.setEmail("vikram@gmail.com");
		person.setContact_no(98765432);
		
		Account account1 = new Account();
		account1.setAccount_no(345623456);
		account1.setBank_name("Kotak");
		account1.setIfsc_code("KKBK00987");
		
		account1.setPerson(person);
		
		Account account2 = new Account();
		account2.setAccount_no(886547894);
		account2.setBank_name("Induslnd");
		account2.setIfsc_code("INDB000765");
		
		account2.setPerson(person);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityTransaction.commit();
		
		
	}
	

}
