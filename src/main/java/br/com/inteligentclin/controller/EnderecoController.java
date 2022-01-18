package br.com.inteligentclin.controller;

import br.com.inteligentclin.dtos.enderecoDTO.EnderecoModelDTO;
import br.com.inteligentclin.dtos.enderecoDTO.EnderecoSummaryDTO;
import br.com.inteligentclin.service.EnderecoService;
import br.com.inteligentclin.service.exception.EntidadeRelacionadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

//    @PostMapping
//    @Transactional
//    @ResponseStatus(HttpStatus.CREATED)
//    public EnderecoModelDTO salvar(@RequestBody EnderecoModelDTO enderecoDTO) {
//        return enderecoService.salvar(enderecoDTO);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoModelDTO buscarPorId(@PathVariable("id") Long id) {
        return enderecoService.buscarPorId(id).get();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<EnderecoSummaryDTO> buscarTodos(Pageable pageable) {
        return enderecoService.buscarTodos(pageable);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable("id") Long id) throws EntidadeRelacionadaException {
        enderecoService.excluirPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@PathVariable("id") Long id, @RequestBody EnderecoModelDTO enderecoDTO) {
        enderecoService.atualizar(id, enderecoDTO);
    }

}

