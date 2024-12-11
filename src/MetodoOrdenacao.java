import java.util.List;

public interface MetodoOrdenacao {

    /* Ordena um vetor de produtos seguindo um critério especificado
    @param ini primeira posição do array
    @param fim ultima posição do array
    @param produtos lista dos produtos já formatados
    @param criterioOrdenacao criterio no qual a ordenação será feita
     */

    public void ordenar(int ini, int fim, List<ProdutoFormatacao> produtos, String criterioOrdenacao);
}