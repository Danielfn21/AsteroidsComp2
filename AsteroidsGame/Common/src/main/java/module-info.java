import Danielfn21.common.services.IBulletCreator;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;
import Danielfn21.common.services.IPostEntityProcessingService;

module Common {
    exports Danielfn21.common.services;
    exports Danielfn21.common.data;
    exports Danielfn21.common.data.entityparts;
    exports Danielfn21.common.util;

    uses IBulletCreator;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
}