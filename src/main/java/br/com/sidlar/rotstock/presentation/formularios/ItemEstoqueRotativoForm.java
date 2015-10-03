package br.com.sidlar.rotstock.presentation.formularios;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoEspecificacao;

/**
 * Classe que representa o objeto de domino ItemEstoqueRotativo no formulario html do de entrada de equipamentos.
 */
public class ItemEstoqueRotativoForm {
    private String defeito;
    private Finalidade finalidade;
    private EquipamentoEspecificacao equipamentoEspecificacao;
    private StatusItemEstoqueRotativo status;

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public Finalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(Finalidade finalidade) {
        this.finalidade = finalidade;
    }

    public EquipamentoEspecificacao getEquipamentoEspecificacao() {
        return equipamentoEspecificacao;
    }

    public void setEquipamentoEspecificacao(EquipamentoEspecificacao equipamentoEspecificacao) {
        this.equipamentoEspecificacao = equipamentoEspecificacao;
    }

    public StatusItemEstoqueRotativo getStatus() {
        return status;
    }

    public void setStatus(StatusItemEstoqueRotativo status) {
        this.status = status;
    }
}