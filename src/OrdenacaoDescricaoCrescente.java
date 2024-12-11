import java.util.List;

public class OrdenacaoDescricaoCrescente implements CriterioDeOrdenacao {

    @Override
    public boolean comparar(List<ProdutoFormatacao> produtos, int a, int b) {
        return produtos.get(a).getDescricao().compareToIgnoreCase(produtos.get(b).getDescricao()) > 0;
    }

    @Override
    public boolean comparar2(List<ProdutoFormatacao> produtos, int a, ProdutoFormatacao b) {
        return produtos.get(a).getDescricao().compareToIgnoreCase(b.getDescricao()) > 0;
    }
}