package br.com.sidlar.rotstock.presentation;


import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class EquipamentoToEquipamentoFormConverter {
    public List<EquipamentoForm> getEquipamentoForm(List<Equipamento> equipamentos) {
        ArrayList<EquipamentoForm> equipamentosForm = new ArrayList<EquipamentoForm>();

        for (Equipamento equipamento : equipamentos) {
            equipamentosForm.add(new EquipamentoForm(
                    equipamento.getId(),
                    equipamento.getSerial(),
                    equipamento.getFabricante(),
                    equipamento.getModelo(),
                    equipamento.getLocal(),
                    equipamento.getInformacoesEspecificas(),
                    getTipoEquipamento(equipamento)
            ));
        }
            return equipamentosForm;
    }

    private TipoEquipamento getTipoEquipamento(Equipamento equipamento) {
        if (equipamento instanceof Computador) {
            return TipoEquipamento.COMPUTADOR;
        }
        if (equipamento instanceof Monitor) {
            return TipoEquipamento.MONITOR;
        }
        if (equipamento instanceof LeitorCheque) {
            return TipoEquipamento.LEITOR_CHEQUE;
        }
        if (equipamento instanceof Impressora) {
            return TipoEquipamento.IMPRESSORA;
        }
        if (equipamento instanceof Teclado) {
            return TipoEquipamento.TECLADO;
        }
        if (equipamento instanceof Mouse) {
            return TipoEquipamento.MOUSE;
        }
        if (equipamento instanceof Telefone) {
            return TipoEquipamento.TELEFONE;
        }
    return null;
    }

}
