/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

//imports
import utils.CardSwitcher;
import javax.swing.JPanel;

/**
 *
 * @author michael.roy-diclemen
 */
public class EndPanel extends javax.swing.JPanel {
        public static final String CARD_NAME = "end";
        CardSwitcher switcher;
        
       /**
        * Creates new form EndPanel
        */
       public EndPanel(CardSwitcher p) {
           initComponents();
           switcher = p;
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        againButton = new javax.swing.JButton();

        againButton.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        againButton.setText("Play Again");
        againButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                againButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(againButton)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(againButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

//    replay button
    private void againButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_againButtonActionPerformed
        switcher.switchToCard(GamePanel.CARD_NAME);
    }//GEN-LAST:event_againButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton againButton;
    // End of variables declaration//GEN-END:variables
}
