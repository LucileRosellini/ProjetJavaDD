package com.projectJava.thymeleaf.model;

public class Personnage {

    private String name ;
    private boolean type;

    public Personnage() {
    }

    //ICI Declaration des attributs de character
    //ID NAME CLASSE PERSO
    //getter setter
    //constructeur avec 0 arguments ==> Convention . On définit toujours un constructeur vide.
    //constructeur avec 3 arguments



    public Personnage(String nomJoueur , boolean typeWarrior ) {
        this.name = nomJoueur;
        this.type = typeWarrior;
    }



    public String getName() {
        return(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getType() {
        return (this.type);
    }

    public void setType(boolean type) {
        this.type = type;
    }

}
