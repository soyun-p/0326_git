package ex5_layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		frame.setBounds(500, 200, 250, 400);
		frame.setLayout(null);
		frame.setBackground(Color.LIGHT_GRAY);
		
		Font font = new Font("", Font.PLAIN, 18);
		
		// 프레임 최상단에 위치할 TextField, Button
		// TextField : 키보드에서 한 줄 짜리 값을 입력받는 객체
		TextField tf = new TextField();  // 검색바
		tf.setFont(font);
		tf.setBounds(5, 35, 180, 25);
		
		Button btn = new Button("입력");
		btn.setBounds(200, 35, 40, 25);
		btn.setEnabled(false);  // 처음에 버튼은 비활성화 상태로 시작
		
		
		// 프레임 중앙에 배치될 TextArea(추가할 텍스트, 세로길이, 가로길이, 스크롤바 스타일) : 엔터키 칠 수 있는, 여러 줄 짜리 값을 입력받는 객체
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY); // 세로로만 스크롤
		ta.setFont(font);
		ta.setBounds(10, 70, 228, 250);
		
		
		
		frame.add(tf);
		frame.add(btn);
		frame.add(ta);
		
		
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
		
		
		
	} // main

}
