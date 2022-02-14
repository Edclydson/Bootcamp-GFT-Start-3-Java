import java.util.ArrayList;
/**
 * @author:EDCLYDSON SOUSA
 * 
 * 
 */
public class Cliente
{
    private String NomeCliente;
    private String CpfCliente;
   
   ArrayList<String> contas = new ArrayList<>();
    
    public String getNomeCliente() {
        return NomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }
    public String getCpfCliente() {
        return CpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        CpfCliente = cpfCliente;
    }
   

    
}