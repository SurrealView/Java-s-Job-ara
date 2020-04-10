package com.kh.parkBBakBBak.view.cafe;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;





public class BackgroundPanel extends JPanel{
   public JFrame mf;
   public JPanel panel;
   public Player u;
   public int num = 0;
   public JButton button;
   JTextField tf2;
   JTextArea ta;
   Font font = new Font("맑은 고딕", Font.BOLD, 20);
   JTextArea ta1;
   JTextArea ta2;
   JTextArea ta3;

   int num2 = 0;
   int num3 = 0 ;
   public BackgroundPanel(JFrame mf , Player p ) {
      panel = this;
      this.mf = mf;
      u = p ;
      
      this.setLayout(null);
      mf.setTitle("카페");
 
      
      String[] explain = {"오늘의 메뉴를 확인하시려면 우측 하단의 텍스트박스를 클릭해주세요.","zz"};
      
      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/cafeBack.PNG").getImage().getScaledInstance(1194,834, 0)));
      label.setBounds(0, 0, 1194,834);
      
      JLabel cafeManager = new JLabel(new ImageIcon(new ImageIcon("images/cafeManager2.PNG").getImage().getScaledInstance(319, 243, 0)));
      cafeManager.setBounds(640,257,319,243);
      
      JLabel textArea = new JLabel(new ImageIcon(new ImageIcon("images/txtarea2.PNG").getImage().getScaledInstance(820, 270, 0)));
      textArea.setBounds(180,498,820,270);
      
      BackgroundPanel world = new BackgroundPanel(mf,u);
      ChangePanel.replacePanel(mf,panel,world);
      
      tf2 = new JTextField("안녕하세요 카페에 오신 것을 환영합니다.");
      tf2.setBounds(240,527,820,170);
      tf2.setOpaque(false);
      tf2.disable();
      tf2.setBorder(null);
      ta = new JTextArea();
      ta.setEditable(false);
      ta.setBounds(240,557,820,170);
      ta.setOpaque(false);
      ta.setFont(font);
      ta.append("카페 매니저 은우 :\n어서오세요 OracleCafe입니다.\n주문하시겠습니까?");
      ta.setVisible(true);
      ta2 = new JTextArea();
      ta2.setEditable(false);
      ta2.setBounds(240,557,820,50);
      ta2.setOpaque(false);
      ta2.setFont(font);
      ta2.setVisible(false);
      ta2.append("1.아이스 아메리카노");
      ta3 = new JTextArea();
      ta3.setEditable(false);
      ta3.setBounds(240,607,820,50);
      ta3.setOpaque(false);
      ta3.setFont(font);
      ta3.setVisible(false);
      ta3.append("2.오늘의 메뉴");
      cafeManager.addMouseListener(new My());
      
      ta.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseClicked(MouseEvent e) {
            ta.setText(explain[num]);
            num++;
            if(num==2) {
               num=0;
               ta.setVisible(false);
               ta2.setVisible(true);
               ta3.setVisible(true);
            }
            
         }
      });
      
      ta2.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseClicked(MouseEvent e) {
            ta3.setVisible(false);
            if(num2==0) {
            ta2.setText("당신은 아메리카노를 마시고\n체력이 1 회복되었습니다.\n쿠폰이 1 감소합니다.");
         u.setHp(u.getHp()+1);
            u.setCouponQTY(u.getCouponQTY()-1);
//            num2++;
            }else if(num2==1) {
               ta2.setText("당신의 체력은 " + u.getHp()+"가 되었고 ,\n쿠폰은 "+u.getCouponQTY()+"개 남았습니다.");
               num2++;
               
            }else {
               num2=0;
//               ChangePanel change = new ChangePanel(mf, panel);
               BackgroundPanel world = new BackgroundPanel(mf,u);
               ChangePanel.replacePanel(mf,panel,world);
//               change.replacePanel(world);
            }
         }
      });
      ta3.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseClicked(MouseEvent e) {
            ta2.setVisible(false);
            ta3.setLocation(240,557);
            
            BackgroundPanel world = new BackgroundPanel(mf,u);
            ChangePanel.replacePanel(mf,panel,world);
            
           /*
            if(num3==0) {
            ta3.setText("당신은 아메리카노를 마시고\n체력이 1 회복되었습니다.\n쿠폰이 1 감소합니다.");
            u.setHp(u.getHp()+1);
            u.setCouponQTY(u.getCouponQTY()-1);
            num3++;
            }else if(num3==1) {
               ta3.setText("당신의 체력은 " + u.getHp()+"가 되었고 ,\n쿠폰은 "+u.getCouponQTY()+"개 남았습니다.");
               num3++;
            }else {
               num3=0;
               
//               ChangePanel change = new ChangePanel(mf, panel);
               BackgroundPanel world = new BackgroundPanel(mf,u);
               ChangePanel.replacePanel(mf,panel,world);
               
//               change.replacePanel(world);
            }
            
            */
            
         }
      }
         
            
    		  );
      /*JTextField tf = new JTextField("dd");
      tf.setBounds(100,481,820,170);
      tf.setOpaque(false);*/
      
      button = new JButton("클릭");
      button.setBounds(700,581,100,100);
      
      button.addMouseListener(new My2());
      
      
      
      
      
      button.setFont(font);
      button.setVisible(false);
//      button2.setFont(font);
      //tf.setFont(font);
      tf2.setFont(font);
      this.add(ta2);
      this.add(ta3);
      this.add(ta);
      this.add(label); 
      this.add(cafeManager);
      this.add(textArea);
      //this.add(tf);
//      this.add(button2);
      //this.add(button);
      this.add(tf2);
      this.setComponentZOrder(ta3,0);
      this.setComponentZOrder(ta2, 1);
      this.setComponentZOrder(ta, 2);
      this.setComponentZOrder(tf2, 4);
//      this.setComponentZOrder(button2, 0);
      this.setComponentZOrder(button, 4);
      this.setComponentZOrder(label, 4);
      this.setComponentZOrder(cafeManager, 3);
      this.setComponentZOrder(textArea, 3);
      //this.setComponentZOrder(tf, 2);
   }

   class My extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
      
//      public void mouseClicked(MouseEvent e) {
    	  
//         ChangePanel change = new ChangePanel(mf, panel);
         //TestPanel world = new TestPanel(mf,u);
         
         //change.replacePanel(world);
      }
      
   }
   class My2 extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
      
//      public void mouseClicked(MouseEvent e) {
//         ChangePanel change = new ChangePanel(mf, panel);
         //BGPanel2 world = new BGPanel2(mf);
         
         //change.replacePanel(world);
      }
      
   }
   class My31 extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
      
//      public void mouseClicked(MouseEvent e) {
//         ChangePanel change = new ChangePanel(mf, panel);
         BackgroundPanel world = new BackgroundPanel(mf,u);
         ChangePanel.replacePanel(mf,panel,world);
//         change.replacePanel(world);
      }
      
   }
}