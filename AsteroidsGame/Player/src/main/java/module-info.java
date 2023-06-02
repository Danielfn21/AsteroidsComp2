import Danielfn21.common.services.IBulletCreator;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;

module Player {
    requires Common;

    uses IBulletCreator;

    provides IGamePluginService with Danielfn21.player.PlayerPlugin;
    provides IEntityProcessingService with Danielfn21.player.PlayerControlSystem;
}