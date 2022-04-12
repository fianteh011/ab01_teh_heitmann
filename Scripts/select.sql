select *
From ware;

Use swashop;
select *
From swashop.katalog;


show databases;
select * From swashop.produktdetails;

select ware.warennummer, ware.name, ware.preis, ware.beschreibung
From katalog INNER JOIN ware
ON katalog.warennummer = ware.warennummer;

select ware.warennummer, ware.name, ware.preis, ware.beschreibung
From katalog
INNER JOIN ware
ON katalog.warennummer = ware.warennummer
where katalog.warennummer = 1;

select ware.warennummer, ware.name, ware.preis, ware.beschreibung
From katalog INNER JOIN ware
ON katalog.warennummer = ware.warennummer where ware.name LIKE '%maus%';