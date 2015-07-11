package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.CaracteristicasBasicasEquipamento;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.EquipamentoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter{
    @Autowired
    LocalRepository localRepository;

    @Autowired
    private EquipamentoFactory equipamentoFactory;

    public Equipamento convertToEquipamento(EquipamentoForm equipamentoForm) {
        CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento =
                new CaracteristicasBasicasEquipamento(
                        equipamentoForm.getId(),
                        equipamentoForm.getSerial(),
                        equipamentoForm.getFabricante(),
                        equipamentoForm.getModelo(),
                        equipamentoForm.getIdLocal(),
                        equipamentoForm.getProprietario()
                );
        switch (equipamentoForm.getTipoEquipamento()) {
            case MONITOR:
                return equipamentoFactory.criaMonitor(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getPolegadas()
                );
            case COMPUTADOR:
                return equipamentoFactory.criaComputador(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getProcessador(),
                        equipamentoForm.getMemoria(),
                        equipamentoForm.getHd()
                );
            case TECLADO:
                return equipamentoFactory.criaTeclado(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getTipoConexao()
                );
            case MOUSE:
                return equipamentoFactory.criaMouse(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getTipoConexao()
                );
            case LEITOR_CHEQUE:
                return equipamentoFactory.criaLeitorCheque(
                        caracteristicasBasicasEquipamento
                );
            case TELEFONE:
                return equipamentoFactory.criaTelefone(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getSemFio(),
                        equipamentoForm.getIp()
                );
            case IMPRESSORA:
                return equipamentoFactory.criaImpressora(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getColorida(),
                        equipamentoForm.getTipoImpressora()
                );
            default:
                throw new IllegalArgumentException("Não é possivel criar o equipamento com o identificador " + equipamentoForm.getTipoEquipamento());
        }
    }
    public EquipamentoForm convertToEquipamentoForm(Equipamento equipamento) {
        EquipamentoForm equipamentoForm = new EquipamentoForm();
        equipamentoForm.setId(equipamento.getId());
        equipamentoForm.setSerial(equipamento.getSerial());
        equipamentoForm.setFabricante(equipamento.getFabricante());
        equipamentoForm.setModelo(equipamento.getModelo());
        equipamentoForm.setLocal(equipamento.getLocal());
        equipamentoForm.setIdLocal(equipamento.getLocal().getId());
        equipamentoForm.setProprietario(equipamento.getProprietario());
        equipamentoForm.setInformacoesEspecificas(equipamento.getInformacoesEspecificas());
        if (equipamento instanceof Computador) {
            Computador computador = (Computador) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.COMPUTADOR);
            equipamentoForm.setProcessador(computador.getProcessador());
            equipamentoForm.setMemoria(computador.getMemoria());
            equipamentoForm.setHd(computador.getHd());
        }
        else if (equipamento instanceof Monitor) {
            Monitor monitor = (Monitor) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.MONITOR);
            equipamentoForm.setPolegadas(monitor.getPolegadas());
        }
        else if (equipamento instanceof LeitorCheque) {
            equipamentoForm.setTipoEquipamento(TipoEquipamento.LEITOR_CHEQUE);
        }
        else if (equipamento instanceof Impressora) {
            Impressora impressora = (Impressora) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.IMPRESSORA);
            equipamentoForm.setColorida(impressora.getColorida());
            equipamentoForm.setTipoImpressora(impressora.getTipoImpressora());
        }
        else if (equipamento instanceof Teclado) {
            Teclado teclado = (Teclado) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.TECLADO);
            equipamentoForm.setTipoConexao(teclado.getTipoConexao());
        }
        else if (equipamento instanceof Mouse) {
            Mouse mouse = (Mouse) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.MOUSE);
            equipamentoForm.setTipoConexao(mouse.getTipoConexao());
        }
        else if (equipamento instanceof Telefone) {
            Telefone telefone = (Telefone) equipamento;
            equipamentoForm.setTipoEquipamento(TipoEquipamento.TELEFONE);
            equipamentoForm.setIp(telefone.getIp());
            equipamentoForm.setSemFio(telefone.getSemFio());
        }
        return equipamentoForm;
    }
    public List<EquipamentoForm> convertToEquipamentoForm(List<Equipamento> equipamentos) {
        ArrayList<EquipamentoForm> equipamentosForm = new ArrayList<>();
            for (Equipamento equipamento : equipamentos) {
                equipamentosForm.add(convertToEquipamentoForm(equipamento));
            }
        return equipamentosForm;
    }
}
