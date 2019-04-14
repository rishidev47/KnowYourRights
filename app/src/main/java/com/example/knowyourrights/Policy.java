package com.example.knowyourrights;

public class Policy {
    public String name;
    public String category;
    public String eligibility;
    public String discription;
    public String link;

    public Policy(String name, String category, String eligibility, String discription, String link){
        this.name=name;
        this.category=category;
        this.eligibility=eligibility;
        this.discription=discription;
        this.link=link;
    }

    @Override
    public String toString() {
        return name+" "+category+" "+eligibility+" "+discription+" "+link;
    }
}
