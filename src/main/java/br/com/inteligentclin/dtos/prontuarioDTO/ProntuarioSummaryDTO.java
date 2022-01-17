package br.com.inteligentclin.dtos.prontuarioDTO;

import br.com.inteligentclin.dtos.dentistaDTO.DentistaSummaryDTO;
import br.com.inteligentclin.dtos.pacienteDTO.PacienteMixProntuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProntuarioSummaryDTO implements Serializable {

    private static final long seriaVersionUID = 1L;

    private Long id;

    @NotNull(message = "Por gentileza, informe a qual paciente pertence esse prontuário.")
    private PacienteMixProntuarioDTO paciente;

    @NotNull(message = "É necessário informar qual o dentista responsável pelo paciente dono desse prontuário.")
    private DentistaSummaryDTO dentista;

}
