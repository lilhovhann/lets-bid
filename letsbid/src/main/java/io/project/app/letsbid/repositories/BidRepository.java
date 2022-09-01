package io.project.app.letsbid.repositories;

import io.project.app.letsbid.domain.response.Bid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findAllByCategoriesNotIn(ArrayList<String> categories);
    
       
}
