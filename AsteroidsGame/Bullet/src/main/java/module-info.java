import Danielfn21.common.services.IBulletCreator;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;

module Bullet {
    requires Common;

    provides IBulletCreator with Danielfn21.bullet.BulletPlugin;
    provides IGamePluginService with Danielfn21.bullet.BulletPlugin;
    provides IEntityProcessingService with Danielfn21.bullet.BulletControlSystem;
}