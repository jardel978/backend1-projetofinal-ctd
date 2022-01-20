package br.com.inteligentclin.dtos.dentistaDTO;

import br.com.inteligentclin.dtos.PessoaModelDTO;
import br.com.inteligentclin.dtos.consultaDTO.ConsultaMixClasseModelDTO;
import br.com.inteligentclin.dtos.prontuarioDTO.ProntuarioMixDentistaModelDTO;
import br.com.inteligentclin.entity.enums.Especialidade;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DentistaModelDTO extends PessoaModelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O número de matrícula do dentista é obrigatório.")
    private String matricula;

    private List<Especialidade> especialidades;

    private Set<ConsultaMixClasseModelDTO> consultas;

    private Set<ProntuarioMixDentistaModelDTO> prontuarios;

}
