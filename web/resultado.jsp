<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cálculo de Percentual</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, intial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css"/>
    </head>
    <body style="background-color: #d3d3d4">
        <div class="container">
        <form method="post" action="">
            <div>
                <h2>Resultado do cálculo</h2>
                nome:
                <b><%=request.getAttribute("nome")%></b>
                <br/>
                Salário atual:
                <b><%=request.getAttribute("salario")%></b>
                <br/>
                Cargo:
                <b><%=request.getAttribute("cargo")%></b>
                <br/>
                Turno(s):[<%=request.getAttribute("contTurnos")%>]
                <% for(String cadaTurno : request.getParameterValues("turnos")){
                    out.println("<b>"+cadaTurno+"</b>/");
                    }
                %>
                <br/>
                Regime:
                <b><%=request.getAttribute("regime")%></b>
                <br/>
                Percentual de aumento:
                <b><%=request.getAttribute("aumentoFinal")%></b>
                <br/>
                Valor do salário atualizado:
                <b><%=request.getAttribute("novoSalario")%></b>
                <br/>
                <input type="button" value="Novo cálculo" onclick="history.back(-1);"/>
            </div>
        </form>
        </div>
        <script type="text/javascript" src="JS/bootstrap.min.js"/>
    </body>
</html>
