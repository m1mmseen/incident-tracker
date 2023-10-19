<img alt="Static Badge" src="https://img.shields.io/badge/Project level-Advanced/Capstone-blue">




# incident-tracker
Refactorized copy of IncidentTracker_Dev
## Table of Content
- [About the project](README.md#about-the-project)
- [TechStack](README.md#TechStack)
- [Getting started](README.md#getting-started)
- [API-Endpoints](README.md#api-endpoints)
- [License](README.md#license)
- [Author](README.md#author)

## Purpose: 
Easy tracking of all security inciednts including suspect behavior like mails, failures e.g.

## About the project
Using the tracker, incidents can be documented and tracked. The idea is that every user can report an incident, ensuring that as many incidents as possible can be recorded without any obstacles. In this first version, basic features have been implemented. However, the plan is to implement more user stories in the future. The following process is possible in this initial version:
A user reports an incident, categorizes it, and assigns a level of severity. They also give it a title and a detailed description. After the incident has been reported, so-called updates can be used to add all related measures, as well as additional notes, etc.
There is a login for registered users, but for now, only an admin should be able to add new users, so the respective endpoint can only be accessed by an admin.
The dashboard displays all incidents, recent activities, and, in the case of an admin, all active users and failed logins. However, the last two features mentioned do not yet have an API endpoint or JavaScript logic.

Every user can see their own details, change their password, and log out via a user menu in the bottom left corner. All features have been implemented except for the password change. Currently, only an admin is allowed to delete a user.
There is already a basic implementation for notifications. The idea is to make it possible to quickly share an incident with important other users or departments.
Also, sending notifications to customers or suppliers as external communication is sensible, but it could also be considered outside the scope of the tracker.

In the frontend, the option to close or, in this case, solve an incident has already been implemented. What's missing is the corresponding logic in the backend and the database.

Future Features after finishing the current Definition of Done:
Editing an incident afterwards, assigning an incident to another user, create a final report after solving an incident

## TechStack

Build Tool: Apache Maven <br>
Database: MySql

| Backend  | Frontend |
| -------------| ------------- |
| Spring Boot Starter Web <br> Spring Boot Data JPA <br> Spring Boot Starter Security <br> Spring Boot Starter OAuth2 Resource Server <br> Json Web Token | Vue <br> Vite <br> Axios <br> Pinia <br> Bootstrap |


## Getting started

After cloning this repo you can start the application with [docker compose](https://docs.docker.com/compose/gettingstarted/).

In the root folder of the app run:

`docker-compose up --build`

Docker starts a network and all three container which are needed (database, backend, frontend). Sometime it could be necessary to manually restart the backend or frontend container, even though the restart ist set to always. You can do this by using the docker-desktop app or by first run `docker-compose down` and then `docker-compose up --build` (closes all containers and then restarts them).

### Use API-Endpoint without frontend

Open your postman or a similar programm to make requests to the API (see [API-Endpoints](README.md#api-endpoints) )
Please keep in mind to send authorization token for every request after login in.
## API-Endpoints

  Root | Endpoint | Methode | Secured (optional additional layer) | Purpose | Controller |
| -------- | -------- | -------- | -------- | -------- |-------- |
| /api/incident   | /{incidentId}    | GET     |  yes    | informations about specific incident | IncidentController |
| /api/incident    | /{incidentId}     | DELETE     | yes (admin)     | delets the chosen incident | IncidentController |
| /api/incident    | /all     | GET     | yes  | returns a list of all incidents | IncidentController |
| /api/incident    | /categories     | GET     | yes  | returns a list of all categories | IncidentController |
| /api/incident    | /severities     | GET     | yes  | returns a list of all severities | IncidentController |
| /api/incident    | /report    | POST     | yes  | creates a new incident (needs user id in RequestBody) | IncidentController |
| /api/updates    | /newUpdate     | POST     | yes  | creates a new update for the incident (needs incident id in RequestBody) | IncidentUpdatesController |
| /api/updates   | /allUpdates     | GET     | yes  | returns a list of all updates | IncidentUpdatesController |
| /api/updates    | /{incidentId}     | GET     | yes  | returns a list of all updates to a specified incident | IncidentUpdatesController |
| /api/user    | /{userId}}     | GET     | yes (current authorized user) | returns the user informations | UserController |
| /api/user    | /all     | GET     | yes (admin)  | returns a list of all users | UserController |
| /api/user    | /customSort     | GET     | yes (admin)  | returns a list of all users in a specific order | UserController |
| /auth    | /register     | POST     | no  | returns a list of all users in a specific order | AuthenticationController |
| /auth    | /login   | POST     | no  | returns a list of all users in a specific order | AuthenticationController |


## License

[GNU GENERAL PUBLIC LICENSE](LICENSE)

## Author

<h1 align="center">Hi 👋, I'm M1mmseen</h1>
<h3 align="center">A new member of the coding community</h3>

- 🔭 I’m currently working on [my Incident tracker app](https://github.com/m1mmseen/incident-tracker/)

- 🌱 I’m currently learning **Vue, Spring Boot, Docker**

- 👯 I’m looking to collaborate on **java-related projects**

- 🤝 I’m looking for help with **deployment of apps**

- 👨‍💻 All of my projects are available at [https://github.com/m1mmseen/](https://github.com/m1mmseen/)

- ⚡ Fun fact **I know a bunch of bad jokes**

<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://stackoverflow.com/users/m1mmseen" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/stack-overflow.svg" alt="m1mmseen" height="30" width="40" /></a>
<a href="https://www.leetcode.com/m1mmseen" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/leet-code.svg" alt="m1mmseen" height="30" width="40" /></a>
</p>

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> <a href="https://www.figma.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/figma/figma-icon.svg" alt="figma" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a> <a href="https://www.linux.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="linux" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://nodejs.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> <a href="https://pandas.pydata.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/2ae2a900d2f041da66e950e4d48052658d850630/icons/pandas/pandas-original.svg" alt="pandas" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://www.qt.io/" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Qt_logo_2016.svg" alt="qt" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://vuejs.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/vuejs/vuejs-original-wordmark.svg" alt="vuejs" width="40" height="40"/> </a> <a href="https://zapier.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/zapier/zapier-icon.svg" alt="zapier" width="40" height="40"/> </a> </p>

<p><img align="center" src="https://github-readme-stats.vercel.app/api/top-langs?username=m1mmseen&show_icons=true&locale=en&layout=compact" alt="m1mmseen" /></p>

<p>Profil happy created with https://rahuldkjain.github.io/gh-profile-readme-generator/</p>
