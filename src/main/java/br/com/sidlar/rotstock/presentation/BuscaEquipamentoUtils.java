package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscaEquipamentoUtils {
    @Autowired
    private Converter converter;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    public List<EquipamentoForm> buscaEquipamento(EquipamentoForm equipamentoForm){
        boolean buscaComSerial = !equipamentoForm.getSerial().equalsIgnoreCase("");
        boolean buscaComLocal = equipamentoForm.getIdLocal() != null;
        boolean buscaComTipoEquipamento = equipamentoForm.getTipoEquipamento() != null;

        if(buscaComSerial){
            ArrayList<EquipamentoForm> listaEquipamentoForm = new ArrayList<>();
            listaEquipamentoForm.add(buscaPorSerial(equipamentoForm));

            return listaEquipamentoForm;
        }else if(buscaComLocal & buscaComTipoEquipamento){
            return buscaPorLocalAndTipoEquipamento(equipamentoForm);
        }else if (buscaComLocal) {
            return buscaPorLocal(equipamentoForm);
        }else if (buscaComTipoEquipamento) {
           return buscaPorTipoEquipamento(equipamentoForm);
        }else{
            return converter.convertToEquipamentoForm(equipamentoRepository.buscaTodos());
        }
    }
    private EquipamentoForm buscaPorSerial(EquipamentoForm equipamentoForm) {
        Equipamento equipamento = equipamentoRepository.buscaPorSerial(equipamentoForm.getSerial());
        return converter.convertToEquipamentoForm(equipamento);
    }
    private List<EquipamentoForm> buscaPorLocalAndTipoEquipamento(EquipamentoForm equipamentoForm){
        int idLocal = equipamentoForm.getIdLocal();
        Class clazzTipoEquipamento = classPorTipoEquipamento(equipamentoForm.getTipoEquipamento());
        List<Equipamento> equipamentos = equipamentoRepository.buscaPorTipoEquipamentoLocal(clazzTipoEquipamento,idLocal);

        return converter.convertToEquipamentoForm(equipamentos);
    }
    private List<EquipamentoForm> buscaPorLocal(EquipamentoForm equipamentoForm) {
        int idLocal = equipamentoForm.getIdLocal();
        List<Equipamento> equipamentos = equipamentoRepository.buscaPorLocal(idLocal);

        return converter.convertToEquipamentoForm(equipamentos);
    }
    private List<EquipamentoForm> buscaPorTipoEquipamento(EquipamentoForm equipamentoForm) {
        Class clazzTipoEquipamento = classPorTipoEquipamento(equipamentoForm.getTipoEquipamento());
        List<Equipamento> equipamentos = equipamentoRepository.buscaPorTipoEquipamento(clazzTipoEquipamento);

        return converter.convertToEquipamentoForm(equipamentos);
    }
    private Class classPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        switch (tipoEquipamento){
            case COMPUTADOR:
                return Computador.class;
            case MONITOR:
                return Monitor.class;
            case IMPRESSORA:
                return Impressora.class;
            case LEITOR_CHEQUE:
                return LeitorCheque.class;
            case TECLADO:
                return Teclado.class;
            case MOUSE:
                return  Mouse.class;
            case TELEFONE:
                return Telefone.class;
            default:
                throw new IllegalArgumentException("Não é possivel buscar o equipamento com o identificador " + tipoEquipamento);
        }
    }
}
