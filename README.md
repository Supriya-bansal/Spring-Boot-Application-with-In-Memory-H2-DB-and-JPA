# Spring-Boot-Application-with-In-Memory-H2-DB-and-JPA

This service is used for managing Member portal and can be used for :

1. Fetching all the members from In memory database.
2. Fetching one member by providing the id.
3. Adding a new member to the portal.
4. Updating the data for existing member.
5. Deleting a member from the portal by providing an id.


Built with :

1. Spring-boot : Java based Web framework
2. Gradle : Dependency Management
3. H2 : In memory database
4. JPA : ORM specification

Member Service Operations:

| Method | Path                              | Description                                                                                                       | Parameters                                |
|--------|-----------------------------------|-------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| GET    | member-api/v1/members             | Get the details of all the members present.                                                                       | none                                      |
| GET    | member-api/v1/members/{id}        | Get the details of a specific member by passing the corresponding id.                                             | @PathVariable Long id                     |
| POST   | member-api/v1/members             | Add a new member to the application.                                                                              | @RequestBody Member                       |
| PUT    | member-api/v1/members/update/{id} | Update the details of existing member by passing new Member object and id for which the details are to be updated | @RequestBody Member @PathVariable Long id |
| DELETE | member-api/v1/members/delete/{id} | Delete an existing member by passing corresponding id.                                                            | @PathVariable Long id                     |
