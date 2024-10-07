/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import static automatastarter.GamePanel.p;
import static automatastarter.PredPrey.grid;
import utils.CardSwitcher;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import utils.ImageUtil;
import java.awt.image.BufferedImage;

/**
 *
 * @author michael.roy-diclemen
 */
public class IntroPanel extends javax.swing.JPanel {
    public static final String CARD_NAME = "intro";
    CardSwitcher switcher = null;
    private Timer timer;
    private final int frameWidth = 200;
    private final int frameHeight = 200;
    private final BufferedImage frame0 = ImageUtil.loadAndResizeImage("src/automatastarter/frame_0_delay-0.33s.gif", frameWidth, frameHeight);
    private final BufferedImage frame1 = ImageUtil.loadAndResizeImage("src/automatastarter/frame_1_delay-0.33s.gif", frameWidth, frameHeight);
    private final BufferedImage frame2 = ImageUtil.loadAndResizeImage("src/automatastarter/frame_2_delay-0.33s.gif", frameWidth, frameHeight);
    private final BufferedImage frame3 = ImageUtil.loadAndResizeImage("src/automatastarter/frame_3_delay-0.33s.gif", frameWidth, frameHeight);
    private final BufferedImage[] frames = {frame0, frame1, frame2, frame3};
    private int frameNum = 0;
    
    /**
     * Creates new form IntroPanel
     */
    public IntroPanel(CardSwitcher p) {
        initComponents();
        switcher = p;
        timer = new Timer(100, new AnimTimerTick());
        timer.start();

    }
    
    private class AnimTimerTick implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
//            change to next frame
            frameNum = (frameNum + 1) % 4;

            //force redraw
            repaint();
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        draw frame
        g.drawImage(frames[frameNum], this.getWidth()/2 - frameWidth/2, 0, this);
        repaint();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        gameButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        gameButton.setText("Game");
        gameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButtonActionPerformed(evt);
            }
        });

        infoButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        infoButton.setText("Info");
        infoButton.setToolTipText("");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        title.setText("Predator and Prey");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoButton))
                    .addComponent(title))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameButton)
                    .addComponent(infoButton))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameButtonActionPerformed
        timer.stop();
        timer.restart();
        switcher.switchToCard(GamePanel.CARD_NAME);
    }//GEN-LAST:event_gameButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        timer.stop();
        timer.restart();
        switcher.switchToCard(InfoPanel.CARD_NAME);
    }//GEN-LAST:event_infoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gameButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
