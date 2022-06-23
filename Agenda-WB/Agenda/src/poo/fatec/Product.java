package poo.fatec;
import java.io.*;

public class Product implements Serializable {
	
	String name;
	String gender;
	
	public Product(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public int timesUsed() {
		int cont = 0;
		for (Site site: Company.sites) {
			cont += site.howMuchThisProductIsUsed(this.name);
		}
		return cont;
	}
	
	@Override
	public String toString() {
		return name + " - Sexo: " + gender + " ID: ";
	}
	
}
