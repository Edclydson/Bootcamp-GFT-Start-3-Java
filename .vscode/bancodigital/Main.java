import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
          
        Operacao.cadastrarcliente("Edclydson","6548484898", "1234", "Conta Corrente", "101933", 10000);
        String menubanco;
        //System.out.println(Operacao.informacoesClientes.get(0));//Operacao.banco.values().toString()
        while(true)
        {
            try
            {
                menubanco = JOptionPane.showInputDialog(null, "Banco GFT\n1-Cadastrar-se\n2-Acessar Conta\n3-Sair");
                switch(menubanco)
                {
                    case "1":{
                        Operacao.formulario();
                        System.out.println(Operacao.banco.values());
                        break;
                    }
                    case "2":{
                        String numconta = JOptionPane.showInputDialog(null, "Informe o numero da sua conta:");
                        String senha = JOptionPane.showInputDialog(null, "Informe a senha:");
                        Operacao.acessaconta(numconta,senha);
                        break;
                    }
                    case "3":{System.exit(0);}
                    default:{break;}
                }
            }catch(NullPointerException e){System.out.println("Programa fechou!"); System.exit(0);}
        }
    }
}
