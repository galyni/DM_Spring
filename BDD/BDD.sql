CREATE DATABASE IF NOT EXISTS SpringHibernate;
USE SpringHibernate;
    CREATE TABLE IF NOT EXISTS Product(
        nom varchar(255) NOT NULL,
        code varchar(13) NOT NULL,
        quantite int NOT NULL,
        prix double NOT NULL,
        datePeremption Date NOT NULL,
        PRIMARY KEY (code)
    );

    CREATE TABLE IF NOT EXISTS Utilisateur(
        firstName varchar(50) NOT NULL,
        userName varchar(20) NOT NULL,
        billingAddress varchar (300) NOT NULL,
        mail varchar(255) NOT NULL,
        password varchar(250) NOT NULL,
        role varchar(50),
        PRIMARY KEY (mail)
    );

    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Banane', '978020137962', 12 , 1.99,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Clémentine', '7412589634561', 21 , 1.99,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Orange', '369020137962', 3 , 1.99,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Sardines', '123020137962', 23 , 1.99,'2021-04-20');
    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Framboises', '869020137962', 5 , 1.99,'2021-08-12');
    INSERT INTO PRODUCT(nom, code , quantite, prix, datePeremption) VALUES ('Raisins', '222020137962', 1 , 1.99,'2021-05-1');

    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('Nicolas', 'nicosss@gmail.com','$2a$10$eguDw6AzbMP6sJSHIg/1JOqq16Td.6rEeugSx30xni.RNkr5CkmOS', 'Orayas', '3 chemin de l''impératif catégorique', 'ADMIN');
    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('David', 'cpt_flynt@gmail.com','$2a$10$eguDw6AzbMP6sJSHIg/1JOqq16Td.6rEeugSx30xni.RNkr5CkmOS', 'cpt_flynt', '2 ruelle des blagues vaseuses', 'ADMIN');
    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('Quentin', 'froggy@gmail.com','$2a$10$eguDw6AzbMP6sJSHIg/1JOqq16Td.6rEeugSx30xni.RNkr5CkmOS', 'froggy', '3 avenue de la saciété', 'ADMIN');
    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('Frederic', 'orayas@gmail.com','$2a$10$eguDw6AzbMP6sJSHIg/1JOqq16Td.6rEeugSx30xni.RNkr5CkmOS', 'testos', '5 boulevard des marins d''eau douce', 'ADMIN');
    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('Tom', 'comptetest@test.com','$2y$10$7HIw8T7hb4zKKg7ltuxRkOxRWlLIBWnU0Ae5QjazbiswZCf2GaU5u', 'Tomtom', '5 chemin du chemin du chemin', null);
    INSERT INTO Utilisateur(firstName, mail, password, userName, billingAddress, role) VALUES ('Tom', 'compteadmintest@test.com','$2a$10$eguDw6AzbMP6sJSHIg/1JOqq16Td.6rEeugSx30xni.RNkr5CkmOS', 'Tomtom', '5 chemin du chemin du chemin', 'ADMIN');
