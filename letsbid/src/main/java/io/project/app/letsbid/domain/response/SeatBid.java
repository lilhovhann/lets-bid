package io.project.app.letsbid.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatBid {
    
    @JsonProperty("bid")
    @ApiModelProperty(value = "Array of 1+ Bid objects each related to an impression. Multiple bids can relate to the same impression..")
    private ArrayList<Bid> bid = new ArrayList<>();
    
    @JsonProperty("seat")
    @ApiModelProperty(value = "ID of the buyer seat (e.g., advertiser, agency) on whose behalf this bid is made.")
    private String seat;
    
    @JsonProperty("group")
    @ApiModelProperty(value = "0 = impressions can be won individually; 1 = impressions must be won or lost as a group.")
    private int group;
    
    @JsonProperty("ext")
    @ApiModelProperty(value = "Placeholder for bidder-specific extensions to OpenRTB.")
    private Ext ext;

    public SeatBid(ArrayList<Bid> bid, String seat) {
        this.bid = bid;
        this.seat = seat;
    }
    
    
    
}
