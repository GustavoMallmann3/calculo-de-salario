package Model;

public class Assistente {
    private double salario;
    
    public static float aumCateg=2;
    
    public Assistente(double salario){
        this.salario = salario;
    }
    
    public double calculaDissidio(double aumento){
        return this.salario+(this.salario*(aumento+aumCateg)/100);
    }
}
