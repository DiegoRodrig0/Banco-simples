import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    Cliente client = new Cliente();

    Scanner teclado = new Scanner(System.in);
    ArrayList<Cliente> clientes = new ArrayList<>();

    void menu() {
        boolean sair = true;
		do {
			System.out.println("=======================================================");
			System.out.println("            C A I X A   E L E T R O N I C O            ");
			System.out.println("=======================================================");
			System.out.println(" Bem vindo ");
			System.out.println("=======================================================");
            System.out.println("[1] Cadastrar");
			System.out.println("[2] Status");
			System.out.println("[3] Sacar");
			System.out.println("[4] Depositar");
			System.out.println("[5] Transferir");
            System.out.println("[6] Deletar conta");
			System.out.println("[0] Sair");
			System.out.println("=======================================================");
			
			int op = teclado.nextInt();
            teclado.nextLine();
			switch (op) {
			case 1:
				System.out.println("Digite seu nome: ");
                String name = teclado.nextLine();
                System.out.println("Digite uma senha para sua conta: ");
                String senha = teclado.nextLine();
                cadastro(name, senha);
                break;
            case 2:
                System.out.println("Digite o seu nome de cadastro: ");
                String s_nome_conta = teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String s_senha = teclado.nextLine();
                status(s_nome_conta, s_senha); 
                break;
			case 3:
                System.out.println("Digite o número da conta: ");
                int s_num_conta = teclado.nextInt();
                System.out.println("Valor para o saque: ");
				float s_valor = teclado.nextFloat();
                teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String s_senha_conta = teclado.nextLine();
				sacar(s_num_conta, s_valor, s_senha_conta);
				break;
			case 4:
                System.out.println("Digite o número da conta: ");
                int d_valor_conta = teclado.nextInt();
				System.out.print("Valor para depósito: ");
				float d_valor = teclado.nextFloat();
                teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String d_senha = teclado.nextLine();
				depositar(d_valor_conta, d_senha, d_valor);
				break;
			case 5:
                System.out.println("Número da sua conta: ");
                int t_valor_conta = teclado.nextInt();
                System.out.println("Número da conta que deseja transferir: ");
                int t_valor_conta_t = teclado.nextInt();
                System.out.println("Valor da transferência: ");
                float t_valor = teclado.nextFloat();
                teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String t_senha = teclado.nextLine();
                tranferir(t_valor_conta, t_valor_conta_t, t_valor, t_senha);
                break;
            case 6:
                System.out.println("Digite o seu nome de cadastro: ");
                String d_nome_conta = teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String d_senha_conta = teclado.nextLine();
                deletar(d_nome_conta, d_senha_conta); 
                break;
            case 0:
				sair = false;
				break;
			default:
				System.out.println("Operação inválida");	
			}
		} while (sair);
	}

    void cadastro(String nome, String senha) {
        this.clientes.add(new Cliente(this.clientes.size(), nome, senha, 100));
        System.out.println("Conta cadastrada com sucesso.");
    }

    void status(String nome, String senha) {
        boolean y = false;
        for(int i = 0; i < clientes.size(); i++){
            Cliente c = clientes.get(i);
            if(c.getTitular().equals(nome) && c.getSenha().equals(senha)){
                System.out.println("-------------------------------------");
                System.out.println("Número da conta: " + c.getNumeroConta());
                System.out.println("Titular: " + c.getTitular());
                System.out.println("Saldo: " + c.getSaldo());
                System.out.println("-------------------------------------");
                y = true;
                break;        
            }
        }
        if(y == false) {
            System.out.println("Titular não encontrado ou senha incorreta.");
        } 
    }
    
    void sacar(int numConta, float valor, String senha) {
        Cliente t_atual = clientes.get(numConta); 
        if(t_atual.getSenha().equals(senha)){
            if(t_atual.getSaldo() >= valor) {
            t_atual.setSaldo(t_atual.getSaldo() - valor);
            System.out.println("Saque efetuado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Senha Incorreta.");
        }
    }

    void depositar(int numConta, String senha, float valor) {
        Cliente t_atual = clientes.get(numConta);
        if(t_atual.getSenha().equals(senha)){
            t_atual.setSaldo(t_atual.getSaldo() + valor);
            System.out.println("Depósito efetuado com sucesso.");
        } else {
            System.out.println("Número da conta ou senha incorretos.");
        }
    }

    void tranferir(int numConta, int numContaT, float valor, String senha) {
        Cliente t_atual = clientes.get(numConta);
        Cliente transfer = clientes.get(numContaT);
        if(t_atual.getSenha().equals(senha)){
            if(t_atual.getSaldo() >= valor){
            t_atual.setSaldo(t_atual.getSaldo() - valor);
            transfer.setSaldo(transfer.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        }else {
            System.out.println("Senha Incorreta.");
        }
    }

    void deletar(String nome, String senha) {
        boolean y = false;
        for(int i = 0; i < clientes.size(); i++){
            Cliente c = clientes.get(i);
            if(c.getTitular().equals(nome) && c.getSenha().equals(senha)){
                clientes.remove(c);
                System.out.println("Conta deletada com sucesso.");
                y = true;
                break;        
            }
        }
        if(y == false) {
            System.out.println("Titular não encontrado ou senha incorreta.");
        }               
    }
}