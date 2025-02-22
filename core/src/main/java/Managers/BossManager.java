package Managers;

import BulletHellPatterns.BulletHellPattern;
import BulletHellPatterns.CirclePattern;
import BulletHellPatterns.DynamicSpiralPattern;
import BulletHellPatterns.ForkPattern;
import BulletHellPatterns.SpiralPattern;
import Enemies.Boss;
import Enemies.Enemy;

public class BossManager extends EnemyManager{
	private int[] speedOptions = {800,900,1000};
	private int[] healthOptions = {25000, 27000, 30000};
	
	public BossManager() {
		bhpType.add(new SpiralPattern());
		bhpType.add(new DynamicSpiralPattern());
		bhpType.add(new CirclePattern());
		bhpType.add(new ForkPattern());
	}

	@Override
	public void manageBHPType(Enemy e, int choice) {
		if (e instanceof Boss) {
			Boss boss = (Boss) e;
			for (choice = 0; choice < bhpType.size() ; choice++) {
				BulletHellPattern bhpChosen = bhpType.get(choice);
				boss.setBossBHPlist(bhpChosen);
			}
		}
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
