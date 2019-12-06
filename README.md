# Pilotable Starsector Fighters

 *HowCanSomeoneLetaGoodThinggotoWaste (HCSLGTW) is a Starsector mod that makes fighters pilotable, even modded ones.*

## Currently Supported:

Mod Name | Completion Level | Bugs? | Deviations 
-------- | ---------------- | ----- | ----------
Diable Avionics | 90% | [II], [III] | [A]
Dassault-Mikoyan | 40% | [III] | [B]

## Planned to be Supported:
Mod Name | Completion Level | Confusion | Planned Implementation
-------- | ---------------- | --------- | ----------------------
Artefact | 0% | NaN | NaN
Disassemble Reassemble | 0% | NaN | NaN
Foundation of Borken | 0% | NaN | NaN
NGO | 0% | NaN | NaN
ORA | 0% | NaN | NaN
SAD | 0% | NaN | NaN
Shadowyards | 0% | NaN | NaN
Ship and Weapon Pack | 0% | NaN | NaN
Tyrador Safeguard Coalition | 0% | NaN | NaN


### Current Bugs:
 
 [II] - Blizzaia is basically useless, as it has nothing but missiles, and one IBIS.
 
 [III] - All fighters cost over 50-60 supplies just to fix, starting from 0% CR.

 [IV] - Can't ever build the ships, as they will consume all your capacity instead. Dunno if fixed by commit f958bac.
 

### Deviations:

 [A] - Blizzaia + adds a missile autoloader, and *technically* fixes [II]. Problem is that it murders everything.
 
 [B] - The Foil Bit, the tiniest thingie, is somehow one of the ***strongest*** single ship fighters in the mod currently. Can even solo some small frigates, as long as there's no beams in play. No fighter can stand against beams.


### Fixed Bugs:

 [I] - `Zephyr will crash with a null error due to missing weapons, either side. Will attempt to remedy this by separating its arms from its weapons.` 99% fixed as of commit 80a92a1. 


## How to install custom Jars?

* Diable Avionics - Dump the jar in the root folder of the Diable mod folder. Replace the `mod_info.json` with the one in the folder as well. Make sure to backup, just in case. ~~or just reinstall the mod~~ 
 
