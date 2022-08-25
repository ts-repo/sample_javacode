package com.app.boot.strategy;

public class Fire implements Magic{

    private final Member member;

    Fire(final Member member){
        this.member = member;
    }
    @Override
    public String name() {
        return "ファイア";
    }
    @Override
    public int costMagicPoint() {
        return 2;
    }
    @Override
    public int attackPower() {
        return 20 + (int)(member.level * 0.5);
    }
    @Override
    public int costTechnicalPoint() {
        return 0;
    }
}
