package com.company;

public class WildCat extends Cat implements Playable {

    public WildCat(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public WildCat(){ }

    public void HatePeople(){
        System.out.println("I hate people..rrr..meow..");
    }

    public void eat(){
        System.out.println("I like to eat the people..ha-ha ;)");
    }

    public void play(){
        System.out.println("I'm playing with human bones..boo-ha-ha..");
    }
}
