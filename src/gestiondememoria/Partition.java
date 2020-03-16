/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondememoria;

/**
 *
 * @author Omar Beltrán
 */
public class Partition {
    
    /**
     * las dimensiones por defecto serán de 500 en X, 300 en Y
     */
    public Partition() {
        this.partitionName = "By Default";
        this.partitionSize = 100;
        this.startX = 5;
        this.startY = 5;
        this.endX = startX+500;
        this.endY = startY+300;
    }
    
    /**
     * 
     * @param name
     */
    public Partition(String name) {
        this.partitionName = name;
        this.partitionSize = 20;
        this.startX = 5;
        this.startY = 5;
        this.endX = startX+500;
        this.endY = startY+60;
    }
    
    public Partition(String name, int size, int startX, int startY, int endX, int endY) {
        this.partitionName = name;
        this.partitionSize = size;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    /**
     * @return the startX
     */
    public int getStartX() {
        return startX;
    }

    /**
     * @param startX the startX to set
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * @return the startY
     */
    public int getStartY() {
        return startY;
    }

    /**
     * @param startY the startY to set
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * @return the endX
     */
    public int getEndX() {
        return endX;
    }

    /**
     * @param endX the endX to set
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * @return the endY
     */
    public int getEndY() {
        return endY;
    }

    /**
     * @param endY the endY to set
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * @return the partitionSize
     */
    public int getPartitionSize() {
        return partitionSize;
    }

    /**
     * @param partitionSize the partitionSize to set
     */
    public void setPartitionSize(int partitionSize) {
        this.partitionSize = partitionSize;
    }

    /**
     * @return the partitionName
     */
    public String getPartitionName() {
        return partitionName;
    }

    /**
     * @param partitionName the partitionName to set
     */
    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }
    
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int partitionSize;
    private String partitionName;
}
