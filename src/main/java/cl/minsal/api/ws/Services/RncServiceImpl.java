package cl.minsal.api.ws.Services;

import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class RncServiceImpl implements RncService {
    public void bookLeave(Date startDate, Date endDate, String name) {
        System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] " +
                "for [" + name + "] ");
    }

}


