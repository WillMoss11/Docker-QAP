<h1 align="left">Golf Club System</h1>

###

<h3 align="left">Running the Application</h3>

###

<p align="left">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>

###

<h4 align="left">Using Docker Compose</h4>

###

<p align="left">1. Clone the repository<br>2. Make sure you are in the project root directory<br>3. Build and run:</p>

###

 ```bash
   docker-compose up --build
   ```

###

<p align="left">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>

###

<h4 align="left">Local Development</h4>

###

<p align="left">1. Make sure your MySQL is running locally<br>2. Update docker-compose.yml database settings<br>3. Run with Maven:</p>

###

 ```bash
   mvn spring-boot:run
   ```

###

<p align="left">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>

###

<h3 align="left">API Endpoints</h3>

###

<p align="left">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>

###

<p align="left">• Members: /api/members<br>• Tournaments: /api/tournaments</p>

###

<h4 align="left">Search Endpoints</h4>

###

<p align="left">• Members by name: /api/members/search/name?name=<br>• Tournaments by location: /api/tournaments/search/location?location=</p>

###
