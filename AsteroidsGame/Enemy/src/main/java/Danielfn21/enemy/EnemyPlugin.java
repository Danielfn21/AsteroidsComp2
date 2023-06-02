// EnemyPlugin.java
package Danielfn21.enemy;

import Danielfn21.common.data.Color;
import Danielfn21.common.data.Entity;
import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;
import Danielfn21.common.data.entityparts.LifePart;
import Danielfn21.common.data.entityparts.MovingPart;
import Danielfn21.common.data.entityparts.PositionPart;
import Danielfn21.common.data.entityparts.ShootingPart;
import Danielfn21.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    public EnemyPlugin() {

    }

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < this.getRandomNumber(2, 5); i++) {
            world.addEntity(this.createEnemyShip(gameData));
        }
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = this.getRandomNumber(0, gameData.getDisplayWidth());
        float y = this.getRandomNumber(0, gameData.getDisplayHeight());
        float radians = this.getRandomNumber(0f, (float) (2 * Math.PI));

        Entity enemyShip = new Enemy();

        enemyShip.setRadius(10);

        enemyShip.setShapeX(new float[] {-10, 0, 10, 0});
        enemyShip.setShapeY(new float[] {10, -10, 10, 2});
        enemyShip.setColor(new Color(1, 0, 0, 1));
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed, 50));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1, 0));
        enemyShip.add(new ShootingPart(0.2f));

        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }

    private float getRandomNumber(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }
}
