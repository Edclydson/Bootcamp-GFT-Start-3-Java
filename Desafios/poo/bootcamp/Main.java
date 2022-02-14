import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Mentoria mentoria1 = new Mentoria();
        Curso curso1 = new Curso();
        Curso curso2 = new Curso();

        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Curso Linguagem Java Completo.");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("Curso Spring");
        curso2.setDescricao("Curso Framework Spring.");
        curso2.setCargaHoraria(3);

        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao("Mentoria do curso java");
        mentoria1.setData(LocalDate.now());

        bootCamp BootCamp = new bootCamp();
        BootCamp.setNome("BootCamp Java Developer");
        BootCamp.setDescricao("Descrição BootCamp Java Developer");
        BootCamp.getConteudos().add(curso1);
        BootCamp.getConteudos().add(curso2);
        BootCamp.getConteudos().add(mentoria1);

        Dev devEdclydson = new Dev();
        devEdclydson.setNome("Edclydson");
        System.out.println("--------");
        System.out.println("Conteudos Inscritos: " +devEdclydson.getConteudoInscrito());
        devEdclydson.inscreverNoBootcamp(BootCamp);
        System.out.println("--------");
        System.out.println("Conteudos Inscritos: " +devEdclydson.getConteudoInscrito());
        System.out.println("Conteudos Concluidos: " +devEdclydson.getConteudoConcluido());
        devEdclydson.progredir();
        System.out.println("\n--------");
        System.out.println("Conteudos Inscritos: " +devEdclydson.getConteudoInscrito());
        System.out.println("Conteudos Concluidos: " +devEdclydson.getConteudoConcluido());
        System.out.println("XP: " +devEdclydson.calculartotalXp());

    }
    
}
