package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.equipamento.fabrica.CaracteristicasBasicasEquipamento;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.EquipamentoFactory;
import br.com.sidlar.rotstock.presentation.TipoEquipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipamentoService {
    @Autowired
    EquipamentoFactory equipamentoFactory;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    public void persisteEquipamento(EquipamentoModel equipamentoModel) {
        Equipamento equipamento = criarEquipamento(equipamentoModel);
        equipamentoRepository.gravaEquipamento(equipamento);
    }

    public void alteraEquipamento(EquipamentoModel equipamentoModel) {
        Equipamento equipamento = criarEquipamento(equipamentoModel);
        equipamentoRepository.alteraEquipamento(equipamento);
    }

    public EquipamentoModel buscaPorId(int idEquipamento){
       return convertEquipamentoModel(equipamentoRepository.buscaPorId(idEquipamento));
    }

    public EquipamentoModel buscaPorSerial(String serial) {
       Equipamento equipamento = equipamentoRepository.buscaPorSerial(serial);
       if(equipamento != null){
           return convertEquipamentoModel(equipamento);
       }
        return null;
    }

    public List<EquipamentoModel> buscaPorLocal(int idLocal) {
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorLocal(idLocal);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoModel> buscaPorLocalAndTipoEquipamento(int idLocal,TipoEquipamento tipoEquipamento) {
        Class clazzTipoEquipamento = classPorTipoEquipamento(tipoEquipamento);

        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorTipoEquipamentoLocal(clazzTipoEquipamento,idLocal);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoModel> buscaPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        Class clazzTipoEquipamento = classPorTipoEquipamento(tipoEquipamento);

        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorTipoEquipamento(clazzTipoEquipamento);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoModel> buscaTodosEquipamentos() {
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaTodos();
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    private Equipamento criarEquipamento(EquipamentoModel equipamentoModel) {
        Equipamento equipamento;
        CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento =
                new CaracteristicasBasicasEquipamento(
                        equipamentoModel.getId(),
                        equipamentoModel.getSerial(),
                        equipamentoModel.getFabricante(),
                        equipamentoModel.getModelo(),
                        equipamentoModel.getIdLocal(),
                        equipamentoModel.getProprietario()
                );
        switch (equipamentoModel.getTipoEquipamento()) {
            case COMPUTADOR:
                equipamento = equipamentoFactory.criaComputador(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getProcessador(),
                        equipamentoModel.getMemoria(),
                        equipamentoModel.getHd()
                );
                break;
            case MONITOR:
                equipamento = equipamentoFactory.criaMonitor(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getPolegadas()
                );
                break;
            case TECLADO:
                equipamento = equipamentoFactory.criaTeclado(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getTipoConexao()
                );
                break;
            case MOUSE:
                equipamento = equipamentoFactory.criaMouse(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getTipoConexao()
                );
                break;
            case LEITOR_CHEQUE:
                equipamento = equipamentoFactory.criaLeitorCheque(
                        caracteristicasBasicasEquipamento
                );
                break;
            case TELEFONE:
                equipamento =equipamentoFactory.criaTelefone(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getSemFio(),
                        equipamentoModel.getIp()
                );
                break;
            case IMPRESSORA:
                equipamento = equipamentoFactory.criaImpressora(
                        caracteristicasBasicasEquipamento,
                        equipamentoModel.getColorida(),
                        equipamentoModel.getTipoImpressora()
                );
                break;
            default:
                throw new IllegalArgumentException("Não é possivel criar o equipamento com o identificador " + equipamentoModel.getTipoEquipamento());
        }
        return equipamento;
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

    private EquipamentoModel convertEquipamentoModel(Equipamento equipamento) {
        EquipamentoModel equipamentoModel = new EquipamentoModel();
            equipamentoModel.setId(equipamento.getId());
            equipamentoModel.setSerial(equipamento.getSerial());
            equipamentoModel.setFabricante(equipamento.getFabricante());
            equipamentoModel.setModelo(equipamento.getModelo());
            equipamentoModel.setLocal(equipamento.getLocal());
            equipamentoModel.setIdLocal(equipamento.getLocal().getId());
            equipamentoModel.setProprietario(equipamento.getProprietario());
            equipamentoModel.setInformacoesEspecificas(equipamento.getInformacoesEspecificas());

        if (equipamento instanceof Computador) {
            Computador computador = (Computador) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.COMPUTADOR);
            equipamentoModel.setProcessador(computador.getProcessador());
            equipamentoModel.setMemoria(computador.getMemoria());
            equipamentoModel.setHd(computador.getHd());
        }
        else if (equipamento instanceof Monitor) {
            Monitor monitor = (Monitor) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.MONITOR);
            equipamentoModel.setPolegadas(monitor.getPolegadas());
        }
        else if (equipamento instanceof LeitorCheque) {
            equipamentoModel.setTipoEquipamento(TipoEquipamento.LEITOR_CHEQUE);
        }
        else if (equipamento instanceof Impressora) {
            Impressora impressora = (Impressora) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.IMPRESSORA);
            equipamentoModel.setColorida(impressora.getColorida());
            equipamentoModel.setTipoImpressora(impressora.getTipoImpressora());
        }
        else if (equipamento instanceof Teclado) {
            Teclado teclado = (Teclado) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.TECLADO);
            equipamentoModel.setTipoConexao(teclado.getTipoConexao());
        }
        else if (equipamento instanceof Mouse) {
            Mouse mouse = (Mouse) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.MOUSE);
            equipamentoModel.setTipoConexao(mouse.getTipoConexao());
        }
        else if (equipamento instanceof Telefone) {
            Telefone telefone = (Telefone) equipamento;
            equipamentoModel.setTipoEquipamento(TipoEquipamento.TELEFONE);
            equipamentoModel.setIp(telefone.getIp());
            equipamentoModel.setSemFio(telefone.getSemFio());
        }
        return equipamentoModel;
    }

    private List<EquipamentoModel> convertToListEquipamentoModel(List<Equipamento> listaEquipamento) {
        ArrayList<EquipamentoModel> listaEquipamentoModel = new ArrayList<>();

        for (Equipamento equipamento : listaEquipamento) {
            listaEquipamentoModel.add(convertEquipamentoModel(equipamento));
        }

        return listaEquipamentoModel;
    }


}