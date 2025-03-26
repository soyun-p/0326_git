package ex2_check;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex_Checkbox {
	public static void main(String[] args) {
		
		Frame f = new Frame("질문");
		f.setLayout(null);
		f.setBounds(500, 100, 800, 250);
		
		Font font = new Font("", Font.BOLD, 30);
		
		Label q1 = new Label("1. 관심 분야는 무엇입니까?");
		q1.setFont(font);
		q1.setBounds(20, 50, 400, 40);
		
		
		// 관심 분야를 보여줄 체크박스
		Checkbox sports = new Checkbox("sports");
		Checkbox movie = new Checkbox("movie");
		Checkbox music = new Checkbox("music");
		sports.setBounds(20, 90, 50, 20);
		movie.setBounds(75, 90, 50, 20);
		music.setBounds(130, 90, 50, 20);
		
		
		// 체크박스 선택을 감지하는 감지자
		ItemListener checkListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// e.getItem().toString() : 선택된 체크박스 text
				
				
				switch( e.getItem().toString() ) {
				
				case "sports":
					String s = e.getStateChange() == 1 ? "sports check" : "sports uncheck";
					System.out.println(s);
					break;
					
				case "movie":
					s = e.getStateChange() == 1 ? "movie check" : "movie uncheck";
					System.out.println(s);
					break;
					
				case "music":
					s = e.getStateChange() == 1 ? "music check" : "music uncheck";
					System.out.println(s);
					break;
				
				} // switch
			    
			
			}
		};;
		
		
		sports.addItemListener(checkListener);
		movie.addItemListener(checkListener);
		music.addItemListener(checkListener);
		
		
		
		f.add(q1);
		f.add(sports);
		f.add(movie);
		f.add(music);
		
		
		
		
		
		// 라디오 버튼 선택 감지자
		ItemListener radioListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				switch( e.getItem().toString() ) {
				
				case "남자":
					System.out.println("i am male");
					break;
					
				case "여자":
					System.out.println("i am female");
					break;
					
					
				} // switch
				
			}
		};
		
		
		// 라디오 버튼
		Label q2 = new Label("2. 당신의 성별은 무엇입니까?");
		q2.setFont(font);
		q2.setBounds(20, 120, 400, 40);
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox male = new Checkbox("남자", group, true);
		Checkbox female = new Checkbox("여자", group, false);
		
		male.addItemListener(radioListener);
		female.addItemListener(radioListener);
		
		male.setBounds(20, 165, 50, 40);
		female.setBounds(80, 165, 50, 40);
		
		
		f.add(q2);
		f.add(male);
		f.add(female);
		
		
		
		
		
		
		
		
		
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
