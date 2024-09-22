## Smart Attendance System API with Java and Spring Boot

This project is an Intelligent Time Clock API developed using Java and Spring Boot. The application provides features for managing employee time tracking, including authentication and authorization, database migrations, and API security.

### RESTful API Details

The Smart Attendance RESTful API includes the following features:

- Project created with Spring Boot and Java 17
- MySQL database with JPA and Spring Data JPA
- Authentication and authorization with Spring Security and JWT (JSON Web Token) tokens
- Database migration with Flyway
- Use the H2 in-memory database to run unit tests.
- Unit and integration tests with JUnit and Mockito
- Caching with EhCache
- Continuous integration with TravisCI

### How to Run the Application

Make sure Maven is installed and added to your system's PATH, as well as Git.

### Unit Testing Application

---

### CompanyRepositoryTest

This repository contains unit tests for the functionalities of the CompanyRepository, using Spring Boot to perform integration tests with the Spring context and a test profile.

**Dependencies Used**

- JUnit 5: For writing and executing tests.
- Spring Boot Test: Facilitates integration and loading of the Spring context during tests.
- ActiveProfiles: Set to "test", to use the test profile of the project.

**Test Structure**

- `@SpringBootTest`: Annotation used to load the complete application context during tests.
- `@ActiveProfiles("test")`: Ensures that the test profile is activated.
- `@BeforeEach`: Creates a `Company` entity and saves it to the database before each test.
- `@AfterEach`: Removes all `Company` records after each test to ensure data is clean for the next test.
- `@Test`: Tests specific functionality of retrieving a company by its CNPJ.

**Test Implemented**

- `testBuscarPorCnpj (testFindByCnpj)`:
  - **Purpose**: To verify that the registered company can be correctly found by its CNPJ.
  - **Steps**:
    - A company is created with a CNPJ.
    - The repository is used to find this company by its CNPJ.
    - The test validates whether the CNPJ returned matches the saved company's CNPJ.

---

### EmployeeRepositoryTest

This test class validates the functionality of the `EmployeeRepository` and its integration with `CompanyRepository`. It focuses on testing the persistence and retrieval of `Employee` entities, including search operations by email, CPF (Brazilian individual taxpayer registry identification), and combinations of both.

**Key Points**:

- Test Framework: JUnit 5
- Spring Context: `@SpringBootTest` for full integration testing with the application context.
- Active Profile: "test" (uses a test-specific configuration).
- Repositories: `EmployeeRepository`, `CompanyRepository`

**Test Methods**:

- `testBuscarEmployeePorEmail`

  - **Description**: Verifies if the `EmployeeRepository` correctly retrieves an employee by their email.
  - **Assertion**: Compares the email fetched from the database with the expected email.

- `testBuscarEmployeePorCpf`

  - **Description**: Ensures the repository can retrieve an employee using their CPF.
  - **Assertion**: Validates the CPF matches the expected value.

- `testBuscarEmployeePorEmailECpf`

  - **Description**: Checks if the repository can find an employee using both CPF and email.
  - **Assertion**: Verifies the retrieved employee is not null.

- `testBuscarEmployeePorEmailOuCpfParaEmailInvalido`

  - **Description**: Ensures that an employee can be retrieved by CPF even when an invalid email is provided.
  - **Assertion**: Ensures the employee is still found with a valid CPF and invalid email.

- `testBuscarEmployeePorEmailECpfParaCpfInvalido`

  - **Description**: Tests the scenario where a valid email is provided along with an invalid CPF.
  - **Assertion**: Confirms the employee is found despite the invalid CPF.

**Setup and Teardown**:

- `@BeforeEach setUp()`: Initializes test data by saving a `Company` and an `Employee` entity to the repository.
- `@AfterEach tearDown()`: Cleans up the database by removing all entries from the repositories.

**Helper Methods**:

- `obterDadosEmployee(Company company)`: Creates an `Employee` object with preset attributes like email, CPF, and password.
- `obterDadosCompany()`: Creates a `Company` object with example data.

---

### EntrieRepositoryTest

This test class validates the functionality of the `EntrieRepository`, focusing on the persistence and retrieval of `Entrie` entities linked to `Employee` entities. It includes testing for retrieval operations by employee ID and pagination.

**Key Points**:

- Test Framework: JUnit 5
- Spring Context: `@SpringBootTest` for full integration testing with the application context.
- Active Profile: "test" (uses a test-specific configuration).
- Repositories: `EntrieRepository`, `EmployeeRepository`, `CompanyRepository`

**Test Methods**:

- `testBuscarEntriesPorEmployeeId`

  - **Description**: Verifies that the repository correctly retrieves entries associated with an employee by their ID.
  - **Assertion**: Validates that the number of entries returned matches the expected count.

- `testBuscarEntriesPorEmployeeIdPaginado`

  - **Description**: Tests the retrieval of entries for an employee with pagination.
  - **Assertion**: Ensures the total number of elements matches the expected count.

**Setup and Teardown**:

- `@BeforeEach setUp()`: Initializes test data by saving a `Company`, an `Employee`, and their associated entries to the repository.
- `@AfterEach tearDown()`: Cleans up the database by removing all entries from the company repository.

**Helper Methods**:

- `obterDadosEntries(Employee employee)`: Creates an `Entrie` object with preset attributes like date and type.
- `obterDadosEmployee(Company company)`: Creates an `Employee` object with preset attributes like email, CPF, and password.
- `obterDadosCompany()`: Creates a `Company` object with example data.

---

### Acknowledgments

This project was developed under the guidance and mentorship of Marcio Casale de Souza.
