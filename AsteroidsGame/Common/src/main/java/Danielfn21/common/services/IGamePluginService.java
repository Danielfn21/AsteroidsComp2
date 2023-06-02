package Danielfn21.common.services;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;


public interface IGamePluginService {
    void start(GameData gameData, World world);
    void stop(GameData gameData, World world);
}
