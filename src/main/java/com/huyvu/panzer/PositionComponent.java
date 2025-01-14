package com.huyvu.panzer;

import com.artemis.Component;

// PositionComponent: Chứa thông tin về vị trí
public class PositionComponent extends Component {
    float x, y;

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}


