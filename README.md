The goal of this project is to have a service integrated with fake ad-exchange service.
Please refer to the Google's OpenRTB documentation for information.
The provided container expects only a single env which meant to be the final service bidder endpoint. The bidder service will be registered in the ad-exchange so that it can receive requests.

## Requirements
- A service which can answer bid requests in OpenRTB made by the fake ad-exchange.
- A service which can have a way to pre-configure very basic ad campaigns (db, file-system or hardcoded) to bid with.
- The bidder should respect blocked IAB categories from the bid request.
- An ideal solution should run in docker environment with docker compose command and include a Dockerfile in the solution.
**Bonus point:** Capture
 some auction metrics, i.e distribution of bid requests per IAB category.

## Installations

- install maven
- install docker
- install docker-compose

## Let's run it 
`./run.sh`

Now you will see how the system is sending bid requests and getting bid responses if necessary.

## Swagger
You can check the endpoints in swagger as well http://localhost:9095/swagger-ui.html

## To check category distribution, check this endpoint
/api/v2/bids/metrics/get/category