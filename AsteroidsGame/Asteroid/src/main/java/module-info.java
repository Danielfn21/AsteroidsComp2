import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;

module Asteroid {
    requires Common;

    provides IGamePluginService with Danielfn21.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with Danielfn21.asteroid.AsteroidControlSystem;
}