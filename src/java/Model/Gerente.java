package Model;

public class Gerente {
    private double salario;
    
    public static float aumCateg=4;
    
    public Gerente(double salario){
        this.salario = salario;
    }
    
    public double calculaDissidio(double aumento){
        return this.salario+(this.salario*(aumento+aumCateg)/100);
    }
}
