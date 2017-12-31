-----Description
This simple application has been designed as apprenticeship task. It launches REST service to record transactions of car dealer. It uses Spring Boot framework and is built with Maven.

Launching application creates endpoint for REST service at http://localhost:8080/transactions/
At the start 2 transactions will be created to populate "database", all transactions are kept in app, there is no database at this point.
Using GET request without any additional parameters will result in getting all recorded transaction id JSON format.
Using GET request with an ID as parameter will result in getting details of single transaction with that ID.
Using DELETE request with ID will delete single transaction with that ID.
Using POST request with body in JSON format will create new transaction details.
Using PUT request with body in JSON format will update already recorded transaction.

-----Examples:
GET http://localhost:8080/transactions/ - will result in getting response with all transactions in applitaction
GET http://localhost:8080/transactions/1 - will result in getting response with single transaction with ID 1
DELETE http://localhost:8080/transactions/1 - will result in deleting single transaction with ID 1
POST http://localhost:8080/transactions/ - will result in creating single transaction with next ID, body example below:

"{
        "id": 20,
        "customerFirstName": "John",
        "customerLastName": "Smith",
        "customerBirthDate": null,
        "customerGender": null,
        "customerPESEL": null,
        "vehicleRegisterNumber": null,
        "vehicleFirstRegistrationDate": null,
        "vehicleUserName": null,
        "vehicleUserPESEL": null,
        "vehicleUserAddress": null,
        "vehicleOwnerName": null,
        "vehicleOwnerPESEL": null,
        "vehicleOwnerAddress": null,
        "vehicleBrand": null,
        "vehicleType": null,
        "vehicleModel": null,
        "vehicleIdentificationNumber": null,
        "vehicleMaxTotalMass": null,
        "vehiclePermissableMass": null,
        "vehiclePermissableMassGroup": null,
        "vehicleMassOwn": null,
        "vehicleRegisterExpiryDate": null,
        "vehicleRegisterSetUpDate": null,
        "vehicleCategory": null,
        "vehicleApprovalNumber": null,
        "vehicleNumberOfAxles": null,
        "vehicleTruckTrailerTotalMassWithBreaks": null,
        "vehicleTruckTrailerTotalMassWithoutBreaks": null,
        "vehicleEngineCapacity": null,
        "vehicleEngineMaxNetPower": null,
        "vehicleFuelType": null,
        "vehiclePowerToMass": null,
        "vehicleSeats": null,
        "vehicleStandingPlaces": null
    }"

Id parameter will be ignored, and will be set to next Id in application, body must contain full object in JSON body.

PUT http://localhost:8080/transactions/1 - will result in updating transaction with id 1. PUT request should have full body, any JSON parameters that are not passed will update data to "null". Body example same as in POST request.

-----Tests:
Tests have been made with JUnit. They tests all methods in TransactionService.class by getting all transaction, transaction with ID 1, deleting transaction with ID 0, updating transaction with ID 1 and HttpError404 Not Found Exception by trying to delete transaction with ID 20.

