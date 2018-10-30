package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class BeneficiarioValidator implements DocumentoValidator {
    String elemento = "BeneficiarioFonasa";

    @Override
    public void validate(Documento documento) {
        String beneficiarioFonasa = documento.getBodyDoc().getDiagnosticoDoc().getDatosDemograficos().getBeneficiarioFonasa();
        Integer prevision = documento.getBodyDoc().getDiagnosticoDoc().getDatosDemograficos().getPrevision();
        if (prevision == 1){
            if (beneficiarioFonasa == null) {
                throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
            }
            Boolean isValid = beneficiarioFonasa.toUpperCase().equals("A") ||
                    beneficiarioFonasa.toUpperCase().equals("B") ||
                    beneficiarioFonasa.toUpperCase().equals("C") ||
                    beneficiarioFonasa.toUpperCase().equals("D") ;
            if(!isValid){
                throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
            }
        }
    }
}