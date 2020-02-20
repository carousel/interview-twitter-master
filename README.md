# interview-twitter

## Basic info 
This project is used for testing candidates through implementing features on simplified Twitter clone app.

Only basic skeleton is implemented and is left to candidate to implement specific feature.

## Demo users

There are several users and faked tweets inserted in the system as bootstrap data. 
To have this app more interesting to work on, all the users are very famous in cryptocurrency world that is getting a lot of traction lately.

## Project structure

Project is divided into REST and UI part.
REST part is implemented with Java and Spring Boot and UI part with Angular 5.
Each part is in separate project in this repository.

## Starting the application
To start REST service, navigate to `interview-twitter-rest` and execute `./mvnw spring-boot:run` if running on *nix OS system.
If running on Windows, execute `mvnw.cmd spring-boot:run`.

To start UI, make sure `yarn` is installed on your system (version 1.3.2). 
Run the `yarn` command after cloning the project in order to download dependencies.
Then go to `interview-twitter-ui` and execute `yarn start` and navigate in browser to `http://localhost:4200`. 
More details are available in UI project README file.

## Base implementation features

Implemented features should be easily understable from source code but here's the quick summary:

- Login
- Create a tweet
- Overview of all the following users tweets
- View of users own tweets
- View following users
- View followers

# Alternative implementations for user profile feature
    1. Use Value objects instead of primitives in UserProfileDTO. Benefit is that wrapped primitives will have behavior(object) and can be modeled with valid state - using invariants
    2. Reuse existing HTTP requests on front-end side e.g. /api/tweets. Benefit is better performance. Problem is that we will loose explicit user profile intention in code. Also front-end complexity will increase.
    3. Call repositories directly from controller. In many cases this is perfelcty valid since profile data is used only for reporting. Tradeoff is to bypass services as convention.
    4. Create joins between tables directly. Benefit could be slightly better performance. Tradeoff is loosing ORM API verbosity.
