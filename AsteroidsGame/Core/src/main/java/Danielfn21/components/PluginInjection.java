package Danielfn21.components;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;
import Danielfn21.common.services.IGamePluginService;
import Danielfn21.common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pluginInjector")
public class PluginInjection {

    public void startPlugins(GameData gameData, World world) {
        List<IGamePluginService> plugins = SPILocator.locateAll(IGamePluginService.class);
        plugins.forEach((plugin) -> plugin.start(gameData, world));
    }
}
