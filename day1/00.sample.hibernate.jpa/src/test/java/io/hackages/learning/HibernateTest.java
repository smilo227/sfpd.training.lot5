package io.hackages.learning;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import io.hackages.learning.model.Product;
import io.hackages.learning.util.HibernateUtil;

@TestMethodOrder(OrderAnnotation.class)
public class HibernateTest {

	private static EntityManager entityManager;
	
	@BeforeAll
	public static void setup() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("EntityManager created");
	}
	
	@AfterAll
	public static void tearDown() {
		HibernateUtil.shutdown();
		System.out.println("EntityManager destroyed");
	}
	
	@BeforeEach
	public void openSession() {
		entityManager.getTransaction().begin();
		System.out.println("Transaction created");
	}
	
	@AfterEach
	public void closeSession() {
		entityManager.close();
		System.out.println("Session closed\n");
	}
	
	@Test
	@Order(1)
	public void testCreate() {
		System.out.println("Running testCreate...");
		
		Product product = new Product("my Phone v1", 899);
		entityManager.persist(product);
		
		Assertions.assertTrue(true);
	}
	
}