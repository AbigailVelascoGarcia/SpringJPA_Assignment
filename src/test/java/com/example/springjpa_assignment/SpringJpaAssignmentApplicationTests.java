package com.example.springjpa_assignment;

import com.example.springjpa_assignment.Entity.Order;
import com.example.springjpa_assignment.Entity.Product;
import com.example.springjpa_assignment.Entity.User;
import com.example.springjpa_assignment.Repository.OrderRepository;
import com.example.springjpa_assignment.Repository.ProductRepository;
import com.example.springjpa_assignment.Repository.UserRepository;
import com.example.springjpa_assignment.ServiceClass.ProductService;
import com.example.springjpa_assignment.ServiceClass.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringJpaAssignmentApplicationTests {
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserService userService = new UserService();
	@Autowired
	ProductService productService = new ProductService();

	@Autowired
	ProductRepository productRepo;

	@Autowired
	OrderRepository orderRepo;
	@Test
	void contextLoads() {
	}
	@Test
	void createProducts(){
		Product product1 = new Product();
		product1.setName("Pilot Kakuno");
		product1.setPrice(300d);
		product1.setDescription("Fountain pen");
		product1.setInventory_amount(100);
		product1.setStatus(true);
		productRepo.save(product1);

		Product product2 = new Product();
		product2.setName("Picross Book");
		product2.setPrice(250d);
		product2.setDescription("Puzzle book");
		product2.setInventory_amount(50);
		product2.setStatus(true);
		productRepo.save(product2);

	}
	@Test
	public void createOrder(){
		Order order = new Order();
		order.setOrder_date(LocalDate.now());
		order.setUser(userRepo.findById(1).get());
		order.setProduct(productRepo.findById(1).get());
		orderRepo.save(order);
	}

	// User tests
	@Test
	void  createUsers_Success() {
		User user1 = new User();
		user1.setName("Abi");
		user1.setLast_name("Velasco");
		user1.setBio("Hola :-)");
		user1.setEmail("abivelasco@gmail.com");
		user1.setArea_of_interest("puzzles");
		userService.createUser(user1);

		User user2 = new User();
		user2.setName("Nat");
		user2.setLast_name("Velasco");
		user2.setBio("A87987809809");
		user2.setEmail("nat@gmail.com");
		user2.setArea_of_interest("puzzles");
		userService.createUser(user1);

		User user3 = new User();
		user3.setName("Eco");
		user3.setLast_name("Velasco");
		user3.setBio("AHHHHHHHHHHHHHH!");
		user3.setEmail("ecocachorro@gmail.com");
		user3.setArea_of_interest("Food");
		userService.createUser(user3);
	}

	@Test
	void  createExistingUser() {
		User existingUser = new User();
		existingUser.setEmail("nat@gmail.com");

	}

	@Test
	void updateUser(){
		User existingUser = userRepo.findById(1).get();

		userService.updateUser(existingUser,"abi@gmail.com", "Design");
	}

	@Test
	void deleteUser(){
		userService.deleteUser(1);
	}
	@Test
	void getAllUsers(){
		List<User> users = userService.getAllUsers();

		for (User user: users) {
			System.out.println("ID:" + user.getUser_id());
			System.out.println("NAME: " + user.getName());
			System.out.println("LAST NAME: " + user.getLast_name());
			System.out.println("BIO: " + user.getBio());
			System.out.println("EMAIL: " + user.getEmail());
			System.out.println("--------------------------------------------------");

		}

	}

	@Test
	void findUserByName(){
		User user = userService.getUserbyName("Nat");

		System.out.println("ID:" + user.getUser_id());
		System.out.println("NAME: " + user.getName());
		System.out.println("LAST NAME: " + user.getLast_name());
		System.out.println("BIO: " + user.getBio());
		System.out.println("EMAIL: " + user.getEmail());
		System.out.println("--------------------------------------------------");

	}

	@Test
	void findUserByEmail(){
		User user = userService.getUserByEmail("ecocachorro@gmail.com");

		System.out.println("ID:" + user.getUser_id());
		System.out.println("NAME: " + user.getName());
		System.out.println("LAST NAME: " + user.getLast_name());
		System.out.println("BIO: " + user.getBio());
		System.out.println("EMAIL: " + user.getEmail());
		System.out.println("--------------------------------------------------");
	}


	//Product tests
	@Test
	void insertExistingproduct(){
		Product product = productRepo.findById(1).get();
		productService.insertProduct(product);
	}

	@Test
	void insertNewProduct(){
		Product product = new Product();
		product.setName("Cotton sketchbook");
		product.setPrice(300d);
		product.setDescription("40 x 70 ");
		product.setStatus(true);

		productService.insertProduct(product);
	}

	@Test
	void updateProduct(){
		Product existingProduct = productRepo.findById(2).get();
		productService.updateProduct(existingProduct, null, null, "Fun picture puzzle book", null);
	}

	@Test
	public void deleteProduct(){
		productService.deleteProduct(2);
	}

	@Test
	void getAllProducts(){
		List<Product> products = productService.getAllProducts();

		for (Product product: products) {
			System.out.println("ID:" + product.getProduct_id());
			System.out.println("NAME: " + product.getName());
			System.out.println("PRICE: " + product.getPrice());
			System.out.println("DESCRIPTION: " + product.getDescription());
			System.out.println("INVENTORY AMOUNT: " + product.getInventory_amount());
			System.out.println("STATUS: " + product.getStatus());
			System.out.println("--------------------------------------------------");

		}
	}

	@Test
	void findByName(){
		Product product = productRepo.findByName("Pilot Kakuno");
		System.out.println("ID:" + product.getProduct_id());
		System.out.println("NAME: " + product.getName());
		System.out.println("PRICE: " + product.getPrice());
		System.out.println("DESCRIPTION: " + product.getDescription());
		System.out.println("INVENTORY AMOUNT: " + product.getInventory_amount());
		System.out.println("STATUS: " + product.getStatus());
		System.out.println("--------------------------------------------------");
	}

	@Test
	void getProductsByPrice(){
		List<Product> products = productService.getProductsByPrice(300d);

		for (Product product: products) {
			System.out.println("ID:" + product.getProduct_id());
			System.out.println("NAME: " + product.getName());
			System.out.println("PRICE: " + product.getPrice());
			System.out.println("DESCRIPTION: " + product.getDescription());
			System.out.println("INVENTORY AMOUNT: " + product.getInventory_amount());
			System.out.println("STATUS: " + product.getStatus());
			System.out.println("--------------------------------------------------");

		}
	}
}
