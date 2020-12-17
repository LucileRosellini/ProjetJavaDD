package com.projectJava.thymeleaf.model;

public class Personnage {

        private String name ;
        private int ID;
        private String type;

        public Personnage() {
        }

        //ICI Declaration des attributs de character
        //ID NAME CLASSE PERSO
        //getter setter
        //constructeur avec 0 arguments ==> Convention . On définit toujours un constructeur vide.
        //constructeur avec 3 arguments



        public Personnage(String nomJoueur, int Identifiant , String typeWarrior ) {
            this.name = nomJoueur;
            this.ID = Identifiant;
            this.type = typeWarrior;
        }



        public String getName() {
            return(this.name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getID() {
            return (this.ID);
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getType() {
            return (this.type);
        }

        public void setType(String type) {
            this.type = type;
        }
    }