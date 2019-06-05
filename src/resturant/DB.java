package resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class DB {

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://rest.accdb");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return con;
    }

    public static int count(String col, String table) throws SQLException {
        Connection con = connect();
        try {

            PreparedStatement ps = con.prepareStatement("select count(" + col + ")from " + table);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return Integer.parseInt(result.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        } finally {
            con.close();
        }
        return 0;
    }

    public static boolean insert(String table, int id, String name, String type, int cost) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = null;
        try {
            String colM = "(numM,nameM,typeM,costM)";
            String colD = "(numD,nameD,typeD,costD)";
            if (table.equals("meals")) {
                ps = con.prepareStatement("insert into " + table + "" + colM + "Values(" + id + " , '" + name + "','" + type + "' ," + cost + " )");
            } else {
                ps = con.prepareStatement("insert into " + table + "" + colD + "Values(" + id + " , '" + name + "','" + type + "' ," + cost + " )");
            }

            return ps.execute();
        } catch (Exception ex) {
            if (table.equals("drink")) {
                JOptionPane.showMessageDialog(null, "اسم المشروب موجود من قبل");
            } else {
                JOptionPane.showMessageDialog(null, "اسم الوجبة موجود من قبل");
            }

        } finally {
            con.close();
        }

        return true;
    }

    public static boolean insertMN(String table, int id, String name, String comp) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = null;
        try {
            String colMN = "(ID,nameMN,comp)";
            ps = con.prepareStatement("insert into " + table + "" + colMN + "Values(" + id + " , '" + name + "' , '" + comp + "' )");
            return ps.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "من فضلك ادخل رقم مندوب مناسب");
        } finally {
            con.close();
        }

        return true;
    }

    public static boolean insertphone(String table, int id, String phone) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = null;
        try {
            String colMN = "(ID_phone,numm)";
            ps = con.prepareStatement("insert into " + table + "" + colMN + "Values(" + id + " , '" + phone + "' )");
            return ps.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "من فضلك قم بعمل إضافة للمندوب ثم أدخل ارقام التليفون الخاصة به او حاول برقم اخر");
        } finally {
            con.close();
        }
        return true;
    }

    public static boolean deletetphone(int id, String phone) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from  phone where ID_phone = " + id + " and numm = '" + phone + "'");
            return ps.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            con.close();
        }
        return true;
    }

    public static boolean deletetphoneEmp(String id, String phone) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from  emp_phone where ID = " + id + " and phone = '" + phone + "'");
            return ps.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            con.close();
        }
        return true;
    }

    public static int AutoNum(String tableName, String colName) throws SQLException {
        Connection con = connect();
        try {

            PreparedStatement ps = con.prepareStatement("select COALESCE(max(" + colName + "), 0)from " + tableName);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return (Integer.parseInt(result.getString(1)) + 1);
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        } finally {
            con.close();
        }
        return 0;
    }

    public static int AutoNumMN(String tableName, String colName) throws SQLException {
        Connection con = connect();
        try {

            PreparedStatement ps = con.prepareStatement("select COALESCE(max(" + colName + "), 0)from " + tableName);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return (Integer.parseInt(result.getString(1)) + 1);
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        } finally {
            con.close();
        }
        return 0;
    }

    public static ObservableList<Drinks> getDranks() throws SQLException {

        Connection con = connect();
        ObservableList<Drinks> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = con.prepareStatement("select * from drink");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Drinks(rs.getInt("numD"), rs.getString("nameD"), rs.getString("typeD"), rs.getInt("costD")));
            }

        } catch (Exception e) {
        } finally {
            con.close();
        }

        return list;
    }

    public static ObservableList<Meels> getMeals() throws SQLException {

        Connection con = connect();
        ObservableList<Meels> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = con.prepareStatement("select * from meals");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Meels(rs.getInt("numM"), rs.getString("nameM"), rs.getString("typeM"), rs.getInt("costM")));
            }

        } catch (Exception e) {
        } finally {
            con.close();
        }

        return list;
    }

    public static ObservableList<MN> getMN() throws SQLException {

        Connection con = connect();
        ObservableList<MN> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("select * from MN");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MN(rs.getInt("ID"), rs.getString("nameMN"), rs.getString("comp")));
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            con.close();
        }

        return list;
    }

    public static ObservableList<Phone> getPhone(int where) throws SQLException {

        Connection con = connect();
        ObservableList<Phone> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("select numm from phone where ID_phone = " + where + "");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Phone(rs.getString("numm")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            con.close();
        }
        return list;
    }

    public static boolean update(String table, int Condition, String name, String type, int cost) {
        Connection con = connect();
        String sql;
        if (table.equals("drink")) {
            sql = "update " + table + " set nameD = '" + name + "' , typeD= '" + type + "' , costD = " + cost + " where numD = " + Condition;
        }
        if (table.equals("meals")) {
            sql = "update " + table + " set nameM = '" + name + "' , typeM= '" + type + "' , costM = " + cost + " where numM = " + Condition;
        } else {
            sql = "update " + table + " set nameMN = '" + name + "' , comp= '" + type + "' where ID = " + Condition;
        }
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            return !ps.execute();
        } catch (Exception e) {
            if (table.equals("drink")) {
                JOptionPane.showMessageDialog(null, "اسم المشروب موجود من قبل");
            } else {
                JOptionPane.showMessageDialog(null, "اسم الوجبة موجود من قبل");
            }

        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

    public static boolean updateEmp(String conndition, String name, int salary, String job, String address) {
        Connection con = connect();
        String sql;
        sql = "update emp set name_emp = '" + name + "' , salary = " + salary + " , jop = '" + job + "' , address = '" + address + "' where ID = '" + conndition + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return !ps.execute();
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

    public static boolean delete(String table) {

        Connection con = connect();
        String sql;
        if (table.equals("drink")) {
            sql = "delete from drink";
        } else {
            sql = "delete from " + table;
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return !ps.execute();

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static boolean deleteField(String table, int where) {

        Connection conn = connect();
        String sql = null;
        if (table.equals("meals")) {
            sql = "delete from meals where numM = " + where;
        } else if (table.equals("drink")) {
            sql = "delete from drink where numD = " + where;
        } else if (table.equals("MN")) {
            sql = "delete from MN where ID = " + where;
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.execute();
        } catch (Exception e) {

        } finally {

            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return true;

    }

    public static boolean deleteEmp(String where) {

        Connection conn = connect();
        String sql = null;
        sql = "delete from emp where ID = '" + where + "' ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.execute();
        } catch (Exception e) {

        } finally {

            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return true;

    }

    public static Boolean insertEmp(String id, String name_emp, int salary, String address, String jop) {

        Connection conn = connect();
        String col = "(ID,name_emp,salary,jop,address)";
        try {
            PreparedStatement ps = conn.prepareStatement("insert into emp " + col + "values(" + id + ",'" + name_emp + "'," + salary + ",'" + jop + "','" + address + "')");
            return ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "رقم قومي مكرر");

        } finally {
            try {

                conn.close();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static ObservableList<Emp> getEmp() {

        ObservableList<Emp> list = FXCollections.observableArrayList();
        Connection conn = connect();
        String sql = "select * from emp";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Emp(rs.getString("ID"), rs.getString("name_emp"), rs.getInt("salary"), rs.getString("jop"), rs.getString("address")));
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

    public static boolean insertPhoneEmp(String ID, String phone) {
        Connection conn = connect();
        String col = "(ID,phone)";
        String sql = "insert into emp_phone " + col + " values('" + ID + "' , '" + phone + "')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.execute();
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

    public static ObservableList<PhoneEmp> getPhoneEmp(String where) {
        Connection conn = connect();
        ObservableList<PhoneEmp> list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("select phone from emp_phone where ID ='" + where + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhoneEmp(rs.getString("phone")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

    public static int getCountTypeCold() {

        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement("select count(typeD) from drink where typeD = 'بارد' ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }

        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return 0;

    }

    public static int getCountTypeM(String where) {

        Connection conn = connect();
        String sql = null;

        sql = "select count(typeM) from meals where typeM = '" + where + "' ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return (rs.getInt(1));
            }

        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return 0;

    }

    public static ObservableList getEmpname() {

        ObservableList list = FXCollections.observableArrayList();
        String sql = "select name_emp from emp ";
        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name_emp"));
            }

        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return list;
    }
    
     public static ObservableList<G> getG() {

        ObservableList<G> list = FXCollections.observableArrayList();
        String sql = "select * from G ";
        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new G(rs.getString("name_mng") , rs.getString("name_eg") , rs.getString("g") , rs.getString("d") , rs.getInt("buy") , rs.getInt("change")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return list;
    }
    
    public static ObservableList getMNname() {

        ObservableList list = FXCollections.observableArrayList();
        String sql = "select nameMN from MN ";
        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("nameMN"));
            }

        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return list;
    }
    
    public static boolean insertG(String name_mng , String name_eg , String type , int buy , int change){

        Connection conn = connect();
        String col ="(name_mng , name_eg , g , d , buy , change)";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into G "+col+" values('"+name_mng+"' , '"+name_eg+"' , '"+type+"' , '"+sdf.format(new Date())+"' , "+buy+" , "+change+"  )");
            return ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    return true;
    }
    
   
        
        
    
  
    

    public static void main(String[] args) throws SQLException {
                
       
        
    }

}
