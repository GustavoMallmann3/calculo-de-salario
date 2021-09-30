<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCKTYPE html>
<html>
    <head>
        <title>Cálculo de Percentual</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css"/>
    </head>
    <body style="background-color: #d3d3d4">
        <div class="container">
        <form method="get" action="CalculaSalario">
            <div class="text-center">
                <h2>Cálculo do dissímo salarial</h2>
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" required class="form-control"/>
                
                <label for="salario">Salário atual</label>
                <input type="number" step="0.01" id="salario" name="salario" required class="form-control"/>
                
                <label for="cargo">Cargo</label>
                <select id="cargo" name="cargo" required class="form-control">
                    <option value="">Selecione</option>
                    <option value="Assistente">Assistente</option>
                    <option value="Oficial">Oficial</option>
                    <option value="Gerente">Gerente</option>
                    <option value="Diretor">Diretor</option>
                </select>
                
                <label>Turnos:</label>
                    <input type="checkbox" id="manha" name="turnos" value="Manhã"/>Manhã
                    <input type="checkbox" id="tarde" name="turnos" value="Tarde"/>Tarde
                    <input type="checkbox" id="noite" name="turnos" value="NOite"/>Noite
                <br/><br/>
                <label>Tipo de Regime:</label>
                <input type="radio" id="terceirizado" name="regime" value="Terceirizado"/><label>Terceirizado</label>
                    <input type="radio" id="autonomo" name="regime" value="Autônomo"/><label>Autônomo</label>
                    <input type="radio" id="contratado" name="regime" value="Contratado"/><label>Contratado</label>
                <br/><br/>
                
                <input type="hidden" id="aumentoFinal" name="aumentoFinal" value="0"/>
                
                <input type="submit" value="Calcular"/>
                <input type="reset" value="Limpar"/>
            </div>
        </form>
        </div>
        <script type="text/javascript" src="JS/bootstrap.min.js"/>
        
    </body>
</html>