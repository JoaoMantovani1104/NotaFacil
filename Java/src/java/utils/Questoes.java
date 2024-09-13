package utils;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Questoes {
    
    public static ArrayList<Integer> lerGabarito(ArrayList<Integer> lista_questoes, HttpServletRequest request) {
        for (int i = 1; i <= 50; i++) {
            String param = request.getParameter("gabarito" + i);
            //System.out.println("GABARITO da questao" + i + ": " + param);
            try {
                if (param != null && !param.trim().isEmpty()) {
                    lista_questoes.add(Integer.valueOf(param));
                } else {
                    lista_questoes.add(0);
                }
            } catch (NumberFormatException e) {
                lista_questoes.add(0);
            }
        }
        System.out.println("Lista dos valores do gabarito: " + lista_questoes);
        return lista_questoes;
    }
    
    public static ArrayList<Integer> lerRespostas(ArrayList<Integer> lista_questoes, HttpServletRequest request) {
        for (int i = 1; i <= 50; i++) {
            String param = request.getParameter("resposta" + i);
            //System.out.println("RESPOSTA da questao" + i + ": " + param);
            try {
                if (param != null && !param.trim().isEmpty()) {
                    lista_questoes.add(Integer.valueOf(param));
                } else {
                    lista_questoes.add(0);
                }
            } catch (NumberFormatException e) {
                lista_questoes.add(0);
            }
        }
        System.out.println("Lista dos valores das respostas: " + lista_questoes);
        return lista_questoes;
    }
    
    public static boolean verificar(ArrayList<Integer> alt_gabarito, ArrayList<Integer> alt_resposta) {
        if (alt_resposta.size() > alt_gabarito.size()) {
            return false;
        }
        
        for (Integer alternativa : alt_resposta) {
            if (!alt_gabarito.contains(alternativa)) {
                return false;
            }
        }
        return true;
    }
}

