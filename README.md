
## Smart Attendance System API with Java and Spring Boot

This project is an Intelligent Time Clock API developed using Java and Spring Boot. The application provides features for managing employee time tracking, including authentication and authorization, database migrations, and API security.

### RESTful API Details

The Smart Attendance RESTful API includes the following features:

- Project created with Spring Boot and Java 17
- MySQL database with JPA and Spring Data JPA
- Authentication and authorization with Spring Security and JWT (JSON Web Token) tokens
- Database migration with Flyway
- Unit and integration tests with JUnit and Mockito
- Caching with EhCache
- Continuous integration with TravisCI

### How to Run the Application

Make sure Maven is installed and added to your system's PATH, as well as Git.



### Unit Testing Application
---
### CompanyRepositoryTest
This repository contains unit tests for the functionalities of the CompanyRepository, using Spring Boot to perform integration tests with the Spring context and a test profile.

Dependencies Used

- JUnit 5: For writing and executing tests.
- Spring Boot Test: Facilitates integration and loading of the Spring context during tests.
- ActiveProfiles: Set to "test", to use the test profile of the project.

Test Structure
- @SpringBootTest: Annotation used to load the complete application context during tests.
- @ActiveProfiles("test"): Ensures that the test profile is activated.
- @BeforeEach: Creates a Company entity and saves it to the database before each test.
- @AfterEach: Removes all Company records after each test to ensure data is clean for the next test.
- @Test: Tests specific functionality of retrieving a company by its CNPJ.
  
Test Implemented
- testBuscarPorCnpj (testFindByCnpj):
  - Purpose: To verify that the registered company can be correctly found by its CNPJ.
  - Steps:
    - A company is created with a CNPJ.
    - The repository is used to find this company by its CNPJ.
    - The test validates whether the CNPJ returned matches the saved company's CNPJ.

























### Acknowledgments

This project was developed under the guidance and mentorship of Marcio Casale de Souza.
