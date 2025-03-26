package ex3_choice;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_choice {
	public static void main(String[] args) {
		
		Frame f = new Frame();
		f.setLayout(null);
		f.setBounds(400, 200, 300, 150);
		
		Choice day = new Choice();
		// Choice 객체의 높이(height)는 안에 있는 요소의 크기대로 알아서 결정되므로 따로 지정할 필요 없이 0으로 설정.
		day.setBounds(30, 50, 150, 0);
		day.add("SUN");
		day.add("M0N");
		day.add("TUE");
		day.add("WED");
		day.add("THU");
		day.add("FRI");
		day.add("SAT");
		
		
		// 요일 선택 감지자
		day.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				System.out.println(day.getSelectedItem());
				
			}
		});
		
		
		f.add(day);
		
		
		
		//------------------------------------------------------------
		f.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		//-------------------------------------------------------------
		
		f.setVisible(true);
		
	} // main

}
