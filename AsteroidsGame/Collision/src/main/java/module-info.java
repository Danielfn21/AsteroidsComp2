import Danielfn21.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;

    provides IPostEntityProcessingService with Danielfn21.collision.CollisionDetector;
}