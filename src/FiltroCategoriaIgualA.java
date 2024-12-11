import java.util.*;

public class FiltroCategoriaIgualA implements Filtros {

    public boolean filtrar(Produto p, String argFiltro1, String argFiltro2) {
        if(p.getCategoria().equalsIgnoreCase(argFiltro1)) return true;
            else return false;
    }
}