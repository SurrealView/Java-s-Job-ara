package com.kh.parkBBakBBak.view.interview;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MenuPanel;

public class NaviBobetDDau extends JPanel {
   private JFrame mf;
   private JPanel panel;
   private Font font;
   private Player p;
   private Clip end;
   
   public NaviBobetDDau(JFrame mf,Player p) {
      this.mf = mf;
      this.panel = this;
      this.setLayout(null);
      this.setSize(1194, 834);
      this.setLocation(0,0);
      
      
      AudioInputStream audioInputStream;
      File file;
      try {
         file = new File("sounds/kkHouse.wav");
         audioInputStream = AudioSystem.getAudioInputStream(file);
         end = AudioSystem.getClip();
         end.open(audioInputStream);
         end.start();
      } catch (UnsupportedAudioFileException | IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }

      InterviewManager.pageNum=7;
      JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "credit1.png", 1194, 834);
      backGround.setLocation(0, 0);
      
      
   
      
      this.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {

            System.out.println("∞‘¿” ≥°");
            end.stop();
            ChangePanel.replacePanel(mf, panel, new MenuPanel(mf));

         }
      });
      
      
      this.add(backGround);
   }
}