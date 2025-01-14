package com.huyvu.panzer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Tạo các entity
        Entity player = new Entity(1);
        player.position = new PositionComponent();
        player.velocity = new VelocityComponent();
        player.input = new InputComponent();

        // Tạo các hệ thống
        InputSystem inputSystem = new InputSystem();
        MovementSystem movementSystem = new MovementSystem();

        // Giả sử game chạy với một vòng lặp cập nhật mỗi frame


        // Giả lập đầu vào (ví dụ: người chơi nhấn phím "W")
//        player.input.moveUp = true;
        player.input.moveDown = true;
        player.input.moveLeft = true;

        // Vòng lặp game
        ExecutorService executor = Executors.newFixedThreadPool(3);

        var runner = new Runner(inputSystem, movementSystem, player);

        executor.submit(runner);
    }
}
