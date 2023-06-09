import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.services.IGamePluginService;
import Danielfn21.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;

    exports Danielfn21.components;
    exports Danielfn21.main;
}