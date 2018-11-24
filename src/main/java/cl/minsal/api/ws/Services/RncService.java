package cl.minsal.api.ws.Services;

import java.util.Date;

public interface RncService {

    void bookLeave(Date startDate, Date endDate, String name);
}