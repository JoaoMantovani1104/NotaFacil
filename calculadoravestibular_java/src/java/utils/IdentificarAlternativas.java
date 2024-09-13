package utils;

import java.util.ArrayList;

public class IdentificarAlternativas {
    public static ArrayList<ArrayList<Integer>> identificar(ArrayList<Integer> lista_questoes) {
        ArrayList<ArrayList<Integer>> alternativas_questoes = new ArrayList<>();

        for (Integer valor : lista_questoes) {
            ArrayList<Integer> alternativas = new ArrayList<>();
            int alternativa = 1;
            
            while (valor > 0) {
                if (valor % 2 == 1.0) {
                    alternativas.add(alternativa);
                }
                valor /= 2;
                alternativa *= 2;
            }
            alternativas_questoes.add(alternativas);
        }

        return alternativas_questoes;
    }
}
