package Model;

public class Oficial {
    private double salario;
    
    public static float aumCateg=3;
    
    public Oficial(double salario){
        this.salario = salario;
    }
    
    public double calculaDissidio(double aumento){
        return this.salario+(this.salario*(aumento+aumCateg)/100);
    }
}
