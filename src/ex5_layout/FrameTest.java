package ex5_layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

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
		ta.setEditable(false);   // 직접 값 입력 방지
		
		// 프레임 하단에 배치될 버튼
		Button btnSave = new Button("저장");
		Button btnClose = new Button("닫기");
		
		btnSave.setBounds(15, 340, 100, 40);
		btnClose.setBounds(135, 340, 100, 40);
		
		
		// TextField(tf)에 값이 들어간 경우 '입력'버튼 활성화
		tf.addTextListener( new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				
				if( tf.getText().equals("") ) {
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);  // 버튼 활성화
				}
				
			}
		} );
		
		
		// '입력'버튼에 감지자 추가
		btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// setText() : 기존값을 지우고 새로운 값으로 대체
				// ta.setText( tf.getText() + "\n" );
				
				// 기존값을 유지하며 새로운 값을 추가
				ta.append( tf.getText() + "\n" );
				
				tf.setText("");  // 텍스트필드의 값 비우기
				tf.requestFocus();  // 텍스트 필드로 커서를 이동
			}
		} );
		
		
		// 텍스트필드에서 엔터 값 감지
		tf.addKeyListener( new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if( e.getKeyChar() == KeyEvent.VK_ENTER ) {
					ta.append( tf.getText() + "\n");
					tf.setText("");
					tf.requestFocus();
				} // if
				
			};
			
		} );
		
		
		// 닫기 버튼 클릭 시 프레임 종료
		btnClose.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);  // frame.dispose() 도 가능
			}
		});
		
		
		// 저장 버튼 클릭이벤트 감지자
		btnSave.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ta의 값을 메세지 변수에 저장
				String message = ta.getText();
				
				// 파일 출력을 위한 객체
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				
				try {
					FileDialog fd = new FileDialog( frame, "저장", FileDialog.SAVE);
					fd.setVisible(true);
					
					// 파일 저장할 경로
					String path = fd.getDirectory() + fd.getFile();
					System.out.println(path);
					
					// ta에 내용이 있다면 저장
					if( !message.equals("") ) {
						
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						
						bw.write(message);
						
						bw.flush();
						
					}else { // 내용이 없다면 저장할 내용 없다는 안내창 출력
						JOptionPane.showMessageDialog(frame, "저장할 내용이 없습니다.");
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}finally {
					try {
						bw.close();
						fw.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
	
		
		
		// 프레임에 추가
		frame.add(tf);
		frame.add(btn);
		frame.add(ta);
		frame.add(btnSave);
		frame.add(btnClose);
		
		
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
		
		
		
	} // main

}
