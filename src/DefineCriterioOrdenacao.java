public class DefineCriterioOrdenacao {
    public static CriterioDeOrdenacao defineCriterio(String criterio) {
        CriterioDeOrdenacao criterioDefinido;

        switch (criterio) {
            case GeradorDeRelatorios.CRIT_DESC_CRESC: criterioDefinido = new OrdenacaoDescricaoCrescente();
                                                      break;

            case GeradorDeRelatorios.CRIT_DESC_DECRESC: criterioDefinido = new OrdenacaoDescricaoDecrescente();
                                                        break;

            case GeradorDeRelatorios.CRIT_ESTOQUE_CRESC: criterioDefinido = new OrdenacaoEstoqueCrescente();
                                                         break;

            case GeradorDeRelatorios.CRIT_ESTOQUE_DECRESC: criterioDefinido = new OrdenacaoEstoqueDecrescente();
                                                           break;

            case GeradorDeRelatorios.CRIT_PRECO_CRESC: criterioDefinido = new OrdenacaoPrecoCrescente();
                                                       break;

            case GeradorDeRelatorios.CRIT_PRECO_DECRESC: criterioDefinido = new OrdenacaoPrecoDecrescente();
                                                         break;

            default: throw new RuntimeException("Critério de Ordenação Inválido.");
        }

        return criterioDefinido;
    }
}
