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
public class Bid {

    @JsonProperty("id")
    private String id;

    @JsonProperty("impid")
    @ApiModelProperty(value = "Required string ID of the impression object to which this bid applies.")
    private String impId;

    @JsonProperty("price")
    @ApiModelProperty(value = "Bid price in CPM. Suggests using integer math for accounting to avoid rounding errors.")
    private float price;

    @JsonProperty("adid")
    @ApiModelProperty(value = "References the ad to be served if the bid wins.")
    private String adId;

    @JsonProperty("nurl")
    @ApiModelProperty(value = "Win notice URL")
    private String noticeURL;

    @JsonProperty("lurl")
    @ApiModelProperty(value = "Loss notice URL")
    private String lossURL;

    @JsonProperty("adm")
    @ApiModelProperty(value = "Actual ad markup. XHTML if a response to a banner object, or VAST XML if a response to a video object")
    private String adMarkup;

    @JsonProperty("adomain")
    @ApiModelProperty(value = "Advertiser’s primary or top-level domain for advertiser checking; or multiple if imp rotating")
    private ArrayList<String> advDomains;

    @JsonProperty("bundle")
    @ApiModelProperty(value = "A platform-specific application identifier intended to be unique to the app and independent of the exchange")
    private String bundle;

    @JsonProperty("iurl")
    @ApiModelProperty(value = "Sample image URL")
    private String imageURL;

    @JsonProperty("cid")
    @ApiModelProperty(value = "Campaign ID that appears with the Ad markup")
    private String campaignID;

    @JsonProperty("crid")
    @ApiModelProperty(value = "Creative ID for reporting content issues or defects. This could also be used as a reference to a creative ID that is posted with an exchange")
    private String creativeId;
    
    @JsonProperty("tactic")
    @ApiModelProperty(value = "Tactic ID to enable buyers to label bids for reporting to the exchange the tactic through which their bid was submitted.")
    private String tactic;
    
    @JsonProperty("cat")
    @ApiModelProperty(value = "IAB content categories of the creative")
    private ArrayList<String> categories;
    
    @JsonProperty("attr")
    @ApiModelProperty(value = "Array of creative attributes")
    private ArrayList<Integer> attrs;
    
    @JsonProperty("api")
    @ApiModelProperty(value = "API required by the markup if applicable")
    private int api;
    
    @JsonProperty("protocol")
    @ApiModelProperty(value = "Video response protocol of the markup if applicable")
    private int protocol;
      
    @JsonProperty("qagmediarating")
    @ApiModelProperty(value = "creative media rating per IQG guidelines")
    private int mediaRating;
    
    @JsonProperty("language")
    @ApiModelProperty(value = "Language of the creative using ISO-639-1-alpha-2")
    private String language;
    
    @JsonProperty("dealid")
    @ApiModelProperty(value = "DealID extension of private marketplace deals")
    private String dealId;
    
    @JsonProperty("w")
    @ApiModelProperty(value = "Width of the ad in pixels")
    private int width;
    
    @JsonProperty("h")
    @ApiModelProperty(value = "Height of the ad in pixels")
    private int height;
    
    @JsonProperty("wratio")
    @ApiModelProperty(value = "Relative width of the creative when expressing size as a ratio.")
    private int widthRatio;
    
    @JsonProperty("hratio")
    @ApiModelProperty(value = "Relative height of the creative when expressing size as a ratio")
    private int heightRatio;
    
    @JsonProperty("exp")
    @ApiModelProperty(value = "Advisory as to the number of seconds the bidder is willing to wait between the auction and the actual impression.")
    private int exp;
    
    @JsonProperty("ext")
    @ApiModelProperty(value = "Placeholder for bidder-specific extensions to OpenRTB.")
    private Ext ext;
    
    
    private String sourceObjectId; //parentId
    

    
}
