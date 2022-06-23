package poo.fatec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Site implements Serializable{
	String name;
	String address;
	int id;
	
	List<Customer> customers = new ArrayList<>();
	List<Customer> customersBackup = new ArrayList<>();
	
	public Site(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void listCustomersAlphabetically() {
		customersBackup.clear();
		customersBackup.addAll(customers);
		Collections.sort(customersBackup);
		for (Customer customer: customersBackup) {
			if (customer.isDeleted == false) {
				System.out.println(customer);
			}
		}
	}
	
	public void addCustomer(Customer createdCustomer) {
		customers.add(createdCustomer);
	}
	
	public void deleteCustomer(int index) {
		this.customers.get(index).isDeleted = true;
	}
	
	public int avarageAge() {
		int totalAge = 0;
		for (Customer customer: customers) {
			totalAge += customer.getAge();
		}
		return totalAge / customers.size();
	}
	
	public int howMuchThisProductIsUsed(String productName) {
		int cont = 0;
		for (Customer customer: customers) {
			for (Product product: customer.products) {
				if (product.name == productName) {
					cont += 1;
				}
			}
		}
		return cont;
	}

	@Override
	public String toString() {
		return "Site: " + name + "\nID: " + id + "\n";
	}
	
	public boolean equals(Site other) {
		return this.id == other.id;
	}
	
}
