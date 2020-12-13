package br.com.spassu.cliente;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
	private Scanner l;
	private boolean execute;
	private List<Dados> dados;
	private List<Compras> compras;
	private int idCliente;
	
    public static void main( String[] args )
    {
    	new Main();
    }
    
    private Main() {
		l = new Scanner(System.in);
		execute = true;
		dados = new ArrayList<Dados>();

		System.out.println("BEM VINDO AO CADASTRO DE CLIENTES");

		while (execute) {
			String opcao = menu();

			if (opcao.equalsIgnoreCase("1")) {
				listarClientes();
			} else if (opcao.equalsIgnoreCase("2")) {
				incluirClientes();
			} else if (opcao.equalsIgnoreCase("3")) {
				alterarCliente();
			} else if (opcao.equalsIgnoreCase("4")) {
				excluirCliente();
			} else if (opcao.equalsIgnoreCase("5")) {
				consultarCliente();
			} else if (opcao.equalsIgnoreCase("6")) {
				incluirCompra();
			} else if (opcao.equalsIgnoreCase("7")) {
				listarCompras();
			} else if (opcao.equalsIgnoreCase("8")) {
				listarClientesEspeciais();
			} else if (opcao.equalsIgnoreCase("9")) {
				execute = false;
			} else {
				System.out.println("\nOpção Inválida !!! \n");
			}
		}
	}

	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Listar clientes");
		System.out.println("2 - Novo cliente");
		System.out.println("3 - Alterar cliente");
		System.out.println("4 - Excluir cliente");
		System.out.println("5 - Consulta cliente");
		System.out.println("6 - Incluir compra");
		System.out.println("7 - Listar compras");
		System.out.println("8 - Listar cliente especial");
		System.out.println("9 - Sair");
		return l.nextLine();
	}

	//metodo para incluir clientes
	private void incluirClientes() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("Cadastro de Cliente");
			Dados d = new Dados();
			d.setId(Integer.parseInt(System.console().readLine()));
			d.setNome(textInput("Nome: "));
			d.setCidade(textInput("Cidade: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cliente cadastrado !!!");
				dados.add(d);
			} else if (cadastrar.equalsIgnoreCase("n")){
				System.out.println("Cliente não cadastrado !!!");
			} else {
				System.out.println("\nOpção inválida, cliente não cadastrado!!! \n");
			}

			String continua = textInput("Continuar cadastrando (S/N) ?");
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("s")){
				// se for s sai do if e volta para o inicio do while
			} else {
				System.out.println("\nOpção inválida, saindo do cadastro de cliente !!! \n");
				cadastrando = false;
			}
		}
	}

	//metodo para listar clientes
	private void listarClientes() {
		if (dados.size() == 0) {
			System.out.println("\nNão existem clientes cadastrados !!!\n");
		} else {
			System.out.println("\nLista de Clientes\n");
			for (int i = 0; i < dados.size(); i++) {
				Dados d = dados.get(i);
				System.out.println("Cadastro número: " + i);
				System.out.println("\tId: " + d.getId());
				System.out.println("\tNome: " + d.getNome());
				System.out.println("\tCidade: " + d.getCidade() + "\n");
			}
			System.out.println("\nFim da lista\n");
		}
	}
	
	//metodo para alterar cliente
	private void alterarCliente() {
		if (dados.size() == 0) {
			System.out.println("\nNão existem clientes cadastrados !!!\n");
		} else {
			System.out.println("\nInforme o Id do cliente que será alterado:\n");
			idCliente = Integer.parseInt(System.console().readLine());
			for (int i = 0; i < dados.size(); i++) {
				 Dados d = dados.get(i);
				 if(d.getId() == idCliente) {
					 d.setNome(textInput("Nome: "));
					 d.setCidade(textInput("Cidade: "));
				 }
			}
			System.out.println("\nCliente alterado com sucesso!!!\n");
		}	
	}
	
	//metodo para consultar cliente
	private void consultarCliente() {
		if (dados.size() == 0) {
			System.out.println("\nNão existem clientes cadastrados !!!\n");
		} else {
			System.out.println("\nInforme o Id do cliente para consulta:\n");
			idCliente = Integer.parseInt(System.console().readLine());
			for (int i = 0; i < dados.size(); i++) {
				 Dados d = dados.get(i);
				 if(d.getId() == idCliente) {
					 System.out.println("\tId: " + d.getId());
					 System.out.println("\tNome: " + d.getNome());
					 System.out.println("\tCidade: " + d.getCidade() + "\n");
				 }
			}	 
		}
	}
	
	//metodo para excluir cliente
	private void excluirCliente() {
		if (dados.size() == 0) {
			System.out.println("\nNão existem clientes cadastrados !!!\n");
		} else {
			System.out.println("\nInforme o Id do cliente para excluir:\n");
			idCliente = Integer.parseInt(System.console().readLine());
			for (int i = 0; i < dados.size(); i++) {
				 Dados d = dados.get(i);
				 if(d.getId() == idCliente) {
					dados.remove(i); 
				 }
			 }
		}	
	}
	
	//metodo para incluir comprass
	private void incluirCompra() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("Inclusão da compra");
			Compras c = new Compras();
			c.setId(Integer.parseInt(System.console().readLine()));
			c.setDataCompra(textInput("Data Compra: "));
			c.setValorCompra(textInput("Valor Compra: "));

			String cadastrar = textInput("Adicionar compra (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cliente cadastrado !!!");
				compras.add(c);
			} else if (cadastrar.equalsIgnoreCase("n")){
				System.out.println("Compra não cadastrado !!!");
			} else {
				System.out.println("\nOpção inválida, compra não cadastrado!!! \n");
			}

			String continua = textInput("Continuar cadastrando (S/N) ?");
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("s")){
				// se for s sai do if e volta para o inicio do while
			} else {
				System.out.println("\nOpção inválida, saindo do cadastro de compras !!! \n");
				cadastrando = false;
			}
		}
	}
	
	//metodo para listar compras
	private void listarCompras() {
			if (compras.size() == 0) {
				System.out.println("\nNão existem compras cadastradas !!!\n");
			} else {
				System.out.println("\nLista de Compras\n");
				for (int i = 0; i < compras.size(); i++) {
					Compras c = compras.get(i);
					System.out.println("Cadastro número: " + i);
					System.out.println("\tId: " + c.getId());
					System.out.println("\tData Compra: " + c.getDataCompra());
					System.out.println("\tValor Compra: " + c.getValorCompra() + "\n");
				}
				System.out.println("\nFim da lista\n");
			}
	}
	
	//metodo para listar clientes especiais
	private void listarClientesEspeciais() {
		if (compras.size() == 0) {
			System.out.println("\nNão existem compras cadastradas !!!\n");
		} else {
			System.out.println("\nLista de Clientes Especiais\n");
			for (int i = 0; i < compras.size(); i++) {
				Compras c = compras.get(i);
				if(c.getValorCompra() > 1.000) {
					System.out.println("Cadastro número: " + i);
					System.out.println("\tId: " + c.getId());
					System.out.println("\tValor Compra: " + c.getValorCompra() + "\n");
				}
			}
			System.out.println("\nFim da lista\n");
		}
}

	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
	
}
