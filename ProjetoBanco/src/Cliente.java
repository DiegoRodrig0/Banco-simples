public class Cliente {
    private int numeroConta;
    private String titular;
    private String senha;
    private float saldo;

    public Cliente(int numeroConta, String titular, String senha, float saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    }

    Cliente (){
    }
    
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}