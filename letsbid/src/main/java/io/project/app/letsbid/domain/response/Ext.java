package io.project.app.letsbid.domain.response;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ext {
    
    private ArrayList<Integer> attribute = new ArrayList<>();
    private ArrayList<String> impression_tracking_url = new ArrayList<>();
    private EventNotificationToken event_notification_token = new EventNotificationToken();
    private int processing_time_ms;
    
}
