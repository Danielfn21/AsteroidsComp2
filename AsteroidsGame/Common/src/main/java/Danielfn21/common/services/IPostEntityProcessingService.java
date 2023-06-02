package Danielfn21.common.services;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;

public interface IPostEntityProcessingService  {

        void process(GameData gameData, World world);
}
