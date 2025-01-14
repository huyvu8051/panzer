package com.huyvu.panzer;

public class Runner implements Runnable {
    private final InputSystem inputSystem;
    private final MovementSystem movementSystem;
    private final RenderSystem renderSystem;
    private final Entity entity;

    public Runner(InputSystem inputSystem, MovementSystem movementSystem, RenderSystem renderSystem, Entity entity) {
        this.inputSystem = inputSystem;
        this.movementSystem = movementSystem;
        this.renderSystem = renderSystem;
        this.entity = entity;
    }

    @Override
    public void run() {
        float deltaTime = 1; // 60 FPS giả sử
        while (true) {
            // Cập nhật đầu vào và vận tốc


            inputSystem.update(entity);

            // Cập nhật vị trí
            movementSystem.update(entity, deltaTime);

            // In vị trí để kiểm tra
            //System.out.println("Player position: x=" + entity.position.x + ", y=" + entity.position.y);

            renderSystem.repaint();
            // Giả lập một khoảng dừng giữa các frame
            try {
                Thread.sleep(16); // Giả lập 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
