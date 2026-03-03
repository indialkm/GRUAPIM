package repository;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conta;
import model.ContaInvestimentoAutomatico;

public class ContaRepository {

    private ClienteRepository clienteRepository;

    public ContaRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void adicionar(String documentoCliente, Conta novaConta) {
        Cliente cliente = clienteRepository.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            cliente.getContas().add(novaConta);
        }
    }

    public List<Conta> listarPorCliente(String documentoCliente) {
        Cliente cliente = clienteRepository.buscarPorDocumento(documentoCliente);
        return (cliente != null) ? cliente.getContas() : new ArrayList<>();
    }

    public Conta buscarPorNumero(String documentoCliente, String numeroConta) {
        Cliente cliente = clienteRepository.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero().equals(numeroConta)) {
                    return conta;
                }
            }
        }
        return null;
    }
   
    public Conta buscarPorDocumentoContaInvestimento(String documentoCliente) {
    	
    	List<Conta> contas = this.listarPorCliente(documentoCliente);
    	
    	return contas.stream()
                .filter(item -> item instanceof ContaInvestimentoAutomatico)
                .findFirst()
                .orElse(null);
    	
    	
    }

    public boolean remover(String documentoCliente, String numeroConta) {
        Cliente cliente = clienteRepository.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            Conta conta = buscarPorNumero(documentoCliente, numeroConta);
            if (conta != null) {
                return cliente.getContas().remove(conta);
            }
        }
        return false;
    }

    public boolean atualizar(String documentoCliente, String numeroOriginal, Conta contaAtualizada) {
        Cliente cliente = clienteRepository.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            List<Conta> contas = cliente.getContas();
            for (int i = 0; i < contas.size(); i++) {
                if (contas.get(i).getNumero().equals(numeroOriginal)) {
                    if (!numeroOriginal.equals(contaAtualizada.getNumero())) {
                        return false;
                    }
                    contas.set(i, contaAtualizada);
                    return true;
                }
            }
        }
        return false;
    }
}