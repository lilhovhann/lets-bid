package io.project.app.letsbid.domain.request;

import lombok.Data;

@Data
public class Geo {
    private int lat;
    private int lon;
    private String country;
    private String region;
    private String metro;
    private String city;
    private int zip;
}
