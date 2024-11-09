import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class calc implements ActionListener{
    private JFrame f;
    private JButton[] numbutton=new JButton[10];
    private JButton[] specbuttons=new JButton[14];
    private JButton clear,sqt,inverse,delete,dot,add,sub,multi,divide,perc,sin,cos,tan,equal;
    JPanel numberpanel,ONP;
    JRadioButton on,off;
    Font myfont = new Font("Verdana", Font.BOLD, 30);
    JTextField tf;
    private double num1=0.0,num2=0.0,ans;
    private char oper='.'; 
    calc(){
        f=new JFrame("Calculator");
        f.getContentPane().setBackground(Color.BLACK);
        tf=new JTextField();
        numberpanel=new JPanel();
        ONP=new JPanel();
        ButtonGroup bg=new ButtonGroup();

        clear=new JButton("clear");
        delete=new JButton("Delete");
        divide=new JButton("/");
        multi=new JButton("*");
        sub=new JButton("-");
        add=new JButton("+");
        dot=new JButton(".");
        perc=new JButton("%");
        sin=new JButton("sin");
        cos=new JButton("cos");
        tan=new JButton("tan");
        equal=new JButton("=");
        sqt=new JButton("root");
        inverse=new JButton("1/x");

        on=new JRadioButton("ON");
        off=new JRadioButton("OFF");

        bg.add(on);
        bg.add(off);

        ONP.add(on);
        ONP.add(off);
        ONP.setBackground(new Color(138, 127, 114));

        specbuttons[0]=clear;
        specbuttons[1]=delete;
        specbuttons[2]=add;
        specbuttons[3]=sub;
        specbuttons[4]=multi;
        specbuttons[5]=divide;
        specbuttons[6]=dot;
        specbuttons[7]=sin;
        specbuttons[8]=cos;
        specbuttons[9]=tan;
        specbuttons[10]=perc;
        specbuttons[11]=equal;
        specbuttons[12]=sqt;
        specbuttons[13]=inverse;
        
        for(int i=0;i<14;i++){
            specbuttons[i].addActionListener(this);
            specbuttons[i].setFocusable(false);
            specbuttons[i].setEnabled(false);
        }
        for(int i=0;i<10;i++){
            numbutton[i]=new JButton(String.valueOf(i));
            numbutton[i].addActionListener(this);
            numbutton[i].setFocusable(false);
            numbutton[i].setEnabled(false);
            numbutton[i].setBackground(new Color(196, 195, 194));

        }

        numberpanel.add(sin);
        numberpanel.add(cos);
        numberpanel.add(tan);
        numberpanel.add(clear);

        numberpanel.add(numbutton[9]);
        numberpanel.add(numbutton[8]);
        numberpanel.add(numbutton[7]);
        numberpanel.add(delete);
        
        numberpanel.add(numbutton[6]);
        numberpanel.add(numbutton[5]);
        numberpanel.add(numbutton[4]);
        numberpanel.add(add);

        numberpanel.add(numbutton[3]);
        numberpanel.add(numbutton[2]);
        numberpanel.add(numbutton[1]);
        numberpanel.add(sub);

        numberpanel.add(perc);
        numberpanel.add(numbutton[0]);
        numbutton[0].setBackground(new Color(156, 68, 77));
        numberpanel.add(dot);
        numberpanel.add(multi);

        numberpanel.add(divide);
        numberpanel.add(equal);
        numberpanel.add(sqt);
        numberpanel.add(inverse);

        off.setSelected(true);
        off.addActionListener(this);
        on.addActionListener(this);
        on.setBackground(new Color(138, 127, 114));
        off.setBackground(new Color(138, 127, 114));

        
        numberpanel.setLayout(new GridLayout(6,4,2,2));
        ONP.setSize(500,100);
        ONP.setVisible(true);
        tf.setSize(10,50);
        tf.setEditable(false);
        tf.setFont(myfont);
        tf.setBackground(Color.cyan);   
        tf.setForeground(Color.black);   
        tf.setPreferredSize(new Dimension(400, 100));
        f.setSize(400,400);
        f.setResizable(false);
        f.setLayout(new BorderLayout());
        f.add(tf,BorderLayout.NORTH);
        f.add(ONP,BorderLayout.SOUTH);
        f.add(numberpanel,BorderLayout.CENTER);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent e){
        if (on.isSelected()) {
            for(int i=0;i<14;i++){
                specbuttons[i].setEnabled(true);
            }
            for(int i=0;i<10;i++){
                numbutton[i].setEnabled(true);
            }

            for(int i=0;i<10;i++){
                    if(e.getSource()==numbutton[i]){
                        tf.setText(tf.getText()+String.valueOf(i));
                    } }
            if(e.getSource()==clear){
                tf.setText("");
                oper='.';
                num1=0.0;
                num2=0.0;
            }
            else if(e.getSource()==add){
                num1=Double.parseDouble(tf.getText());
                tf.setText("");
                oper='+';
            }
            else if(e.getSource()==sub){
                num1=Double.parseDouble(tf.getText());
                tf.setText("");
                oper='-';
            }
            else if(e.getSource()==multi){
                num1=Double.parseDouble(tf.getText());
                tf.setText("");
                oper='*';
            }
            else if(e.getSource()==divide){
                num1=Double.parseDouble(tf.getText());
                tf.setText("");
                oper='/';
            }
            else if(e.getSource()==equal){
                num2=Double.parseDouble(tf.getText());
                tf.setText("");
                switch (oper) {
                    case '+':
                        ans=num1+num2;
                        tf.setText(String.valueOf(ans));
                        oper='.';
                        break;
                    case '-':
                        ans=num1-num2;
                        tf.setText(String.valueOf(ans));
                        oper='.';
                        break;
                    case '*':
                        ans=num1*num2;
                        tf.setText(String.valueOf(ans));
                        oper='.';
                        break;
                    case '/':
                            if (num2 == 0) {
                                tf.setText("Error");
                            } else {
                                ans = num1 / num2;
                                tf.setText(String.valueOf(ans));
                            }
                            oper = '.';
                            break;
                    default:
                        tf.setText("Invalid");
                        break;
                }
            }
            else if(e.getSource()==dot){
                tf.setText(tf.getText()+".");
            }
            else if(e.getSource() == delete) {
                String currentText = tf.getText();
                if (!currentText.isEmpty()) {
                    tf.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
            else if(e.getSource() == sin) {
                num1 = Double.parseDouble(tf.getText());
                tf.setText(String.valueOf(Math.sin(Math.toRadians(num1))));
                }
            else if(e.getSource() == cos) {
                    num1 = Double.parseDouble(tf.getText());
                    tf.setText(String.valueOf(Math.cos(Math.toRadians(num1))));
                }
            else if(e.getSource() == tan) {
                num1 = Double.parseDouble(tf.getText());
                tf.setText(String.valueOf(Math.tan(Math.toRadians(num1))));
            }
            else if(e.getSource() == perc) {
                num1 = Double.parseDouble(tf.getText());
                tf.setText(String.valueOf(num1 / 100));
            }
            else if(e.getSource() == sqt) {
                num1 = Double.parseDouble(tf.getText());
                    tf.setText(String.valueOf(Math.sqrt(num1)));
            }
            else if(e.getSource() == inverse) {
                num1 = Double.parseDouble(tf.getText());
                    tf.setText(String.valueOf(1/num1));
            }
        }
        else{
            tf.setText("");
            for(int i=0;i<14;i++){
                specbuttons[i].setEnabled(false);
            }
            for(int i=0;i<10;i++){
                numbutton[i].setEnabled(false);
            }
    }
    }
}
public class calcultorstudy {
    public static void main(String args[]){
       new calc();
    }
}
