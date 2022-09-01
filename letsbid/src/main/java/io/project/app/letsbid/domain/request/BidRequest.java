package io.project.app.letsbid.domain.request;

import java.util.ArrayList;
import lombok.Data;

@Data
public class BidRequest{

    private int id;
    private ArrayList<Imp> imp = new ArrayList<>();
    private Device device = new Device();
    private User user = new User();
    private int at;
    private ArrayList<String> bcat = new ArrayList<>();
}
