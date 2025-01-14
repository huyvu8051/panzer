package com.huyvu.panzer;

// Một thực thể có thể có các component khác nhau
public class Entity {
    int id;
    PositionComponent position;
    VelocityComponent velocity;
    InputComponent input;

    public Entity(int id) {
        this.id = id;
    }
}
