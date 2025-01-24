# Cheapest-Transfer-Route
#Prerequisites
Java 17 (or higher, I used 23)
Gradle 

#Build the project using Gradle:
./gradlew build

#To test the JAR file:
java -jar build/libs/Cheapest-Transfer-Route-0.0.1-SNAPSHOT.jar   //it might be different for you

#testing
Postman or Curl (optional for testing)
I used postman ~
http://localhost:8080/api/transfers/optimal-route

{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}

example answer: 
{"totalWeight":15,"totalCost":30,"selectedTransfers":[{"weight":5,"cost":10},{"weight":10,"cost":20}]}


Instead of curl, i also used PowerShells' built-in Invoke-RestMethod for HTTP requests.
Invoke-RestMethod -Uri "http://localhost:8080/api/transfers/optimal-route" -Method Post -Headers @{ "Content-Type" = "application/json" } -Body '{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}'

example answer:   15        30 {@{weight=5; cost=10}, @{weight=10; cost=20}}
