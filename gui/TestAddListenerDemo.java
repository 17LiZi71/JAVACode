package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//使用接口的好处就是支持多继承，而接口中又必须实现父类的抽象方法
public class TestAddListenerDemo implements ActionListener, WindowListener {

    Frame f;
    Button b;

    public TestAddListenerDemo() {
        f = new Frame("Add Listener");
        b = new Button("press me");
        b.addActionListener(this);
        f.addWindowListener(this);
        f.add(b, "North");
        f.setSize(200, 200);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        b.setBackground(Color.blue);
    }

}