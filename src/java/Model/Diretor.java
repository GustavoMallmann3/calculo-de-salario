package Model;

public class Diretor {
    private double salario;
    
    public static float aumCateg=5;
    
    public Diretor(double salario){
        this.salario = salario;
    }
    
    public double calculaDissidio(double aumento){
        return this.salario+(this.salario*(aumento+aumCateg)/100);
    }    
}
