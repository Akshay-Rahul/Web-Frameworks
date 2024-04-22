# Overview:

Build a web application that facilitates POST and GET operations for managing Car details using JPA methods via RESTful APIs.

# Functional Requirements:

Create folders named as controller, model, repository and service inside the WORKSPACE/springapp/src/main/java.com/examly/springapp.

Inside controller folder, create a class named"CarControIler".
Inside model folder, create a class named "Car" with the following attributes:

1. carld - int
2. carName - String
3. car Type - String
4. owners - int
5. currentOwnerName - String
6. mobile - long
7. address - String

Implement getters, setters and constructors for the
corresponding attributes.

# API Endpoints:

### POST

"/api/car" - Returns response status 201 with car objects on successful creation or else 500.

### GET

"/api/car" - Returns response status 200 with List<Car> objects on successful retrieval or else 500.

### GET

"/api/car/distinct - Returns a response status of 200 with the distinct car object filtered by currentOwnerName and address, which are passed as request parameters, upon successful retrieval or else 500.
