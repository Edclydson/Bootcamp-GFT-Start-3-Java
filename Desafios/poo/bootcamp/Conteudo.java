public abstract class Conteudo {
    protected static final double xp_padrao = 10d;

    private String titulo;
    private String descricao;

    public abstract double calculaXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Conteudo [descricao=" + descricao + ", titulo=" + titulo + "]";
    }

    
}
