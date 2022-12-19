package me.daniel.projects.MemeImageGenerator.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static me.daniel.projects.MemeImageGenerator.main.MemeImageEdit.MemeTestImageEdit.laranjoOptionText;
import static me.daniel.projects.MemeImageGenerator.main.MemeImageEdit.StonksImageEdit.stonksOptionContext;

public class AppLauncher {

    public static void main(String[] args) throws IOException {

   createWindow();
    }
//aaaaaa n aguento mais essa vida
    private static void createWindow() throws IOException {
        JFrame frame = new JFrame("Meme Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static void createUI(final JFrame frame) throws IOException, ClassCastException {

        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        //frame here
        JFrame jFrame = new JFrame();
        final JLabel label1 = new JLabel();

        JButton StonksButton = new JButton("Stonks");
        StonksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String StonksButton_dialog = (String) JOptionPane.showInputDialog(
                        frame,
                        "Coloque o texto do meme aqui!",
                        "MemeText",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "Something"

                );

                if(StonksButton_dialog != null && StonksButton_dialog.length() > 0){

                    File outfile = new File("Stonks.png");
                    try {
                        ImageIO.write(stonksOptionContext(StonksButton_dialog), "png", outfile);
                        BufferedImage StonksImage = ImageIO.read(outfile);
                        JLabel StonksLabel = new JLabel(new ImageIcon(StonksImage));
                        StonksLabel.setText("teste");
                        panel.add(StonksLabel);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        JButton button = new JButton("Laranjo Edit");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = (String)JOptionPane.showInputDialog(
                        frame,
                        "Coloque o texto do meme aqui!",
                        "MemeText",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "Something"
                );
                if(result != null && result.length() > 0){


                    try {
                        File outputfile = new File("laranjo.jpg");
                        ImageIO.write(laranjoOptionText(result), "jpg", outputfile);

                        BufferedImage image = ImageIO.read(outputfile);


                    final JLabel label = new JLabel(new ImageIcon(image));
                    panel.add(label);
                    label.setText("Meme criado com o nome: " + result);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    label1.setText("None selected");
                }

            }
        });

        panel.add(button);
        panel.add(label1);
        panel.add(StonksButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

}
