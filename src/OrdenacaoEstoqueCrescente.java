import java.util.List;

public class OrdenacaoEstoqueCrescente implements CriterioDeOrdenacao {

    @Override
    public boolean comparar(List<ProdutoFormatacao> produtos, int a, int b) {
        return produtos.get(a).getQtdEstoque() > produtos.get(b).getQtdEstoque();
    }

    @Override
    public boolean comparar2(List<ProdutoFormatacao> produtos, int a, ProdutoFormatacao b) {
        return produtos.get(a).getQtdEstoque() > b.getQtdEstoque();
    }
}