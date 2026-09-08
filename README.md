# Simply Swords Tweaks

**Simply Swords Tweaks (SST)** is an add-on that aims to customize, balance, and fix various mechanics, weapons, and Battle Standards from Sweenus' Simply Swords mod.

---

## Features

### Battle Standards Customization
- Configure per-banner their buff and debuff amplifiers, their aura radius, as well as extra effects
- The Modern Field option automatically reflects the radius changes
  - A new Field has been added to the `Nullification Standard` (same color as `Netherfused Gems`)
- Toggle to prevent the `Battle Fatigue` status effect from being applied to the caster, applying instead an internal (customizable) cooldown
  - This prevents bypassing cooldowns by drinking milk or cleansing effects any other way
- Toggle whether Battle Standards can be healed by healing spells or positive effects

### Bug Fixes
- Fixes the bug where Battle Standards would maintain higher amplifier levels if the player already had an external higher amplifier (e.g. `Enigma` maintaining `Twisted Blade's` Haste XVI)
- Fixes instances where `Galeforce` could attack its own summoner while under `Tempest's` ability
- Fixes the bug where Icewhisper's aura infinitely stacks Slowness on targets

### In game config
- Tweak everything in the in-game config (or the config file)
- Config is synced from servers to clients upon joining
- Only OPed players can modify the mod's settings in game. Singleplayer worlds are not affected by this

---

## Compatibility

* **[ReBalance](https://www.curseforge.com/minecraft/mc-mods/rebalance)**
  - When installed and enabled in config, Battle Standard aura damage against players respects ReBalance's PvP damage multiplier and global reductions

---

## Building from Source

SST depends on **S-Lib**, which must be published to your local Maven repository before compiling.

#### 1. Clone and Publish S-Lib
```bash
git clone https://github.com/Stalemated/s-lib.git
cd s-lib
# Publish to maven local
gradlew.bat publishToMavenLocal # (Windows)
./gradlew publishToMavenLocal   # (Linux / macOS)
cd ..
```

#### 2. Clone SST and Build
```bash
git clone https://github.com/Stalemated/simply_swords_tweaks.git
cd simply_swords_tweaks
# Build the mod
gradlew.bat build # (Windows)
./gradlew build   # (Linux / macOS)
```

Output JARs will be located in `[loader]/build/libs/`.

---

## Available Platforms

| Platform | Versions             |
|----------|----------------------|
| Fabric   | 1.20.1, 1.21.1 (WIP) |
| Forge    | 1.20.1               |
| NeoForge | 1.21.1 (WIP)         |

---

## Dependencies

- [Simply Swords](https://www.curseforge.com/minecraft/mc-mods/simply-swords) (>= 1.70.0)
- [S-Lib](https://www.curseforge.com/minecraft/mc-mods/s-lib)
- [YACL](https://www.curseforge.com/minecraft/mc-mods/yacl)

### Fabric Only
- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
- [ModMenu](https://www.curseforge.com/minecraft/mc-mods/modmenu) (Optional)

### Optional
- [ReBalance](https://www.curseforge.com/minecraft/mc-mods/rebalance)

---

## Credits

- Based on [ImEden6's](https://github.com/ImEden6) idea for the [Haste Tweaks](https://github.com/ImEden6/simplyswords-haste-tweaks) mod.
- [Sweenus](https://github.com/Sweenus) for creating Simply Swords.
