import Danielfn21.common.services.IBulletCreator;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;
import Danielfn21.common.util.SPILocator;

module Enemy {
    requires Common;

    uses SPILocator;
    uses IBulletCreator;

    provides IGamePluginService with Danielfn21.enemy.EnemyPlugin;
    provides IEntityProcessingService with Danielfn21.enemy.EnemyControlSystem;
}