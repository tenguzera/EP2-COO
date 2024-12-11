import java.util.List;

public class OrdenacaoPrecoCrescente implements CriterioDeOrdenacao {

    @Override
    public boolean comparar(List<ProdutoFormatacao> produtos, int a, int b) {
        return produtos.get(a).getPreco() > produtos.get(b).getPreco();
    }

    @Override
    public boolean comparar2(List<ProdutoFormatacao> produtos, int a, ProdutoFormatacao b) {
        return produtos.get(a).getPreco() > b.getPreco();
    }
}
