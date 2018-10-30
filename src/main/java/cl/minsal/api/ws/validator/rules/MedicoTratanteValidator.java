package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class MedicoTratanteValidator implements DocumentoValidator {
    String elemento = "MedicoTratante";

    @Override
    public void validate(Documento documento) {
        String medico_tratante = documento.getBodyDoc().getResolucionTratamientoDoc().getMedicoTratante();
//        if (medico_tratante == null || medico_tratante.trim().isEmpty()) {
//            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
//        }
    }
}

