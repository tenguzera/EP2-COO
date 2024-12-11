import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuickSort implements MetodoOrdenacao {

    public int particiona(int ini, int fim, List<ProdutoFormatacao> produtos, String criterioOrdenacao) {
        int i = (ini-1);
        int j = (fim+1);

        CriterioDeOrdenacao criterioDefinido = DefineCriterioOrdenacao.defineCriterio(criterioOrdenacao);
        while(true) {
            do {
                j--;
            } while(criterioDefinido.comparar(produtos, j, ini));

            do {
                i++;
            } while(criterioDefinido.comparar(produtos, ini, i));

            if(i < j) {
                Collections.swap(produtos, i, j);
            } else return j;
        }
    }

    public void ordenar(int ini, int fim, List<ProdutoFormatacao> produtos, String criterioOrdenacao) {
        if(ini < fim) {
            int q = particiona(ini, fim, produtos, criterioOrdenacao);
            ordenar(ini, q, produtos, criterioOrdenacao);
            ordenar(q+1, fim, produtos, criterioOrdenacao);
        }
    }
}
