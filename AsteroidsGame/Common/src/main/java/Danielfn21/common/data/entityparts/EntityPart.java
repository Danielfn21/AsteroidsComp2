/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Danielfn21.common.data.entityparts;

import Danielfn21.common.data.GameData;
import Danielfn21.common.data.Entity;

/**
 *
 * @author Alexander
 */
public interface EntityPart {
    void process(GameData gameData, Entity entity);
}
