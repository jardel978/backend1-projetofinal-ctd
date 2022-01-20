package br.com.inteligentclin.controller;

import br.com.inteligentclin.entity.File;
import br.com.inteligentclin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/{idProntuario}")
    @Transactional
//    @PreAuthorize("hasRole('ROLE')")
    public ResponseEntity<File> salvar(@RequestBody MultipartFile file, @PathVariable("idProntuario") Long idProntuario) {
        File fileSalvo = fileService.salvar(file, idProntuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(fileSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<File>> buscarTodos(Pageable pageable) {
        Page<File> page = fileService.buscarTodos(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<File> atualizar(@PathVariable("id") Long id, @RequestBody MultipartFile file) throws IOException {
        File fileAtualizado = fileService.atualizar(id, file);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(fileAtualizado);
    }

}
