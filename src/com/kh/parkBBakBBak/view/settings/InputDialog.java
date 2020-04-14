package com.kh.parkBBakBBak.view.settings;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class InputDialog {
   public String Dialog() {
      JOptionPane input = new JOptionPane();
      UIManager.put("OptionPane.background", Color.GRAY);
      UIManager.put("Panel.background", Color.GRAY);
//      UIManager.put("Button.foreground", Color.white);
      UIManager.put("Button.background", Color.WHITE);
     
      
      String str = input.showInputDialog("입력할 사항은?");
      return str;
   }
}