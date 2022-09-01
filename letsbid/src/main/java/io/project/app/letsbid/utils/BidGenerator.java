package io.project.app.letsbid.utils;

import io.project.app.letsbid.domain.response.Bid;
import io.project.app.letsbid.domain.response.BidResponse;
import io.project.app.letsbid.domain.response.SeatBid;
import io.project.app.letsbid.services.BidService;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lilit_Hovhannisyan
 */
@Service
@Slf4j
public class BidGenerator {

    @Autowired
    private BidService bidService;

    public BidResponse generateBidResponse(String id,
            float price,
            String adId,
            String noticeURL,
            String imageURL,
            ArrayList<String> advDomains,
            String bundle,
            String campaignID,
            String creativeId,
            ArrayList<String> categories,
            ArrayList<Integer> attrs,
            int width,
            int height,
            String seat,
            String bidId,
            String currency) {

        BidResponse bidResponse = new BidResponse();
        bidResponse.setBidId(bidId);
        bidResponse.setCurrency(currency);
        bidResponse = bidService.saveBidResponse(bidResponse);

        Bid bid = generateBid(bidResponse.getId(), id, price, adId, noticeURL, imageURL, advDomains, bundle, campaignID, creativeId, categories, attrs, width, height);

        bidResponse.getSeatBid().add(new SeatBid(new ArrayList<Bid>(Arrays.asList(bid)), seat));
        bidService.saveBidResponse(bidResponse);
        return bidResponse;
    }

    private Bid generateBid(String sourceObjectId,
            String id,
            float price,
            String adId,
            String noticeURL,
            String imageURL,
            ArrayList<String> advDomains,
            String bundle,
            String campaignID,
            String creativeId,
            ArrayList<String> categories,
            ArrayList<Integer> attrs,
            int width,
            int height) {
        Bid bid = new Bid();

        bid.setId(id);
        bid.setPrice(price);
        bid.setAdId(adId);
        bid.setNoticeURL(noticeURL);
        bid.setImageURL(imageURL);
        bid.setAdvDomains(advDomains);
        bid.setBundle(bundle);
        bid.setCampaignID(campaignID);
        bid.setCreativeId(creativeId);
        bid.setCategories(categories);
        bid.setAttrs(attrs);
        bid.setWidth(width);
        bid.setHeight(height);
        bid.setSourceObjectId(sourceObjectId);

        return bidService.saveBid(bid);
    }

}
