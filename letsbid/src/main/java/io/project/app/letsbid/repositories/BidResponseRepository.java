package io.project.app.letsbid.repositories;

import io.project.app.letsbid.domain.response.BidResponse;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BidResponseRepository extends MongoRepository<BidResponse, String> {
    Optional<BidResponse> findFirstByBidId(String bidid);
    
       
}
