
./gradlew build

(!) Some deps must be removed from jar:
everything under org/ except bson/

cp build/libs/graphql-bdm-service-1.0-SNAPSHOT.jar /home/bonita/Versions/7.7/7.7.0-GA/BonitaStudioSubscription-7.7.0/workspace/tomcat/server/webapps/bonita/WEB-INF/lib

Test Query:
http://localhost:8080/bonita/graphql?query=%7B%0AallBooks%7B%0Aname%0A%7D%0A%7D
URL encoded version of http://localhost:8080/bonita/graphql?query={allBooks{name}}

http://localhost:8080/bonita/graphql?query=%7BallLoans%7Bcustomer%2Ctype%2Cstatus%7D%7D



Exposing the endpoint on /API/graphql would allow to preview in the UID but requires to update REST API security
