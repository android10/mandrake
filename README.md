# Mandrake - THIS IS A WIP!!!

 - Please refer to the [Ktor Documentation](https://ktor.io/) to understand how this framework works. 

## Gradle Tasks

 - `./gradlew clean`
 - `./gradlew build`
 - `./gradlew runDev`
 - `./gradlew runUnitTests`

## Run and setup this Project
 
 - Application configuration can be found in the `application.conf` file. 
 - You can run by executing `./gradlew runDev` inside this directory.

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
## Run and setup this Project

 - [ ] Containerize the app. 
 - [ ] [Authentication and Authorization](https://ktor.io/docs/authentication.html)
 - [ ] [Implement SSL](https://ktor.io/docs/ssl.html) with [Let's Encrypt](https://letsencrypt.org/)
 - [ ] [Metrics and Performance Monitoring](https://ktor.io/docs/dropwizard-metrics.html)
 - [ ] [Error Handling](https://ktor.io/docs/status-pages.html)

## Deploy to Heroku

 - Url: [https://mandrake.herokuapp.com/](https://mandrake.herokuapp.com/)
 - 

## Frontend

 - http://0.0.0.0:4000/

## REST Api

 - http://0.0.0.0:4000/api
 - http://0.0.0.0:4000/api/v1/jobs

## Documentation

 - http://0.0.0.0:4000/docs/api
