package com.kh.parkBBakBBak.view.cafe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MenuPanel;
import com.kh.parkBBakBBak.view.WorldPanel;





public class BackgroundPanel extends JPanel{
   public JFrame mf;
   public JPanel panel;
   public Player u;
   public int num = 0;
   public JButton button;
   public static int couponCount = 0 ;
   JTextArea ta;
   Font font = new Font("맑은 고딕", Font.BOLD, 20);
   JTextArea ta1;
   JTextArea ta2;
   JTextArea ta3;
   JTextArea forTM;

   public static int pppppakk=0;
   int num2 = 0;
   int num3 = 0 ;
   int num4 = 0;
   protected static final String ADDRESS = "images/";
   
   public BackgroundPanel(JFrame mf , Player p ) {
      panel = this;
      this.mf = mf;
      u = p ;
      
      MenuPanel.mainBgm.stop();
      
      this.setLayout(null);
 
      
     
      System.out.println("카페입장");
      int couponGaesoo = u.getCouponQTY();
      System.out.println("쿠폰개수 : " + u.getCouponQTY());
      String[] explain = {"오늘의 메뉴를 확인하시려면 우측 하단의 텍스트박스를 클릭해주세요.","zz"};
      
      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/cafeBack.PNG").getImage().getScaledInstance(1194,834, 0)));
      label.setBounds(0, 0, 1194,834);
      
      JLabel cafeManager = new JLabel(new ImageIcon(new ImageIcon("images/cafeManager2.PNG").getImage().getScaledInstance(319, 243, 0)));
      cafeManager.setBounds(640,257,319,243);
      
      JLabel textArea = new JLabel(new ImageIcon(new ImageIcon("images/txtarea2.PNG").getImage().getScaledInstance(820, 270, 0)));
      textArea.setBounds(180,498,820,270);
      
      JButton goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.PNG").getImage().getScaledInstance(60, 60, 0)));
      
      
      goBack.setBounds(1104,30,60,60);
      goBack.setBorderPainted(false);
      goBack.setContentAreaFilled(false);
      goBack.setFocusPainted(false);
      ta = new JTextArea();
      ta.setEditable(false);
      ta.setBounds(240,557,820,170);
      ta.setOpaque(false);
      ta.setFont(font);
      ta.append("카페 매니저 은우 \n어서오세요 OracleCafe입니다.\n주문하시겠습니까?");
      ta.setVisible(true);
      
      ta2 = new JTextArea();
      ta2.setEditable(false);
      ta2.setBounds(240,557,820,50);
      ta2.setOpaque(false);
      ta2.setFont(font);
      ta2.setVisible(false);
      ta2.append("1.아이스 아메리카노(쿠폰 한 개 필요)");
      
      ta3 = new JTextArea();
      ta3.setEditable(false);
      ta3.setBounds(240,607,820,50);
      ta3.setOpaque(false);
      ta3.setFont(font);
      ta3.setVisible(false);
      ta3.append("2.오늘의 메뉴(쿠폰 한 개 필요)");
     
      
      forTM = new JTextArea();
      forTM.setEditable(false);
      forTM.setBounds(1030,740,300,35);
      forTM.setOpaque(false);
      forTM.setFont(font);
      forTM.setForeground(Color.WHITE);
      forTM.append("오늘의 메뉴");
     
      
      //this.createBattery(u.getHp());
      
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
           
            System.out.println("쿠폰카운트"+couponCount);
            if(couponGaesoo>0) {
            if(num2==0) {
            
            ta2.setText("당신은 아메리카노를 마시고\n체력이 1 회복되었습니다.\n쿠폰이 1 감소합니다.");
            u.setHp(u.getHp()+1);
            u.setCouponQTY(u.getCouponQTY()-1);
            
            num2++;
            }else if(num2==1) {
               if(u.getHp()>5) {
                     u.setHp(5);
                  }
               ta2.setText("당신의 체력은 " + u.getHp()+"가 되었고 ,\n쿠폰은 "+u.getCouponQTY()+"개 남았습니다.");
               num2++;
               
            }else {
               num2=0;
               couponCount++;
               
               if(couponCount==1) {
                  HiddenPanel hidden = new HiddenPanel(mf, u);
                  ChangePanel.replacePanel(mf, panel, hidden);
                  
               }else if(couponCount==5) {
                  HiddenPanel2 hidden = new HiddenPanel2(mf, u);
                   ChangePanel.replacePanel(mf, panel, hidden);
               }else {
                  BackgroundPanel world = new BackgroundPanel(mf,u);
                  ChangePanel.replacePanel(mf,panel,world);
                  
               }
            }
         }else if(couponGaesoo<=0) {
            if(num4==0) {
                ta2.setText("보유하신 쿠폰이 없습니다. 메인화면으로 돌아갑니다.");
                num4++;
                }else {
                num4=0;
                 
                System.out.println("카페 아웃1");

                WorldPanel.cafeBgm.stop();
                ChangePanel.replacePanel(mf, panel, new WorldPanel(mf,u));
                }
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
            ta3.setSize(820,80);
            ta3.setLocation(240,557);
            
            
            if(couponGaesoo>0) {
               if(num3==0) {
                  int random = new Random().nextInt(10);
                  if(random==0||random==1) {
                     ta3.setText("달고나명란마요쉐이크를 마시고\n체력이 1 감소되었습니다\n쿠폰이 1 감소합니다");
                     u.setHp(u.getHp()-1);
                     u.setCouponQTY(u.getCouponQTY()-1);
                  }else if(random==2) {
                     ta3.setText("흑당마라민트초코를 마시고\n체력이 4 회복되었습니다\n쿠폰이 1 감소합니다");
                     u.setHp(u.getHp()-2);
                     u.setCouponQTY(u.getCouponQTY()-1);
                  }else if(random==3||random==4||random==5) {
                     ta3.setText("아이스 아메리카노를 마시고\n체력이 1 회복되었습니다\n쿠폰이 1 감소합니다");
                     u.setHp(u.getHp()+1);
                     u.setCouponQTY(u.getCouponQTY()-1);
                  }else if(random==6||random==7||random==8) {
                     ta3.setText("아이스 카페라떼를 마시고\n체력이 2 회복되었습니다\n쿠폰이 1 감소합니다");
                     u.setHp(u.getHp()+2);
                     u.setCouponQTY(u.getCouponQTY()-1);
                  }else if(random==9) {
                     ta3.setText("아이스 바닐라라떼를 마시고\n체력이 3 회복되었습니다\n쿠폰이 1 감소합니다");
                     u.setHp(u.getHp()+3);
                     u.setCouponQTY(u.getCouponQTY()-1);
                  }
                  ++num3;
               }else if(num3==1) {
                  if(u.getHp()>5) {
                        u.setHp(5);
                     }
                  ta3.setText("당신의 체력은 " + u.getHp()+"가 되었고 ,\n쿠폰은 "+u.getCouponQTY()+"개 남았습니다.");
                  num3++;
               }else {
                        num3=0;
                        couponCount++;
                          
                          if(couponCount==1) {
                             HiddenPanel hidden = new HiddenPanel(mf, u);
                             ChangePanel.replacePanel(mf, panel, hidden);
                             
                          }else if(couponCount==5) {
                             HiddenPanel2 hidden = new HiddenPanel2(mf, u);
                              ChangePanel.replacePanel(mf, panel, hidden);
                          }else {
                        BackgroundPanel world = new BackgroundPanel(mf,u);
                        ChangePanel.replacePanel(mf,panel,world);
                          }
               }
            }
            if(couponGaesoo<=0){
               if(num4==0) {
               ta3.setText("보유하신 쿠폰이 없습니다. 메인화면으로 돌아갑니다.");
               num4++;
               }else {
               num4=0;
               System.out.println("카페 아웃2");
               WorldPanel.cafeBgm.stop();
               ChangePanel.replacePanel(mf, panel, new WorldPanel(mf,u));
               }
            }
           
            
            
            
         }
      }
         
            
            );
      
      MouseListener todaysMenu = new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
         JOptionPane.showMessageDialog(null, "            오늘의 메뉴판\n\n1.달고나 명란마요 쉐이크 : 배터리 1 감소        "
               + "\n\n2.아이스 아메리카노 : 배터리 1 회복        \n\n3.아이스 카페라떼 : 배터리 2 회복        \n\n4.아이스 바닐라라떼 : 배터리 3 회복        \n\n5.흑당마라민트초코쉐이크 : 배터리 4 회복      \n ", "오늘의 메뉴^.^",1);
         
      }
      @Override
      public void mouseEntered(MouseEvent e) {
      }
      @Override
      public void mouseExited(MouseEvent e) {
      }
      @Override
      public void mousePressed(MouseEvent e) {
      }
      @Override
      public void mouseReleased(MouseEvent e) {
      }
         
      };
     
      goBack.addMouseListener(new MouseListener() {
      
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
         System.out.println("카페 아웃3");
         WorldPanel.cafeBgm.stop();
         ChangePanel.replacePanel(mf, panel, new WorldPanel(mf,u));
         
      }
   });
     
     forTM.addMouseListener(todaysMenu);
      cafeManager.addMouseListener(new MouseListener() {
      
      @Override
      public void mouseReleased(MouseEvent e) {
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
      }
      
      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub
         cafeManager.setLocation(640,257);
         cafeManager.setSize(319, 243);
         cafeManager.setIcon(new ImageIcon(new ImageIcon("images/cafeManager2.PNG").getImage().getScaledInstance(319, 243, 0)));
      }
      
      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub
         if(pppppakk==0) {
            
            cafeManager.setLocation(640,137);
            cafeManager.setSize(360,384);
            cafeManager.setIcon(new ImageIcon(new ImageIcon("images/PPackPPack.PNG").getImage().getScaledInstance(360, 384, 0)));
         }
      }
      
      @Override
      public void mouseClicked(MouseEvent e) {
         if(pppppakk==0) {
            JaeHyung world = new JaeHyung(mf,u);
            ChangePanel.replacePanel(mf,panel,world);
         }
         
         
      }
   });
      
      

      JLabel labelB = addJLabelImage(new JLabel(), "batteryCase.png", 111, 44);
      labelB.setLocation(10, 5);
      String[] remainBattery = new String[] { "battery1.png", "battery2.png", "battery3.png", "battery4.png",
            "Battery5.png" };

      ArrayList<Image> images = new ArrayList<Image>();
      for (int i = 0; i < remainBattery.length; i++) {
         images.add(new ImageIcon(ADDRESS + remainBattery[i]).getImage().getScaledInstance(111, 44, 0));
      }

      ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

      for (int i = 0; i < u.getHp(); i++) {
         batteryLabels.add(new JLabel(new ImageIcon(images.get(i))));
         batteryLabels.get(i).setSize(111, 44);
         batteryLabels.get(i).setLocation(10, 5);
         this.add(batteryLabels.get(i));
         //this.setComponentZOrder(batteryLabels.get(i), i);
      }
      this.add(labelB);
      //this.setComponentZOrder(labelB, 1);
      this.add(goBack);
      this.add(ta2);
      this.add(ta3);
      this.add(ta);
      this.add(cafeManager);
      this.add(textArea);
      this.add(forTM);
      this.add(label); 
      
      this.setComponentZOrder(forTM, 1);
      this.setComponentZOrder(goBack, 0);
      this.setComponentZOrder(ta3,2);
      this.setComponentZOrder(ta2, 3);
      this.setComponentZOrder(ta, 4);
     // this.setComponentZOrder(label, 6);
      this.setComponentZOrder(cafeManager, 5);
      this.setComponentZOrder(textArea, 5);
   }
   public JLabel addJLabelImage(JLabel label, String path, int x, int y) {

      Image image = new ImageIcon(ADDRESS + path).getImage().getScaledInstance(x, y, 0);
      label = new JLabel(new ImageIcon(image));
      label.setSize(x, y);

      return label;
   }
   //public void createBattery(int hp) {
//
//      JLabel labelB = addJLabelImage(new JLabel(), "batteryCase.png", 111, 44);
//      labelB.setLocation(10, 5);
//      String[] remainBattery = new String[] { "battery1.png", "battery2.png", "battery3.png", "battery4.png",
//            "Battery5.png" };
//
//      ArrayList<Image> images = new ArrayList<Image>();
//      for (int i = 0; i < remainBattery.length; i++) {
//         images.add(new ImageIcon(ADDRESS + remainBattery[i]).getImage().getScaledInstance(111, 44, 0));
//      }
//
//      ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();
//
//      for (int i = 0; i < u.getHp(); i++) {
//         batteryLabels.add(new JLabel(new ImageIcon(images.get(i))));
//         batteryLabels.get(i).setSize(111, 44);
//         batteryLabels.get(i).setLocation(10, 5);
//         this.add(batteryLabels.get(i));
//      }
//      
//      this.add(labelB);
//      //this.setComponentZOrder(labelB, 1);
   
}