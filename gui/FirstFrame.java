package gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

public class FirstFrame extends Frame {
	public static void main(String[] args) {
		Frame frame = new Frame("Rental system");
		frame.setSize(1400, 700);
		frame.setBackground(Color.PINK);
		frame.setLayout(new FlowLayout());
		Button userRegistration = new Button("用户注册");
		Button userLog = new Button("用户登录");
		Button rootuserLog = new Button("管理员登录");
		userRegistration.setBackground(Color.YELLOW);
		userLog.setBackground(Color.GREEN);
		rootuserLog.setBackground(Color.ORANGE);
		frame.add(userRegistration);
		frame.add(userLog);
		frame.add(rootuserLog);
		frame.setVisible(true);
		
        Panel pn2 = new Panel();
		CheckboxGroup cg = new CheckboxGroup();
		pn2.setLayout(new FlowLayout());
		pn2.add(new Checkbox("one",cg,true));
		pn2.add(new Checkbox("two",cg,false));
		pn2.add(new Checkbox("three",cg,false));
		frame.add(pn2);
	}
}