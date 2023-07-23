import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerI extends Remote {
    public String Insert(String Name,String Mobile,String Gender,String DOB,String problem,String appointment,String Address,String doctor) throws RemoteException;
    public String Update(String Name,String Mobile,String Gender,String DOB,String problem,String appointment,String Address,String doctor) throws RemoteException;
    public ArrayList Search(String Name, String Mobile, String Gender, String DOB, String problem, String appointment, String Address, String doctor) throws RemoteException;
    public String Delete(String Name,String Mobile,String Gender,String DOB,String problem,String appointment,String Address,String doctor) throws RemoteException;
}