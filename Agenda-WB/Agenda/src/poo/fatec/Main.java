package poo.fatec;

import java.io.*;

public class Main implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		
		System.out.println("-------------------------------------------");
		System.out.println("Seja bem vindo(a) à agenda de clientes WB.");
		System.out.println("-------------------------------------------");
		
		File databaseFile = new File("sitesDatabase.ser");
		if(databaseFile.exists()) { 
		    Company.readState();
		    Service.selectSite();
		}
		else {
			Service.updateState();
		}
	}
	

}
