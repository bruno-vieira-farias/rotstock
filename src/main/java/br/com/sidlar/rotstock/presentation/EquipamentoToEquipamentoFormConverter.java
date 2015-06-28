package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class EquipamentoToEquipamentoFormConverter {
    public List<EquipamentoForm> getEquipamentosForm(List<Equipamento> equipamentos) {
        ArrayList<EquipamentoForm> equipamentosForm = new ArrayList<EquipamentoForm>();

        for (Equipamento equipamento : equipamentos) {
            equipamentosForm.add(getEquipamentoForm(equipamento));
        }
        return equipamentosForm;
    }

    public EquipamentoForm getEquipamentoForm(Equipamento equipamento) {
        EquipamentoForm equipamentoForm = new EquipamentoForm();
            equipamentoForm.setId(equipamento.getId());
            equipamentoForm.setSerial(equipamento.getSerial());
            equipamentoForm.setFabricante(equipamento.getFabricante());
            equipamentoForm.setModelo(equipamento.getModelo());
            equipamentoForm.setLocal(equipamento.getLocal());
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
}
