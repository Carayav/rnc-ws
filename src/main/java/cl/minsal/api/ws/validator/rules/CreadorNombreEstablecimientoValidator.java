package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;

public class CreadorNombreEstablecimientoValidator implements DocumentoValidator {
    String elemento = "NombreEstablecimiento";
    @Override
    public void validate(Documento documento) {
        String establecimiento = documento.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getNombreEstablecimiento();
        if (establecimiento == null) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (!establecimiento.toLowerCase().equals("Instituto Nacional del Cancer".toLowerCase())) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }

    }
}
