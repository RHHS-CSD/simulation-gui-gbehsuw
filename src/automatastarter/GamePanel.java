/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author michael.roy-diclemen
 */
public class GamePanel extends javax.swing.JPanel  {

    public static final String CARD_NAME = "game";
    static PredPrey p = new PredPrey();
    
    CardSwitcher switcher; // This is the parent panel
    public Timer animTimer;
    
    //variables for labels
    private boolean organismAdd;
    private int[] organisms = new int[2];
    

    /**
     * Creates new form GamePanel
     * @param c
     */
    public GamePanel(CardSwitcher c) {
        initComponents();
        
        this.setFocusable(true);
        
        //tells us the panel that controls this one
        switcher = c;
        
        //create and start a Timer for animation
        animTimer = new Timer(1000, new AnimTimerTick());

        //        add radio btns to group and set prey add to true
        radioGroup.add(preyBtn);
        radioGroup.add(predBtn);
        preyBtn.setSelected(true);
        
    }
    
//    set the txt for the jLabels
    private void setLabels() {
        organisms[0] = p.numPrey();
        organisms[1] = p.numPred();
        preyCount.setText("Prey: " + organisms[0]);
        predCount.setText("Pred: " + organisms[1]);
        generationLabel.setText("Generation: " + p.getStepNumber());
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
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        randomize = new javax.swing.JButton();
        preyBtn = new javax.swing.JRadioButton();
        predBtn = new javax.swing.JRadioButton();
        predCount = new javax.swing.JLabel();
        preyCount = new javax.swing.JLabel();
        generationLabel = new javax.swing.JLabel();
        organismAddLabel = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        gridXSlider = new javax.swing.JSlider();
        gridYSlider = new javax.swing.JSlider();
        speedSliderLabel = new javax.swing.JLabel();
        gridXLabel = new javax.swing.JLabel();
        gridYLabel = new javax.swing.JLabel();
        optionBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setForeground(new java.awt.Color(51, 51, 51));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        startBtn.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        stopBtn.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        stopBtn.setText("Stop");
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        randomize.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        randomize.setText("Randomize");
        randomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeActionPerformed(evt);
            }
        });

        preyBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        preyBtn.setText("Prey");
        preyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preyBtnActionPerformed(evt);
            }
        });

        predBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        predBtn.setText("Predator");
        predBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predBtnActionPerformed(evt);
            }
        });

        predCount.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        predCount.setText("Predator: 0");

        preyCount.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        preyCount.setText("Prey: 0");

        generationLabel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        generationLabel.setText("Generation: 0");

        organismAddLabel.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        organismAddLabel.setText("Add Organism");

        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        gridXSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridXSliderStateChanged(evt);
            }
        });

        gridYSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridYSliderStateChanged(evt);
            }
        });

        speedSliderLabel.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        speedSliderLabel.setText("Speed");

        gridXLabel.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        gridXLabel.setText("X Width");

        gridYLabel.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        gridYLabel.setText("Y Width");

        optionBtn.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        optionBtn.setText("Options");
        optionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(stopBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(resetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(randomize)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(optionBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gridXLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gridYLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speedSliderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gridXSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gridYSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preyBtn)
                            .addComponent(organismAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(predBtn))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(predCount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generationLabel))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(speedSliderLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gridXLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gridYLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gridXSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gridYSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optionBtn)
                            .addComponent(randomize)
                            .addComponent(resetBtn)
                            .addComponent(stopBtn)
                            .addComponent(startBtn))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(organismAddLabel)
                            .addComponent(generationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(preyCount)
                            .addComponent(preyBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(predCount)
                            .addComponent(predBtn))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

//    add prey/pred on mouse drag
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int addType;
        if (organismAdd) {
            addType = 20;
        } else {
            addType = -1;
        }
        
//        update and reset labels
        p.updateGrid(evt.getX(), evt.getY(), this.getWidth(), this.getHeight(), addType);
        setLabels();
        
//        force redraw again
        repaint();
    }//GEN-LAST:event_formMouseDragged

//    start the simulation
    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        animTimer.start();
        
//        make sure images scale to proper window size
        p.setImgs(this.getWidth(), this.getHeight());
    }//GEN-LAST:event_startBtnActionPerformed

//    stop the timer
    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        animTimer.stop();
    }//GEN-LAST:event_stopBtnActionPerformed

//    reset the timer and grid
    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        animTimer.restart();
        animTimer.stop();
        p.gridSetUp(false);
        p.setStepNumber(0);
        setLabels();
        repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

//    randomize the board with prey and pred
    private void randomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeActionPerformed
        animTimer.restart();
        animTimer.stop();
        p.gridSetUp(true);
        p.setStepNumber(0);
        setLabels();
        repaint();
    }//GEN-LAST:event_randomizeActionPerformed

//    change to adding prey
    private void preyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preyBtnActionPerformed
        organismAdd = false;
    }//GEN-LAST:event_preyBtnActionPerformed

//    change to adding pred
    private void predBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predBtnActionPerformed
        organismAdd = true;
    }//GEN-LAST:event_predBtnActionPerformed

//    adjust the speed of the timer, where the minimum speed is 10
    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        animTimer.setDelay((100 - speedSlider.getValue())*10 + 10);
    }//GEN-LAST:event_speedSliderStateChanged

//    change the width of the grid
    private void gridXSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridXSliderStateChanged
        animTimer.restart();
        animTimer.stop();
        p.setGridX(gridXSlider.getValue() / 2 + 5);
        p.setImgs(this.getWidth(), this.getHeight());
        p.gridSetUp(false);
        setLabels();
        repaint();
    }//GEN-LAST:event_gridXSliderStateChanged

//    change the height of the grid
    private void gridYSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridYSliderStateChanged
        animTimer.restart();
        animTimer.stop();
        p.setGridY(gridYSlider.getValue() / 2 + 5);
        p.setImgs(this.getWidth(), this.getHeight());
        setLabels();
        repaint();
    }//GEN-LAST:event_gridYSliderStateChanged

//    check if the panel is resized and update the image sizes
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        p.setImgs(this.getWidth(), this.getHeight());
    }//GEN-LAST:event_formComponentResized

//    switch to info panel after stopping the timer
    private void optionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionBtnActionPerformed
        animTimer.restart();
        animTimer.stop();
        p.setStepNumber(0);
        switcher.switchToCard(OptionPanel.CARD_NAME);
    }//GEN-LAST:event_optionBtnActionPerformed

//    on mouse clicked
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int addType = 0;
        if (organismAdd) {
            addType = 20;
        } else {
            addType = -1;
        }
        p.updateGrid(evt.getX(), evt.getY(), this.getWidth(), this.getHeight(), addType);
        
        setLabels();

//        force redraw again
        repaint();
    }//GEN-LAST:event_formMouseClicked
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel generationLabel;
    private javax.swing.JLabel gridXLabel;
    private javax.swing.JSlider gridXSlider;
    private javax.swing.JLabel gridYLabel;
    private javax.swing.JSlider gridYSlider;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton optionBtn;
    private javax.swing.JLabel organismAddLabel;
    private javax.swing.JRadioButton predBtn;
    private javax.swing.JLabel predCount;
    private javax.swing.JRadioButton preyBtn;
    private javax.swing.JLabel preyCount;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JButton randomize;
    private javax.swing.JButton resetBtn;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JLabel speedSliderLabel;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
    
    //    to paint every time
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        p.drawGrid(g, this.getWidth(), this.getHeight(), this);
    }

//    on tick
    private class AnimTimerTick implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            //move prey and pred
            p.setGrid(p.movement());
            p.step();
            
//            set the labels
            setLabels();
            
//            check lose state
            if ((p.numPred() + p.numPrey()) <= 0) {
                animTimer.restart();
                animTimer.stop();
                p.setStepNumber(0);
                switcher.switchToCard(EndPanel.CARD_NAME);
            }
            
            //force redraw
            repaint();
        }
    }
}
