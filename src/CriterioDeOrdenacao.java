import java.util.List;

public interface CriterioDeOrdenacao {
    public boolean comparar (List<ProdutoFormatacao> produtos, int a, int b);
    public boolean comparar2 (List<ProdutoFormatacao> produtos, int a, ProdutoFormatacao b);
}
