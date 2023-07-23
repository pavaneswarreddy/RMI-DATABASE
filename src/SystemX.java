import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemX extends UnicastRemoteObject implements CustomerI {
    JFrame f = new JFrame();
    static JTextArea ta;
    public SystemX() throws RemoteException{
        super();
        ta = new JTextArea();
        ta.setBounds(30,30,400,400);
        f.add(ta);

        f.setTitle("SystemX");
        f.setSize(500,500);
        f.setVisible(true);

    }
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        SystemX s = new SystemX();
        reg.rebind("db", s);
        ta.append("server is running now");
    }

    @Override
    public String Insert(String Name,String Mobile,String Gender,String DOB,String problem,String appointment,String Address,String doctor)throws RemoteException {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
            Statement stmt = conn.createStatement();
        ) {
            String s="Success";
            // Execute a query
            ta.append("\n INSERTED");
            String sql = "INSERT INTO patientdetails VALUES ('"+Name+"','"+Mobile+"' ,'"+Gender+"','"+DOB+"', '"+problem+"','"+appointment+"','"+Address+"','"+doctor+"')";
            stmt.executeUpdate(sql);

            String result="SUCCESSFULLY REGISTERED";
            return result;

        } catch (SQLException e) {
            return e.toString();
        }     }

    @Override
    public String Update(String Name, String Mobile, String Gender, String DOB, String problem, String appointment, String Address, String doctor) throws RemoteException {

            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                Statement stmt = conn.createStatement();
            ) {

                ta.append("\n UPDATING PLEASE WAIT");
                String sql="Update patientdetails Set AppointmentDate='"+appointment+"' Where Mobile = '"+Mobile+"'";
                stmt.executeUpdate(sql);
                ta.append("\n SUCCESSFULLY UPDATED");
            String result="SUCCESSFULLY UPDATED";
            return  result;



    } catch (Exception exc) {
            return exc.toString();


        }

    }

        @Override
    public ArrayList Search(String Name, String Mobile, String Gender, String DOB, String problem, String appointment, String Address, String doctor) throws RemoteException {
            ArrayList student=new ArrayList();
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
                Statement stmt = conn.createStatement();
            ) {
                // Execute a query
                ta.append("\n SEARCHING...");
                String sql="SELECT * FROM patientdetails  Where Mobile = '"+Mobile+"'";

                ResultSet rs;
                       rs= stmt.executeQuery(sql);
                       while (rs.next()){
                           student.add("Name:"+rs.getString("Name"));
                           student.add("Mobile:"+rs.getString("Mobile"));
                           student.add("Gender:"+rs.getString("Gender"));
                           student.add("DOB:"+rs.getString("DOB"));
                           student.add("Problem:"+rs.getString("Problem"));
                           student.add("AppointmentDate:"+rs.getString("AppointmentDate"));
                           student.add("Address:"+rs.getString("Address"));
                           student.add("Doctor:"+rs.getString("Doctor"));

                       }
            ta.append("\n FOUND");






    } catch (Exception e) {
                e.printStackTrace();
            }
        return student;

        }
    @Override
    public String Delete(String Name, String Mobile, String Gender, String DOB, String problem, String appointment, String Address, String doctor) throws RemoteException {

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
            Statement stmt = conn.createStatement();
        ) {

            ta.append("\n Delete PLEASE WAIT");
            String sql="DELETE FROM patientdetails WHERE `patientdetails`.`Mobile` = '"+Mobile+"'";
            stmt.executeUpdate(sql);
            ta.append("\n SUCCESSFULLY DELETED");
            String result="SUCCESSFULLY DELETED";
            return  result;



        } catch (Exception exc) {
            return exc.toString();


        }

    }}


