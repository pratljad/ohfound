CREATE DATABASE `OHFOUND`;

DROP TABLE `OHFOUND`.User;
DROP TABLE `OHFOUND`.Gegenstand;
DROP TABLE `OHFOUND`.Ueberbegriff;

CREATE TABLE `OHFOUND`.User(
	
    Id integer NOt Null auto_increment,
    Vorname VArchar(255),
    Nachname Varchar(255),
    Email Varchar(255) unique,
    Passwort Varchar(255),
    IsAdmin Boolean,
    
    PRIMARY KEY (Id)
);

CREATE TABLE `OHFOUND`.Ueberbegriff(

	Id integer NOT NULL auto_increment,
    Bezeichnung Varchar(255),
    
    PRIMARY KEY (Id)
);

CREATE TABLE `OHFOUND`.Gegenstand(

	Id integer NOT NULL auto_increment,
    Ueberbegriff_Id Integer,
    Beschreibung Varchar(255),
    Ort Varchar(255),
    Image LONGBLOB,
    User_Id Integer,
    
    PRIMARY KEY (Id),
    FOREIGN KEY (Ueberbegriff_Id) REFERENCES `OHFOUND`.Ueberbegriff(Id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (User_Id) REFERENCES `OHFOUND`.User(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `OHFOUND`.Ueberbegriff(Id, Bezeichnung) VALUES (1, 'Handy');
INSERT INTO `OHFOUND`.Ueberbegriff(Id, Bezeichnung) VALUES (2, 'Schlüssel');
INSERT INTO `OHFOUND`.Ueberbegriff(Id, Bezeichnung) VALUES (3, 'Brieftasche');
INSERT INTO `OHFOUND`.Ueberbegriff(Id, Bezeichnung) VALUES (4, 'Ring');
INSERT INTO `OHFOUND`.Ueberbegriff(Id, Bezeichnung) VALUES (5, 'Laptop');

INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (1, 1, 'Samsung','Villach', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (2, 2, 'Autoschlüssel','Klagenfurt', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (3, 3, 'Lederbrieftasche','Villach Westbahnhof', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (4, 1, 'IPhone','HTL-Villach', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (5, 5, 'Schwarze Laptoptasche mit Laptop','Draulände Villach', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (6, 1, 'IPhone','Gasthof Hasslacher', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (7, 2, 'Autoschlüssel und Hausschlüssel','Miami', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (8, 3, 'Lederbrieftasche','Villach Huptbahnhof', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (9, 1, 'IPhone','HTL-Villach', null);
INSERT INTO `OHFOUND`.Gegenstand(Id, Ueberbegriff_Id, Beschreibung, Ort, Image) VALUES (10, 2, 'Schlüsselnbund','BORG Spittal', null);

INSERT INTO `OHFOUND`.User(Id, Vorname, Nachname, Email, Passwort, IsAdmin) VALUES (1, 'Andrea', 'Djedovic', 'andrea@gmail.com', '1234', true);
INSERT INTO `OHFOUND`.User(Id, Vorname, Nachname, Email, Passwort, IsAdmin) VALUES (2, 'Claudia', 'Djedovic', 'claudia@gmail.com', '4321', false);
COMMIT;


SELECT * FROM `OHFOUND`.Ueberbegriff;
SELECT * FROM `OHFOUND`.Gegenstand;
SELECT * FROM `OHFOUND`.User;

select * from `OHFOUND`.Gegenstand;