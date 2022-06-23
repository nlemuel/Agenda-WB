package poo.fatec;

import java.text.ParseException;
import java.util.Scanner;

public class View {
	
	static Scanner reader = new Scanner(System.in);
	
	public static Site registerSites()  {
		System.out.print("Digite o nome da unidade: ");
		String siteName = input();
		return new Site(siteName, Company.sites.size());
	}
	
	
	public static Site siteSelection() {
		Company.sites.forEach(site -> System.out.println(site));
		System.out.print("Selecione o site pelo ID: ");
		int option = reader.nextInt();
		return Company.sites.get(option);
	}

	
	public static String siteOptions() {
		System.out.println("\n*********************");
		System.out.println("Selecione a opção desejada:");
		System.out.println("1. Cadastrar cliente");
		System.out.println("2. Editar cliente");
		System.out.println("3. Excluir cliente");
		System.out.println("4. Listar todos os clientes");
		System.out.println("5. Listar clientes de apenas um gênero");
		System.out.println("6. Cadastrar serviço para cliente");
		System.out.println("7. Relatórios (outras listagens)");
		System.out.println("8. Criar um novo site/loja");
		System.out.println("9. Sair da agenda");
		System.out.println("*********************\n");
		System.out.print("Selecione a sua opção: ");
		
		String option = input();
		return option;
	}
	

	public static int menuAfterOperation() {
		System.out.println("Deseja realizar outra ação?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.print("Selecione sua opção: ");
		int option = inputInt();
		return option;
	}
	

	public static Customer inputCustomer(Site selectedSite) throws Exception {
		System.out.print("Insira o nome do cliente: ");
		String nome = input();
		System.out.print("Insira o telefone do cliente: ");
		String telefone = input();
		System.out.print("Insira o sexo do cliente (M/F): ");
		String sexo = input();
		System.out.print("Digite a data de nascimento do cliente (dd/MM/yyyy): ");
		String birthDate = input();

		try {
			return new Customer(nome, telefone, sexo, birthDate, selectedSite.customers.size());
		} catch (ParseException e) {
			System.out.println("Dados inseridos no formato incorreto. Digite novamente");
			Service.createCustomer(selectedSite);
		}
		return null;
	}
	
	public static int editedCustomerMenu(Site selectedSite) {
		System.out.println("Selecione o cliente que deseja editar, de acordo com o ID: ");
		selectedSite.listCustomersAlphabetically();
		System.out.print("ID selecionado: ");
		int option = inputInt();
		return option;
	}
	
	public static int deleteCustomerMenu(Site selectedSite) {
		System.out.println("Selecione o cliente que deseja remover, de acordo com o ID");
		selectedSite.listCustomersAlphabetically();
		System.out.print("ID selecionado: ");
		int option = inputInt();
		return option;
	}
	
	public static String listCustomerByGender(Site selectedSite) {
		System.out.print("Digite o gênero que quer listar(M/F): ");
		String genero = input().toUpperCase();
		return genero;
	}
	
	public static int selectCustomer(Site selectedSite) {
		System.out.println("Selecione o cliente que deseja inserir o serviço ou produto, por ID");
		selectedSite.listCustomersAlphabetically();
		System.out.print("Digite o ID do cliente: ");	
		int option = inputInt();
		return option;
	}
	
	public static int selectProduct(Site selectedSite) {
		System.out.println("Escolha o produto, de acordo com o ID");
		Company.listProducts();
		System.out.print("Digite o ID do produto a ser adicionado ao cliente: ");
		int option = inputInt();
		return option;
	}
	
	public static String selectReport(Site selectedSite){
		System.out.println("\n*********************");
		System.out.println("Selecione qual relatório você deseja extrair");
		System.out.println("1. Idade média do público por site.");
		System.out.println("2. Idade média do público geral.");
		System.out.println("3. Serviço mais procurado.");
		System.out.println("4. Serviço mais procurado por gênero.");
		System.out.println("5. Voltar para o menu principal.");
		System.out.println("*********************\n");
		String option = input();
		return option;
	}
		
	public synchronized static void pause() {
		reader.reset();
		System.out.println("Tecle ENTER para continuar...");
		reader.nextLine();
	}
	
	public synchronized static String input(){
		String input = reader.nextLine();
		reader.reset();
		return input;
	}
	
	public synchronized static int inputInt(){
		int input = reader.nextInt();
		reader.reset();
		return input;
	}
}

