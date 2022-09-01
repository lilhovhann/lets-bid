package io.project.app.letsbid.services;

import io.project.app.letsbid.domain.response.Bid;
import io.project.app.letsbid.domain.response.BidResponse;
import io.project.app.letsbid.repositories.BidRepository;
import io.project.app.letsbid.repositories.BidResponseRepository;
import io.project.app.letsbid.utils.BidGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class BidService {

    @Autowired
    private BidResponseRepository bidResponseRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private BidGenerator bidGenerator;
    
    private static int counter;

    public void generateAds() {

        
        if (counter==0) {
            log.info("Generating ads to bid with...");
            deleteAllBidResponses();
            deleteAllBids();
            BidResponse bidResponse1 = bidGenerator.generateBidResponse(
                    "1", 1, "1111",
                    "http://example.com/winnoticeurl1",
                    "http://adserver.com/pathtosampleimage1",
                    new ArrayList<String>(Arrays.asList("advertiserdomain.com")),
                    "com.intent.first",
                    "campaign111",
                    "creative111",
                    new ArrayList<String>(Arrays.asList("IAB3-12", "IAB3-8")),
                    new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                    251, 261, "111", "abc1111", "USD");

            BidResponse bidResponse2 = bidGenerator.generateBidResponse(
                    "2", 2, "2222",
                    "http://example.com/winnoticeurl2",
                    "http://adserver.com/pathtosampleimage2",
                    new ArrayList<String>(Arrays.asList("google.com")),
                    "com.intent.second",
                    "campaign222",
                    "creative222",
                    new ArrayList<String>(Arrays.asList("IAB3-6", "IAB3-5")),
                    new ArrayList<Integer>(Arrays.asList(4, 5, 6)),
                    252, 262, "222", "abc2222", "USD");

            BidResponse bidResponse3 = bidGenerator.generateBidResponse(
                    "3", 3, "3333",
                    "http://example.com/winnoticeurl3",
                    "http://adserver.com/pathtosampleimage3",
                    new ArrayList<String>(Arrays.asList("facebook.com")),
                    "com.intent.third",
                    "campaign333",
                    "creative333",
                    new ArrayList<String>(Arrays.asList("IAB3-11", "IAB3-10")),
                    new ArrayList<Integer>(Arrays.asList(7, 8, 9)),
                    253, 263, "333", "abc3333", "USD");  
            ++counter;
        }
    }

    
    public List<Bid> findByCategoriesNotIn(ArrayList<String> blockedCaregories){
       return bidRepository.findAllByCategoriesNotIn(blockedCaregories);
    }
    
     public  Optional<BidResponse> findBidResponseById(String id) {
        Optional<BidResponse> foundBidResponse = bidResponseRepository.findById(id);
        
        if(foundBidResponse.isPresent()){
            log.info("Found BidResponse with id "+id);
            return foundBidResponse;
        }
        return Optional.empty();
    }
             
    public BidResponse saveBidResponse(BidResponse bidResponse) {
        return bidResponseRepository.save(bidResponse);
    }
    
    public Bid saveBid(Bid bid) {
        return bidRepository.save(bid);
    }
    
    public void deleteAllBidResponses() {
        bidResponseRepository.deleteAll();
    }
    
    public void deleteAllBids() {
        bidRepository.deleteAll();
    }
    
}
