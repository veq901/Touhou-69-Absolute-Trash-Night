package Managers;

import BulletHellPatterns.BulletHellPattern;
import BulletHellPatterns.CirclePattern;
import BulletHellPatterns.DynamicSpiralPattern;
import BulletHellPatterns.ForkPattern;
import BulletHellPatterns.SpiralPattern;
import Enemies.Enemy;

public class FairyManager extends EnemyManager{
	private int[] speedOptions = {400,500};
	private int[] healthOptions = {2000, 3000, 4000};
	
	public FairyManager() {
		// loads up all the potential patterns a Fairy can pick from
		bhpType.add(new SpiralPattern());
		bhpType.add(new DynamicSpiralPattern());
		bhpType.add(new CirclePattern());
		bhpType.add(new ForkPattern());
	}
	
	@Override
	public void manageBHPType(Enemy e, int choice) {
		BulletHellPattern bhpChosen = bhpType.get(choice);
		e.setBulletPattern(bhpChosen);
	}
	
	@Override
	public void manageSpeed(Enemy e, int choice) {
		e.setSpeed(speedOptions[choice]);
	}
	
	@Override
	public void manageHealth(Enemy e, int choice) {
		e.setHealth(healthOptions[choice]);
	}
	
	public int getCantSpeedOptions() {return speedOptions.length;}
	public int getCantHealthOptions() {return healthOptions.length;}
	
}
