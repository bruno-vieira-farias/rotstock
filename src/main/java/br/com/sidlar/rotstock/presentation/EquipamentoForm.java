package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.equipamento.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipamentoForm {

    @Size(min=2, max=15, message = "* O serial deve possuir entre 2 e 15 caracteres")
    private String serial;

    @NotNull(message = "* Qual é o fabricante deste equipamento?")
    private Fabricante fabricante;

    @Size(min=1 , message = "* Qual é o modelo deste equipamento?")
    private String modelo;

    @NotNull(message = "* Quem é o proprietario")
    private Proprietario proprietario;

    @NotNull(message = "* Informe um local")
    private Integer idLocal;

    @NotNull(message = "* Informe qual o equipamento desejado")
    private TipoEquipamento tipoEquipamento;

    @NotNull(message = "* Selecione um processador")
    private Processador processador;

    @NotNull(message = "* Selecione uma memória")
    private Memoria memoria;

    @NotNull(message = "* Selecione um hd")
    private Hd hd;

    @NotNull(message = "* Selecione uma das opções")
    private Boolean colorida;

    @NotNull(message = "* Selecione um tipo de Impressora")
    private TipoImpressora tipoImpressora;

    @NotNull(message = "* Quantas polegadas tem este monitor?")
    private Polegadas polegadas;

    @NotNull(message = "* Qual o tipo de conexão?")
    private TipoConexao tipoConexao;

    @NotNull(message = "* Selecione uma das opções")
    private Boolean semFio;

    @NotNull(message = "* Selecione uma das opções")
    private Boolean ip;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public Hd getHd() {
        return hd;
    }

    public void setHd(Hd hd) {
        this.hd = hd;
    }

    public Boolean getColorida() {
        return colorida;
    }

    public void setColorida(Boolean colorida) {
        this.colorida = colorida;
    }

    public TipoImpressora getTipoImpressora() {
        return tipoImpressora;
    }

    public void setTipoImpressora(TipoImpressora tipoImpressora) {
        this.tipoImpressora = tipoImpressora;
    }

    public Polegadas getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(Polegadas polegadas) {
        this.polegadas = polegadas;
    }

    public TipoConexao getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(TipoConexao tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public Boolean getSemFio() {
        return semFio;
    }

    public void setSemFio(Boolean semFio) {
        this.semFio = semFio;
    }

    public Boolean getIp() {
        return ip;
    }

    public void setIp(Boolean ip) {
        this.ip = ip;
    }
}
