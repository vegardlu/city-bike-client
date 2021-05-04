mvn clean install
docker build -t vegardlu/orange-lights:0.0.1 .
docker tag vegardlu/orange-lights:0.0.1 vegardlu/orange-lights:latest
docker push vegardlu/orange-lights:latest
docker push vegardlu/orange-lights:0.0.1