package br.com.sidlar.rotstock.domain;

import br.com.sidlar.rotstock.domain.Usuario.Usuario;
import br.com.sidlar.rotstock.domain.equipamento.Equipamento;
import java.util.Date;

public class ItemEstoqueRotativo {
    private Date dataEntrada;
    private String defeito;
    private Usuario usuarioEntrada;
    private Finalidade finalidade;
    private Equipamento equipamento;
    private StatusItemEstoqueRotativo status;

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public ItemEstoqueRotativo(Date dataEntrada, String defeito, Usuario usuarioEntrada, Finalidade finalidade, Equipamento equipamento, StatusItemEstoqueRotativo status) {
        this.dataEntrada = dataEntrada;
        this.defeito = defeito;
        this.usuarioEntrada = usuarioEntrada;
        this.finalidade = finalidade;
        this.equipamento = equipamento;
        this.status = status;
    }

    public void setDataEntrada(Date dataEntrada) {
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
