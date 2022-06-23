package poo.fatec;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer implements Comparable<Customer>, Serializable{
	
	public String name;
	public String phone;
	public String gender;
	public Date birthDate;
	private int id;
	private CPF cpf;
	private List<RG> rgs;
	public List<Product> products = new ArrayList<>(); 
	public boolean isDeleted;
	
	
	public Customer(String name, String phone, String gender, String birthDate, int id) throws ParseException {
		this.name = name;
		this.phone = phone; 
		this.gender = gender;
		SimpleDateFormat textDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.birthDate = textDateFormat.parse(birthDate);
		this.id = id;
		this.isDeleted = false;
	}
	
	public int getId() {
		return id;
	}
	
	public void update(String name, String phone, String birthDate) throws ParseException {
		this.name = name;
		this.phone = phone; 
		SimpleDateFormat textDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.birthDate = textDateFormat.parse(birthDate);
		System.out.println("Dados atualizados com sucesso");
	}
	
	public long getAge() {
		long birth = birthDate.getTime() / 1000;
		Date today = new Date();
		long now = today.getTime() / 1000;
		return (now - birth ) / 31536000;
	}
	
	private boolean isThisGenderValid(Customer customer) {
		if (customer.gender.toUpperCase() == "M" || customer.gender.toUpperCase() == "F") {
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if (isThisGenderValid(this)){
			if (this.name.length() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteCustomer() {
		this.isDeleted = true;
	}
	
	public void recoverCustomer() {
		this.isDeleted = false;
	}
	
	public void addProduct(int option) {
		this.products.add(Company.products.get(option));
	}
	
	@Override
	public String toString() {
		return "-----------------------\n"
				+ "Cliente ID: " + id + "\nNome: " + name + "\nTelefone: " + phone + "\nIdade: " + getAge()
				+"\n-----------------------";
	}

	@Override
	public int compareTo(Customer other) {
		return this.name.compareToIgnoreCase(other.name);
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public List<RG> getRgs() {
		return rgs;
	}

	public void setRgs(List<RG> rgs) {
		this.rgs = rgs;
	}
}
