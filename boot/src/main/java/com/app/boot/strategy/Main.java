package com.app.boot.strategy;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        final Map<MagicType,Magic> magics = new HashMap<>();
        Member member = new Member();
        final Fire fire = new Fire(member);
        final Shiden shiden = new Shiden(member);
        final HellFile hellFile = new HellFile(member);

        magics.put(MagicType.fire, fire);
        magics.put(MagicType.shiden, shiden);
        magics.put(MagicType.hellFire, hellFile);

        


    }
}
