package me.daniel.projects.MemeImageGenerator.main.MemeImageEdit;

import me.daniel.projects.MemeImageGenerator.main.AppLauncher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MemeTestImageEdit extends AppLauncher {

    public static BufferedImage laranjoOptionText(String result) throws IOException {


        URL url = new URL("https://cdn.discordapp.com/attachments/554048737648050179/610011657632219147/laranjo-meme-cke.jpg");

        BufferedImage img = ImageIO.read(url);
        Graphics2D graphics = img.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font font = new Font("Arial", Font.BOLD, 30);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        graphics.drawString(result, 5, 30);
        graphics.dispose();

        return img;
}
}
