public class FiltroNoIntervalo implements Filtros {

    public boolean filtrar(Produto p, String argFiltro1, String argFiltro2) {
        return p.getPreco() <= Double.parseDouble(argFiltro2) && p.getPreco() >= Double.parseDouble(argFiltro1);
    }
}
