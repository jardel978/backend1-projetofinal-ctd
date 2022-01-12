package br.com.inteligentclin.dtos.pacienteDTO;

import br.com.inteligentclin.dtos.PessoaModelDTO;
import br.com.inteligentclin.dtos.enderecoDTO.EnderecoModelDTO;
import br.com.inteligentclin.entity.Consulta;
import br.com.inteligentclin.entity.Endereco;
import br.com.inteligentclin.entity.Idade;
import br.com.inteligentclin.entity.Prontuario;
import br.com.inteligentclin.entity.enums.Sexo;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModelDTO extends PessoaModelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate dataNascimento;

    private Idade idade;

    private Endereco endereco;

    private Set<Consulta> consultas;

    private Prontuario prontuario;

    private Sexo sexo;

}