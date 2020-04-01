package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		validarPessoa(lancamento);
		
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoRecuperado = buscarLancamentoPorCodigo(codigo);
		if(!lancamento.getPessoa().equals(lancamentoRecuperado.getPessoa())) {
			validarPessoa(lancamentoRecuperado);	
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoRecuperado, "codigo");
		return lancamentoRepository.save(lancamentoRecuperado);
	}

	private Lancamento buscarLancamentoPorCodigo(Long codigo) {
		Optional<Lancamento> lancamentoOptional = lancamentoRepository.findById(codigo);
		
		if(!lancamentoOptional.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return lancamentoOptional.get();
	}
	
	private void validarPessoa(Lancamento lancamento) {
		Optional<Pessoa> pessoaOptional = null;
		
		if(lancamento.getPessoa().getCodigo() != null) {
			pessoaOptional = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		}
		
		if(pessoaOptional == null || !pessoaOptional.isPresent() || pessoaOptional.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
	}

}
