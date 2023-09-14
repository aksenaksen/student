import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Data.Person;
import Data.Student;
import prop.Parse_data;
public class SignUpForm extends JFrame {
    private JLabel titleLabel;
    private JLabel idLabel;
    private JTextField idTextField;
    private JButton duplicateCheckButton;
    private JLabel pwdLabel;
    private JPasswordField pwdPasswordField;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel departmentLabel;
    private JTextField departmentTextField;
    private JLabel gradeLabel;
    private JTextField gradeTextField;
    private JButton signUpButton;
    private JButton loginButton;
    boolean tmp=false;
    public SignUpForm() {
        setTitle("회원가입");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 3));

        titleLabel = new JLabel("회원가입");
        add(titleLabel);

        idLabel = new JLabel("ID");
        add(idLabel);
        idTextField = new JTextField();
        add(idTextField);
        duplicateCheckButton = new JButton("중복확인");
        add(duplicateCheckButton);

        pwdLabel = new JLabel("비밀번호");
        add(pwdLabel);
        pwdPasswordField = new JPasswordField();
        add(pwdPasswordField);

        nameLabel = new JLabel("이름");
        add(nameLabel);
        nameTextField = new JTextField();
        add(nameTextField);

        departmentLabel = new JLabel("학과");
        add(departmentLabel);
        departmentTextField = new JTextField();
        add(departmentTextField);

        gradeLabel = new JLabel("학년");
        add(gradeLabel);
        gradeTextField = new JTextField();
        add(gradeTextField);

        signUpButton = new JButton("가입");
        add(signUpButton);

        loginButton = new JButton("로그인화면으로");
        add(loginButton);



        duplicateCheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parse_data d=new Parse_data();
                try {
                    if(d.check(idTextField.getText(),1)){
                        System.out.println("성공");
                        tmp=true;
                    }
                    else{
                        System.out.println("이미 존재");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // 가입 버튼 클릭 이벤트 처리
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student person = new Student();
                if (tmp){
                    person.setid(idTextField.getText());
                    person.setName(nameTextField.getText());
                    person.setPwd(pwdPasswordField.getText());
                    person.setDept(departmentTextField.getText());
                    person.setYear(Integer.parseInt(gradeTextField.getText()));
                    System.out.println("["+person.getId()+","+person.getName()+","+person.getDept()+","+person.getYear()+","+person.getPwd()+"]");
                }
                else{
                    System.out.println("아이디 중복확인이 필요합니다.");
                }
                // 회원가입 정보를 처리하는 코드를 추가하세요.
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });
    }
}
