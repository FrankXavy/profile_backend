# Getting Started with Profile backend API

## Available Scripts

In the project directory, you can run:

### `mvn clean install`
### `option 1: Run by Ide, right click in ProfileApplication.java and run`
### `option 2: Ones compiled, inside will be a folder named target, and inside of this folder you will find a jar file named profile-0.0.1-SNAPSHOT.jar, in a terminal run the next command:`
### `java -jar profile-0.0.1-SNAPSHOT.jar`

Runs the app in the development mode.\
Open [http://localhost:7777](http://localhost:7777/v2/api-docs) to view it in your browser.

This Api provides 4 endpoints.

##For the part 1 of the challenge we have the next endpoints:

To get the profile info [http://localhost:7777/profile/{id}](http://localhost:7777/profile/{id})

To get the timeline twitter info [http://localhost:7777/tweets/timeline/{twitter_user_id}](http://localhost:7777/tweets/timeline/{twitter_user_id})

##For the part 2 of the challenge we have the next endpoints:

To get the portfolio info GET [http://localhost:7777/api/portfolio/{id}](http://localhost:7777/api/portfolio/{id})

To update the portfolio info PUT [http://localhost:7777/api/portfolio/](http://localhost:7777/api/portfolio/)
with body

{
"id": 4,
"description": "Durante el sorteo, que se realizó la mañana de este 1 de abril de 2022, se oficializó que el primer partido de la edición sería entre el anfitrión Catar ante la Tri, primeros ubicados del Grupo A.",
"experienceSummary": "Senegal y Países Bajos jugarán a las 13:00 locales (05:00, hora de Ecuador) del lunes 21 de noviembre en el Al Thumama Stadium.",
"imageUrl": "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/evolucion-leonardo-dicaprio-principal-1573497722.jpg?crop=1.00xw:0.747xh;0,0.0811xh&resize=980:*",
"names": "Fifa",
"phone": "9999999999",
"twitterUser": null,
"twitterUserId": "fxf",
"title": "Catar vs. Ecuador",
"userId": null,
"address": null,
"email": "jack@gmail.com",
"experience": "¡Cambio de planes! La FIFA publicó el cronograma oficial del Mundial de Catar 2022, donde se descarta que Ecuador juegue el partido inaugural.",
"imagePath": null,
"name": "Ecuador Catar 2022",
"zipCode": null
}
