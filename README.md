# TODOs

- Transactional : pk ça marche pas : Nico et David
- Comptes utilisateurs, login..
- Controllers and service : Nico et David
- Views : Frédo et Quentin
    - product detail
    - add product form
    - ...
- Gestion d'erreurs (unicité BDD, objet non en base...)
- Validation des formulaires
- Authentification pour edit, update, delete...

Spring Hibernate project
=========================

# Prérequis : 
- Utiliser WAMP ou XAMP 
- Un IDE capable d'utiliser Glassfish ou Tomcat 
- Git 

# Instructions pour lancer le site : 

- Dans un CMD, lancer la commande : git clone https://github.com/galyni/DM_Spring.git
- Ouvrir le dossier avec Intelij
- Une fois Intelij lancé, dans le bandeau de droite appelé "Gradle", lancer "bootRun"
- Utiliser l'URL : http://localhost:8080/GetProductsList

#Autre : 

Templates pour le projet Spring Hibernate des EPSI B3.

Pour compiler l'application :
`./gradlew classes`

Pour démarrer l'application :
* partie I à III :
`./gradlew appRun`
* partie IV et suivante :
`./gradlew bootRun`

Les exemples de code se trouvent dans le répertoire : `./resourcesEtudiant`
