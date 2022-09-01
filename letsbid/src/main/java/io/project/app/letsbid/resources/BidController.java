package io.project.app.letsbid.resources;

import io.micrometer.core.annotation.Timed;
import io.project.app.letsbid.domain.request.BidRequest;
import io.project.app.letsbid.domain.response.BidResponse;
import io.project.app.letsbid.repositories.BidResponseRepository;
import io.project.app.letsbid.services.BidProcessingService;
import io.project.app.letsbid.services.BidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v2/bids")
@Slf4j
public class BidController {

    @Autowired
    public BidService bidService;

    @Autowired
    public BidResponseRepository bidRepository;

    @Autowired
    public BidProcessingService bidProcessingService;

    @Autowired
    public BidResponseRepository bidRequestRepository;

    @PostMapping(path = "process/bid")
    @CrossOrigin
    @Timed
    @ApiOperation(value = "Process Bid", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Processed successfully"),
        @ApiResponse(code = 400, message = "Could not process")
    }
    )

    public ResponseEntity<?> processBid(@RequestBody BidRequest request) {

        log.info("Processing the bid...");
        log.info("BID: " + request.toString());

        bidService.generateAds();
        BidResponse result = bidProcessingService.processBid(request);

        if (result.getNbr() >= 1) {
            log.info("########################################################################################################");
            log.info("########################################################################################################");
            log.info("########################################################################################################");
            log.info("########################################################################################################");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        log.info("########################################################################################################");
        log.info("########################################################################################################");
        log.info("########################################################################################################");
        log.info("########################################################################################################");
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping(path = "find/all")
    @CrossOrigin
    @Timed
    @ApiOperation(value = "Process Bid", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Processed successfully"),
        @ApiResponse(code = 400, message = "Could not process")
    }
    )

    public ResponseEntity<?> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(bidRepository.findAll());

    }
    
    @GetMapping(path = "/metrics/get/category")
    @CrossOrigin
    @Timed
    @ApiOperation(value = "Distribution", response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Processed successfully"),
        @ApiResponse(code = 400, message = "Could not process")
    }
    )

    public ResponseEntity<?> getCatDistribution() {

        return ResponseEntity.status(HttpStatus.OK).body(bidProcessingService.getCategoryCount());

    }

}
