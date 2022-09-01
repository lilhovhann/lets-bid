package io.project.app.letsbid.services;

import io.project.app.letsbid.domain.request.BidRequest;
import io.project.app.letsbid.domain.response.Bid;
import io.project.app.letsbid.domain.response.BidResponse;
import io.project.app.letsbid.domain.response.SeatBid;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class BidProcessingService {

    @Autowired
    private BidService bidService;
    
    private static HashMap<String, Integer> categoryCount = new HashMap<>();

    public BidResponse processBid(BidRequest request) {
        
        countCategoryDistribution(request.getBcat());
        
        BidResponse bidResponse = new BidResponse();

        if (request.getImp().get(0).getBanner().getH() > 300) {

            Optional<Bid> foundBid = findRandomBidWithCategory(request.getBcat());
            if (foundBid.isPresent()) {
                bidResponse = bidService.findBidResponseById(foundBid.get().getSourceObjectId()).get();
                bidResponse.setId(String.valueOf(request.getId()));
                bidResponse.getSeatBid().get(0).getBid().get(0).setImpId(String.valueOf(request.getImp().get(0).getId()));
                log.info("OKAY LETS BID: BID RESPONSE: ==> " + bidResponse.toString());
                return bidResponse;
            }

            bidResponse.setId(String.valueOf(request.getId()));
            bidResponse.setSeatBid(new ArrayList<SeatBid>());
            bidResponse.setNbr(8);
            log.info("============================================================");
            log.info("NO BID: BID RESPONSE: ==> " + bidResponse.toString());
            return bidResponse;

        }
        log.info("============================================================");
        log.info("NO BID: BID RESPONSE: ==> " + bidResponse.toString());

        return bidResponse;

    }

    private Optional<Bid> findRandomBidWithCategory(ArrayList<String> categories) {
        List<Bid> foundBids = bidService.findByCategoriesNotIn(categories);
        if (!foundBids.isEmpty()) {
            log.info("============================================================");
            log.info("FOUND BIDS WITHOUT BLOCKED CATEGORY ");
            log.info("============================================================");
            Random rand = new Random();
            int randomNumberUpperBound = foundBids.size();
            return Optional.of(foundBids.get(rand.nextInt(randomNumberUpperBound)));
        }
        return Optional.empty();
    }

    private void countCategoryDistribution(ArrayList<String> categories) {

        for (String category : categories) {
            if (categoryCount.containsKey(category)) {
                categoryCount.put(category, categoryCount.get(category) + 1);
            } else {
                categoryCount.put(category, 1);
            }
        }
    }

    public HashMap<String, Integer> getCategoryCount() {
        return categoryCount;
    }
    
    

}
