package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class ResolucionComiteValidator implements DocumentoValidator {
    String elemento = "ResolucionComite";

    @Override
    public void validate(Documento documento) {
        String resolucion_comite = documento.getBodyDoc().getResolucionTratamientoDoc().getTratamientoGeneral().getResolucionComite();
        if (resolucion_comite == null || resolucion_comite.trim().isEmpty()) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        try {
            Integer.parseInt( resolucion_comite );
        }
        catch( NumberFormatException e ) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
        Boolean isValid = Integer.parseInt(resolucion_comite) > 1 || Integer.parseInt(resolucion_comite) < 255;
        if (!isValid) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
