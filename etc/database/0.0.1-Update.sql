create database budget;

create table person (
	id integer primary key,
	name varchar(20) NOT NULL
);

create table category (
	id integer primary key,
	name varchar(20) NOT NULL
);

create table subcategory (
	id integer primary key,
	name varchar(20) NOT NULL,
	categoryId integer NOT NULL
);

create table revenue (
	id integer primary key,
	montant float NOT NULL,
	personId integer NOT NULL
);

create table depense (
	id integer primary key,
	montant float NOT NULL,
	created date NOT NULL,
	personId integer NOT NULL,
	subcategoryId integer NOT NULL
);