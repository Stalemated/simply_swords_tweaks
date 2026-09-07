package com.stalemated.simplytweaks.config;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class SSTConfig {

    @SerialEntry(comment = """
            --------------------------------
            General Banner Settings
            --------------------------------
            Allow battle standard entities to receive healing from any source.
            """)
    public boolean banner_healing_allowed = true;

    @SerialEntry(comment = """
            --------------------------------
            Galeforce (Enigma)
            --------------------------------
            Haste amplifier granted to owner near Galeforce.
            """)
    public int galeforce_haste_amplifier = 7;

    @SerialEntry(comment = "Radius around Galeforce in blocks to receive the Haste effect.")
    public float galeforce_haste_radius = 3.0f;

    @SerialEntry(comment = "AoE pull and effect radius for Galeforce.")
    public int galeforce_aoe_radius = 2;

    @SerialEntry(comment = "Pain amplifier applied to targets.")
    public int galeforce_pain_amplifier = 49;

    @SerialEntry(comment = """
            --------------------------------
            Abyssal Standard (Harbinger)
            --------------------------------
            Haste amplifier granted to owner by Abyssal Standard.
            """)
    public int abyssal_standard_haste_amplifier = 7;

    @SerialEntry(comment = "Radius around Abyssal Standard in blocks to receive the Haste effect.")
    public float abyssal_standard_haste_radius = 3.0f;

    @SerialEntry(comment = "Radius around Abyssal Standard in blocks for team Haste, aura damage and negative effects for enemies.")
    public int abyssal_standard_aoe_radius = 6;

    @SerialEntry(comment = "Haste amplifier granted to nearby allies by Abyssal Standard.")
    public int abyssal_standard_aoe_haste_amplifier = 2;

    @SerialEntry(comment = "Slowness amplifier applied to enemies in range.")
    public int abyssal_standard_aoe_slowness_amplifier = 0;

    @SerialEntry(comment = """
            --------------------------------
            Righteous Standard (Sunfire)
            --------------------------------
            Radius around Sunfire in blocks for team Strength, healing and aura damage.
            """)
    public int sunfire_aoe_radius = 6;

    @SerialEntry(comment = "Strength amplifier granted to nearby allies by Sunfire.")
    public int sunfire_strength_amplifier = 1;

    @SerialEntry(comment = """
            --------------------------------
            Nullification Standard (Netherfused Gem Effect)
            --------------------------------
            Radius around Nullification Standard in blocks for removing buffs from enemies and debuffs from allies.""")
    public int nullification_aoe_radius = 6;

    @SerialEntry(comment = "Prevents the Battle Fatigue harmful status effect from being applied to the caster. This enables instead an immutable internal cooldown system to handle Nullification Standard's cooldown.")
    public boolean nullification_prevent_battle_fatigue = true;

    @SerialEntry(comment = "Cooldown in seconds before Nullification Standard can be summoned again. Only works when 'nullification_prevent_battle_fatigue' is set to true.")
    public float nullification_cooldown = 40.0f;

    @SerialEntry(comment = """
            --------------------------------
            Bug Fixes
            --------------------------------
            Fix the Effect Stacking bug where a banner can maintain a higher amplifier than set in the config if you obtain it some other way (e.g. Enigma maintaining Twisted Blade's Haste 15 while the player is near Galeforce).
            """)
    public boolean fix_status_effect_stacking = true;

    @SerialEntry(comment = "Fix Galeforce attacking its owner while they have the 'Elemental Vortex' status effect.")
    public boolean fix_elemental_vortex_leak = true;

    @SerialEntry(comment = "Caps Icewhisper's Slowness debuff amplifier from stacking infinitely. Set to '-1' to disable the fix.")
    public int icewhisper_slowness_cap = 3;

    @SerialEntry(comment = """
            --------------------------------
            Compatibility
            --------------------------------
            Apply ReBalance global reduction and PvP multiplier to Battle Standard damage.
            """)
    public boolean rebalance_compat_enabled = true;

    public void map(SSTConfig source) {
        if (source == null) return;
        this.banner_healing_allowed = source.banner_healing_allowed;
        this.galeforce_haste_amplifier = source.galeforce_haste_amplifier;
        this.galeforce_haste_radius = source.galeforce_haste_radius;
        this.galeforce_aoe_radius = source.galeforce_aoe_radius;
        this.galeforce_pain_amplifier = source.galeforce_pain_amplifier;
        this.abyssal_standard_haste_amplifier = source.abyssal_standard_haste_amplifier;
        this.abyssal_standard_haste_radius = source.abyssal_standard_haste_radius;
        this.abyssal_standard_aoe_radius = source.abyssal_standard_aoe_radius;
        this.abyssal_standard_aoe_haste_amplifier = source.abyssal_standard_aoe_haste_amplifier;
        this.abyssal_standard_aoe_slowness_amplifier = source.abyssal_standard_aoe_slowness_amplifier;
        this.sunfire_aoe_radius = source.sunfire_aoe_radius;
        this.sunfire_strength_amplifier = source.sunfire_strength_amplifier;
        this.nullification_aoe_radius = source.nullification_aoe_radius;
        this.nullification_prevent_battle_fatigue = source.nullification_prevent_battle_fatigue;
        this.nullification_cooldown = source.nullification_cooldown;
        this.fix_status_effect_stacking = source.fix_status_effect_stacking;
        this.fix_elemental_vortex_leak = source.fix_elemental_vortex_leak;
        this.icewhisper_slowness_cap = source.icewhisper_slowness_cap;
        this.rebalance_compat_enabled = source.rebalance_compat_enabled;
    }
}
