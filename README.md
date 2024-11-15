# SightseeingApp

## About the Project
SightseeingApp is a backend service developed during a hackathon as part of the TIS Java/Spring Academy. The goal of the project was to create a backend for a sightseeing application, providing core functionalities such as user management, attraction ratings, and image handling. 

The following functionalities were implemented:

1. Retrieve a list of attractions for a specific location.
2. Add a new user to the system.
3. Save a user's favorite attractions.
4. Rate an attraction.
5. Retrieve details about an attraction.
6. Retrieve user details and their favorite attractions.
7. Add an image for an attraction.
8. Retrieve images for an attraction.

---

## Built With
- **Java**: Core language for backend development.
- **Spring Boot**: Framework for building and running the application.
- **Spring Data JPA**: For database operations.
- **H2 Database**: In-memory database used during development.

---

## How to Run Locally
To run the application locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/lknezevicc/SightseeingApp.git
   ```
   
2. **Open the project in IntelliJ IDEA**
   - Import the project as a Maven project.
   - Ensure that the H2 in-memory database dependency is correctly installed.

4. **Add H2 in-memory database as a data source**
   
5. **Run the application:**
   - In IntelliJ, navigate to the App main class in the src/main/java directory.
   - Right-click the class and select Run ‘App’.

7. **Test API Endpoints:**
   - To test the API, you can use a tool like [Postman](https://www.postman.com/).
