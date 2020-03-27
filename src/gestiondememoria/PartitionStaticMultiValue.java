/*
 * Desarrollar un programa o programas que simulen lo siguiente:
1 Gestión de memoria:
a. Reubicación contigua simple
b. Particiones estáticas un sólo tamaño
c. Particiones estáticas de varios tamaños
d. Particiones dinámicas.
e. Segmentación
f. Paginación  
Comparar y medir la fragmentaciòn después de terminar la ubicación de los archivos en memoria
http://sistemasopers.blogspot.com/2015/09/particiones-fijas-y-dinamicas.html
 */
package gestiondememoria;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Omar Beltrán
 */
public class PartitionStaticMultiValue extends javax.swing.JFrame {
    private final ArrayList<Partition> partitions = new ArrayList(); 
    private static final int diskSize = 100;
    private static final int LIMSUP = 200;
    private static final int LIMINF = 1;
    private int nPartition;
    private JLabel label[] = new JLabel[200];
    /**
     * Creates new form PartitionStaticMultiValue
     */
    public PartitionStaticMultiValue() {
        
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
        String partitionName = String.valueOf(JOptionPane.showInputDialog("Ingrese el nombre de la partición"));
        if (!partitionName.isEmpty()) {
            int partitionSize = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la partición"));
            if (partitionSize > 0) {
                createPartition(partitionName, partitionSize);
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
        nPartition = 1;
        partitions.removeAll(partitions);
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
    
    private void createPartition(String partitionName, int partitionSize) {
        Partition partition = new Partition(partitionName, partitionSize, 
                    getStartPoint(partitionSize), getEndPoint(partitionSize));
        drawPartition(partition);
        partitions.add(partition);
    }
    
    private Point getStartPoint(int sizePartition) {
        Point startPoint = new Point();
        int index = partitions.size();
        if(index > 1) {
            startPoint.x = (partitions.get(index-1).getEndX())-partitions.get(index-1).getSizeX();
            startPoint.y = partitions.get(index-1).getStartY();
        }else {
            startPoint.x = 5;
            startPoint.y = 5;
        }
        return startPoint;
    }
    
    private Point getEndPoint(int partitionSize) {
        Point endPoint = new Point();
        int index = partitions.size();
        if(index > 1) {
            endPoint.x = partitions.get(index-1).getEndX();
            endPoint.y = partitions.get(index-1).getEndY();
        }else {
            endPoint.x = 500;
            endPoint.y = 100;
        }
        return endPoint;
    }
    
    private void drawPartition(Partition partition) {
        int index = partitions.size();
        if(index != 1) {
            label[0].setVisible(false);
            Point startPoint = getStartPoint(partition.getPartitionSize());
            Point endPoint = getEndPoint(partition.getPartitionSize());
            //int X = 5, Y = 5, sizeX = 500+X, sizeY = 300+Y;
            Font fuente = new Font("Arial", 3, 14);
            label[index]= new JLabel("lbl" +index);
            label[index].setBounds(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            
            //edit properties
            label[index].setBorder(BorderFactory.createEtchedBorder(Color.WHITE,Color.LIGHT_GRAY));
            label[index].setBackground(Color.RED);
            label[index].setText("Partition "+partition.getPartitionName()+" Size "+partition.getPartitionSize()+" Gb");
            label[index].setFont(fuente);
            label[index].setOpaque(true);
            label[index].setHorizontalAlignment(0);
            label[index].setVerticalAlignment(0);
            label[index].setHorizontalTextPosition(11);
            label[index].setVerticalTextPosition(0);
            add(label[index]);
        }
        else { //significa que está el disco vacío
            
        }
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
    
    void drawEmptyHardDisk() {
        Partition partition = new Partition();
        if (partitions.isEmpty()) {
            partitions. add(partition);
            int X = 5, Y = 5, sizeX = 500+X, sizeY = 300+Y;
            Font fuente = new Font("Arial", 3, 14);
            label[0]= new JLabel("lbl" +0);
            label[0].setBounds(X, Y, sizeX, sizeY);
            
            //edit properties
            label[0].setBorder(BorderFactory.createEtchedBorder(Color.WHITE,Color.LIGHT_GRAY));
            label[0].setBackground(Color.WHITE);
            label[0].setText("Empty Hard Disk Size: "+partition.getPartitionSize()+" Gb");
            label[0].setFont(fuente);
            label[0].setOpaque(true);
            label[0].setHorizontalAlignment(0);
            label[0].setVerticalAlignment(0);
            label[0].setHorizontalTextPosition(11);
            label[0].setVerticalTextPosition(0);
            add(label[0]);
        }
        else 
            JOptionPane.showMessageDialog(null,"No es posible crear disco, ya existe uno","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    void createLabel(int numberLabels) {
        int X = 5, Y = 5, sizeX = 500, sizeY = 300/numberLabels;
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
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartitionStaticMultiValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartitionStaticMultiValue().setVisible(true);
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
