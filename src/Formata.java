import java.io.PrintWriter;

public class Formata {

    public static void formatar(ProdutoFormatacao p, PrintWriter out) {
        Produto formatacao;
        out.print("<li>");

        if(p.getItalico() && p.getNegrito()) {
            formatacao = new ProdutoCor(new ProdutoNegrito(new ProdutoItalico(p)), p.getCor());
        }
        else if(p.getItalico()) {
            formatacao = new ProdutoItalico(new ProdutoCor(p, p.getCor()));
        }
        else if(p.getNegrito()) {
            formatacao = new ProdutoNegrito(new ProdutoCor(p, p.getCor()));
        }
        else {
            formatacao = new ProdutoCor(p, p.getCor());
        }

        out.print(formatacao.formataParaImpressao());
        out.print("</span>");
        out.println("</li>");
    }
}