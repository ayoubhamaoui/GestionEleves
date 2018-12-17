# GestionEleves
application java-swing permet de la gestion des élèves et le filières




## Table filiere
```SQL
create table filiere(
	idf int NOT NULL AUTO_INCREMENT,
	code varchar(25) UNIQUE,
	libelle varchar(100),
	primary key(idf)
)
```


## Table Etudiant
```SQL
create table etudiant(
	ide int NOT NULL AUTO_INCREMENT,
	idf int,
	Nom varchar(25),
	Prenom varchar(25),
	age int,
	primary key(ide),
	foreign key(idf) references filiere(idf)
)
```

## Some data to start with
```SQL
insert into filiere(code,libelle) values("GINF1","1er année genie informatique");
insert into filiere(code,libelle) values("GINF2","2eme année genie informatique");
insert into filiere(code,libelle) values("GINF3","3eme année genie informatique");


insert into filiere(code,libelle) values("GSTR1","1er année genie systeme telecommunication et réseau");
insert into filiere(code,libelle) values("GSTR2","2eme année genie system telecommunicatin et réseau");
insert into filiere(code,libelle) values("GSTR3","3eme année genie system telecommunicatin et réseau");

insert into filiere(code,libelle) values("GIND1","1er année genie industriel");
insert into filiere(code,libelle) values("GIND2","2eme année genie industriel");
insert into filiere(code,libelle) values("GIND3","3eme année genie industriel");


-----------------------------------------------------------------------------------------------------------


insert into etudiant(idf,Nom,Prenom,age) values(2,"Hamaoui","Ayoub",22);
insert into etudiant(idf,Nom,Prenom,age) values(2,"Enaime","Hamza",21);
insert into etudiant(idf,Nom,Prenom,age) values(2,"Ajaanit","Taoufik",21);


insert into etudiant(idf,Nom,Prenom,age) values(1,"Houssin","Houssin",20);
insert into etudiant(idf,Nom,Prenom,age) values(1,"Amine","Alami",20);

insert into etudiant(idf,Nom,Prenom,age) values(3,"Najih","Idriss",22);
insert into etudiant(idf,Nom,Prenom,age) values(3,"Lahlou","Othmane",22);

insert into etudiant(idf,Nom,Prenom,age) values(6,"Ouaabi","Youssef",23);
insert into etudiant(idf,Nom,Prenom,age) values(6,"Mazti","Tarik",22);

insert into etudiant(idf,Nom,Prenom,age) values(4,"Yahya","Yahya",22);
```


