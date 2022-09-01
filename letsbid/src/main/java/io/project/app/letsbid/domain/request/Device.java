package io.project.app.letsbid.domain.request;

import lombok.Data;

@Data
public class Device {
    private String ua;
    private Geo geo = new Geo();
    private String ip;
    private int devicetype;
    private String os;
    
}
