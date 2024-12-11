public class DefineAlgoritmoOrdenacao {
    public static MetodoOrdenacao defineAlgorimoOrdenacao(String algoritmo) {
        MetodoOrdenacao metodoEscolhido;

        switch (algoritmo) {
            case GeradorDeRelatorios.ALG_INSERTIONSORT: metodoEscolhido = new InsertionSort();
                                                        break;

            case GeradorDeRelatorios.ALG_QUICKSORT: metodoEscolhido = new QuickSort();
                                                    break;

            default: throw new RuntimeException("Algoritmo Inválido.");
        }
        return metodoEscolhido;
    }
}
