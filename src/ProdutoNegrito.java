public class ProdutoNegrito implements Produto{
    private Produto produto;

    private static final String SEPARADOR = ", ";

    private int id;
    private String descricao;
    private String categoria;
    private int qtdEstoque;
    private double preco;

    public ProdutoNegrito(Produto produto) {
        setProduto(produto);
    }

    // setters
    private void setProduto(Produto produto) {
        this.produto = produto;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

    public double getPreco() {
        return this.preco;
    }

    // metodo que devolve uma String  em negrito que representa o produto, a ser usada na geração dos relatorios.
    @Override
    public String formataParaImpressao(){
        return ("<span style=\"font-weight:bold\">" + produto.formataParaImpressao());
    }
}