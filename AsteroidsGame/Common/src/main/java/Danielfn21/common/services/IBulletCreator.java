package Danielfn21.common.services;

import Danielfn21.common.data.Entity;
import Danielfn21.common.data.GameData;
import Danielfn21.common.data.World;

public interface IBulletCreator {

    Entity create(Entity shooter, GameData gameData);
}
