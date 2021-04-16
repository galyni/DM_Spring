CREATE DATABASE IF NOT EXISTS SpringHibernate;
USE SpringHibernate;
    CREATE TABLE IF NOT EXISTS Product(
        nom varchar(255) NOT NULL,
        code varchar(13) NOT NULL,
        quantite int NOT NULL,
        datePeremption Date NOT NULL,
        PRIMARY KEY (code)
    );

    CREATE TABLE IF NOT EXISTS Utilisateur(
        login varchar(20) NOT NULL,
        mail varchar(255) NOT NULL,
        password varchar(250) NOT NULL,
        PRIMARY KEY (mail)
    );

    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Banane', '978020137962', 12 ,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Clémentine', '7412589634561', 21 ,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Orange', '369020137962', 3 ,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Sardines', '123020137962', 23 ,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Framboises', '869020137962', 5 ,'2021-08-12');
    INSERT INTO PRODUCT(nom, code , quantite, datePeremption) VALUES ('Raisins', '222020137962', 1 ,'2021-05-1');

    INSERT INTO Utilisateur(login, mail, password) VALUES ('Orayas', 'orayas@gmail.com','admin');
    INSERT INTO Utilisateur(login, mail, password) VALUES ('cpt_flynt', 'cpt_flynt@gmail.com','admin');
    INSERT INTO Utilisateur(login, mail, password) VALUES ('froggy', 'froggy@gmail.com','admin');
    INSERT INTO Utilisateur(login, mail, password) VALUES ('testos', 'testos@gmail.com','admin');

