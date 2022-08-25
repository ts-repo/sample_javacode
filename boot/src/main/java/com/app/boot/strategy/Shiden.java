package com.app.boot.strategy;

public class Shiden implements Magic{

    private final Member member;

    Shiden(final Member member){
        this.member = member;
    }

    @Override
    public String name() {
        return "紫電";
    }

    @Override
    public int costMagicPoint() {
        return 5 + (int)(member.level * 0.2);
    }

    @Override
    public int attackPower() {
        return 50 + (int)(member.agility * 1.5);
    }

    @Override
    public int costTechnicalPoint() {
        return 5;
    }
}
