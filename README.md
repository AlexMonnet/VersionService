# VersionService
A basic java-based webservice that compares version numbers.

## Running The Service
Running the service is handled simply by gradle and spring boot. Run the following command to run the service.

`./gradlew run`

## Testing The Service
Testing the service is handled by gradle. Run the following command to test the service.

`./gradlew test`

## Executing String Comparison
After running the service you can compare strings by making a get request to the localhost:port of the service. The port that service is listening on is determined by the 'port' value in the [application.yml file.](/web-service/src/main/resources/application.yml) 

## Example Execution
### Browser
`localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.7`

Returns a simple response with only "before"

`localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.5`

Returns a simple response with only "after"

`localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.6`

Returns a simple response with only "equal"

### Curl
`curl "localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.7"`

Returns "before"

`curl "localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.5"`

Returns "after"

`curl "localhost:8080/api/compareVersions?sourceVersion=2.6&targetVersion=2.6"`

Returns "equal"
