package com.company;



public class HomeCat extends Cat implements Playable{
    public String master;

    public HomeCat(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public HomeCat(){};

    public void layOnSofa(){
        System.out.println("Laying on a sofa - it's a my hobby of my life :)");
    }

    public void SpoilShoes(){
        System.out.println("I didn't spoil a shoes ^_^");
    }


    public void eat(){
        System.out.println("I like to eat a Kitekat...om-nom-nom..");
    }

    public void play(){
        System.out.println("I'm playing with earphones..purr purr..");
    }
}
