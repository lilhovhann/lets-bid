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
public class BidResponse{

    @JsonProperty("id")
    @ApiModelProperty(value = "Reflection of the bid request ID for logging purposes")
    private String id;

    @JsonProperty("seatbid")
    @ApiModelProperty(value = "Array of seatbid objects")
    private ArrayList<SeatBid> seatBid = new ArrayList<>();

    @JsonProperty("bidid")
    @ApiModelProperty(value = "Optional response tracking ID for bidders")
    private String bidId;
    
    @JsonProperty("cur")
    @ApiModelProperty(value = "Bid currency")
    private String currency;
    
    @JsonProperty("customdata")
    @ApiModelProperty(value = "Encoded user features")
    private String customdata;
    
    @JsonProperty("nbr")
    @ApiModelProperty(value = "Reason for not bidding, where 0 = unknown error, 1 = technical error, 2 = invalid request, 3 = known web spider, 4 = suspected Non-Human Traffic, 5 = cloud, data center, or proxy IP, 6 = unsupported device, 7 = blocked publisher or site, 8 = unmatched user")
    private int nbr = 1;
    
    @JsonProperty("ext")
    @ApiModelProperty(value = "Placeholder for bidder-specific extensions to OpenRTB.")
    private Ext ext;

}
