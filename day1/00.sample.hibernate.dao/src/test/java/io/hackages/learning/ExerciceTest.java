package io.hackages.learning;

import io.hackages.learning.dao.ClientDao;
import io.hackages.learning.dao.OrderDao;
import io.hackages.learning.dao.ProductDao;
import io.hackages.learning.model.*;
import io.hackages.learning.model.CustomerOrder;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class ExerciceTest {

	private static ProductDao productDao;
	private static ClientDao clientDao;
	private static OrderDao orderDao;

	@BeforeAll
	public static void setup() {
		productDao = new ProductDao();
		clientDao = new ClientDao();
		orderDao = new OrderDao();
		System.out.println("Dao created");
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Dao destroyed");
	}	
	
	@Test
	public void testCreate() {
		System.out.println("Running testCreate...");
		
		Product product = new Product("my Phone v1", 699);
		Integer id = productDao.saveProduct(product);
		
		assertTrue(id > 0);
	}

	@Test
	public void testList() {
		System.out.println("Running testList...");
		
		List<Product> resultList = productDao.getProducts();
		
		Assertions.assertFalse(resultList.isEmpty());
		Assertions.assertEquals(resultList.size(), 1);
	}

	@Test
	public void testCreate2() {
		System.out.println("Running testCreate...");

		Product product1 = new Product("cat", 699,ProductCategory.CAT_FOOD);
		Product product2 = new Product("dog", 123,ProductCategory.DOG_FOOD);
		Product product3 = new Product("bird", 45,ProductCategory.BIRD_FOOD);
		productDao.saveProduct(product1);
		productDao.saveProduct(product2);
		productDao.saveProduct(product3);
		List<Product> products = productDao.getProducts();
		assertEquals(products.size(), 3);

		Client jane = new Client("jane", "janedoe@dfg");
		Client johndoe = new Client("John",  "johndoe@sedfzsefg");


		List<Client> clients = clientDao.getClients();
		assertTrue(clients.isEmpty());

		clientDao.saveClient(jane);
		clientDao.saveClient(johndoe);
		assertEquals(clients.size(),2);
		// First part of challenge

		// 2nd part : Add Orders
		OrderDetail orderDetail1 = new OrderDetail(products.get(0), 10);
		OrderDetail orderDetail2 = new OrderDetail(products.get(1), 10);
		OrderDetail orderDetail3 = new OrderDetail(products.get(2), 10);


		CustomerOrder orderForCustomer1 = new CustomerOrder(clients.get(0), RandomStringUtils.randomAlphanumeric(15));
		orderForCustomer1.addOrderDetail(orderDetail1);
		orderForCustomer1.addOrderDetail(orderDetail2);
		orderForCustomer1.addOrderDetail(orderDetail3);

	}

}
