package io.hackages.learning;

import io.hackages.learning.dao.ClientDao;
import io.hackages.learning.dao.OrderDao;
import io.hackages.learning.dao.OrderDetailsDao;
import io.hackages.learning.dao.ProductDao;
import io.hackages.learning.model.*;
import io.hackages.learning.model.Order;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import javax.swing.plaf.basic.BasicListUI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class ExerciceTest {

	private static ProductDao productDao;
	private static ClientDao clientDao;
	private static OrderDao orderDao;
	private static OrderDetailsDao orderDetailsDao;

	@BeforeAll
	public static void setup() {
		productDao = new ProductDao();
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
		Integer id = (Integer) productDao.saveProduct(product);
		
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

		Product product1 = new Product("cat", 699);
		Product product2 = new Product("dog", 123);
		Product product3 = new Product("bird", 45);
		product1.setProductCategory(ProductCategory.CAT_FOOD);
		product2.setProductCategory(ProductCategory.DOG_FOOD);
		product3.setProductCategory(ProductCategory.BIRD_FOOD);
		Integer id = (Integer) productDao.saveProduct(product1);
		Integer id2 = (Integer) productDao.saveProduct(product2);
		Integer id3 = (Integer) productDao.saveProduct(product3);
		Client jane = new Client("jane", "janedoe@dfg");
		Client johndoe = new Client("John",  "johndoe@sedfzsefg");

		Integer janeID = clientDao.saveClient(jane);
		Integer johnId = clientDao.saveClient(johndoe);

		// First part of challenge

		// 2nd part : Add Orders
		List<Order> orderFroClientJane = new ArrayList<>();
		ArrayList<Product> products = new ArrayList<>();
		products.add(product1);

		// Order order = new Order(jane, "Jane's order", List new OrderDetails(products, 50));
		Order order = new Order(jane, "Jane's order", ListOfOrderDetails );
		orderFroClientJane.add(order);

		ArrayList<Product> products2 = new ArrayList<>();
		products2.add(product3);
		products2.add(product2);
		List<Order> ordersForClientJohn = new ArrayList<>();
		ordersForClientJohn.add(new Order(johndoe,"johndoe's order",new OrderDetails(products2,20)));
		ordersForClientJohn.add(new Order(johndoe,"johndoe's order",new OrderDetails(products2,30)));

		/* One way
		jane.setOrders(orderFroClientJane);
		johndoe.setOrders(ordersForClientJohn);
		clientDao.updateClient(jane); // using Cascade
		 */

		/* Another way
		orderDao.saveOrder(orderFroClientJane.get(0));
		orderDao.saveOrder(ordersForClientJohn.get(0));
		orderDao.saveOrder(ordersForClientJohn.get(1));
		*/

		assertEquals(clientDao.getClients().get(1).getOrders().size(), johndoe.getOrders().size());
	}

}
