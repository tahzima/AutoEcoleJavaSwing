#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Database: autoecole
#------------------------------------------------------------

CREATE DATABASE autoecole;
USE autoecole;

#------------------------------------------------------------
# Table: Personnels
#------------------------------------------------------------

CREATE TABLE Personnels(
        id            Int NOT NULL identity(1,1) ,
        nom           Varchar (50) NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        cin           Varchar (50) NOT NULL ,
        dateNaissance Date NOT NULL ,
        numTel        Varchar (50) NOT NULL ,
        adresse       Varchar (50) NOT NULL ,
        poste         Varchar (50) NOT NULL ,
        dateEmbauche  Date NOT NULL ,
        salaire       Float NOT NULL,
		CONSTRAINT Personnels_PK PRIMARY KEY (id)
);


#------------------------------------------------------------
# Table: Users
#------------------------------------------------------------

CREATE TABLE Users(
        id            Int  identity(1,1)  NOT NULL ,
        login         Varchar (50) NOT NULL ,
        password      Varchar (50) NOT NULL ,
        id_Personnels Int NOT NULL
	,CONSTRAINT Users_PK PRIMARY KEY (id)

	,CONSTRAINT Users_Personnels_FK FOREIGN KEY (id_Personnels) REFERENCES Personnels(id)
	,CONSTRAINT Users_Personnels_AK UNIQUE (id_Personnels)
);


#------------------------------------------------------------
# Table: Candidats
#------------------------------------------------------------

CREATE TABLE Candidats(
        id            Int  identity(1,1)  NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        cin           Varchar (50) NOT NULL ,
        dateNaissance Date NOT NULL ,
        numTel        Varchar (50) NOT NULL ,
        adresse       Varchar (50) NOT NULL
	,CONSTRAINT Candidats_PK PRIMARY KEY (id)
);


#------------------------------------------------------------
# Table: Vehicules
#------------------------------------------------------------

CREATE TABLE Vehicules(
        id                  Int  identity(1,1)  NOT NULL ,
        type                Varchar (50) NOT NULL ,
        marque              Varchar (50) NOT NULL ,
        modele              Varchar (50) NOT NULL ,
        nbPlace             Int NOT NULL ,
        typeCarburant       Varchar (50) NOT NULL ,
        matricule           Varchar (50) NOT NULL ,
        puissanceFiscale    Int NOT NULL ,
        assurance           Varchar (50) NOT NULL ,
        dateLimiteAssurance Date NOT NULL ,
        kmVidange           Int NOT NULL
	,CONSTRAINT Vehicules_PK PRIMARY KEY (id)
);


#------------------------------------------------------------
# Table: Examens
#------------------------------------------------------------

CREATE TABLE Examens(
        id           Int  identity(1,1)  NOT NULL ,
        dateExamen   Date NOT NULL ,
        nbEchec      Int NOT NULL ,
        id_Candidats Int NOT NULL
	,CONSTRAINT Examens_PK PRIMARY KEY (id)

	,CONSTRAINT Examens_Candidats_FK FOREIGN KEY (id_Candidats) REFERENCES Candidats(id)
);


#------------------------------------------------------------
# Table: ExamensTheoriques
#------------------------------------------------------------

CREATE TABLE ExamensTheoriques(
        id_Examens   Int identity(1,1) NOT NULL ,
        id           Int NOT NULL ,
        note         Int NOT NULL ,
        decision     Varchar (50) NOT NULL ,
        dateExamen   Date NOT NULL ,
        nbEchec      Int NOT NULL ,
        id_Candidats Int NOT NULL
	,CONSTRAINT ExamensTheoriques_PK PRIMARY KEY (id_Examens,id)

	,CONSTRAINT ExamensTheoriques_Examens_FK FOREIGN KEY (id_Examens) REFERENCES Examens(id)
	,CONSTRAINT ExamensTheoriques_Candidats0_FK FOREIGN KEY (id_Candidats) REFERENCES Candidats(id)
);


#------------------------------------------------------------
# Table: ExamensPratiques
#------------------------------------------------------------

CREATE TABLE ExamensPratiques(
        id_Examens   Int identity(1,1) NOT NULL ,
        id           Int NOT NULL ,
        decision     Varchar (50) NOT NULL ,
        dateExamen   Date NOT NULL ,
        nbEchec      Int NOT NULL ,
        id_Candidats Int NOT NULL
	,CONSTRAINT ExamensPratiques_PK PRIMARY KEY (id_Examens,id)

	,CONSTRAINT ExamensPratiques_Examens_FK FOREIGN KEY (id_Examens) REFERENCES Examens(id)
	,CONSTRAINT ExamensPratiques_Candidats0_FK FOREIGN KEY (id_Candidats) REFERENCES Candidats(id)
);


#------------------------------------------------------------
# Table: Seances
#------------------------------------------------------------

CREATE TABLE Seances(
        id            Int  identity(1,1)  NOT NULL ,
        date          Date NOT NULL ,
        typeSeance    Varchar (50) NOT NULL ,
        id_Vehicules  Int ,
        id_Personnels Int NOT NULL
	,CONSTRAINT Seances_PK PRIMARY KEY (id)

	,CONSTRAINT Seances_Vehicules_FK FOREIGN KEY (id_Vehicules) REFERENCES Vehicules(id)
	,CONSTRAINT Seances_Personnels0_FK FOREIGN KEY (id_Personnels) REFERENCES Personnels(id)
);


#------------------------------------------------------------
# Table: SeancesCandidats
#------------------------------------------------------------

CREATE TABLE SeancesCandidats(
        id         Int identity(1,1) NOT NULL ,
        id_Seances Int NOT NULL
	,CONSTRAINT SeancesCandidats_PK PRIMARY KEY (id,id_Seances)

	,CONSTRAINT SeancesCandidats_Candidats_FK FOREIGN KEY (id) REFERENCES Candidats(id)
	,CONSTRAINT SeancesCandidats_Seances0_FK FOREIGN KEY (id_Seances) REFERENCES Seances(id)
);

