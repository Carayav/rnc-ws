package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

public class GeneroValidator implements DocumentoValidator {
    String elemento = "Genero";
    @Override
    public void validate(Documento documento) {
        BigInteger genero = documento.getHeaderDoc().getPaciente().getGenero();
        if (genero != null) {
            Boolean isValid = genero.intValue() == 1 ||
                    genero.intValue() == 2 ||
                    genero.intValue() == 3 ||
                    genero.intValue() == 9;
            if (!isValid) {
                throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
            }
        }
    }
}