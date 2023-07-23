

import oracle.sql.DATE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.rmi.Naming;

import java.rmi.RemoteException;

import java.sql.*;
import java.util.ArrayList;

import java.util.Random;


class gui
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel Doctor;

    private JComboBox doctor;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub,search,update;
    private JButton GETOTP;
    private JButton reset;
    private  JButton delete;
    private JTextArea tout;
    private JLabel res;
     String systemOTP,s="";
     int ranNo;
     String NAME,MOBILE,GENDER,DOB,PROBLEM,APPOINTMENT,ADDRESS,DOCTOR;
    private JLabel otp;
    private JTextArea resadd;
    private JLabel problem;
    private JTextField tpro;
    private JTextField txxotp;
     private JLabel DOP;
     private JTextField tdop;

    private  JLabel txotp;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };
    private String doctors[]
            ={"Ram(Pediatrician)","HARSHITH(Cardiologist)","Yashwanth(Oncologist)","kartik(Pulmonologist)",
            };



    // constructor, to initialize the components
    // with default values.
    public gui() throws RemoteException {


        setTitle("Appointment Form");
        setBackground(Color.CYAN);
        setBounds(300, 90, 850, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);

        title = new JLabel("Appointment Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 0);
        title.setBackground(Color.GREEN);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(50, 70);
        name.setBackground(Color.CYAN);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(125, 70);
        tname.setBackground(Color.CYAN);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(50, 100);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(125, 100);
        tmno.setBackground(Color.CYAN);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(50, 150);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(125, 150);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(200, 150);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(50, 200);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(110, 200);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(160, 200);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(210, 200);
        c.add(year);

        problem = new JLabel("Problem");
        problem.setFont(new Font("Arial", Font.PLAIN, 20));
        problem.setSize(100, 20);
        problem.setLocation(50, 260);
        c.add(problem);

        tpro = new JTextField();
        tpro.setFont(new Font("Arial", Font.PLAIN, 15));
        tpro.setSize(150, 20);
        tpro.setLocation(125, 260);
        tpro.setBackground(Color.CYAN);
        c.add(tpro);

        DOP = new JLabel("Appointment date");
        DOP.setFont(new Font("Arial", Font.PLAIN, 20));
        DOP.setSize(170, 20);
        DOP.setLocation(50, 310);
        c.add(DOP);

        tdop = new JTextField();
        tdop.setFont(new Font("Arial", Font.PLAIN, 15));
        tdop.setSize(150, 20);
        tdop.setLocation(215, 310);
        tdop.setBackground(Color.CYAN);
        c.add(tdop);

        add= new JLabel("Doctors");
        doctor =new JComboBox(doctors);
        doctor.setFont(new Font("Arial",Font.PLAIN,15));
        doctor.setSize(600,20);
        doctor.setLocation(40,30);
        c.add(doctor);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(50, 350);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(150, 350);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(200, 550);
        c.add(term);

        sub = new JButton("Insert");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(160, 600);
        sub.addActionListener(this);
        c.add(sub);

        search = new JButton("Search");
        search.setFont(new Font("Arial", Font.PLAIN, 15));
        search.setSize(100, 20);
        search.setLocation(60, 600);
        search.addActionListener(this);
        c.add(search);

        update = new JButton("Update");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setSize(100, 20);
        update.setLocation(340, 600);
        update.addActionListener(this);
        c.add(update);



        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(250, 600);
        reset.addActionListener(this);
        c.add(reset);


        delete = new JButton("delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(100, 20);
        delete.setLocation(440, 600);
        delete.addActionListener(this);
        c.add(delete);


        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 580);
        c.add(res);

        otp = new JLabel("OTP");
        otp.setFont(new Font("Arial", Font.PLAIN, 20));
        otp.setSize(500, 25);
        otp.setLocation(50, 480);
        c.add(otp);

        GETOTP = new JButton("GETOTP");
        GETOTP.setFont(new Font("Arial", Font.PLAIN, 15));
        GETOTP.setSize(100, 20);
        GETOTP.setLocation(200, 520);
        GETOTP.addActionListener(this);
        c.add(GETOTP);


        txxotp = new JTextField();
        txxotp.setFont(new Font("Arial", Font.PLAIN, 15));
        txxotp.setSize(190, 20);
        txxotp.setLocation(150, 480);
        c.add(txxotp);

        txotp = new JLabel("");
        txotp.setFont(new Font("Arial", Font.PLAIN, 20));
        txotp.setSize(500, 25);
        txotp.setLocation(220, 450);
        c.add(txotp);



        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }
    String sc;


    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {{
        if (e.getSource() == GETOTP) {
            for (int i = 0; i < 4; i++) {
                // Generate random digit within 0-9
                ranNo = new Random().nextInt(9);
                s = s.concat(Integer.toString(ranNo));
            }
            systemOTP = s;
            txotp.setText(systemOTP);
            sc=txxotp.getText();
                if(s.equals(sc)){}
                  else{res.setText("enter above OTP");

            }



        }}
        if(e.getSource()==update)
        { if(term.isSelected())
        {   sc=txxotp.getText();
            if(s.equals(sc)){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                Statement stmt = con.createStatement();
                NAME=tname.getText();
                if (male.isSelected())
                    GENDER="Male";
                if(female.isSelected())
                    GENDER="Female";
                String mobile=tmno.getText();
                DOB
                        =
                        (String) date.getSelectedItem()
                                + "/" + (String) month.getSelectedItem()
                                + "/" + (String) year.getSelectedItem()
                ;
                DOCTOR=(String) doctor.getSelectedItem();
                ADDRESS=tadd.getText();
                PROBLEM=tpro.getText();
                APPOINTMENT=tdop.getText();
                CustomerI dbi =(CustomerI)Naming.lookup("rmi://localhost:1099/db");
                String result=dbi.Update(NAME,mobile,GENDER,DOB,PROBLEM,APPOINTMENT,ADDRESS,DOCTOR);
                JOptionPane.showMessageDialog(null,result,"SUCCESS",JOptionPane.INFORMATION_MESSAGE);


        } catch (Exception exce) {

                JOptionPane.showMessageDialog(null,exce,"Error",JOptionPane.ERROR_MESSAGE);

            }}
            else {JOptionPane.showMessageDialog(null,"enter corrcet otp","Error",JOptionPane.ERROR_MESSAGE);;

            }
        }}
        if(e.getSource()==delete){
            if(term.isSelected())
                sc=txxotp.getText();
            if(s.equals(sc)){
           try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                Statement stmt = con.createStatement();
                NAME=tname.getText();
                if (male.isSelected())
                    GENDER="Male";
                if(female.isSelected())
                    GENDER="Female";
                String mobile=tmno.getText();
                DOB
                        =
                        (String) date.getSelectedItem()
                                + "/" + (String) month.getSelectedItem()
                                + "/" + (String) year.getSelectedItem()
                ;
                DOCTOR=(String) doctor.getSelectedItem();
                ADDRESS=tadd.getText();
                PROBLEM=tpro.getText();
                APPOINTMENT=tdop.getText();
                CustomerI dbi =(CustomerI)Naming.lookup("rmi://localhost:1099/db");
                String result=dbi.Delete(NAME,mobile,GENDER,DOB,PROBLEM,APPOINTMENT,ADDRESS,DOCTOR);
               JOptionPane.showMessageDialog(null,result,"SUCCESS",JOptionPane.INFORMATION_MESSAGE);

           }
            catch (Exception exce)
            {
                JOptionPane.showMessageDialog(null,exce,"Error",JOptionPane.ERROR_MESSAGE);
            }}else{JOptionPane.showMessageDialog(null,"enter corrcet otp","Error",JOptionPane.ERROR_MESSAGE);;}

        }
        if(e.getSource()==search)
        {if(term.isSelected())
            sc=txxotp.getText();
            if(s.equals(sc))
            {
                try
                {Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                    Statement stmt = con.createStatement();
                    NAME=tname.getText();
                    if (male.isSelected())
                        GENDER="Male";
                    if(female.isSelected())
                        GENDER="Female";
                    String mobile=tmno.getText();
                    DOB
                            =
                            (String) date.getSelectedItem()
                                    + "/" + (String) month.getSelectedItem()
                                    + "/" + (String) year.getSelectedItem()
                    ;
                    DOCTOR=(String) doctor.getSelectedItem();
                    ADDRESS=tadd.getText();
                    PROBLEM=tpro.getText();
                    APPOINTMENT=tdop.getText();
                    String data;
                    CustomerI dbi =(CustomerI)Naming.lookup("rmi://localhost:1099/db");
                    ArrayList rs =dbi.Search(NAME,mobile,GENDER,DOB,PROBLEM,APPOINTMENT,ADDRESS,DOCTOR);
                    String data1,data2;
                    data1= (String) rs.get(5)+"\n";
                    data2= (String) rs.get(7)+"\n";
                    data=data1+data2;
                    tout.setText(data);



                    tout.setEditable(false);

                    JOptionPane.showMessageDialog(null,"SUCCESSFULLY FOUND","SUCCESS",JOptionPane.INFORMATION_MESSAGE);


                } catch (Exception except) {
                    JOptionPane.showMessageDialog(null,except,"Error",JOptionPane.ERROR_MESSAGE);


                }}else{JOptionPane.showMessageDialog(null,"enter corrcet otp","Error",JOptionPane.ERROR_MESSAGE);;}


        }
           if (e.getSource() == sub) {
            if (term.isSelected())
            {if(term.isSelected())
                sc=txxotp.getText();
                if(s.equals(sc))  {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                    Statement stmt = con.createStatement();
                    String data1,data2,data3,data4,data5,data6,data;
                     data1 = "Name : "
                            + tname.getText() + "\n";
                     NAME=tname.getText();
                    data2="Mobile : "
                            + tmno.getText() + "\n";
                    String mobile=tmno.getText();
                    String gender = "";


                    if (male.isSelected())
                        GENDER="Male";

                   if(female.isSelected())
                        GENDER="Female";

                    data4
                            = "DOB : "
                            + (String) date.getSelectedItem()
                            + "/" + (String) month.getSelectedItem()
                            + "/" + (String) year.getSelectedItem()
                            + "\n";


                    DOB
                            =
                            (String) date.getSelectedItem()
                            + "/" + (String) month.getSelectedItem()
                            + "/" + (String) year.getSelectedItem()
                            ;
                    String Doctor;

                     data5= "DOCTOR :" + (String) doctor.getSelectedItem() + "\n";
                     DOCTOR=(String) doctor.getSelectedItem();

                     data6 = "Address : " + tadd.getText()+"\n";
                     String Address;
                     ADDRESS=tadd.getText();
                     PROBLEM=tpro.getText();
                    String data7 = "Problem: " + tpro.getText()+"\n";

                     APPOINTMENT=tdop.getText();
                    String data8 = "Appointment Date: "
                            + tdop.getText() + "\n";
                     CustomerI dbi=(CustomerI) Naming.lookup("rmi://localhost:1099/db");
                     dbi.Insert(NAME,mobile,GENDER,DOB,PROBLEM,APPOINTMENT,ADDRESS,DOCTOR);
                     String data0="Gender :"+GENDER+"\n";


                data=data1 + data2 +data0+ data4 + data5+ data6+data7+data8;
                    tout.setText(data);
                    tout.setEditable(false);
                    JOptionPane.showMessageDialog(null,"SUCCESSFULLY APPOINTMENT ","SUCCESS",JOptionPane.INFORMATION_MESSAGE);

                    res.setText("Registration Successfully..");}
                catch (Exception ex)
                {
                    System.out.println("client exception "+e.toString());
                    JOptionPane.showMessageDialog(null,"ERROR","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    ex.printStackTrace();
                }}else{JOptionPane.showMessageDialog(null,"enter corrcet otp","Error",JOptionPane.ERROR_MESSAGE);;}

            }

            else {
                tout.setText("");
                resadd.setText("");
                res.setText("\n\n\n\nPlease accept the"
                        + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }

    }

}

// Driver Code
class Registration {

    public static void main(String[] args) throws Exception
    {
        gui f = new gui();

    }
}
