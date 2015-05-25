package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.Polegadas;
import br.com.sidlar.rotstock.domain.equipamento.Proprietario;
import br.com.sidlar.rotstock.domain.equipamento.TipoConexao;
import br.com.sidlar.rotstock.domain.equipamento.TipoImpressora;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.Size;

public class EquipamentoForm {

    @Size(min=2, max=30, message = "Xiii...")
    private String serial;
    private String fabricante;
    private String modelo;
    private Proprietario proprietario;
    private Integer idLocal;
    private TipoEquipamento tipoEquipamento;

    private String processador;
    private String memoria;
    private String hd;

    private Boolean colorida = Boolean.FALSE;
    private TipoImpressora tipoImpressora;

    private Polegadas polegadas;

    private TipoConexao tipoConexao;

    private Boolean semFio = Boolean.FALSE;
    private Boolean ip = Boolean.FALSE;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
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

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
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
