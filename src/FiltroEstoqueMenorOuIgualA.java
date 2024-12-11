public class FiltroEstoqueMenorOuIgualA implements Filtros {

    public boolean filtrar(Produto p, String argFiltro1, String argFiltro2) {
        if(p.getQtdEstoque() <= Integer.parseInt(argFiltro1)) return true;
            else return false;
    }
}