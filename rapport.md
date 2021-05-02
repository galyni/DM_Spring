# Application


# Choix techniques

Spring boot

ORM : Hibernate

# Design patterns

Injection de dépendance (par annotations)
MVC

# Entités persistées

Product :  
Utilisateur :  

# cycle de vie des sessions

Par requête. Gérées au niveau des services, par l'appel à un objet SessionFactory;
Si on avait des requêtes complexes, les appels depuis les services et l'annotation @Transactional
permettraient de ne pas commit les modifications en base avant qu'elles soient toutes validées.