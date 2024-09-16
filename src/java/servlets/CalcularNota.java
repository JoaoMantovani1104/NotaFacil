package servlets;

import utils.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcularNota")
public class CalcularNota extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Integer> list_gabarito = new ArrayList<>();
        ArrayList<Integer> list_respostas = new ArrayList<>();

        try {
            Questoes.lerGabarito(list_gabarito, request);
            Questoes.lerRespostas(list_respostas, request);

            ArrayList<ArrayList<Integer>> alternativas_gabarito = new ArrayList<>();
            ArrayList<ArrayList<Integer>> alternativas_respostas = new ArrayList<>();

            alternativas_gabarito = IdentificarAlternativas.identificar(list_gabarito);
            alternativas_respostas = IdentificarAlternativas.identificar(list_respostas);

            double nota_final = Desempenho.calcular(alternativas_gabarito, alternativas_respostas);

            response.setContentType("text/html");
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<script type=\"text/javascript\">");
            response.getWriter().println("alert('Nota final: " + nota_final + "/300');");
            response.getWriter().println("</script>");
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao processar as questões: " + e.getMessage());
        }
    }
}