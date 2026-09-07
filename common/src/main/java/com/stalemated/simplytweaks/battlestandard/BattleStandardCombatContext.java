package com.stalemated.simplytweaks.battlestandard;

public final class BattleStandardCombatContext {
    private static final ThreadLocal<Integer> DEPTH = ThreadLocal.withInitial(() -> 0);

    private BattleStandardCombatContext() {}

    public static void enter() {
        DEPTH.set(DEPTH.get() + 1);
    }

    public static void exit() {
        int current = DEPTH.get();
        if (current <= 1) {
            DEPTH.remove();
        } else {
            DEPTH.set(current - 1);
        }
    }

    public static boolean isBannerDamage() {
        return DEPTH.get() > 0;
    }
}
