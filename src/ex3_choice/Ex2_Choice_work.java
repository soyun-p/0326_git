package ex3_choice;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex2_Choice_work {
	public static void main(String[] args) {


		Frame f = new Frame("지역선택");
		f.setLayout(null);
		f.setBounds(400, 200, 300, 300);


		Choice local = new Choice();
		local.setBounds(30, 50, 150, 0);

		local.add("서울");
		local.add("경기");
		local.add("인천");
		local.add("광주");
		local.add("대구");
		local.add("대전");
		local.add("부산");

		Font font = new Font("", Font.PLAIN, 30);
		Label lb = new Label("", Label.CENTER);
		lb.setFont(font);
		lb.setBounds(30, 150, 240, 150);


		f.add(local);
		f.add(lb);
		
		
		// 감지자 추가
		local.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String region = local.getSelectedItem();
				lb.setText(region);

			}
		});
		
		
		
		
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
