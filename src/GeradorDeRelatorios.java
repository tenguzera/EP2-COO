import java.io.*;
import java.util.*;

public class GeradorDeRelatorios {
	public static final String ALG_INSERTIONSORT = "quick";
	public static final String ALG_QUICKSORT = "insertion";

	public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_DESC_DECRESC = "descricao_d";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_PRECO_DECRESC = "preco_d";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";
	public static final String CRIT_ESTOQUE_DECRESC = "estoque_d";
	
	public static final String FILTRO_TODOS = "todos";
	public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = "estoque_menor_igual";
	public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";
	public static final String FILTRO_PRECO_INTERVALO = "intervalo_preco";
	public static final String FILTRO_CONTEM_SUBSTRING = "filtro_substring";

	private List<ProdutoFormatacao> produtos;
	private String algoritmo;
	private String criterio;
	private String filtro;
	private String argFiltro;
	private String argFiltro2;

	public GeradorDeRelatorios(List<ProdutoFormatacao> produtos, String algoritmo, String criterio, String filtro, String argFiltro, String argFiltro2) {
		this.produtos = produtos;
		this.algoritmo = algoritmo;
		this.criterio = criterio;
		this.filtro = filtro;
		this.argFiltro = argFiltro;
		this.argFiltro2 = argFiltro2;
	}

	private void ordena(int ini, int fim) {
		MetodoOrdenacao MetodoDefinido = DefineAlgoritmoOrdenacao.defineAlgorimoOrdenacao(algoritmo);
		MetodoDefinido.ordenar(ini, fim, this.produtos, criterio);
	}
	
	public void debug() {
		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'");
		if(argFiltro2!=" ") System.out.println("segundo parametro filtro = '" + argFiltro2 + "'");
	}

	public void geraRelatorio(String arquivoSaida) throws IOException {
		debug();
		ordena(0, produtos.size() - 1);

		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for(int i = 0; i < produtos.size(); i++) {
			ProdutoFormatacao p = produtos.get(i);
			boolean escolhido = false;
			escolhido = DefineFiltros.defineFiltro(filtro, p, argFiltro, argFiltro2);

			if(escolhido) {
				Formata.formatar(p, out);
				count++;
			}
		}

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public static List<ProdutoFormatacao> carregaProdutos() {
		List<ProdutoFormatacao> p = new ArrayList<>();

		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("produtos.csv")));
			in.nextLine();
			while(in.hasNextLine()) {
				in.useDelimiter(", ");
				int id = in.nextInt();
				String desc = in.next();
				String categ = in.next();
				int qtd_estoque = in.nextInt();
				double preco = Double.parseDouble(in.next());
				boolean italico = in.nextBoolean();
				boolean negrito = in.nextBoolean();
				in.useDelimiter(" ");
				in.next();
				in.useDelimiter("\n");
				String cor = in.next();
				ProdutoFormatacao produto = new ProdutoFormatacao(id, desc, categ, qtd_estoque, preco, italico, negrito, cor);
				p.add(produto);
				in.nextLine();
			}
		} catch(IOException e) {
			System.err.println("Arquivo .csv não encontrado.");
		}
		return p;
	}

	public static void main(String [] args) {
		if(args.length < 4) {
			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <parâmetro de filtragem2>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco_c' ou 'preco_d 'ou 'descricao_c' ou 'descricao_d 'ou 'estoque_c' ou 'estoque_d'");
			System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual'"); 
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem");
			System.out.println("\tparâmetro de filtragem2: outros argumentos adicionais que podem ser necessários para a filtragem");
			System.out.println();
			System.exit(1);
		}

		String opcao_algoritmo = args[0];
		String opcao_criterio_ord = args[1];
		String opcao_criterio_filtro = args[2];
		String opcao_parametro_filtro = args[3];
		String opcao_segundo_parametro_filtro = " ";
		if(args.length>4) opcao_segundo_parametro_filtro = args[4];
		
		GeradorDeRelatorios gdr = new GeradorDeRelatorios(
									carregaProdutos(),
									opcao_algoritmo,
									opcao_criterio_ord,
									opcao_criterio_filtro,
									opcao_parametro_filtro,
									opcao_segundo_parametro_filtro
								 );

		try {
			gdr.geraRelatorio("saida.html");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
