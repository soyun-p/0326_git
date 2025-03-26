package ex1_calculator_hw0325;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalFrameMain {
	public static void main(String[] args) {
		
		Frame f = new Frame("계산기");
		f.setBounds(400, 200, 260, 300);
		f.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 20);
		
		Label lb = new Label("0");
		lb.setBounds(10, 180, 180, 100);
		lb.setFont(font);
		
		f.add(lb);
		
		
		// 모든 버튼의 이벤트를 감지할 감지자 클래스
		MyListener_Cal ml = new MyListener_Cal();
		ml.setLb(lb);
		
		
		// ---숫자 버튼---
		Button[] nums = new Button[10];
		
		for(int i = 0; i < nums.length; i++) {
			
			nums[i] = new Button("" + i);  // String.valueOf도 사용 가능
			
			// 버튼의 위치, 크기
			if( i >= 0 && i <= 4 ) {
				nums[i].setBounds(i*50+10, 40, 40, 40);
			}else {
				nums[i].setBounds((i-5)*50+10, 90, 40, 40);
			}
			
			nums[i].addActionListener(ml); // 버튼에 감지자 추가
			f.add(nums[i]);
			
		} // for
		
		
		// ---연산자 버튼---
		Button[] opers = new Button[5];
		String[] opStr = {"+", "-", "*", "/", "="};
		
		for(int i = 0; i < opers.length; i++) {
			
			opers[i] = new Button( opStr[i] );  // 버튼에 기호 문자 넣기
			opers[i].setBounds(i*50+10, 140, 40, 40);  // 버튼의 위치, 크기
			
			opers[i].addActionListener(ml);  // 감지자 추가
			f.add(opers[i]);  // 프레임에 저장.
			
		} // for
		
		
		// 초기화 버튼
		Button btnC = new Button("C");
		btnC.setBounds(200, 210, 50, 50);
		
		btnC.addActionListener(ml);   // 감지자 추가
		f.add(btnC);
		
		
		// ---종료 버튼 감지, 동작---
		f.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		
		
		f.setVisible(true);
		
		
		
		
	} // main

}
