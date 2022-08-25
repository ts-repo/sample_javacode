package com.app.boot.strategy;

public class HellFile implements Magic{

    private final Member member;

    HellFile(final Member member){
        this.member = member;
    }

    @Override
    public String name() {
        return "地獄の業火";
    }

    @Override
    public int costMagicPoint() {
        return 16;
    }

    @Override
    public int attackPower() {
        return 200 + (int)(member.magicAttack * 0.5 + member.vitality * 2);
    }

    @Override
    public int costTechnicalPoint() {
        return 20 + (int)(member.level * 0.4);
    }
}
