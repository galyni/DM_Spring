Spring Hibernate project
=========================

# Prérequis : 
- Utiliser WAMP ou XAMP
- Git 

# Instructions pour lancer le site : 

- Dans un CMD, lancer la commande : git clone https://github.com/galyni/DM_Spring.git
- Importer la base de donnée (MySQL) à l'aide du script (BDD/BDD.sql). 
- lancer la commande './gradlew bootRun' depuis la racine du projet
- Utiliser l'URL : http://localhost:8080

# Comptes à utiliser pour réaliser les tests

Compte simple : 

Email : comptetest@test.com
Mot de passe : test

Compte Administrateur : 

Email : compteadmintest@test.com
Mot de passe : admin

# Remarques 

Nous avions utilisé la classe cookieFilter pour connecter automatiquement les utilisateurs, mais nous avons décider d'enlever ce comportement 
au moment de la mise en place de SpringSecurity. 

