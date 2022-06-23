package poo.fatec;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Company implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static List<Site> sites = new ArrayList<>();
	public static List<Product> products = new ArrayList<>();
	
	public static void populateProducts() {
		products.clear();
		products.add(new Product("Manicure", "F"));
		products.add(new Product("Pedicure", "F"));
		products.add(new Product("Design de sobrancelhas", "F"));
		products.add(new Product("Corte de cabelo", "F"));
		products.add(new Product("Pintura de cabelo", "F"));
		products.add(new Product("Remoção de rugas", "F"));
		products.add(new Product("Remoção de manchas de pele", "F"));
		products.add(new Product("Aplicação de botox", "F"));
		products.add(new Product("Tratamento para emagrecimento", "F"));
		products.add(new Product("Redução de medidas", "F"));
		products.add(new Product("Design de sobrancelhas", "F"));
		products.add(new Product("Maquiagem para datas comemorativas", "F"));
		products.add(new Product("Dia da noiva", "F"));
		products.add(new Product("Depilaçção", "F"));
		products.add(new Product("Descoloração de pelos", "F"));
		products.add(new Product("Unhas de gel, fibra, porcelana", "F"));
		products.add(new Product("Barbearia", "M"));
		products.add(new Product("Corte de cabelo", "M"));
		products.add(new Product("Modelagem de barba", "M"));
		products.add(new Product("Tratamento contra calvice", "M"));
	}
	
	public static void listProducts() {
		populateProducts();
		int index = 0;
		for (Product product: products) {
			System.out.print(product);
			System.out.println(index);
			index += 1;
		}
	}
	
	
	public static void createSite(Site insertedSite) {
		sites.add(insertedSite);
	}
	
	
	public static boolean thereAreSitesRegistered() {
		if (sites.size() == 0) {
			return false;
		}
		return true;
	}
	
	
	public static void listSites() {
		for (Site site: sites) {
			System.out.println(site);
		}
	}
	
	
	public static int avarageAgeByGender(String gender) {
		int totalAge = 0;
		int totalCustomers = 0;
		for (Site site: sites) {
			for (Customer customer: site.customers) {
				if (customer.gender.toUpperCase() == gender.toUpperCase()) {
					totalAge += customer.getAge();
					totalCustomers = totalCustomers + 1;
				}
			}
		}
		if (totalCustomers == 0) {
			return 0;
		}
		return totalAge / totalCustomers;		
	}
	
	public static String mostUsedProduct() {
		return "Não conseguimos finalizar a lógica deste relatório a tempo. Sentimos muito pelo inconvenient :\\";
	}
	
	
	public static void saveState() throws Exception {
		FileOutputStream streamer = new FileOutputStream("sitesDatabase.ser");
		ObjectOutputStream writer = new ObjectOutputStream(streamer);
		writer.writeObject(sites);
		writer.close();
	}
	
	public static void readState() throws IOException, ClassNotFoundException {
		FileInputStream streamer = new FileInputStream("sitesDatabase.ser");
		ObjectInputStream reader = new ObjectInputStream(streamer);
		sites = (List<Site>) reader.readObject();
		reader.close();
		System.out.println("Sites lidos com sucesso!");
	}
	
}

