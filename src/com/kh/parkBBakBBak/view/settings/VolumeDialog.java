package com.kh.parkBBakBBak.view.settings;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.kh.parkBBakBBak.view.MenuPanel;
import com.kh.parkBBakBBak.view.cafe.BackgroundPanel;

public class VolumeDialog {
	public VolumeDialog(JFrame mf) {

		int sliderWidth = 300;
		int sliderHeight = 75;
		int dialWidth = 700;
		int dialHeight = 500;

		// ���̾�α� ����
		Dialog sd = new Dialog(mf, "���� ����");
		sd.setBounds(dialWidth, dialHeight, 400, 300);
		sd.setBackground(Color.DARK_GRAY);
		sd.add(new JLabel("simple dialog test"));
		sd.setLayout(null);

		// ���� ������
		JLabel volumeIcon = new JLabel(
				new ImageIcon(new ImageIcon("images/soundButton.png").getImage().getScaledInstance(100, 100, 0)));
		volumeIcon.setBounds(sd.getWidth() / 2 - 50, 60, 100, 100);

		// �����̴�
		JSlider slider = new JSlider(0, 100, 50);
		slider.setBounds(sd.getWidth() / 2 - sliderWidth / 2, sd.getHeight() / 2 + 25, sliderWidth, sliderHeight);
		slider.setBackground(Color.DARK_GRAY);

		// �ݱ� ��ư
		JButton closeButton = new JButton("close");
		closeButton.setForeground(Color.WHITE);
		closeButton.setSize(100, 25);
		closeButton.setLocation(sd.getWidth() / 2 - 50, sd.getHeight() / 2 + 100);
		closeButton.setBackground(Color.black);

		// �����̴� ���� ����
		slider.setMajorTickSpacing(10); // ū ���� ���� 10�� ����
		slider.setMinorTickSpacing(5); // ���� ���� ���� 5�� ����
		slider.setPaintTicks(true); // ������ ǥ���Ѵ�.
		slider.setPaintLabels(true); // ���� ���̺�� ǥ���Ѵ�.
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				int val = slider.getValue();
				float calcfull = 0.0f;
				if (val < 50) {
					float calcLessHalf = ((float) val * (800000.0f / 500000.0f)) - 80.0f;
					calcfull = calcLessHalf;
				} else {
					float calcMoreHalf = ((float) val * (60206.0f / 1000000.0f));
					calcfull = calcMoreHalf;
				}

//            System.out.println("val : "+val+ " | calcfull : "+calcfull);
//            float calcfull = ((float) val * (860206.0f / 1000000.0f)) - 80.0f;

				FloatControl volumeMainBgm = (FloatControl) MenuPanel.mainBgm.getControl(FloatControl.Type.MASTER_GAIN);
//				FloatControl volumeCafeBgm = (FloatControl) BackgroundPanel.cafeBgm
//						.getControl(FloatControl.Type.MASTER_GAIN);

				volumeMainBgm.setValue(calcfull);
//				volumeCafeBgm.setValue(calcfull);

			}
			// maximum : 6.0206
			// minimum : -80.0

		});

		sd.add(slider);
		sd.add(volumeIcon);
		sd.add(closeButton);
		sd.setVisible(true);
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sd.dispose();

			}
		});
	}

}