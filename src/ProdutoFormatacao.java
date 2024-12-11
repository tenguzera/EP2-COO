public class ProdutoFormatacao extends ProdutoPadrao{
    private static final String SEPARADOR = ", ";

    private int id;
    private String descricao;
    private String categoria;
    private int qtdEstoque;
    private double preco;

    private boolean italico;
    private boolean negrito;
    private String cor;

    public ProdutoFormatacao(int id, String descricao, String categoria, int qtdEstoque, double preco,boolean negrito, boolean italico, String cor){
        super(id, descricao, categoria, qtdEstoque, preco);
        setItalico(italico);
        setNegrito(negrito);
        setCor(cor);
    }

    // setters
    private void setItalico(boolean italico) {
        this.italico = italico;
    }

    private void setNegrito(boolean negrito) {
        this.negrito = negrito;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    // getters
    public boolean getItalico() {
        return this.italico;
    }

    public boolean getNegrito() {
        return this.negrito;
    }

    public String getCor() {
        return this.cor;
    }
}