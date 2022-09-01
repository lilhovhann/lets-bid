The goal of this exercise is to write a service in any programming language (golang is prefered) to integrate with our fake ad-exchange service, which is provided as a Docker container in the file docker-compose.yaml of this repository. Please refer to the Google's OpenRTB documentation for information on how to interact with the API. The provided container expects only a single env which meant to be the final service bidder endpoint. The bidder service should register itself with the ad-exchange so that it can receive requests.

## Requirements
- A service which can answer bid requests in OpenRTB made by the fake ad-exchange.
- A service which can have a way to pre-configure very basic ad campaigns (db, file-system or hardcoded) to bid with.
- The bidder should respect blocked IAB categories from the bid request.
- An ideal solution should run in docker environment with docker compose command and include a Dockerfile in the solution.
**Bonus point:** Capture some auction metrics, i.e distribution of bid requests per IAB category.

## Start with cleaning (always start with cleaning 🧹 😁 )
`./clean.sh`

## Now let's run it
`./run.sh`

Now you will see how the system is sending bid requests and getting bid responses if necessary.

## Swagger
You can check the endpoints in swagger as well http://localhost:9095/swagger-ui.html

## To check category distribution, check this endpoint
/api/v2/bids/metrics/get/category