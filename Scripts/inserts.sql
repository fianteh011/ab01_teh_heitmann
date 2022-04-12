INSERT INTO ware (Name, Beschreibung, Preis)
VALUES  ("Maus", "tolle Maus", 30),
        ("Tastatur", "RGB Beleuechtung", 25),
        ("USB-C Kabel", "Lightning included", 10),
        ("Headset", "7.1 Surround sound", 80),
        ("Invalid", "just a test", 0);

INSERT INTO katalog (Warennummer)
VALUES  (2),(3),(4);

INSERT INTO produktdetails (Bezeichnung, Warennummer)
VALUES ("Marmor",2),("irgendwas",3);