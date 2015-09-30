package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.equipamento.fabrica.CaracteristicasBasicasEquipamento;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.EquipamentoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipamentoService {
    @Autowired
    private EquipamentoFactory equipamentoFactory;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public void persisteEquipamento(EquipamentoEspecificacao equipamentoEspecificacao) {
        Equipamento equipamento = criarEquipamento(equipamentoEspecificacao);
        equipamentoRepository.gravaEquipamento(equipamento);
    }

    public void alteraEquipamento(EquipamentoEspecificacao equipamentoEspecificacao) {
        Equipamento equipamento = criarEquipamento(equipamentoEspecificacao);
        equipamentoRepository.alteraEquipamento(equipamento);
    }

    public EquipamentoEspecificacao buscaPorId(int idEquipamento){
       return convertEquipamentoModel(equipamentoRepository.buscaPorId(idEquipamento));
    }

    public EquipamentoEspecificacao buscaPorSerial(String serial) {
       Equipamento equipamento = equipamentoRepository.buscaPorSerial(serial);
       if(equipamento != null){
           return convertEquipamentoModel(equipamento);
       }
        return null;
    }

    public List<EquipamentoEspecificacao> buscaPorLocal(int idLocal) {
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorLocal(idLocal);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoEspecificacao> buscaPorLocalAndTipoEquipamento(int idLocal,TipoEquipamento tipoEquipamento) {
        Class clazzTipoEquipamento = classPorTipoEquipamento(tipoEquipamento);

        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorTipoEquipamentoLocal(clazzTipoEquipamento,idLocal);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoEspecificacao> buscaPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        Class clazzTipoEquipamento = classPorTipoEquipamento(tipoEquipamento);

        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaPorTipoEquipamento(clazzTipoEquipamento);
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    public List<EquipamentoEspecificacao> buscaTodosEquipamentos() {
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaTodos();
        return convertToListEquipamentoModel(listaEquipamentos);
    }

    private Equipamento criarEquipamento(EquipamentoEspecificacao equipamentoEspecificacao) {
        Equipamento equipamento;
        CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento =
                new CaracteristicasBasicasEquipamento(
                        equipamentoEspecificacao.getId(),
                        equipamentoEspecificacao.getSerial(),
                        equipamentoEspecificacao.getFabricante(),
                        equipamentoEspecificacao.getModelo(),
                        equipamentoEspecificacao.getIdLocal(),
                        equipamentoEspecificacao.getProprietario()
                );
        switch (equipamentoEspecificacao.getTipoEquipamento()) {
            case COMPUTADOR:
                equipamento = equipamentoFactory.criaComputador(
                        caracteristicasBasicasEquipamento,
                        equipamentoEspecificacao.getProcessador(),
                        equipamentoEspecificacao.getMemoria(),
                        equipamentoEspecificacao.getHd()
                );
                break;
            case MONITOR:
                equipamento = equipamentoFactory.criaMonitor(
                        caracteristicasBasicasEquipamento,
                        equipamentoEspecificacao.getPolegadas()
                );
                break;
            case TECLADO:
                equipamento = equipamentoFactory.criaTeclado(
                        caracteristicasBasicasEquipamento,
                        equipamentoEspecificacao.getTipoConexao()
                );
                break;
            case MOUSE:
                equipamento = equipamentoFactory.criaMouse(
                        caracteristicasBasicasEquipamento,
                        equipamentoEspecificacao.getTipoConexao()
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
                        equipamentoEspecificacao.getSemFio(),
                        equipamentoEspecificacao.getIp()
                );
                break;
            case IMPRESSORA:
                equipamento = equipamentoFactory.criaImpressora(
                        caracteristicasBasicasEquipamento,
                        equipamentoEspecificacao.getColorida(),
                        equipamentoEspecificacao.getTipoImpressora()
                );
                break;
            default:
                throw new IllegalArgumentException("Não é possivel criar o equipamento com o identificador " + equipamentoEspecificacao.getTipoEquipamento());
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

    private EquipamentoEspecificacao convertEquipamentoModel(Equipamento equipamento) {
        EquipamentoEspecificacao equipamentoEspecificacao = new EquipamentoEspecificacao();
            equipamentoEspecificacao.setId(equipamento.getId());
            equipamentoEspecificacao.setSerial(equipamento.getSerial());
            equipamentoEspecificacao.setFabricante(equipamento.getFabricante());
            equipamentoEspecificacao.setModelo(equipamento.getModelo());
            equipamentoEspecificacao.setLocal(equipamento.getLocal());
            equipamentoEspecificacao.setIdLocal(equipamento.getLocal().getId());
            equipamentoEspecificacao.setProprietario(equipamento.getProprietario());
            equipamentoEspecificacao.setInformacoesEspecificas(equipamento.getInformacoesEspecificas());

        if (equipamento instanceof Computador) {
            Computador computador = (Computador) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.COMPUTADOR);
            equipamentoEspecificacao.setProcessador(computador.getProcessador());
            equipamentoEspecificacao.setMemoria(computador.getMemoria());
            equipamentoEspecificacao.setHd(computador.getHd());
        }
        else if (equipamento instanceof Monitor) {
            Monitor monitor = (Monitor) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.MONITOR);
            equipamentoEspecificacao.setPolegadas(monitor.getPolegadas());
        }
        else if (equipamento instanceof LeitorCheque) {
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.LEITOR_CHEQUE);
        }
        else if (equipamento instanceof Impressora) {
            Impressora impressora = (Impressora) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.IMPRESSORA);
            equipamentoEspecificacao.setColorida(impressora.getColorida());
            equipamentoEspecificacao.setTipoImpressora(impressora.getTipoImpressora());
        }
        else if (equipamento instanceof Teclado) {
            Teclado teclado = (Teclado) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.TECLADO);
            equipamentoEspecificacao.setTipoConexao(teclado.getTipoConexao());
        }
        else if (equipamento instanceof Mouse) {
            Mouse mouse = (Mouse) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.MOUSE);
            equipamentoEspecificacao.setTipoConexao(mouse.getTipoConexao());
        }
        else if (equipamento instanceof Telefone) {
            Telefone telefone = (Telefone) equipamento;
            equipamentoEspecificacao.setTipoEquipamento(TipoEquipamento.TELEFONE);
            equipamentoEspecificacao.setIp(telefone.getIp());
            equipamentoEspecificacao.setSemFio(telefone.getSemFio());
        }
        return equipamentoEspecificacao;
    }

    private List<EquipamentoEspecificacao> convertToListEquipamentoModel(List<Equipamento> listaEquipamento) {
        ArrayList<EquipamentoEspecificacao> listaEquipamentoEspecificacao = new ArrayList<>();

        for (Equipamento equipamento : listaEquipamento) {
            listaEquipamentoEspecificacao.add(convertEquipamentoModel(equipamento));
        }

        return listaEquipamentoEspecificacao;
    }


}