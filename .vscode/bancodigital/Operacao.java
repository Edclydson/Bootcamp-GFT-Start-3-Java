import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

import java.util.Random;

///ORDEM QUE INFORMAÇOES DO CLIENTE SAO GUARDADAS {NOME,CPF,TIPODACONTA,NUMERODACONTA,SALDO,SENHA}

class Operacao
{
    static Random rand = new Random();
    static Cliente clienteNovo = new Cliente();
    static Conta contaNova = new Conta();
    static Map<String,List> banco  = new HashMap<>();
    static ArrayList<List> consultaCliente = new ArrayList<>();
    static List<String> informacoesClientes = new ArrayList<>();
    
    public static void cadastrarcliente(String nome,String cpf,String senha,String tipoconta,String numeroconta,double saldo)
    {        
        contaNova.setTipoDaConta(tipoconta);
        contaNova.setNumeroDaConta(numeroconta);
        contaNova.setSaldo(saldo);
        contaNova.setSenha(senha);
        clienteNovo.setNomeCliente(nome);
        clienteNovo.setCpfCliente(cpf);
        informacoesClientes.add(clienteNovo.getNomeCliente());
        informacoesClientes.add(clienteNovo.getCpfCliente());
        informacoesClientes.add(contaNova.getTipoDaConta());
        informacoesClientes.add(contaNova.getNumeroDaConta());
        informacoesClientes.add(String.valueOf(contaNova.getSaldo()));
        informacoesClientes.add(contaNova.getSenha());
       
        banco.put(numeroconta, informacoesClientes.stream().toList());
        System.out.println("Bem vindo ao Banco GFT,"+nome+"\n");
        System.out.println("O numero da sua conta é: "+numeroconta+" guarde bem esse numero!");
        System.out.println("Sua conta foi criada! Agora você pode acessa-la :)\n");
        informacoesClientes.clear();
    }

    public static void formulario()
    {
        String nomeinformado,cpfinformado,tipocontainformado,senhainformada = "";
        String numerocontainformado = "";
        double saldoinformado = 0;
        nomeinformado = JOptionPane.showInputDialog(null, "Nome Completo:");
        cpfinformado = JOptionPane.showInputDialog(null, "CPF: (somente números)");
        tipocontainformado = JOptionPane.showInputDialog(null, "Tipo de Conta: 1-Conta Corrente  2-Conta Poupança");
        if(tipocontainformado.equals("1")){
            tipocontainformado = "Conta Corrente";
             numerocontainformado = String.valueOf(rand.nextInt(100000,999999));
              saldoinformado = Double.parseDouble(JOptionPane.showInputDialog(null, "Depósito Inicial: R$").replace(",", "."));}
        else if(tipocontainformado.equals("2")){
            tipocontainformado = "Conta Poupança";
             numerocontainformado = String.valueOf(rand.nextInt(10000000,99999999));
              saldoinformado = 0;}
        else{JOptionPane.showMessageDialog(null, "Escolha uma das duas opções!");}
        senhainformada = JOptionPane.showInputDialog(null, "Defina uma senha:");
        cadastrarcliente(nomeinformado, cpfinformado, senhainformada, tipocontainformado, numerocontainformado, saldoinformado);
    }

    public static void acessaconta(String acessarnumeroconta, String acessarsenha)
    {
    try
    {
        if(banco.containsKey(acessarnumeroconta) == true)
        {
            consultaCliente.add(banco.get(acessarnumeroconta));
            if(consultaCliente.get(0).get(3).equals(acessarnumeroconta) && consultaCliente.get(0).get(5).equals(acessarsenha))
            {
                System.out.println("Cliente possui cadastro\n");
                menuoperacao(String.valueOf(consultaCliente.get(0).get(0)),String.valueOf(consultaCliente.get(0).get(3)));
                consultaCliente.clear();
            }else{System.out.println("Cliente não cadastrado\n");}
        }else{System.out.println("Cliente não cadastrado\n");}
        consultaCliente.clear();
    }catch(ArrayIndexOutOfBoundsException e){}
}

    public static void menuoperacao(String nomeCliente,String numerocontacliente)
    {
        String menuoperacao = JOptionPane.showInputDialog(null, "Banco GFT\n Olá,"+nomeCliente+"!\n O que deseja fazer?\n1-Sacar\n2-Depositar\n3-Transferir\n4-Extrato\n5-Sair");
        switch(menuoperacao)
        {
            case "1":{sacar(numerocontacliente,Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do saque: R$")));break;}
            case "2":{depositar(numerocontacliente,Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do deposito: R$")));break;}
            case "3":{transferir(numerocontacliente,JOptionPane.showInputDialog(null, "Digite o numero da conta de destino:"),Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da transferencia: R$")));break;}
            case "4":{extrato();break;}
            case "5":{System.out.println("Sessão finalizada\n"); break;}
            default:{}
        }
            consultaCliente.clear();   
    }

    public static void sacar(String numeroconta,double valordosaque)
    {
        double saldocontacliente = Double.parseDouble(String.valueOf(consultaCliente.get(0).get(4)));
        if(valordosaque<=saldocontacliente){
            System.out.println("Transação autorizada\n");
            informacoesClientes.clear();
            informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(0)));
            informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(1)));
            informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(2)));
            informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(3)));
            informacoesClientes.add(String.valueOf(saldocontacliente-valordosaque));
            informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(5)));
            consultaCliente.clear();
            consultaCliente.add(informacoesClientes.stream().toList());
            banco.replace(numeroconta, banco.get(numeroconta), consultaCliente);}
        else{System.out.println("Saldo insuficiente\n");}
    }

    public static void depositar(String numeroconta,double valordodeposito)
    {
        double saldocontacliente = Double.parseDouble(String.valueOf(consultaCliente.get(0).get(4)));
        informacoesClientes.clear();
        informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(0)));
        informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(1)));
        informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(2)));
        informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(3)));
        informacoesClientes.add(String.valueOf(saldocontacliente+valordodeposito));
        informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(5)));
        consultaCliente.clear();
        consultaCliente.add(informacoesClientes.stream().toList());
        banco.replace(numeroconta, banco.get(numeroconta), consultaCliente);
        System.out.println("Transação realizada com sucesso\n");
    }

    public static void transferir(String numerocontaorigem,String numerocontadestino,double valordatransferencia)
    {
    if(numerocontaorigem.equals(numerocontadestino))
    {
        System.out.println("Você não pode transferir para você mesmo!\n");
    }
    else{
        double saldocontaclienteorigem = Double.parseDouble(String.valueOf(consultaCliente.get(0).get(4)));
        if(saldocontaclienteorigem==0 || saldocontaclienteorigem<valordatransferencia){System.out.println("Saldo insuficiente\n");}
        else
        {
                //OPERACAO NA CONTA ORIGEM
                informacoesClientes.clear();
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(0)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(1)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(2)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(3)));
                informacoesClientes.add(String.valueOf(saldocontaclienteorigem-valordatransferencia));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(5)));
                consultaCliente.clear();
                consultaCliente.add(informacoesClientes.stream().toList());
                banco.replace(numerocontaorigem, banco.get(numerocontaorigem), consultaCliente);
                //OPERACAO NA CONTA DESTINO
                informacoesClientes.clear();
                consultaCliente.clear();
                consultaCliente.add(banco.get(numerocontadestino));
                double saldocontaclientedestino = Double.parseDouble(String.valueOf(consultaCliente.get(0).get(4)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(0)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(1)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(2)));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(3)));
                informacoesClientes.add(String.valueOf(saldocontaclientedestino+valordatransferencia));
                informacoesClientes.add(String.valueOf(consultaCliente.get(0).get(5)));
                consultaCliente.clear();
                consultaCliente.add(informacoesClientes.stream().toList());
                banco.replace(numerocontadestino, banco.get(numerocontadestino),consultaCliente);
                System.out.println("Transação realizada com sucesso\n");
            }
        }
    }

    public static void extrato()
    {
        System.out.println("NOME: "+consultaCliente.get(0).get(0)+"\n");
        System.out.println("TIPO DA CONTA: "+consultaCliente.get(0).get(2)+"\n");
        System.out.println("NUMERO DA CONTA: "+consultaCliente.get(0).get(3)+"\n");
        System.out.println("SALDO: R$"+consultaCliente.get(0).get(4)+"\n");

    }
}