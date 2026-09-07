package com.stalemated.simplytweaks.gui.screen;

import com.stalemated.lib.config.permissions.ClientConfigPermissions;
import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class SSTConfigScreen {

    public static Screen create(Screen parent) {
        boolean canEdit = ClientConfigPermissions.OP_OR_SP.get();

        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("sst.config_screen.title"))
                .category(createBattleStandardsCategory(canEdit))
                .category(createBugFixesCategory(canEdit))
                .category(createCompatibilityCategory(canEdit))
                .save(ConfigManager.MANAGER::saveFromClient)
                .build()
                .generateScreen(parent);
    }

    private static ConfigCategory createBattleStandardsCategory(boolean canEdit) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("sst.category.battle_standards"))
                .tooltip(Text.translatable("sst.category.battle_standards.desc"))
                .group(getGeneralGroup(canEdit))
                .group(getGaleforceGroup(canEdit))
                .group(getAbyssalStandardGroup(canEdit))
                .group(getSunfireGroup(canEdit))
                .group(getNullificationGroup(canEdit))
                .build();
    }

    private static OptionGroup getGeneralGroup(boolean canEdit) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("sst.group.banner_general"))
                .option(createBooleanOption(
                        "sst.option.banner_healing_allowed",
                        canEdit,
                        cfg -> cfg.banner_healing_allowed,
                        (cfg, val) -> cfg.banner_healing_allowed = val,
                        true
                ))
                .build();
    }

    private static OptionGroup getGaleforceGroup(boolean canEdit) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("sst.group.galeforce"))
                .option(createIntOption(
                        "sst.option.galeforce_haste_amplifier",
                        canEdit, 0, 15, 1,
                        cfg -> cfg.galeforce_haste_amplifier,
                        (cfg, val) -> cfg.galeforce_haste_amplifier = val,
                        7
                ))
                .option(createFloatOption(
                        "sst.option.galeforce_haste_radius",
                        canEdit, 0.5f, 32.0f, 0.5f,
                        cfg -> cfg.galeforce_haste_radius,
                        (cfg, val) -> cfg.galeforce_haste_radius = val,
                        3.0f
                ))
                .option(createIntOption(
                        "sst.option.galeforce_aoe_radius",
                        canEdit, 1, 32, 1,
                        cfg -> cfg.galeforce_aoe_radius,
                        (cfg, val) -> cfg.galeforce_aoe_radius = val,
                        2
                ))
                .option(createIntOption(
                        "sst.option.galeforce_pain_amplifier",
                        canEdit, 0, 100, 1,
                        cfg -> cfg.galeforce_pain_amplifier,
                        (cfg, val) -> cfg.galeforce_pain_amplifier = val,
                        49
                ))
                .build();
    }

    private static OptionGroup getAbyssalStandardGroup(boolean canEdit) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("sst.group.abyssal_standard"))
                .option(createIntOption(
                        "sst.option.abyssal_standard_haste_amplifier",
                        canEdit, 0, 15, 1,
                        cfg -> cfg.abyssal_standard_haste_amplifier,
                        (cfg, val) -> cfg.abyssal_standard_haste_amplifier = val,
                        7
                ))
                .option(createFloatOption(
                        "sst.option.abyssal_standard_haste_radius",
                        canEdit, 0.5f, 32.0f, 0.5f,
                        cfg -> cfg.abyssal_standard_haste_radius,
                        (cfg, val) -> cfg.abyssal_standard_haste_radius = val,
                        3.0f
                ))
                .option(createIntOption(
                        "sst.option.abyssal_standard_aoe_radius",
                        canEdit, 1, 32, 1,
                        cfg -> cfg.abyssal_standard_aoe_radius,
                        (cfg, val) -> cfg.abyssal_standard_aoe_radius = val,
                        6
                ))
                .option(createIntOption(
                        "sst.option.abyssal_standard_aoe_haste_amplifier",
                        canEdit, 0, 15, 1,
                        cfg -> cfg.abyssal_standard_aoe_haste_amplifier,
                        (cfg, val) -> cfg.abyssal_standard_aoe_haste_amplifier = val,
                        2
                ))
                .option(createIntOption(
                        "sst.option.abyssal_standard_aoe_slowness_amplifier",
                        canEdit, 0, 15, 1,
                        cfg -> cfg.abyssal_standard_aoe_slowness_amplifier,
                        (cfg, val) -> cfg.abyssal_standard_aoe_slowness_amplifier = val,
                        0
                ))
                .build();
    }

    private static OptionGroup getSunfireGroup(boolean canEdit) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("sst.group.sunfire"))
                .option(createIntOption(
                        "sst.option.sunfire_aoe_radius",
                        canEdit, 1, 32, 1,
                        cfg -> cfg.sunfire_aoe_radius,
                        (cfg, val) -> cfg.sunfire_aoe_radius = val,
                        6
                ))
                .option(createIntOption(
                        "sst.option.sunfire_strength_amplifier",
                        canEdit, 0, 15, 1,
                        cfg -> cfg.sunfire_strength_amplifier,
                        (cfg, val) -> cfg.sunfire_strength_amplifier = val,
                        1
                ))
                .build();
    }

    private static OptionGroup getNullificationGroup(boolean canEdit) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("sst.group.nullification"))
                .option(createIntOption(
                        "sst.option.nullification_aoe_radius",
                        canEdit, 1, 32, 1,
                        cfg -> cfg.nullification_aoe_radius,
                        (cfg, val) -> cfg.nullification_aoe_radius = val,
                        6
                ))
                .option(createBooleanOption(
                        "sst.option.nullification_prevent_battle_fatigue",
                        canEdit,
                        cfg -> cfg.nullification_prevent_battle_fatigue,
                        (cfg, val) -> cfg.nullification_prevent_battle_fatigue = val,
                        true
                ))
                .option(createFloatOption(
                        "sst.option.nullification_cooldown",
                        canEdit, 1.0f, 60.0f, 0.5f,
                        cfg -> cfg.nullification_cooldown,
                        (cfg, val) -> cfg.nullification_cooldown = val,
                        40.0f
                ))
                .build();
    }

    private static ConfigCategory createBugFixesCategory(boolean canEdit) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("sst.category.bug_fixes"))
                .tooltip(Text.translatable("sst.category.bug_fixes.desc"))
                .option(createBooleanOption(
                        "sst.option.fix_status_effect_stacking",
                        canEdit,
                        cfg -> cfg.fix_status_effect_stacking,
                        (cfg, val) -> cfg.fix_status_effect_stacking = val,
                        true
                ))
                .option(createBooleanOption(
                        "sst.option.fix_elemental_vortex_leak",
                        canEdit,
                        cfg -> cfg.fix_elemental_vortex_leak,
                        (cfg, val) -> cfg.fix_elemental_vortex_leak = val,
                        true
                ))
                .option(createIntOption(
                        "sst.option.icewhisper_slowness_cap",
                        canEdit, -1, 15, 1,
                        cfg -> cfg.icewhisper_slowness_cap,
                        (cfg, val) -> cfg.icewhisper_slowness_cap = val,
                        3
                ))
                .build();
    }

    private static ConfigCategory createCompatibilityCategory(boolean canEdit) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("sst.category.compatibility"))
                .tooltip(Text.translatable("sst.category.compatibility.desc"))
                .option(createBooleanOption(
                        "sst.option.rebalance_compat_enabled",
                        canEdit,
                        cfg -> cfg.rebalance_compat_enabled,
                        (cfg, val) -> cfg.rebalance_compat_enabled = val,
                        true
                ))
                .build();
    }

    private static Option<Integer> createIntOption(String nameKey, boolean canEdit, int min, int max, int step, Function<SSTConfig, Integer> getter, BiConsumer<SSTConfig, Integer> setter, int defaultValue) {
        return Option.<Integer>createBuilder()
                .name(Text.translatable(nameKey))
                .description(OptionDescription.of(
                        Text.translatable(nameKey + ".desc"),
                        canEdit ? Text.empty() : Text.translatable("sst.config_screen.op_required")
                ))
                .binding(
                        defaultValue,
                        () -> {
                            SSTConfig cfg = ConfigManager.getActiveConfig();
                            return cfg != null ? getter.apply(cfg) : defaultValue;
                        },
                        val -> ConfigManager.MANAGER.updateField(setter, val, ClientConfigPermissions.OP_OR_SP)
                )
                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(min, max).step(step))
                .available(canEdit)
                .build();
    }

    private static Option<Float> createFloatOption(String nameKey, boolean canEdit, float min, float max, float step, Function<SSTConfig, Float> getter, BiConsumer<SSTConfig, Float> setter, float defaultValue) {
        return Option.<Float>createBuilder()
                .name(Text.translatable(nameKey))
                .description(OptionDescription.of(
                        Text.translatable(nameKey + ".desc"),
                        canEdit ? Text.empty() : Text.translatable("sst.config_screen.op_required")
                ))
                .binding(
                        defaultValue,
                        () -> {
                            SSTConfig cfg = ConfigManager.getActiveConfig();
                            return cfg != null ? getter.apply(cfg) : defaultValue;
                        },
                        val -> ConfigManager.MANAGER.updateField(setter, val, ClientConfigPermissions.OP_OR_SP)
                )
                .controller(opt -> FloatSliderControllerBuilder.create(opt).range(min, max).step(step))
                .available(canEdit)
                .build();
    }

    private static Option<Boolean> createBooleanOption(String nameKey, boolean canEdit, Function<SSTConfig, Boolean> getter, BiConsumer<SSTConfig, Boolean> setter, boolean defaultValue) {
        return Option.<Boolean>createBuilder()
                .name(Text.translatable(nameKey))
                .description(OptionDescription.of(
                        Text.translatable(nameKey + ".desc"),
                        canEdit ? Text.empty() : Text.translatable("sst.config_screen.op_required")
                ))
                .binding(
                        defaultValue,
                        () -> {
                            SSTConfig cfg = ConfigManager.getActiveConfig();
                            return cfg != null ? getter.apply(cfg) : defaultValue;
                        },
                        val -> ConfigManager.MANAGER.updateField(setter, val, ClientConfigPermissions.OP_OR_SP)
                )
                .controller(TickBoxControllerBuilder::create)
                .available(canEdit)
                .build();
    }
}
