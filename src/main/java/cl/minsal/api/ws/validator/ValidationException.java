package cl.minsal.api.ws.validator;

public class ValidationException  extends RuntimeException {

    String code;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public ValidationException(String errorMessage, String code) {
        super(errorMessage);
        this.code = code;
    }
}
