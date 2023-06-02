package Danielfn21.components;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;
import Danielfn21.common.services.IEntityProcessingService;
import Danielfn21.common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("processorInjector")
public class ProcessInjection implements IProcessor {
    @Override
    public void process(GameData gameData, World world) {
        List<IEntityProcessingService> processors = SPILocator.locateAll(IEntityProcessingService.class);
        processors.forEach((processor) -> processor.process(gameData, world));
    }
}
