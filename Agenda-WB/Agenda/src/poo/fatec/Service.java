package poo.fatec;
import java.io.*;

public class Service implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	public static void updateState() throws Exception {
		createSite();
		Company.saveState();
	}
	public static void createSite() throws Exception {
		Site registeredSite = View.registerSites();
		Company.createSite(registeredSite);
		Company.saveState();
		System.out.println("Site registrado com sucesso");
		View.pause();
		optionsManager(registeredSite);
	}
	
	public static void selectSite() throws Exception{
		Site selectedSite = View.siteSelection();
		optionsManager(selectedSite);
	}
	
	
	public static void optionsManager(Site selectedSite) throws Exception {
		View.input();
		String option = View.siteOptions();
		switch (option) {
		  case "1":
			  createCustomer(selectedSite);
		  case "2":
			  editCustomer(selectedSite);
		  case "3":
			  deleteCustomer(selectedSite);
		  case "4":
			  listCustomersAlphabetically(selectedSite);
		  case "5":
			  listCustomerByGender(selectedSite);
		  case "6":
			  inputProductToCustomer(selectedSite);
		  case "7":
			  manageReport(selectedSite);
		  case "8":
			  createSite();
		  case "9":
			  endProgram();
		  default:
			  System.out.println("Valor inválido. Você será redirecionado ao menu novamente.");
			  View.pause();
			  optionsManager(selectedSite);
		}
		
	}
	
	public static void createCustomer(Site selectedSite) throws Exception {
		selectedSite.customers.add(View.inputCustomer(selectedSite));
		Company.saveState();
		System.out.println("Cliente criado com sucesso;");
		View.pause();
		optionsManager(selectedSite);
	}
	
	
	public static void editCustomer(Site selectedSite) throws Exception {
		int option = View.editedCustomerMenu(selectedSite);
		System.out.print("Digite o novo nome: ");
		View.input();
		String newName = View.input();
		System.out.print("Digite o novo telefone: ");
		String newPhone = View.input();
		System.out.print("Digite a nova data de nascimento (dd/MM/yyy): ");
		String newBirthDate = View.input();
		selectedSite.customers.get(option).update(newName, newPhone, newBirthDate);
		View.pause();
		optionsManager(selectedSite);
	}
	
	
	public static void deleteCustomer(Site selectedSite) throws Exception {
		int option = View.deleteCustomerMenu(selectedSite);
		selectedSite.deleteCustomer(option);
		Company.saveState();
		System.out.println("Cliente removido com sucesso");
		View.pause();
		optionsManager(selectedSite);
	}
	
	public static void listCustomersAlphabetically(Site selectedSite) throws Exception {
		  System.out.println("Listagem de clientes do site " + selectedSite.name + " em ordem alfabética");
		  selectedSite.listCustomersAlphabetically();
		  View.pause();
		  optionsManager(selectedSite);
	}
	
	public static void listCustomerByGender(Site selectedSite) throws Exception {
		String selectedGender = View.listCustomerByGender(selectedSite);
		System.out.println("Listagem dos clientes do sexo " + selectedGender + "\n");
		for (Customer customer: selectedSite.customers) {
			if (customer.gender.toUpperCase().equals(selectedGender.toUpperCase()) && customer.isDeleted == false) {
				System.out.println(customer);
			}
		}
		View.pause();
		optionsManager(selectedSite);
	}
	
	public static void inputProductToCustomer(Site selectedSite) throws Exception{
		int customerIndex = View.selectCustomer(selectedSite);
		int inputProduct = View.selectProduct(selectedSite);
		selectedSite.customers.get(customerIndex).addProduct(inputProduct);
		System.out.println("Produto/Serviço cadastrado com sucesso");
		View.pause();
		optionsManager(selectedSite);
	}
	
	public static void manageReport(Site selectedSite) throws Exception {
		String option = View.selectReport(selectedSite);
		switch(option) {
			case "1":
				reportAvarageAge(selectedSite);
			case "2":
				reportAvareAgeByGender(selectedSite);
			case "3":
				break;
			case "4":
				break;
			case "5":
				optionsManager(selectedSite);
			default:
				System.out.println("Valor inválido. Digite novamente");
				View.pause();
				manageReport(selectedSite);
		}
	}
	
	public static void reportAvarageAge(Site selectedSite) throws Exception {
		System.out.print("A idade média do publico no site selecionado é ");
		System.out.println(selectedSite.avarageAge());
		System.out.println("--------------------------");
		View.pause();
		manageReport(selectedSite);
	}
	
	public static void reportAvareAgeByGender(Site selectedSite) throws Exception {
		System.out.print("Digite o gênero que deseja extrair a idade média: ");
		String gender = View.input();
		int avarageAge = Company.avarageAgeByGender(gender);
		System.out.print("O valor médio de idade é ");
		System.out.println(avarageAge);
		View.pause();
		manageReport(selectedSite);
	}
	
	public static void endProgram() throws Exception {
		Company.saveState();
		System.out.println("Obrigado por utilizar a agenda.");
		System.exit(0);
	}
}

