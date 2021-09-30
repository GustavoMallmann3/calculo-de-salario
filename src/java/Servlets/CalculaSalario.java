package Servlets;

import Model.Assistente;
import Model.Diretor;
import Model.Gerente;
import Model.Oficial;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculaSalario extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeRecebido = request.getParameter("nome");
        request.setAttribute("nome", nomeRecebido);
        
        double salarioRecebido = Double.parseDouble(request.getParameter("salario"));
        request.setAttribute("salario", salarioRecebido);
        
        double aumento = Double.parseDouble(request.getParameter("aumentoFinal"));
        
        String[] turnosRecebidos = request.getParameterValues("turnos");
        
        if(!Validade.valida(turnosRecebidos)){
            try(PrintWriter out = response.getWriter()){
                out.print(
                    "<script type='text/javascript'>"+
                        "alert('precisa marcar no mínimo um turno!');"+
                        "history.back(-1);"+
                        "</script>"
                );
            }
        }
        
        int contTurnos = 0;

        for(String turno:turnosRecebidos){
            request.setAttribute("turnos[]", turno);
            contTurnos++;
        }
        
        request.setAttribute("contTurnos", contTurnos);
        
        switch(contTurnos){
            case 1:aumento +=3;
            break;
            case 2:aumento +=6;
            break;
            case 3:aumento +=9;
            break;
        }
        
        String regimeRecebido=request.getParameter("regime");
        request.setAttribute("regime", regimeRecebido);
        
        switch(regimeRecebido){
            case "Terceirizado":aumento +=0.5;
            break;
            case "Autônomo":aumento +=0.75;
            break;
            case "Contratado":aumento +=1;
            break;
        }
        
        String cargoRecebido=request.getParameter("cargo");
        request.setAttribute("cargo", cargoRecebido);
        
        switch(cargoRecebido){
            case "Assistente":
                Assistente assistente = new Assistente(salarioRecebido);
                request.setAttribute("novoSalario", assistente.calculaDissidio(aumento));
                request.setAttribute("aumentoFinal", Assistente.aumCateg+aumento);
            break;
            case "Oficial":
                Oficial oficial = new Oficial(salarioRecebido);
                request.setAttribute("novoSalario", oficial.calculaDissidio(aumento));
                request.setAttribute("aumentoFinal", Oficial.aumCateg+aumento);
            break;
            case "Gerente":
                Gerente Gerente = new Gerente(salarioRecebido);
                request.setAttribute("novoSalario", Gerente.calculaDissidio(aumento));
                request.setAttribute("aumentoFinal", Gerente.aumCateg+aumento);
            break;
            case "Diretor":
                Diretor diretor = new Diretor(salarioRecebido);
                request.setAttribute("novoSalario", diretor.calculaDissidio(aumento));
                request.setAttribute("aumentoFinal", Diretor.aumCateg+aumento);
            break;
        }
        
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
