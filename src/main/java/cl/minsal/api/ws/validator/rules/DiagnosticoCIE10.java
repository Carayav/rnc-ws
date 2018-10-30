package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class DiagnosticoCIE10 implements DocumentoValidator {
    String elemento = "DiagnosticoCIE10";
    @Override
    public void validate(Documento documento) {
        String diagnosticoCIE10 = documento.getBodyDoc().getDiagnosticoDoc().getDiagnostico().getDiagnosticoCIE10();
        if (diagnosticoCIE10 == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (diagnosticoCIE10.trim().isEmpty()){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (diagnosticoCIE10.length() < 2) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        } if (diagnosticoCIE10.length() > 8) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
