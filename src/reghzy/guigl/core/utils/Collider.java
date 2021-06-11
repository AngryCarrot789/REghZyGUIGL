package reghzy.guigl.core.utils;

import reghzy.guigl.maths.Vector2;

public interface Collider {
    boolean intersects(Collider collider);
    boolean intersectsPoint(Vector2 point);
    boolean intersectsPoint(float x, float y);
    boolean intersectsRangeX(float minX, float maxX);
    boolean intersectsRangeY(float minY, float maxY);
}
