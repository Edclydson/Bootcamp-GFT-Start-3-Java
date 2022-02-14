import java.time.LocalDate;

public class Mentoria extends Conteudo{
   
    private LocalDate data;
    
    @Override
    public double calculaXp(){
        return xp_padrao + 20d;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
