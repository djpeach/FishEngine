package io.peachapps.fish;

import io.peachapps.fish.graphics.Screen;
import io.peachapps.fish.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = width / 16 * 9; // gives a 16 x 9 aspec ratio
    public static int scale = 3;

    private Thread gameThread;
    private volatile boolean running = false;
    private JFrame frame;
    private Screen screen;
    private Keyboard keys;

    private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();
    private int x, y = 0;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        keys = new Keyboard();
        frame = new JFrame();

        addKeyListener(keys);
    }

    // synchronized protects shared resources across threads
    public synchronized void start() {
        running = true;
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Fish");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

    // lock at 60 fps
    public void update() {
        keys.update();
        if (keys.up) y++;
        if (keys.down) y--;
        if (keys.left) x++;
        if (keys.right) x--;
    }

    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render(x, y);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(new Color(40, 80, 70));
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
        graphics.dispose();

        bufferStrategy.show();
    }

    @Override
    public void run() {
        //before game starts
        long lastTickTime = System.nanoTime();
        long oneSecondTimer = System.currentTimeMillis();
        final double nanoSeconds = 1_000_000_000 / 60.0;
        double delta = 0;
        int updates = 0;
        int frames = 0;

        // run game
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTickTime) / nanoSeconds;
            lastTickTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            while (System.currentTimeMillis() - oneSecondTimer > 1000) {
                frame.setTitle("Fish | " + updates + " ups, " + frames + " fps.");
                oneSecondTimer += 1000;
                updates = 0;
                frames = 0;
            }
        }

        // after game closes
    }
}
