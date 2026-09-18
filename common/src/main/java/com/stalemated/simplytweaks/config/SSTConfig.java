package com.stalemated.simplytweaks.config;

import com.stalemated.lib.config.annotation.*;
import com.stalemated.lib.config.network.SyncMode;

@Sync(SyncMode.OVERRIDE_CLIENT)
public class SSTConfig {

    @Comment("""
            --------------------------------
            General Banner Settings
            --------------------------------
            Allow battle standard entities to receive healing from any source.
            """)
    public boolean banner_healing_allowed = true;

    @Comment("""
            --------------------------------
            Galeforce (Enigma)
            --------------------------------
            Haste amplifier granted to owner near Galeforce.
            """)
    @RangeInt(min = 0, max = 15)
    public int galeforce_haste_amplifier = 7;

    @Comment("Radius around Galeforce in blocks to receive the Haste effect.")
    @RangeFloat(min = 1.0f, max = 32.0f)
    public float galeforce_haste_radius = 3.0f;

    @Comment("AoE pull and effect radius for Galeforce.")
    @RangeInt(min = 0, max = 32)
    public int galeforce_aoe_radius = 2;

    @Comment("Pain amplifier applied to targets.")
    @RangeInt(min = 0, max = 64)
    public int galeforce_pain_amplifier = 49;

    @Comment("""
            --------------------------------
            Abyssal Standard (Harbinger)
            --------------------------------
            Haste amplifier granted to owner by Abyssal Standard.
            """)
    @RangeInt(min = 0, max = 15)
    public int abyssal_standard_haste_amplifier = 7;

    @Comment("Radius around Abyssal Standard in blocks to receive the Haste effect.")
    @RangeFloat(min = 1.0f, max = 32.0f)
    public float abyssal_standard_haste_radius = 3.0f;

    @Comment("Radius around Abyssal Standard in blocks for team Haste, aura damage and negative effects for enemies.")
    @RangeInt(min = 0, max = 32)
    public int abyssal_standard_aoe_radius = 6;

    @Comment("Haste amplifier granted to nearby allies by Abyssal Standard.")
    @RangeInt(min = 0, max = 15)
    public int abyssal_standard_aoe_haste_amplifier = 2;

    @Comment("Slowness amplifier applied to enemies in range.")
    @RangeInt(min = 0, max = 15)
    public int abyssal_standard_aoe_slowness_amplifier = 0;

    @Comment("""
            --------------------------------
            Righteous Standard (Sunfire)
            --------------------------------
            Radius around Sunfire in blocks for team Strength, healing and aura damage.
            """)
    @RangeInt(min = 0, max = 32)
    public int sunfire_aoe_radius = 6;

    @Comment("Strength amplifier granted to nearby allies by Sunfire.")
    @RangeInt(min = 0, max = 15)
    public int sunfire_strength_amplifier = 1;

    @Comment("""
            --------------------------------
            Nullification Standard (Netherfused Gem Effect)
            --------------------------------
            Radius around Nullification Standard in blocks for removing buffs from enemies and debuffs from allies.""")
    @RangeInt(min = 0, max = 32)
    public int nullification_aoe_radius = 6;

    @Comment("Prevents the Battle Fatigue harmful status effect from being applied to the caster. This enables instead an immutable internal cooldown system to handle Nullification Standard's cooldown.")
    public boolean nullification_prevent_battle_fatigue = true;

    @Comment("Cooldown in seconds before Nullification Standard can be summoned again. Only works when 'nullification_prevent_battle_fatigue' is set to true.")
    @RangeFloat(min = 1.0f, max = 60.0f)
    public float nullification_cooldown = 40.0f;

    @Comment("""
            --------------------------------
            Bug Fixes
            --------------------------------
            Fix the Effect Stacking bug where a banner can maintain a higher amplifier than set in the config if you obtain it some other way (e.g. Enigma maintaining Twisted Blade's Haste 15 while the player is near Galeforce).
            """)
    public boolean fix_status_effect_stacking = true;

    @Comment("Fix Galeforce attacking its owner while they have the 'Elemental Vortex' status effect.")
    public boolean fix_elemental_vortex_leak = true;

    @Comment("Caps Icewhisper's Slowness debuff amplifier from stacking infinitely. Set to '-1' to disable the fix.")
    @RangeInt(min = 0, max = 15)
    public int icewhisper_slowness_cap = 3;

    @Comment("""
            --------------------------------
            Compatibility
            --------------------------------
            Apply ReBalance global reduction and PvP multiplier to Battle Standard damage.
            """)
    public boolean rebalance_compat_enabled = true;
}
