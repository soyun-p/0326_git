package ex1_calculator_hw0325;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener_Cal implements ActionListener{
	
	
	private String num1 = "";
	private String num2 = "";
	private String op = "";
	
	private int res1 = 0;  // +, -, * 의 연산 결과
	private float res2 = 0;  // / 의 연산 결과(소수점이 나올 수도 있기 때문)
	
	private int phase = 0;  // num1, num2의 값을 나누어 담기 위한 (단계) 변수
	
	// 결과를 보여줄 레이블
	private Label lb;
	
	public void setLb(Label lb) {  // 감지자 레이블에 주소를 보내는 세터
		this.lb = lb;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 어떤 버튼이 클릭됐는지 구별하는 switch문
		switch( e.getActionCommand() ) {
		
		case "+":
		case "-":
		case "*":
		case "/":
			op = e.getActionCommand();  // 클릭된 연산자 기억
			phase = 1;  // 연산자 입력 후에는 num2의 값을 넣어야 하기 때문에 값을 변경
			lb.setText(num1 + " " + op + " "); 
			break;
			
		default:
			// 숫자버튼이 입력됐을 때
			if( phase == 0 ) {  // num1에 값을 넣는다
				num1 += e.getActionCommand();  // 입력받은 숫자를 이어붙이기
				lb.setText(num1);
			}else {// num2에 값을 넣는다
				num2 += e.getActionCommand();
				lb.setText(num1 + " " + op + " " + num2);
			}
			
			break;
			
		case "=":
			phase = 0;
			if( op.equals("+") ) {
				res1 = Integer.parseInt(num1) + Integer.parseInt(num2);
			}else if( op.equals("-") ) {
				res1 = Integer.parseInt(num1) - Integer.parseInt(num2);
			}else if( op.equals("*") ) {
				res1 = Integer.parseInt(num1) * Integer.parseInt(num2);
			}else if( op.equals("/") ) {
				res2 = Float.parseFloat(num1) / Float.parseFloat(num2);
			}
			
			// 결과 출력
			if( !op.equals("/") ) {
				lb.setText(num1 + " " + op + num2 + "=" + res1);
			}else {
				String formatStr =
						String.format("%s %s %s = %.1f", num1, op, num2, res2);
				lb.setText(formatStr);  // 레이블에 format 텍스트를 저장
				
			}
			break;
			
		case "C":
			// 모든 항목 초기화
			num1 = "";
			num2 = "";
			op = "";
			res1 = 0;
			res2 = 0;
			phase = 0;
			lb.setText("0");
			
			break;
		
		}
		
		
	}
	
	
	

}
