public class Curso extends Conteudo{
   
    private int cargaHoraria;
    
    @Override
    public double calculaXp(){
        return xp_padrao * cargaHoraria;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }    
    
}
