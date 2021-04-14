# Mandrake

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

2021-03-14 14:04:34.124 [main] INFO  Application - Autoreload is disabled because the development mode is off.
2021-03-14 14:04:34.287 [main] INFO  Application - Responding at http://0.0.0.0:4000
```
## Run and setup this Project

 - [ ] Containerize the app. 
 - [ ] ???

## Deploy to Heroku

 - Url: [https://mandrake.herokuapp.com/](https://mandrake.herokuapp.com/)
 - 

## REST Api

 - http://0.0.0.0:4000/api
