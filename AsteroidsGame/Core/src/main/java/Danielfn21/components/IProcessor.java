package Danielfn21.components;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;

public interface IProcessor {
    /**
     * Process system
     *
     * @param gameData Data for the game
     * @param world World of the game
     *
     * @see GameData
     * @see World
     */
    void process(GameData gameData, World world);
}
