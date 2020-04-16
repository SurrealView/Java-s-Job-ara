package com.kh.parkBBakBBak.view.TestRoomMiniGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.testRoom.TestMainPage;

public class MiniGameResult extends JPanel {
   
   private JFrame mf;
   private JPanel MiniGameResult;
   private Player p;
   private JTextArea gameResult;
   
   public MiniGameResult(JFrame mf, Player p) {
      
      
      this.mf = mf;
      this.p = p;
      this.MiniGameResult = this;
      
      FindButtonGame.playCount++;      //���Ӱ��ȭ�鿡�� ���� Ƚ�� ����, 1�� 1ȸ�� ����ǵ��� ��
      
      System.out.println("��������� index : " + FindButtonGame.index);
      System.out.println("����гλ���");
      
      Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
      JLabel chatLb = new JLabel(new ImageIcon(chat));
      chatLb.setLayout(null);
      chatLb.setBounds(180, 250, 820, 270);
      
      
      gameResult = new JTextArea();
      gameResult.setOpaque(false);
      gameResult.append("");
      gameResult.setFont(new Font("���� ���", Font.BOLD, 25));
      gameResult.setEditable(false);
      
      
      Image background = new ImageIcon("images/minigameResultBack.png").getImage().getScaledInstance(1194, 834, 0);
      JLabel backgroundLb = new JLabel(new ImageIcon(background));
      backgroundLb.setBounds(0, 0, 1194, 834);
      
      
      if(FindButtonGame.index == 20) {
         //��ư �� ã������
         gameResult.setText("�뺸�뺸 : �ӹ��� �ϼ��߱���! �̰ɷ� ������ �� ������ �����϶�!\nĿ������ + 1");
         gameResult.setFont(new Font("���� ���", Font.BOLD, 20));
         gameResult.setBounds(250, 355, 700, 400);
         p.setCouponQTY(p.getCouponQTY() + 1);
         
      } else if(FindButtonGame.index < 20 && FindButtonGame.index > 0){
         //��ư �� ��ã���� ��
         gameResult.setBounds(250, 370, 600, 400);
         gameResult.setText("�뺸�뺸 : �ƽ���.. ���� �ٽ� ���� �غ���!");
         gameResult.setFont(new Font("���� ���", Font.BOLD, 20));
      } else if(FindButtonGame.index == 0) {
         gameResult.setBounds(250, 370, 600, 400);
         gameResult.setText("�뺸�뺸 : ����.. �ƹ��͵� ���Ѱž�?");
         gameResult.setFont(new Font("���� ���", Font.BOLD, 20));
      }
      
      gameResult.addMouseListener(new MyMouseAdapter());
      
      this.add(gameResult);
      this.add(chatLb);
      this.add(backgroundLb);
      mf.add(this);
   }
   
   class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mouseClicked(MouseEvent e) {
         if(e.getSource() == gameResult) {
            ChangePanel.replacePanel(mf, MiniGameResult, new TestMainPage(mf,p));
         }
      }
   }

}