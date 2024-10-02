/*
 *************************************************
EXPLANATION OF CODE HERE
**************************************************
A - CardLayout
1) Set the layout of your frame to CardLayout (done from design using the navigator)
2) Add your panels one by one to the frame.
3) For each panel, in design at the bottom of the properties section
you need to give it a Card Name.  You will use this name to perform the swap
4) Whenever you want to change panels, you use this code:
CardLayout cl = (CardLayout)getContentPane().getLayout();
        cl.show(  getContentPane(), "card4");  /replace card4 with card you want to go to

(Optional)If you need to switch cards from the panel, then you need to have some code to find your frame
CardLayout cl = (CardLayout)this.getRootPane().getContentPane().getLayout();

B - Keyboard
GamePanel uses keyboard bindings starting on line 50

C- Mouse
GamePanel implements MouseListener and then adds the listener to the panel

D - Animation Timer - is set up in the Constructor of GamePanel
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import automatastarter.GamePanel;

/**
 *
 * @author michael.roy-diclemen
 */
public class FrameForGame extends javax.swing.JFrame implements CardSwitcher {

    CardLayout cl;
    GamePanel gp;
    static PredPrey p = new PredPrey();
    static boolean organismAdd;
    

    /**
     * Creates new form FrameForGame
     */
    public FrameForGame() {
        initComponents();

        //card layout shows one panel at a time
        cl = new CardLayout();
        cardPanel.setLayout(cl);

        //add 3 panels to the CardLayout
        addPanels();
        switchToCard(IntroPanel.CARD_NAME);

        //some focus stuff for the game panel to capture key events
        gp.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                gp.requestFocusInWindow();
            }
        });
        
//        set up the grid to be empty on open
        p.gridSetUp(false);
        
//        add radio btns to group and set prey add to true
        radioGroup.add(preyBtn);
        radioGroup.add(predBtn);
        preyBtn.setSelected(true);
    }

    private void addPanels() {
        gp = new GamePanel(this);
        cardPanel.add(gp,GamePanel.CARD_NAME);
        cardPanel.add(new EndPanel(this),EndPanel.CARD_NAME);
        cardPanel.add(new IntroPanel(this),IntroPanel.CARD_NAME);
        cardPanel.add(new InfoPanel(this),InfoPanel.CARD_NAME);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        cardPanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        speedSlider = new javax.swing.JSlider();
        speedSliderLabel = new javax.swing.JLabel();
        preyBtn = new javax.swing.JRadioButton();
        predBtn = new javax.swing.JRadioButton();
        organismAddLabel = new javax.swing.JLabel();
        randomize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("Stop");
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        speedSliderLabel.setText("Speed");

        preyBtn.setText("Prey");
        preyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preyBtnActionPerformed(evt);
            }
        });

        predBtn.setText("Predator");
        predBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predBtnActionPerformed(evt);
            }
        });

        organismAddLabel.setText("Add Organism");

        randomize.setText("Randomize");
        randomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(preyBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startBtn)
                                .addGap(76, 76, 76)
                                .addComponent(stopBtn)
                                .addGap(85, 85, 85)
                                .addComponent(resetBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(randomize)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(predBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(speedSliderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274)
                .addComponent(organismAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startBtn)
                    .addComponent(stopBtn)
                    .addComponent(resetBtn)
                    .addComponent(randomize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(organismAddLabel)
                    .addComponent(speedSliderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preyBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(predBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        GamePanel.animTimer.start();
    }//GEN-LAST:event_startBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        GamePanel.animTimer.stop();
    }//GEN-LAST:event_stopBtnActionPerformed

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        GamePanel.animTimer.setDelay((100 - speedSlider.getValue())*10 + 20);
    }//GEN-LAST:event_speedSliderStateChanged

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        GamePanel.animTimer.restart();
        GamePanel.animTimer.stop();
        p.gridSetUp(false);
        repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void preyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preyBtnActionPerformed
        organismAdd = false;
    }//GEN-LAST:event_preyBtnActionPerformed

    private void predBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predBtnActionPerformed
        organismAdd = true;
    }//GEN-LAST:event_predBtnActionPerformed

    private void randomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeActionPerformed
        GamePanel.animTimer.restart();
        GamePanel.animTimer.stop();
        p.gridSetUp(true);
        repaint();
    }//GEN-LAST:event_randomizeActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameForGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameForGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameForGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameForGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameForGame().setVisible(true);
            }
        });
    }

    @Override
    public void switchToCard(String cardName) {
        cl.show(cardPanel, cardName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel organismAddLabel;
    private javax.swing.JRadioButton predBtn;
    private javax.swing.JRadioButton preyBtn;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JButton randomize;
    private javax.swing.JButton resetBtn;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JLabel speedSliderLabel;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables

}
