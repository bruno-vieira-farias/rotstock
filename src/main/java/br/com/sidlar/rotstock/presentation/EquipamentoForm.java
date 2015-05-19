package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.Polegadas;
import br.com.sidlar.rotstock.domain.equipamento.Proprietario;
import br.com.sidlar.rotstock.domain.equipamento.TipoConexao;
import br.com.sidlar.rotstock.domain.equipamento.TipoImpressora;

public class EquipamentoForm {
    private String serial;
    private String fabricante;
    private String modelo;
    private Proprietario proprietario;
    private Integer idLocal;

    private String processador;
    private String memoria;
    private String hd;

    private Boolean colorida;
    private TipoImpressora tipoImpressora;

    private Polegadas polegadas;

    private TipoConexao tipoConexao;

    private Boolean semFio;
    private Boolean ip;


    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
