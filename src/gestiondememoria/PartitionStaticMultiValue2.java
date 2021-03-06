/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondememoria;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Omar Beltrán
 */
public class PartitionStaticMultiValue2 extends javax.swing.JFrame {
    private static final int diskSize = 100;
    private double diskAvaibleSize;
    private int partitionSize = 0; 
    private String partitionName;
    private final int maxSizeX = 500;
    private final int maxSizeY = 300;
    private int startX = 0;
    private int startY = 0;
    private int endX = 0;
    private int endY = 0;
    private static final int LIMSUP = 200;
    private static final int LIMINF = 1;
    private int nPartition;
    private JLabel label[] = new JLabel[200];
    /**
     * Creates new form PartitionStaticMultiValue
     */
    public PartitionStaticMultiValue2() {
        
        initComponents();
        setLocationRelativeTo(this);
        drawEmptyHardDisk();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAction = new javax.swing.JMenu();
        jMenuPartitionDisk = new javax.swing.JMenuItem();
        jMenuClearAll = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemCredits = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuAction.setText("Actions");

        jMenuPartitionDisk.setText("New Partition");
        jMenuPartitionDisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPartitionDiskActionPerformed(evt);
            }
        });
        jMenuAction.add(jMenuPartitionDisk);

        jMenuClearAll.setText("Reset");
        jMenuClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClearAllActionPerformed(evt);
            }
        });
        jMenuAction.add(jMenuClearAll);

        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuAction.add(jMenuExit);

        jMenuBar1.add(jMenuAction);

        jMenuHelp.setText("Help");

        jMenuItemCredits.setText("Credits");
        jMenuItemCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreditsActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemCredits);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPartitionDiskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPartitionDiskActionPerformed
        partitionName = String.valueOf(JOptionPane.showInputDialog("Ingrese el nombre de la partición"));
        if (!partitionName.isEmpty()) {
            partitionSize = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la partición"));
            if (partitionSize > 0) {
                drawPartition(partitionName, partitionSize);
            }    
            else {
                JOptionPane.showMessageDialog(null,"El tamaño de la partición debe ser mayor que 0","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Debe asignar un nombre a la partición","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuPartitionDiskActionPerformed

    private void jMenuClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClearAllActionPerformed
        nPartition = 0;
        dropLabels();
        drawEmptyHardDisk();
    }//GEN-LAST:event_jMenuClearAllActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuItemCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreditsActionPerformed
        JOptionPane.showMessageDialog(null,"Este programa fué desarrollado y diseñado por Omar José Beltrán Rodríguez","Creditos",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItemCreditsActionPerformed

    private void dropLabels() {
        label = null;
        label = new JLabel[200];
    }
    
    private void drawPartition(String partitionName, int partitionSize) {
        nPartition++;
        if (getDimensionPartition(partitionSize)) {
            int index = nPartition;
            label[0].setVisible(false);
            Font fuente = new Font("Arial", 3, 14);
            label[index]= new JLabel("lbl" +index);
            label[index].setBounds(startX, startY, endX, endY);
            
            //edit properties
            label[index].setBorder(BorderFactory.createEtchedBorder(Color.WHITE,Color.LIGHT_GRAY));
            label[index].setBackground(Color.RED);
            label[index].setText("Partition "+partitionName+" Size "+partitionSize+" Gb");
            label[index].setFont(fuente);
            label[index].setOpaque(true);
            label[index].setHorizontalAlignment(0);
            label[index].setVerticalAlignment(0);
            label[index].setHorizontalTextPosition(11);
            label[index].setVerticalTextPosition(0);
            add(label[index]);
            this.repaint();
        }
        else {
            JOptionPane.showMessageDialog(null,"Insuficiente espacio en disco","ERROR",JOptionPane.ERROR_MESSAGE);
            nPartition--;
        }
    }
    
    private boolean getDimensionPartition(int partitionCreateSize) {
        boolean flag = true;
        double percentageDiskPartition = (double)((partitionSize*100)/diskSize)/100;
        int sizePartition = (int)(maxSizeY*percentageDiskPartition);
        if(diskAvaibleSize >= sizePartition) {
            if (nPartition == 1) {
                startX = startY = 5;
                endX = maxSizeX + startX;
                endY =  sizePartition;
                diskAvaibleSize -= partitionCreateSize;
            }
            else {
                startX = 5;
                startY = endY + startY-5;
                endX = maxSizeX + startX;
                endY =  sizePartition;
                diskAvaibleSize -= partitionCreateSize;
            }
        }
        else {
            flag = false;
        }
        return flag;
    }
    
    private Color getColor(int color) {
        switch (color) {
            case 1:
                return Color.RED;
            case 2:
                return Color.PINK;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.BLUE;
            case 6:
                return Color.CYAN;
            case 7:
                return Color.MAGENTA;
            default:
                return Color.ORANGE;
        }
    }
    
    final void drawEmptyHardDisk() {
        diskAvaibleSize = 300;
        int X = 5, Y = 5, sizeX = maxSizeX+X, sizeY = maxSizeY+Y;
        startX = startY = 5;
        endX = endY = 5; 
        Font fuente = new Font("Arial", 3, 14);
        label[0]= new JLabel("lbl" +0);
        label[0].setBounds(X, Y, sizeX, sizeY);
            
        //edit properties
        label[0].setBorder(BorderFactory.createEtchedBorder(Color.WHITE,Color.LIGHT_GRAY));
        label[0].setBackground(Color.WHITE);
        label[0].setText("Empty Hard Disk Size: "+diskSize+" Gb");
        label[0].setFont(fuente);
        label[0].setOpaque(true);
        label[0].setHorizontalAlignment(0);
        label[0].setVerticalAlignment(0);
        label[0].setHorizontalTextPosition(11);
        label[0].setVerticalTextPosition(0);
        add(label[0]);
    }
    
    void createLabel(int numberLabels) {
        int X = 5, Y = 5, sizeX = maxSizeX, sizeY = maxSizeY/numberLabels;
        Font fuente = new Font("Arial", 3, 14);
        //label[0] no es usado
        for(int index=1; index <= numberLabels; index++) {
            label[index]= new JLabel("lbl" +index);
            label[index].setBounds(X, Y, sizeX, sizeY);
            
            //edit properties
            label[index].setBorder(BorderFactory.createEtchedBorder(Color.WHITE,Color.LIGHT_GRAY));
            label[index].setBackground(Color.WHITE);
            label[index].setText("Partition "+String.valueOf(index)+", Size: "+(diskSize/numberLabels)+" Gb");
            label[index].setFont(fuente);
            label[index].setOpaque(true);
            label[index].setHorizontalAlignment(0);
            label[index].setVerticalAlignment(0);
            label[index].setHorizontalTextPosition(11);
            label[index].setVerticalTextPosition(0);
            add(label[index]);
            Y = Y+sizeY;
        }
    }
    
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
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartitionStaticMultiValue2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAction;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClearAll;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemCredits;
    private javax.swing.JMenuItem jMenuPartitionDisk;
    // End of variables declaration//GEN-END:variables
}
