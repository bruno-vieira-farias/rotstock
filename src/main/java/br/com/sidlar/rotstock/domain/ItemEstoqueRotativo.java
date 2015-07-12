package br.com.sidlar.rotstock.domain;

import br.com.sidlar.rotstock.domain.Usuario.Usuario;
import br.com.sidlar.rotstock.domain.equipamento.Equipamento;
import org.joda.time.DateTime;

public class ItemEstoqueRotativo {
    private DateTime dataEntrada;
    private String defeito;
    private Usuario usuarioEntrada;
    private Finalidade finalidade;
    private Equipamento equipamento;

    private enum Status{
        EM_AVALIACAO("Em avaliação"),
        AGUARDANDO_PECA("Aguardando_Peça"),
        PRONTO("Pronto");

        private String descricao;

        Status(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
    private Status status;
}
