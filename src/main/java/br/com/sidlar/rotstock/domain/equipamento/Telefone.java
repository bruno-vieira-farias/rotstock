package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Telefone")
public class Telefone extends Equipamento{
    private Boolean semFio;
    private Boolean ip;

    public Telefone() {
    }

    public Telefone(String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Boolean semFio, Boolean ip) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
        this.semFio = semFio;
        this.ip = ip;
    }

    public Telefone(Integer id, String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Boolean semFio, Boolean ip) {
        super(id, serial, fabricante, modelo, ativo, local, proprietario);
        this.semFio = semFio;
        this.ip = ip;
    }

    public Boolean getSemFio() {
        return semFio;
    }

    public Boolean getIp() {
        return ip;
    }

    @Override
    public String getInformacoesEspecificas() {
        return (semFio?"Sem Fio":"Com Fio") + ", "+(ip?"com conectividade ip":"sem conectividade ip");
    }
}
