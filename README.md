# One Room Booking API

This REST api enable you to book only one room.
You can check the room availability, book the room, update your reservation and cancel it.

This API was developped using SpringBoot 2.4.4 and java 11.

# REST service definition

You can find the service definition at ***http://localhost:8080/swagger-ui/index.html***

There are two resources available: /rooms and /bookings.

6 service are available:
- GET /rooms
For the purpose of the test only one resource is returned.

- GET /rooms/{id}
This service return the room resource with details regarding the options of the room.

- GET /rooms/{id}/check
2 query parameters required: checkIn and checkOut
This enable you to check the availibily of the room.

- POST /bookings
This service enable you to book a room.

Requet body example with required attributs:

```javascript`
{
    "firstName": "John",
    "lastName": "zaaz",
    "email": "aze@apitest.fr",
    "phoneNumber": "09110922023",
    "roomId": 1,
    "checkIn": "2021-04-27",
    "checkOut": "2021-04-28"
}
```
After succesfully booked a room, the location of the reservation can be found on the header "Location" attribute.

* POST /bookings/{reservationNumber}
This service enable you to check your reservation

- PUT /bookings/{reservationNumber}
This service enable you to update your reservation.
The request body is the as for as the POST service.

- Delete /bookings/{reservationNumber}
This service enable you to cancel your reservation.

Please check the service definition at http://localhost:8080/swagger-ui/index.html to more details on how to use the One room booking api.

# Run the SpringBoot application

After cloned the project you can run the application using **mvnw spring-boot:run** (Run at project root)
You also import the project in you favorite IDE and run it.

There is an instance of CommandLineRunner used to initialise the H2 in-memory database to inject mock datas.

#Run the test

To run the test just run **mvnw test**

