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
Coming soon

## TechStack

Build Tool: Apache Maven <br>
Database: MySql

| Backend  | Frontend |
| -------------| ------------- |
| Spring Boot Starter Web <br> Spring Boot Data JPA <br> Spring Boot Starter Security <br> Spring Boot Starter OAuth2 Resource Server <br> Json Web Token | Vue <br> Vite <br> Axios <br> Pinia <br> Bootstrap |


## Getting started

### Start the Database in a docker container with a specified network
1. Pull Image (if needed)

    `docker pull mysql`

2. Create a network for the application
   
    `docker network create incident-tracker-network`

3. Run Database in created network

    `docker run --name mysqldb --network incident-tracker-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=incident-tracker-db -d mysql`

    _//change port (if needed) with portbinding 3307:3306 whereas 3307 is the host port, if 3306 is allready in use and 3306 is the internal port for the database in the container_

### Build or Pull backend docker-image

1. Build application
    `docker build -t incident-tracker-backend .`
   
2. Pull application
    COMING SOON

3. Run backend docker-image in a container

    `docker run --network incident-tracker-network --name incident-tracker-backend-container -p 8080:8080 incident-tracker-backend`

    _//change port (if needed) with portbinding 8081:8080 whereas 8081 is the host port, if 8080 is allready in use and 8080 is the internal port for the database in the container_

### Use API

Open your browser or postman to make requests to the API (see [API-Endpoints](README.md#api-endpoints) )



### Build frontend docker-image
1. Build frontend
   `docker build -t incident-tracker-frontend .`
2. Pull frontend docker-image
   COMING SOON

### Run Frontend
    `docker run -it --network incident-tracker -p 3000:80 --rm --name incident-tracker-frontend-container incident-tracker-frontend`
    
## API-Endpoints

  Root | Endpoint | Methode | Secured (optional additional layer) | Purpose | Controller |
| -------- | -------- | -------- | -------- | -------- |-------- |
| /api   | /incident/{incidentId}    | GET     |  yes    | informations about specific incident | IncidentController |
| /api    | /incident/{incidentId}     | DELETE     | yes (admin)     | delets the chosen incident | IncidentController |
| /api    | /incidents     | GET     | yes  | returns a list of all incidents | IncidentController |
| /api    | /categories     | GET     | yes  | returns a list of all categories | IncidentController |
| /api    | /severities     | GET     | yes  | returns a list of all severities | IncidentController |
| /api    | /incidents/create    | POST     | yes  | creates a new incident (needs user id in RequestBody) | IncidentController |
| /api    | /newUpdate     | POST     | yes  | creates a new update for the incident (needs incident id in RequestBody) | IncidentUpdatesController |
| /api    | /allUpdates     | GET     | yes  | returns a list of all updates | IncidentUpdatesController |
| /api    | /updates/{incidentId}     | GET     | yes  | returns a list of all updates to a specified incident | IncidentUpdatesController |
| /api    | /user/{userId}}     | GET     | yes (current authorized user) | returns the user informations | UserController |
| /api    | /users     | GET     | yes (admin)  | returns a list of all users | UserController |
| /api    | /usersCustomSort     | GET     | yes (admin)  | returns a list of all users in a specific order | UserController |
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
