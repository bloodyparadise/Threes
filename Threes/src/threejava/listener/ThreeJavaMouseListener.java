/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threejava.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import threejava.frame.MainFrame;

/**
 *
 * @author bloodyparadise
 */
public class ThreeJavaMouseListener extends MouseAdapter{
    private MainFrame mainFrame;
    private int count = 0;
    private DragHandler handler;
    
    public ThreeJavaMouseListener(MainFrame frame){
        this.mainFrame = frame;
        this.handler = new DragHandler(mainFrame);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        handler.mouseRelease(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handler.mousePress(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handler.mouseDragged(e);
    }
    
}
