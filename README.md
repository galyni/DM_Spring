# TODOs
 
- Gestion d'erreurs (unicité BDD, objet non en base...) -> toast d'erreur  + redirection
- Redirection quand login à la page prévue

Front : 
- Info visuelle si produit périmé -> champ date dans la création du produit
- Validation des formulaires + step pour le prix
- Faire un Hover pour les boutons verts de la page d'accueil
- Factorisation des pages

Bonus :
- Faire une page en cas d'erreur ("Oups nous ne sommes pas parvenus à trouver ce que vous recherchez")
- Faire un toast quand le produit vient d'être supprimé
- Confirmation à la suppression du produit

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
