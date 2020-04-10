package com.kh.parkBBakBBak.view.cafe;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel2 {
	

	//   private JFrame mf;
	//   private JPanel panel;

	static JFrame mf2;
	static JPanel oldPanel2;
	static JPanel changePanel2;
	   public ChangePanel2() {}
	//   public ChangePanel(JFrame mf, JPanel panel) {
//	      this.mf = mf;
//	      this.panel = panel;
	//   }
	//   public void replacePanel(JPanel changePanel) {
//	      mf.remove(panel);
//	      mf.add(changePanel);
//	      changePanel.setSize(1194,834);
//	      changePanel.setLocation(0,0);
//	      mf.repaint();
	//   }
	   public static void replacePanel(JFrame mf, JPanel oldPanel, JPanel changePanel) {
		  mf2 = mf;
		  oldPanel2 = oldPanel;
		  changePanel2 = changePanel;
	      mf2.remove(oldPanel2);
	      mf2.add(changePanel2);
	      changePanel2.setSize(1194,834);
	      changePanel2.setLocation(0,0);
	      mf.repaint();
	   }
	   
	

}
