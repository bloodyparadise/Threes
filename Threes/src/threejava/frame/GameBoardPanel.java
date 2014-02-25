/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threejava.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import threejava.game.GameStatus;
import threejava.listener.Direction;
import threejava.model.ThreeBlock;

/**
 *
 * @author bloodyparadise
 */
public class GameBoardPanel extends javax.swing.JPanel {
    private GameStatus status = null;
    public static final int MAX_WIDTH = 400;
    public static final int MAX_HEIGHT = 400;
    private int paintDirection = Direction.NONE;
    /**
     * Creates new form GameBoardPanel
     */
    public GameBoardPanel() {
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

    public int getPaintDirection() {
        return paintDirection;
    }

    public void setPaintDirection(int drawDirection) {
        this.paintDirection = drawDirection;
    }

    public boolean isGameStarted(){
        return status != null;
    }
     
    private void paintGameStatus(Graphics2D g2d) {
        if(isGameStarted()){
            paintMainBoard(g2d);
        }
    }
    
    private void paintMainBoard(Graphics2D g2d){
        switch(paintDirection){
            case Direction.NORTH:
                for(int j=1;j<5;j++){
                    for(int i=1;i<5;i++){
                    ThreeBlock block = status.getBlock(i, j);
                    paintBlock(g2d, block);
                    }
                }
                break;
            case Direction.SOUTH:
                for(int j=4;j>0;j--){
                    for(int i=1;i<5;i++){
                    ThreeBlock block = status.getBlock(i, j);
                    paintBlock(g2d, block);
                    }
                }
                break;
            case Direction.WEST:
                for(int i=1;i<5;i++){
                    for(int j=1;j<5;j++){
                    ThreeBlock block = status.getBlock(i, j);
                    paintBlock(g2d, block);
                    }
                }
                break;
            case Direction.EAST:
                for(int i=4;i>0;i--){
                    for(int j=1;j<5;j++){
                    ThreeBlock block = status.getBlock(i, j);
                    paintBlock(g2d, block);
                    }
                }
                break;
            default:
                for(int j=1;j<5;j++){
                    for(int i=1;i<5;i++){
                    ThreeBlock block = status.getBlock(i, j);
                    paintBlock(g2d, block);
                    }
                }
        }
    }
    
    private void paintBlock(Graphics2D g2d, ThreeBlock block){
        int blockWidth = MAX_WIDTH/4; 
        int blockHeight = MAX_HEIGHT/4; 
        //draw backgroud
        if(block.getNumber()==0){
            g2d.setColor(new Color(255,255,255));
        }else if(block.getNumber()==1){
            g2d.setColor(new Color(10,10,255));
        }else if(block.getNumber()==2){
            g2d.setColor(new Color(255,10,10));
        }else{
            g2d.setColor(new Color(255,255,255));
        }
        if(block.getNumber()!=0){
            g2d.fillRoundRect(block.getX(), block.getY(), blockWidth-2, blockHeight-2, 10, 10);
        }
        
        //draw border
        if(block.getNumber()!=0){
            g2d.setColor(new Color(0,0,0));
            g2d.drawRoundRect(block.getX(), block.getY(), blockWidth-2, blockHeight-2, 10, 10);
        }
        
        //draw number
        if(block.getNumber()==0){
            g2d.setColor(new Color(255,255,255));
        }else if(block.getNumber()==1){
            g2d.setColor(new Color(255,255,255));
        }else if(block.getNumber()==2){
            g2d.setColor(new Color(255,255,255));
        }else{
            g2d.setColor(new Color(0,0,0));
        }
        Font font = new Font("Arial Narrow",Font.BOLD,25);
        if(block.getNumber()!=0){
            g2d.setFont(font);
            g2d.drawString(""+block.getNumber(), block.getX()+blockWidth/2-5, block.getY()+blockHeight/2+5);
        }
        
        //game over, draw scores
        if(status.isGameOver()){
            int score = block.computeScore();
            if(score > 0){
                g2d.setColor(new Color(20,20,20));
                font = new Font("Arial Narrow",Font.PLAIN,15);
                g2d.setFont(font);
                g2d.drawString(""+score, block.getX()+blockWidth/2-5, block.getY()+blockHeight/2+25);
            }
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintGameStatus(g2d);
    }
}
