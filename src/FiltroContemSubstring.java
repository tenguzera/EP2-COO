public class FiltroContemSubstring implements Filtros{

    public boolean filtrar(Produto p, String argFiltro1, String argFiltro2) {
        return p.getDescricao().toLowerCase().contains(argFiltro1.toLowerCase());
    }
}