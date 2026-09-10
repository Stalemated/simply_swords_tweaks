# Changelog

## 2.0.0+1.20.1

### General Changes
- Rewrote `Simply Swords Battle Standard Tweaks` into a mod that supports both **Fabric** and **Forge** for 1.20.1
- Added a full in-game config GUI using `YACL`
- Migrated config and networking to `S-Lib`
  - Automatically syncs configs from server to clients upon joining or saving
  - In-game config editing is restricted to OPed on servers, singleplayer is not affected

### New Features
- Added Simply Swords' "Modern Field" support to the Nullification Standard
- Modern Field rings for all banners now dynamically scale to their configured radii
- Added an option (`nullification_prevent_battle_fatigue`) to replace the Battle Fatigue status effect with an internal cooldown, preventing cooldown cleansing using milk or any other way of cleansing negative effects
- Added radius and amplifier settings for Righteous and Nullification Standards alongside existing Galeforce and Abyssal Standard options

### Fixes
- Fixed an issue where Icewhisper's aura would stack Slowness infinitely on targets
  - The cap on Slowness can be adjusted freely (the fix can also be disabled)
- Cleaned up the ReBalance compat's code
- Fixed an issue where sometimes Battle Standards did not get the ReBalance scaling applied to them

