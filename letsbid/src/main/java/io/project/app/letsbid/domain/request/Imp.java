package io.project.app.letsbid.domain.request;

import lombok.Data;

@Data
public class Imp {
    private int id;
    private Banner banner = new Banner();
    private Ext ext = new Ext();
}
