package data.missions.gloriousassault;

import com.fs.starfarer.api.campaign.CargoAPI;
import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

public class MissionDefinition implements MissionDefinitionPlugin {
    @Override
    public void defineMission(MissionDefinitionAPI api) {


        // Set up the fleets so we can add ships and fighter wings to them.
        // In this scenario, the fleets are attacking each other, but
        // in other scenarios, a fleet may be defending or trying to escape
        //
        // In this case, however, we'll be looking at a gladiator trying 
        // not to die, heh.
        api.initFleet(FleetSide.PLAYER, "GLD", FleetGoal.ATTACK, false);
        api.initFleet(FleetSide.ENEMY, "TRA", FleetGoal.ATTACK, true);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "Chaplain Hendricks");
        api.setFleetTagline(FleetSide.ENEMY, "Captured Scrap Bandits");

        // These show up as items in the bulleted list under 
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("How'll he make it?");
        api.addBriefingItem("Who knows! But it'll be fun to watch, mark my words!");

        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        api.setHyperspaceMode(true);


        api.addToFleet(FleetSide.PLAYER, "diableavionics_gladiator_frost_ship_variant", FleetMemberType.SHIP,"Experimental Mini-Frigate", true);

        // Set up the enemy fleet.                
        api.addToFleet(FleetSide.ENEMY, "diableavionics_arbitrator_ship_variant", FleetMemberType.SHIP,"RH-3110", false);
        api.addToFleet(FleetSide.ENEMY, "diableavionics_arbitrator_ship_variant", FleetMemberType.SHIP,"RH-2112", false);
        //api.addToFleet(FleetSide.ENEMY, "diableavionics_raven_ship_variant", FleetMemberType.SHIP,"RH-8925", false);
        //api.addToFleet(FleetSide.ENEMY, "diableavionics_raven_ship_variant", FleetMemberType.SHIP,"RH-0957", false);
        //api.addToFleet(FleetSide.ENEMY, "diableavionics_raven_ship_variant", FleetMemberType.SHIP,"RH-4135", false);
        //api.addToFleet(FleetSide.ENEMY, "diableavionics_frost_ship_variant", FleetMemberType.SHIP,"RH-9185", false);
        //api.addToFleet(FleetSide.ENEMY, "diableavionics_frost_ship_variant", FleetMemberType.SHIP,"RH-2785", false);
        api.addToFleet(FleetSide.ENEMY, "diableavionics_frost_ship_variant", FleetMemberType.SHIP,"RH-7146", false);
        api.addToFleet(FleetSide.ENEMY, "diableavionics_frost_ship_variant", FleetMemberType.SHIP,"RH-1758", false);


        // Set up the map.
        float width = 6000f;
        float height = 12000f;
        api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);

        float minX = -width/2;
        float minY = -height/2;

        // All the addXXX methods take a pair of coordinates followed by data for
        // whatever object is being added.

        // And a few random ones to spice up the playing field.
        // A similar approach can be used to randomize everything
        // else, including fleet composition.

        // TODO:
        // Make this a circle and arena shaped?
        // And then maybe add some lighter nebula as obstacles.

        for (int i = 0; i < 120; i++) {
            // Middle of the map would be (0, 0)?
            // This part should go from 0 to 750.
            // Maybe add a modifier to make it go farther?
            // This made a pretty sweet barrier, somehow.
            float x = 120 + ((750 / 100) * -i * (i / 1080));
            float y = 120 + ((1500 / 100) * -i * (i / 1080));
            float radius = 50f + (float) Math.random() * 500f;
            api.addNebula(x, y, radius);
        }
    }
}
