package com.kh.parkBBakBBak.view.cafe;

import java.awt.Color;
import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;





public class BackgroundPanel extends JPanel{
   public JFrame mf;
   public JPanel panel;
   public Player u;
   public int num = 0;
   public JButton button;
   JTextField tf2;
   JTextArea ta;
   Font font = new Font("���� ���", Font.BOLD, 20);
   JTextArea ta1;
   JTextArea ta2;
   JTextArea ta3;
   JTextArea forTM;

   int num2 = 0;
   int num3 = 0 ;
   int num4 = 0;
   public BackgroundPanel(JFrame mf , Player p ) {
      panel = this;
      this.mf = mf;
      u = p ;
      
      this.setLayout(null);
      mf.setTitle("ī��");
 
      
      String[] explain = {"������ �޴��� Ȯ���Ͻ÷��� ���� �ϴ��� �ؽ�Ʈ�ڽ��� Ŭ�����ּ���.","zz"};
      
      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/cafeBack.PNG").getImage().getScaledInstance(1194,834, 0)));
      label.setBounds(0, 0, 1194,834);
      
      JLabel cafeManager = new JLabel(new ImageIcon(new ImageIcon("images/cafeManager2.PNG").getImage().getScaledInstance(319, 243, 0)));
      cafeManager.setBounds(640,257,319,243);
      
      JLabel textArea = new JLabel(new ImageIcon(new ImageIcon("images/txtarea2.PNG").getImage().getScaledInstance(820, 270, 0)));
      textArea.setBounds(180,498,820,270);
      
      JButton goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.PNG").getImage().getScaledInstance(60, 60, 0)));
     /* BackgroundPanel world = new BackgroundPanel(mf,u);
      ChangePanel.replacePanel(mf,panel,world);*/
      
      tf2 = new JTextField("�ȳ��ϼ��� ī�信 ���� ���� ȯ���մϴ�.");
      tf2.setBounds(240,527,820,170);
      tf2.setOpaque(false);
      tf2.disable();
      tf2.setBorder(null);
      
      goBack.setBounds(1104,30,60,60);
      goBack.setBorderPainted(false);
      goBack.setContentAreaFilled(false);
      goBack.setFocusPainted(false);
      ta = new JTextArea();
      ta.setEditable(false);
      ta.setBounds(240,557,820,170);
      ta.setOpaque(false);
      ta.setFont(font);
      ta.append("ī�� �Ŵ��� ���� :\n������� OracleCafe�Դϴ�.\n�ֹ��Ͻðڽ��ϱ�?");
      ta.setVisible(true);
      
      ta2 = new JTextArea();
      ta2.setEditable(false);
      ta2.setBounds(240,557,820,50);
      ta2.setOpaque(false);
      ta2.setFont(font);
      ta2.setVisible(false);
      ta2.append("1.���̽� �Ƹ޸�ī��");
      
      ta3 = new JTextArea();
      ta3.setEditable(false);
      ta3.setBounds(240,607,820,50);
      ta3.setOpaque(false);
      ta3.setFont(font);
      ta3.setVisible(false);
      ta3.append("2.������ �޴�");
      cafeManager.addMouseListener(new My());
      
      forTM = new JTextArea();
      forTM.setEditable(false);
      forTM.setBounds(1030,740,300,35);
      forTM.setOpaque(false);
      forTM.setFont(font);
      forTM.setForeground(Color.WHITE);
      forTM.append("������ �޴�");
      
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
            	u.setCouponQTY(5);
            ta2.setText("����� �Ƹ޸�ī�븦 ���ð�\nü���� 1 ȸ���Ǿ����ϴ�.\n������ 1 �����մϴ�.");
            u.setHp(u.getHp()+1);
            u.setCouponQTY(u.getCouponQTY()-1);
            num2++;
            }else if(num2==1) {
               ta2.setText("����� ü���� " + u.getHp()+"�� �Ǿ��� ,\n������ "+u.getCouponQTY()+"�� ���ҽ��ϴ�.");
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
            ta3.setSize(820,80);
            ta3.setLocation(240,557);
            
            
            if(u.getCouponQTY()>0) {
            	
            	if(num3==0) {
            		int random = new Random().nextInt(5);
            		if(random==0) {
            			ta3.setText("�ް�������佦��ũ�� ���ð�\nü���� 1 ���ҵǾ����ϴ�\n������ 1 �����մϴ�");
            			u.setHp(u.getHp()-1);
            			u.setCouponQTY(u.getCouponQTY()-1);
            		}else if(random==1) {
            			ta3.setText("��縶���Ʈ���ڸ� ���ð�\nü���� 2 ���ҵǾ����ϴ�\n������ 1 �����մϴ�");
            			u.setHp(u.getHp()-2);
            			u.setCouponQTY(u.getCouponQTY()-1);
            		}else if(random==2) {
            			ta3.setText("���̽� �Ƹ޸�ī�븦 ���ð�\nü���� 1 ȸ���Ǿ����ϴ�\n������ 1 �����մϴ�");
            			u.setHp(u.getHp()+1);
            			u.setCouponQTY(u.getCouponQTY()-1);
            		}else if(random==3) {
            			ta3.setText("���̽� ī��󶼸� ���ð�\nü���� 2 ȸ���Ǿ����ϴ�\n������ 1 �����մϴ�");
            			u.setHp(u.getHp()+2);
            			u.setCouponQTY(u.getCouponQTY()-1);
            		}else if(random==4) {
            			ta3.setText("���̽� �ٴҶ�󶼸� ���ð�\nü���� 3 ȸ���Ǿ����ϴ�\n������ 1 �����մϴ�");
            			u.setHp(u.getHp()+3);
            			u.setCouponQTY(u.getCouponQTY()-1);
            		}
            		/*ta3.setText("����� �Ƹ޸�ī�븦 ���ð�\nü���� 1 ȸ���Ǿ����ϴ�.\n������ 1 �����մϴ�.");
            u.setHp(u.getHp()+1);
            u.setCouponQTY(u.getCouponQTY()-1);*/
            		num3++;
            	}else if(num3==1) {
            		ta3.setText("����� ü���� " + u.getHp()+"�� �Ǿ��� ,\n������ "+u.getCouponQTY()+"�� ���ҽ��ϴ�.");
            		num3++;
            	}else {
            		num3=0;
            		
//               ChangePanel change = new ChangePanel(mf, panel);
            		
            		BackgroundPanel world = new BackgroundPanel(mf,u);
            		ChangePanel.replacePanel(mf,panel,world);
            		
//               change.replacePanel(world);
            	}
            }else {
            	if(num4==0) {
            	ta3.setText("�����Ͻ� ������ �����ϴ�. ����ȭ������ ���ư��ϴ�.");
            	num4++;
            	}else {
            	num4=0;
            	System.out.println("ī�� �ƿ�");
    			ChangePanel.replacePanel(mf, panel, new WorldPanel(mf));
            	}
            }
           
            
            
            
         }
      }
         
            
    		  );
      /*ActionListener handler = new ActionListener() {
    	  
          @Override
          public void actionPerformed(ActionEvent e) {
              if (e.getActionCommand().equals("�޽���")) {// �������� == �񱳰��ƴ�
                                                          // .equals
                  JOptionPane.showMessageDialog(null, "ȭ�鿡 ����� �޼���", "����", JOptionPane.WARNING_MESSAGE);
              } else if (e.getActionCommand().equals("Ȯ��")) {
                  int result = JOptionPane.showConfirmDialog(null, "���α׷��� �����Ͻ� �ͽ��ϱ�?", "����",
                          JOptionPane.OK_CANCEL_OPTION);

                  System.out.printf("%d\n", result);
                  if (result == 0) { //OK=0 , Cancel=2 ����
                      System.exit(0);
                  }
              } else {
                  // �⺻������ �ϳ� �Է¹������� ����Ѵ�. 2���̻󸸵��� �������� ���� �������� ��...
                  String id = JOptionPane.showInputDialog(null, "���� ������?", "������", JOptionPane.OK_CANCEL_OPTION);
                  System.out.println(id);
              }
          }
      };*/
      MouseListener todaysMenu = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "				������ �޴���\n\n1.�ް� ������� ����ũ : ���͸� 1 ����        \n\n2.��縶���Ʈ���ڽ���ũ : ���͸� 2 ����        "
					+ "\n\n3.���̽� �Ƹ޸�ī�� : ���͸� 1 ȸ��        \n\n4.���̽� ī��� : ���͸� 2 ȸ��        \n\n5. ���̽� �ٴҶ�� : ���͸� 3 ȸ��        \n\n", "������ �޴�^.^",1);
			
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
      
      /*JTextField tf = new JTextField("dd");
      tf.setBounds(100,481,820,170);
      tf.setOpaque(false);*/
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
			System.out.println("ī�� �ƿ�");
			ChangePanel.replacePanel(mf, panel, new WorldPanel(mf));
			
		}
	});
      
      
      button = new JButton("Ŭ��");
      button.setBounds(700,581,100,100);
      
      button.addMouseListener(new My2());
      
      /*cafeManager.addMouseListener(new MouseListener() {
		
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
			System.out.println("ī�� �ƿ�");
			ChangePanel.replacePanel(mf, panel, new WorldPanel(mf));
			
		}
	});*/
     forTM.addMouseListener(todaysMenu);
      cafeManager.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			cafeManager.setLocation(640,137);
			cafeManager.setSize(360,384);
			cafeManager.setIcon(new ImageIcon(new ImageIcon("images/PPackPPack.PNG").getImage().getScaledInstance(360, 384, 0)));
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
      
      button.setFont(font);
      button.setVisible(false);
//      button2.setFont(font);
      //tf.setFont(font);
      tf2.setFont(font);
      this.add(goBack);
      this.add(ta2);
      this.add(ta3);
      this.add(ta);
      this.add(label); 
      this.add(cafeManager);
      this.add(textArea);
      this.add(forTM);
      //this.add(tf);
//      this.add(button2);
      //this.add(button);
      this.add(tf2);
      this.setComponentZOrder(forTM, 1);
      this.setComponentZOrder(goBack, 0);
      this.setComponentZOrder(ta3,2);
      this.setComponentZOrder(ta2, 3);
      this.setComponentZOrder(ta, 4);
      this.setComponentZOrder(tf2, 5);
//      this.setComponentZOrder(button2, 0);
//      this.setComponentZOrder(button, 4);
      this.setComponentZOrder(label, 6);
      this.setComponentZOrder(cafeManager, 5);
      this.setComponentZOrder(textArea, 5);
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