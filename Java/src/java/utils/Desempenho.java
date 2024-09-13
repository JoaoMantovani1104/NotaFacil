package utils;

import java.util.ArrayList;

public class Desempenho {
    public static double calcular(ArrayList<ArrayList<Integer>> alts_gabarito, ArrayList<ArrayList<Integer>> alts_resposta){
        ArrayList<Double> notas_questoes = new ArrayList<>();
        double valor_questao = 6.0;

        for (int i = 0; i < alts_gabarito.size(); i++) {
            
            if (Questoes.verificar(alts_gabarito.get(i), alts_resposta.get(i))) {
                int numAlternativasCorretas = 0;
                
                for (Integer resposta : alts_resposta.get(i)) {
                    if (alts_gabarito.get(i).contains(resposta)) {
                        numAlternativasCorretas++;
                    }
                }
                
                int totalAlternativasCorretas = alts_gabarito.get(i).size();
                
                double nota_questao = valor_questao * ((double) numAlternativasCorretas / totalAlternativasCorretas);
                notas_questoes.add(nota_questao);
                
            } else {
                notas_questoes.add(0.0);
            }
        }
        System.out.println("Notas questoes: " + notas_questoes);
        return somaLista(notas_questoes);
    }

    public static double somaLista(ArrayList<Double> lista){
        double soma = 0.0;
        for(Double valor : lista){
            soma += valor;
        }
        //System.out.println("Soma da nota: " + soma);
        return soma;
    }
}
