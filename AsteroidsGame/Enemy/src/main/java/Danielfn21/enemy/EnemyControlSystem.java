package Danielfn21.enemy;

import Danielfn21.common.data.Entity;
import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;
import Danielfn21.common.data.entityparts.LifePart;
import Danielfn21.common.data.entityparts.MovingPart;
import Danielfn21.common.data.entityparts.PositionPart;
import Danielfn21.common.data.entityparts.ShootingPart;
import Danielfn21.common.services.IBulletCreator;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.util.SPILocator;

import java.util.Collection;

public class EnemyControlSystem implements IEntityProcessingService {
    private float totalTime = 0f;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            ShootingPart shootingPart = enemy.getPart(ShootingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);

            this.totalTime = (this.totalTime + gameData.getDelta()) % 100;

            float controlRotateAmplifier = (float) (Math.random() * 2f) + 0.1f;
            float controlGeneralAmplifier = (float) (Math.random() * 2f) + 0.1f;

            movingPart.setLeft(
                    (Math.sin(totalTime * controlRotateAmplifier + (Math.random() * 2f)) * controlGeneralAmplifier) < this.getRandomNumber(-0.3f, -controlGeneralAmplifier)
            );
            movingPart.setRight(
                    (Math.sin(totalTime * controlRotateAmplifier + (Math.random() * 2f)) * controlGeneralAmplifier) > this.getRandomNumber(0.8f, controlGeneralAmplifier)
            );
            movingPart.setUp(
                    this.getRandomNumber(0.01f, 1f) > this.getRandomNumber(0.5f, 1f)
            );

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            shootingPart.process(gameData, enemy);
            lifePart.process(gameData, enemy);

            shootingPart.setShooting(this.getRandomNumber(0f, 1f) > 0.99f);
            if (shootingPart.getShooting()) {
                Collection<IBulletCreator> bulletPlugins = SPILocator.locateAll(IBulletCreator.class);

                for (IBulletCreator bulletPlugin : bulletPlugins) {
                    world.addEntity(bulletPlugin.create(enemy, gameData));
                }
            }

            if (lifePart.isDead()) {
                world.removeEntity(enemy);
            }

            updateShape(enemy);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = (float) (Math.PI / 2f);

        shapex[0] = (float) (x - Math.cos(radians) * 10);
        shapey[0] = (float) (y - Math.sin(radians) * 10);
        shapex[1] = (float) (x + Math.cos(radians) * 5);
        shapey[1] = (float) (y + Math.sin(radians) * 5);
        shapex[2] = (float) (x + Math.cos(radians + Math.PI / 2) * 5);
        shapey[2] = (float) (y + Math.sin(radians + Math.PI / 2) * 5);
        shapex[3] = (float) (x - Math.cos(radians + Math.PI / 2) * 5);
        shapey[3] = (float) (y - Math.sin(radians + Math.PI / 2) * 5);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    private float getRandomNumber(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }
}
