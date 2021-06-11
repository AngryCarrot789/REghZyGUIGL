package reghzy.guigl.core.utils;

import reghzy.guigl.maths.Vector2;

public class ColliderAABB implements Collider {
    /**
     * The minimum coordinate on the X axis. Standing in the center of the AABB looking forward, this is the on the left
     */
    public float minX;
    /**
     * The minimum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is the on the bottom
     */
    public float minY;
    /**
     * The minimum coordinate on the X axis. Standing in the center of the AABB looking forward, this is the on the right
     */
    public float maxX;
    /**
     * The maximum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is the on the top
     */
    public float maxY;

    public ColliderAABB() { }

    public ColliderAABB(float minX, float minY, float maxX, float maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Creates an axis aligned bounding box, where the minimum/maximum
     * coordinates are calculated from the given center and scale
     *
     * @param center The center of the AABB
     * @param scale  The scale of the AABB (aka the distance from the center to the edges)
     */
    public static ColliderAABB fromCenterScale(Vector2 center, Vector2 scale) {
        ColliderAABB aabb = new ColliderAABB();
        aabb.repositionFromCenterAndScale(center, scale);
        return aabb;
    }

    /**
     * Creates an axis aligned bounding box, where the minimum/maximum
     * coordinates are the exact values in the min and max vectors
     *
     * @param min The center of the AABB
     * @param max The scale of the AABB (aka the distance from the center to the edges)
     */
    public static ColliderAABB fromMinMax(Vector2 min, Vector2 max) {
        ColliderAABB aabb = new ColliderAABB();
        aabb.setMin(min);
        aabb.setMax(max);
        return aabb;
    }

    /**
     * Returns the coordinates of this AABB instance's minimum
     * coordinates (in every axis), and returns it in a vector
     */
    public Vector2 getMin() {
        return new Vector2(this.minX, this.minY);
    }

    /**
     * Returns the coordinates of this AABB instance's maximum
     * coordinates (in every axis), and returns it in a vector
     */
    public Vector2 getMax() {
        return new Vector2(this.maxX, this.maxY);
    }

    /**
     * Gets the size of this AABB instance, and returns it in a vector
     *
     * @return
     */
    public Vector2 getSize() {
        return new Vector2(getSizeX(), getSizeY());
    }

    /**
     * Calculates the scale of this AABB instance by halving
     * the sizes in each axis, and returns it in a vector
     * <p>
     * The scale being the distance from the center and the edges, or half
     * the size (size being the distance from the maximum or minimum coordinates)
     * </p>
     */
    public Vector2 getScale() {
        return new Vector2(getScaleX(), getScaleY());
    }

    /**
     * Returns the scale of this AABB instance in the X axis,
     * that being half of the size in the X axis
     */
    public float getScaleX() {
        return getSizeX() / 2;
    }

    /**
     * Returns the scale of this AABB instance in the Y axis,
     * that being half of the size in the Y axis
     */
    public float getScaleY() {
        return getSizeY() / 2;
    }

    /**
     * Calculates the center of this AABB instance using the
     * minimum coordinates and the scale, and returns it in a vector
     */
    public Vector2 getCenter() {
        return getMin().add(getScaleX(), getScaleY());
    }

    /**
     * Gets the size of this AABB instance in the X axis, that being the
     * distance from the maximum to the minimum X coordinates
     */
    public float getSizeX() {
        return maxX - minX;
    }

    /**
     * Gets the size of this AABB instance in the Y axis, that being the
     * distance from the maximum to the minimum Y coordinates
     */
    public float getSizeY() {
        return maxY - minY;
    }

    /**
     * Sets this AABB instance's minimum coordinates as the exact given values
     */
    public void setMin(float x, float y) {
        this.minX = x;
        this.minY = y;
    }

    /**
     * Sets this AABB instance's maximum coordinates as the exact given values
     */
    public void setMax(float x, float y) {
        this.maxX = x;
        this.maxY = y;
    }

    /**
     * Sets this AABB instance's minimums coordinates as the exact values within the given vector
     */
    public void setMin(Vector2 v) {
        this.minX = v.x;
        this.minY = v.y;
    }

    /**
     * Sets this AABB instance's maximums coordinates as the exact values within the given vector
     */
    public void setMax(Vector2 v) {
        this.maxX = v.x;
        this.maxY = v.y;
    }

    /**
     * Calculates new coordinates for this AABB instance's minimum
     * and maximum coordinates using the given center and scale
     *
     * @param center The center of the AABB
     * @param scale  The scale of the AABB (aka the distance from the center to the edges)
     */
    public void repositionFromCenterAndScale(Vector2 center, Vector2 scale) {
        this.minX = center.x - scale.x;
        this.minY = center.y - scale.y;
        this.maxX = center.x + scale.x;
        this.maxY = center.y + scale.y;
    }

    /**
     * Uses the scale of this AABB instance and repositions the minimums
     * and maximums using that scale and the given center
     *
     * @param center The center of the AABB
     */
    public void repositionFromCenter(Vector2 center) {
        Vector2 scale = getScale();
        repositionFromCenterAndScale(center, scale);
    }

    /**
     * Resizes this AABB instance using the center of this AABB and the given scale
     *
     * @param scale The scale of the AABB (aka the distance from the center to the edges)
     */
    public void resizeFromScale(Vector2 scale) {
        Vector2 center = getCenter();
        repositionFromCenterAndScale(center, scale);
    }

    /**
     * Returns the amount that this AABB instance intersects the given AABB in the X axis
     * <p>
     * Returns a positive number if an intersection has happened
     * </p>
     * <p>
     * Returns a negative number if there is no intersection
     * </p>
     */
    public float getIntersectAmountX(ColliderAABB box) {
        float size = box.getSizeX();
        float scale = size / 2;
        float center = box.maxX - scale;
        if (this.maxX < center) {
            return this.maxX - box.minX;
        }
        else {
            return box.maxX - this.maxX;
        }
    }

    /**
     * Returns the amount that this AABB instance intersects the given AABB in the Y axis
     * <p>
     * Returns a positive number if an intersection has happened
     * </p>
     * <p>
     * Returns a negative number if there is no intersection
     * </p>
     */
    public float getIntersectAmountY(ColliderAABB box) {
        float size = box.getSizeY();
        float scale = size / 2;
        float center = box.maxY - scale;
        if (this.maxY < center) {
            return this.maxY - box.minY;
        }
        else {
            return box.maxY - this.maxY;
        }
    }

    /**
     * Returns true if the given vector is inside (intersecting) this AABB instance
     */
    public boolean intersectsVector(Vector2 v) {
        return intersectsPointX(v.x) &&
               intersectsPointY(v.y);
    }

    /**
     * Returns true if this AABB instance is inside (intersecting, in every axis) the given AABB
     */
    public boolean intersectsAABB(ColliderAABB box) {
        return intersectsAABBX(box) &&
               intersectsAABBY(box);
    }

    /**
     * Returns true if this AABB instance is intersecting the given AABB in the X axis
     */
    public boolean intersectsAABBX(ColliderAABB box) {
        return intersectsRangeX(box.minX, box.maxX);
    }

    /**
     * Returns true if this AABB instance is intersecting the given AABB in the Y axis
     */
    public boolean intersectsAABBY(ColliderAABB box) {
        return intersectsRangeY(box.minY, box.maxY);
    }

    @Override
    public boolean intersects(Collider collider) {
        if (collider instanceof ColliderAABB) {
            return intersectsAABB(((ColliderAABB) collider));
        }

        // handle other colliders here :))
        return false;
    }

    @Override
    public boolean intersectsPoint(Vector2 point) {
        return intersectsPoint(point.x, point.y);
    }

    @Override
    public boolean intersectsPoint(float x, float y) {
        return intersectsPointX(x) && intersectsPointY(y);
    }

    /**
     * Returns true if this AABB instance is intersecting the given minimum X and maximum X range
     */
    public boolean intersectsRangeX(float min, float max) {
        return (this.maxX > min) && (this.minX < max);
    }

    /**
     * Returns true if this AABB instance is intersecting the given minimum Y and maximum Y range
     */
    public boolean intersectsRangeY(float min, float max) {
        return (this.maxY > min) && (this.minY < max);
    }

    /**
     * Returns true if this AABB instance is intersecting the given point in the X axis
     */
    public boolean intersectsPointX(float x) {
        return (this.maxX > x) && (this.minX < x);
    }

    /**
     * Returns true if this AABB instance is intersecting the given point in the Y axis
     */
    public boolean intersectsPointY(float y) {
        return (this.maxY > y) && (this.minY < y);
    }

    /**
     * Returns a copy of this AABB instance (same minimum/maximum values, but different object)
     */
    public ColliderAABB copy() {
        return new ColliderAABB(this.minX, this.minY, this.maxX, this.maxY);
    }
}
