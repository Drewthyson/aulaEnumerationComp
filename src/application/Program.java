package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Client Data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int howManyItems = sc.nextInt();
		
		for(int i=0; i<howManyItems; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String itemName = sc.nextLine();
			System.out.print("Product price: ");
			double itemPrice = sc.nextDouble();
			
			Product product = new Product(itemName, itemPrice);
			
			System.out.print("Quantity: ");
			int itemQuantity = sc.nextInt();
			
			OrderItem item = new OrderItem(itemQuantity, itemPrice, product);
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}
}
