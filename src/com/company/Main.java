package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        //Create instances of WildCat
        WildCat wildCat = new WildCat("Grut", "Tiger");
        WildCat wildCat1 = new WildCat("Funk","Lynx");
        //Create instances of HomeCat
        HomeCat homeCat = new HomeCat("Murka","British");
        HomeCat homeCat1 = new HomeCat("Barsik","Persian ");

        //Create list of all cats
        ArrayList<Cat> catsList = new ArrayList<>();
        catsList.add(wildCat);
        catsList.add(wildCat1);
        catsList.add(homeCat);
        catsList.add(homeCat1);

        //print name and breed of all cats
        System.out.println("List of cats: ");
        for (int i = 0; i < catsList.size(); i++) {
            System.out.println("Name: " + catsList.get(i).name);
            System.out.println("Breed: " + catsList.get(i).breed);
        }

        //print abilities home cats
        System.out.println("Home cat's abilities: ");
        homeCat.layOnSofa();
        homeCat.SpoilShoes();
        homeCat.eat();
        homeCat.play();

        //print abilities wild cats
        System.out.println("Wild cat's abilities: ");
        wildCat.HatePeople();
        wildCat.eat();
        wildCat.play();
    }
}
