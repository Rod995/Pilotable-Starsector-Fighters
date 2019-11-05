package data.missions.unfufi;

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
		api.initFleet(FleetSide.PLAYER, "HAAH", FleetGoal.ATTACK, false);
		api.initFleet(FleetSide.ENEMY, "AAL", FleetGoal.ATTACK, true);

		// Set a small blurb for each fleet that shows up on the mission detail and
		// mission results screens to identify each side.
		api.setFleetTagline(FleetSide.PLAYER, "Child");
		api.setFleetTagline(FleetSide.ENEMY, "The Brethen");
		
		// These show up as items in the bulleted list under 
		// "Tactical Objectives" on the mission detail screen
		api.addBriefingItem("FATHER WANTS YOU BACK");
		api.addBriefingItem("BRING MOTHER HOME");
		api.addBriefingItem("BE THE BEST CHILD YOU CAN BE");
		
		// Set up the player's fleet.  Variant names come from the
		// files in data/variants and data/variants/fighters
        api.addToFleet(FleetSide.PLAYER, "diableavionics_warlust_ship_variant", FleetMemberType.SHIP,"MOTHER", true);
		

		// Enemies.
		api.addToFleet(FleetSide.ENEMY, "diableavionics_arbitrator_ship_variant", FleetMemberType.SHIP,"F", true);
		api.addToFleet(FleetSide.ENEMY, "diableavionics_strife_ship_variant", FleetMemberType.SHIP,"A", true);
		api.addToFleet(FleetSide.ENEMY, "diableavionics_valiant_ship_variant", FleetMemberType.SHIP,"T", true);
		api.addToFleet(FleetSide.ENEMY, "diableavionics_warlust_ship_variant", FleetMemberType.SHIP,"H", true);
		api.addToFleet(FleetSide.ENEMY, "diableavionics_frost_ship_variant", FleetMemberType.SHIP,"E", true);
		api.addToFleet(FleetSide.ENEMY, "diableavionics_zephyr_ship_variant", FleetMemberType.SHIP,"R", true);

		// Map
		float width = 15000f;
		float height = 11000f;
		api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);
		
		float minX = -width/2;
		float minY = -height/2;
		
		// All the addXXX methods take a pair of coordinates followed by data for
		// whatever object is being added.
		
		// And a few random ones to spice up the playing field.
		// A similar approach can be used to randomize everything
		// else, including fleet composition.
		for (int i = 0; i < 7; i++) {
			float x = (float) Math.random() * width - width/2;
			float y = (float) Math.random() * height - height/2;
			float radius = 100f + (float) Math.random() * 800f; 
			api.addNebula(x, y, radius);
		}
		
		// Add objectives. These can be captured by each side
		// and provide stat bonuses and extra command points to
		// bring in reinforcements.
		// Reinforcements only matter for large fleets - in this
		// case, assuming a 100 command point battle size,
		// both fleets will be able to deploy fully right away.

		api.addObjective(minX + width * 0.7f, minY + height * 0.25f, "sensor_array");
		api.addObjective(minX + width * 0.8f, minY + height * 0.75f, "nav_buoy");
		api.addObjective(minX + width * 0.2f, minY + height * 0.25f, "nav_buoy");
		
		
	}

}
