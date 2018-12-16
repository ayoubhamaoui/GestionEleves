# GestionEleves
application java-swing permet de la gestion des élèves et le filières




## Table filiere
```SQL
create table filiere(
	idf int primary key,
	code varchar(25),
	libelle varchar(25)
)
```


## Table Etudiant
```SQL
create table etudiant(
	ide int primary key,
	idf int,
	Nom varchar(25),
	Prenom varchar(25),
	age int,
	foreign key(idc) references filiere(idc)
)
```


