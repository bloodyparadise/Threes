/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threejava.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import threejava.game.GameStatus;

/**
 *
 * @author bloodyparadise
 */
public class NextBlockPanel extends javax.swing.JPanel{
    private GameStatus status = null;
    public static final int MAX_WIDTH = 85;
    public static final int MAX_HEIGHT = 85;
    
    public NextBlockPanel() {
        initComponents();
    }
    
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, MAX_WIDTH, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, MAX_HEIGHT, Short.MAX_VALUE)
        );
    }
    
    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
    
    public boolean isGameStarted(){
        return status != null;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintNextBlock(g2d);
    }

    private void paintNextBlock(Graphics2D g2d) {
        int blockWidth = MAX_WIDTH; 
        int blockHeight = MAX_HEIGHT; 
        if(isGameStarted()){
            int nextNumber = status.getNextBlock().getNumber();
            switch (nextNumber){
                case 1:
                    g2d.setColor(new Color(10,10,255));
                    break;
                case 2:
                    g2d.setColor(new Color(255,10,10));
                    break;
                default:
                    g2d.setColor(new Color(255,255,255));
            }
            g2d.fillRoundRect(10, 10, blockWidth-20, blockHeight-20, 10, 10);
        }
    }
}
