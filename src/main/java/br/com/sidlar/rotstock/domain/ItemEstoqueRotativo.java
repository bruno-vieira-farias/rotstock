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
    private StatusItemEstoqueRotativo status;

    public DateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(DateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public StatusItemEstoqueRotativo getStatus() {
        return status;
    }

    public void setStatus(StatusItemEstoqueRotativo status) {
        this.status = status;
    }

    public Finalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(Finalidade finalidade) {
        this.finalidade = finalidade;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Usuario getUsuarioEntrada() {
        return usuarioEntrada;
    }

    public void setUsuarioEntrada(Usuario usuarioEntrada) {
        this.usuarioEntrada = usuarioEntrada;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
}
