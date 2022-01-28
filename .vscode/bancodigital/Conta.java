public class Conta {
    
    private String NumeroDaConta;
    private String TipoDaConta;
    private double Saldo;
    private String Senha;
    
    public String getSenha() {
        return Senha;
    }
    public void setSenha(String password) {
        this.Senha = password;
    }
    public String getNumeroDaConta() {
        return NumeroDaConta;
    }
    public void setNumeroDaConta(String numberaccount) {
        this.NumeroDaConta = numberaccount;
    }
    public String getTipoDaConta() {
        return TipoDaConta;
    }
    public void setTipoDaConta(String accounttype) {
        this.TipoDaConta = accounttype;
    }
    public double getSaldo() {
        return Saldo;
    }
    public void setSaldo(double balance) {
        this.Saldo = balance;
    }

    
}
