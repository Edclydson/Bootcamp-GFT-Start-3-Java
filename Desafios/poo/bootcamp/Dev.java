import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluido = new LinkedHashSet<>();
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Conteudo> getConteudoInscrito() {
        return conteudoInscrito;
    }
    public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
        this.conteudoInscrito = conteudoInscrito;
    }
    public Set<Conteudo> getConteudoConcluido() {
        return conteudoConcluido;
    }
    public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
        this.conteudoConcluido = conteudoConcluido;
    }
    public void inscreverNoBootcamp(bootCamp BootCamp){
        this.conteudoInscrito.addAll(BootCamp.getConteudos());
        BootCamp.getInscricoes().add(this);
    }
    
    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudoInscrito.stream().findFirst();
        if(conteudo.isPresent())
        {
            this.conteudoConcluido.add(conteudo.get());
            this.conteudoInscrito.remove(conteudo.get());
        }else
        {
            System.err.println("Você não está inscrito em nenhum conteúdo!");
        }
    }
    public double calculartotalXp()
    {
        return this.conteudoConcluido.stream().mapToDouble(conteudo -> conteudo.calculaXp()).sum();
    }
    
    public void exibirCursos(){}

    
    
}
