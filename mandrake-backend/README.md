# Mandrake Backend - THIS IS A WIP!!!

 - Please refer to the [Ktor Documentation](https://ktor.io/) to understand how this framework works.

## Gradle Tasks

 - `./gradlew clean`
 - `./gradlew buildApp`
 - `./gradlew build -t` -> for auto-reloading. See below.
 - `./gradlew runApp`
 - `./gradlew runUnitTests`

## Run and setup this Project - Development
 
 - Application configuration can be found in the `application.conf` file.
 - In order to auto reload changes, run `./gradlew build -t` in a terminal (from root directory). 
 - In another terminal, run the server by executing `./gradlew runDev` (from root directory).

The app will run on `http://0.0.0.0:4000/` and you will see a similar output:

```bash 
2021-03-14 14:04:34.098 [main] TRACE Application - {
    ...
    "application" : {
        ...
    },
    ...
    "deployment" : {
        ...
        "port" : 4000
    },
    # Content hidden
    "security" : "***"
}

2021-03-14 14:04:34.287 [main] INFO  Application - Responding at http://0.0.0.0:4000
```

## Deploy to Heroku

 - Url: [https://mandrake.herokuapp.com/](https://mandrake.herokuapp.com/)
 - 

## Frontend

 - http://0.0.0.0:4000/

## REST Api

 - http://0.0.0.0:4000/api
 - http://0.0.0.0:4000/api/v1/jobs

### Endpoints
 - ???
 - ???

## Documentation

 - http://0.0.0.0:4000/docs/api

## TODOs

 - [ ] Containerize the app.
 - [ ] [Authentication and Authorization](https://ktor.io/docs/authentication.html)
 - [ ] [Implement SSL](https://ktor.io/docs/ssl.html) with [Let's Encrypt](https://letsencrypt.org/)
 - [ ] [Metrics and Performance Monitoring](https://ktor.io/docs/dropwizard-metrics.html)
 - [ ] [Error Handling](https://ktor.io/docs/status-pages.html)