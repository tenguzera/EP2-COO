public class DefineFiltros {

    public static boolean defineFiltro(String filtro, ProdutoFormatacao p, String argFiltro1, String argFiltro2) {
        Filtros filtroDefinido;

        switch (filtro) {
            case GeradorDeRelatorios.FILTRO_TODOS:
                filtroDefinido = new FiltroTodos();
                break;

            case GeradorDeRelatorios.FILTRO_ESTOQUE_MENOR_OU_IQUAL_A:
                filtroDefinido = new FiltroEstoqueMenorOuIgualA();
                break;

            case GeradorDeRelatorios.FILTRO_CATEGORIA_IGUAL_A:
                filtroDefinido = new FiltroCategoriaIgualA();
                break;

            case GeradorDeRelatorios.FILTRO_PRECO_INTERVALO:
                filtroDefinido = new FiltroNoIntervalo();
                break;

            case GeradorDeRelatorios.FILTRO_CONTEM_SUBSTRING:
                filtroDefinido = new FiltroContemSubstring();
                break;

            default:
                throw new RuntimeException("Filtro Inválido.");
        }

        return filtroDefinido.filtrar(p, argFiltro1, argFiltro2);
    }
}
