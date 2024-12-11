import java.util.*;

public class InsertionSort implements MetodoOrdenacao {

    public void ordenar(int ini, int fim, List<ProdutoFormatacao> produtos, String criterioOrdenacao) {
        CriterioDeOrdenacao criterioEscolhido = DefineCriterioOrdenacao.defineCriterio(criterioOrdenacao);

        for(int i = ini; i <= fim; i++) {
            ProdutoFormatacao p = produtos.get(i);
            int j = (i-1);
            while(j >= ini) {
                if(criterioEscolhido.comparar2(produtos, j, p)) {
                    produtos.set(j+1, produtos.get(j));
                    j--;
                } else break;
            }
            produtos.set(j+1, p);
        }

    }
}