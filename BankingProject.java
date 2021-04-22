//Basic banking functions need to be done by this project.
package bankingproject;



//packages to conect the databse to the appliation are being linked
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;

// A class BankingProject contains all the functions of yhe project
public class BankingProject extends JFrame implements ActionListener{
    private static long AccountNumber;  //Account number of the user
    private static String Name;         //Name of the user
    private static String type;         //Account type
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,lb21,lb22;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14;
    JPasswordField pf;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    JRadioButton b1,b2;
    
    //It will the first function that will be called from main() and will show a GUI
    //asking account number and password to get log in 
    //otherwise it will call to createAccountFrame() if user wants to create account and press "SignUp"
    public void logInFrame()       
    {
        
        super.setBounds(500,200,400,300);
        super.setTitle("LogIn");        
        super.setResizable(false);
        
        lb1=new JLabel("Account Number");
        lb1.setBounds(20,20,150,30);
        super.add(lb1);
        tf1=new JTextField();                       //Takes AccountNumber
        tf1.setBounds(200,20,180,30);
        super.add(tf1);
        lb2=new JLabel("Password");                  //Takes Password
        lb2.setBounds(20,70,150,30);
        super.add(lb2);
        pf=new JPasswordField();
        pf.setBounds(200,70,180,30);
        super.add(pf);
        btn1=new JButton("Submit");                 //This Button calls homePage() if details are correct
        btn1.setBounds(150,120,100,30);                 
        super.add(btn1);
        btn1.setBackground(Color.cyan);
        btn1.addActionListener(this);
        lb3=new JLabel("Account not created yet?");
        lb3.setBounds(120,180,150,30);
        super.add(lb3);
        lb3.setBackground(Color.RED);
        btn2=new JButton("Create Account");             //This button calls createAccountFrame();
        btn2.setBounds(115,210,150,30);
        super.add(btn2);
        btn2.setBackground(Color.red);
        btn2.addActionListener(this);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
    
    
    //createAccountFrame() takes the data from user in order to create the account
    //It is also a GUI
    //It verifies age,minimum deposit criteria,email pattern,phone number ,strong password or not
    //after checking the details provide the account number and put the information in database
    public void createAccountFrame()
    {
        super.setBounds(400,100,500,600);
        super.setResizable(false);
        super.setTitle("Create Account");
        lb4=new JLabel("Name");
        lb4.setBounds(20,10,150,30);
        super.add(lb4);
        tf2=new JTextField();
        tf2.setBounds(200,10,200,30);
        super.add(tf2);
        lb5=new JLabel("Email");
        lb5.setBounds(20,60,150,30);
        super.add(lb5);
        tf3=new JTextField();
        tf3.setBounds(200,60,200,30);
        super.add(tf3);
        lb6=new JLabel("Phone Number");
        lb6.setBounds(20,110,150,30);
        super.add(lb6);
        tf4=new JTextField();
        tf4.setBounds(200,110,200,30);
        super.add(tf4);
        lb7=new JLabel("Age");
        lb7.setBounds(20,160,150,30);
        super.add(lb7);
        tf5=new JTextField();
        tf5.setBounds(200,160,200,30);
        super.add(tf5);
        lb8=new JLabel("Account Type");
        lb8.setBounds(20,210,150,30);
        super.add(lb8);
        ButtonGroup g=new ButtonGroup(); 
        b1=new JRadioButton("SA");
        b1.setBounds(200,210,100,30);
        super.add(b1);
        b2=new JRadioButton("CA");
        b2.setBounds(300,210,100,30);
        super.add(b2);
        g.add(b1);
        g.add(b2);
        lb9=new JLabel("Password");
        lb9.setBounds(20,260,150,30);
        super.add(lb9);
        tf6=new JTextField();
        tf6.setBounds(200,260,200,30);
        super.add(tf6);
        lb10=new JLabel("Deposit");
        lb10.setBounds(20,310,150,30);
        super.add(lb10);
        tf7=new JTextField();
        tf7.setBounds(200,310,200,30);
        super.add(tf7);
        btn3=new JButton("Submit");         //The button checks all the details are in correct format like 
                                            //mail, phone number,strong password,age ,deposit
                                            //if correct store data in databse and provide account number 
        
        btn3.setBounds(200,380,100,30);
        btn3.setBackground(Color.CYAN);
        super.add(btn3);
        btn3.addActionListener(this);
        btn4=new JButton("LogIn Here");  //This button takes us to login page again 
        btn4.setBounds(200,450,100,30);
        btn4.setBackground(Color.RED);
        super.add(btn4);
        btn4.addActionListener(this);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //respswd() shows a GUI over the screen in order to reset password
    //It takes old password and new password 
    //After verifying it make changes to the database
    public void respswd()
    {
        super.setBounds(450,200,500,300);
        super.setTitle("Reset Password");
        super.setResizable(false);
        lb20=new JLabel("Old Password");
        lb20.setBounds(20,20,200,30);
        super.add(lb20);
        tf12=new JTextField();
        tf12.setBounds(250,20,200,30);
        super.add(tf12);
        lb21=new JLabel("New Password");
        lb21.setBounds(20,70,200,30);
        super.add(lb21);
        tf13=new JTextField();
        tf13.setBounds(250,70,200,30);
        super.add(tf13);
        lb22=new JLabel("Confirm New Password");
        lb22.setBounds(20,120,200,30);
        super.add(lb22);
        tf14=new JTextField();
        tf14.setBounds(250,120,200,30);
        super.add(tf14);
        btn12=new JButton("Reset");     //This button make changes if old password is correct 
                                        //and new one is strong password too.
        btn12.setBounds(150,200,200,30);
        super.add(btn12);
        btn12.setBackground(Color.RED);
        btn12.addActionListener(this);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //This function requires benificiary account number and name
    // If it exists in databse user who is logged in can transfer the funds if has enough balance 
    //Accordingly changes in database will happen.
    public void transfer()
    {
        super.setBounds(450,200,500,500);
        super.setTitle("Transfer fund");
        super.setResizable(false);
        lb16=new JLabel("Beneficary Account Number");
        lb16.setBounds(20,20,220,30);
        super.add(lb16);
        tf8=new JTextField();
        tf8.setBounds(250,20,200,30);
        super.add(tf8);
        lb17=new JLabel("Confirm Beneficary Account Number");
        lb17.setBounds(20,70,220,30);
        super.add(lb17);
        tf9=new JTextField();
        tf9.setBounds(250,70,200,30);
        super.add(tf9);
        lb18=new JLabel("Benificary Name");
        lb18.setBounds(20,120,220,30);
        super.add(lb18);
        tf10=new JTextField();
        tf10.setBounds(250,120,200,30);
        super.add(tf10);
        lb19=new JLabel("Amount");
        lb19.setBounds(20,170,220,30);
        super.add(lb19);
        tf11=new JTextField();
        tf11.setBounds(250,170,200,30);
        super.add(tf11);
        btn10=new JButton("Transfer");  //this button is responsible for the transfer funds
        btn10.setBounds(150,250,200,30);
        super.add(btn10);
        btn10.setBackground(Color.RED);
        btn10.addActionListener(this);
        btn11=new JButton("Cancel");
        btn11.setBounds(150,300,200,30);
        super.add(btn11);
        btn11.setBackground(Color.RED);
        btn11.addActionListener(this);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //After successful logIn homepage() gui will be seen
    //showing account number and name of user
    //here user can transfer ,check balance and reset password 
    public void homePage(String nam,long ac,String x)
    {
        Name=nam;
        AccountNumber=ac;
        type=x;
        super.setBounds(450,200,500,500);
        super.setTitle("Home Page");
        super.setResizable(false);
        lb11=new JLabel("Name            : "+nam.toUpperCase());
        lb11.setBounds(20,30,400,30);
        super.add(lb11);
        lb12=new JLabel("Account Number  : "+ac);
        lb12.setBounds(20,50,400,30);
        super.add(lb12);
        lb13=new JLabel("Account Type    : "+x);
        lb13.setBounds(20,70,400,30);
        super.add(lb13);
        btn5=new JButton("Check Balance");
        btn5.setBounds(100,120,200,30);
        super.add(btn5);
        btn5.setBackground(Color.CYAN);
        btn5.addActionListener(this);
        btn6=new JButton("Transfer");
        btn6.setBounds(100,170,200,30);
        super.add(btn6);
        btn6.setBackground(Color.CYAN);
        btn6.addActionListener(this);
        btn7=new JButton("Reset Password");
        btn7.setBounds(100,220,200,30);
        super.add(btn7);
        btn7.setBackground(Color.CYAN);
        btn7.addActionListener(this);
     
        btn9=new JButton("Log Out");
        btn9.setBounds(100,320,200,30);
        super.add(btn9);
        btn9.setBackground(Color.RED);
        btn9.addActionListener(this);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //It checks whether password is strong
    static boolean checkPassword(String pswd)
    {
        boolean sc=false,cl=false,sl=false,d=false;
        //sc checks for atleast one special character @,#,%,?
        //cl checks atleast one uppercase
        //sl checks for atleast one lowercase letter
        //d checks if it contains digit
        if(pswd.length()>=8 && pswd.length()<=20)       //Password length should be in between 8 and 20
        {
            for(int i=0;i<pswd.length();i++)
            {
                if(pswd.charAt(i)=='@'||pswd.charAt(i)=='#'||pswd.charAt(i)=='%'||pswd.charAt(i)=='?')
                {
                    sc=true;
                }
                if(Character.isDigit(pswd.charAt(i)))
                {
                    d=true; 
                }
                if(Character.isLowerCase(pswd.charAt(i)))
                {
                    sl=true;
                }
                if(Character.isUpperCase(pswd.charAt(i)))
                {
                    cl=true;
                }
            }
        }
        if(sc && sl && d && cl)
        {
            return true;
        }
        return false;
    }
    
    //checkPhone checks if there are exactly 10 digits in phone number
    static boolean checkPhone(String phno)
    {
        if(phno.length()==10)
        {
            for(int i=0;i<phno.length();i++)
            {
                if(!Character.isDigit(phno.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
    static boolean checkMail(String email)
    {
        if(email.length()>10)
        {   
        int cat=0;
        if(!Character.isLetter(email.charAt(0)))
        {
            return false;
        }
        if(!email.endsWith(".com"))
        {
            return false;
        }
        for(int i=1;i<email.length()-4;i++)
        {
            if((!Character.isAlphabetic(email.charAt(i))) && !Character.isDigit(email.charAt(i)) && email.charAt(i)!='@')
            {
                return false;
            }
            if(email.charAt(i)=='@')   cat++;
            
        }
       if(cat!=1)
        {
            return false;
        }   
        return true;
        }
        return false;

    }

    
    public static void main(String[] args) {
       
        BankingProject b=new BankingProject();
        
        b.logInFrame();             //first logIn GUI will be shown to user
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1)
        {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin");
                Statement st=co.createStatement();
                String ac=tf1.getText();
                char[] psd=pf.getPassword();
                String pwd=new String(psd,0,psd.length);
                ResultSet rs=st.executeQuery("select * from details");
                boolean x=false;
                while(rs.next())
                {
                    if(rs.getInt("AccountNumber")==Integer.parseInt(ac) && rs.getString("Password").equals(pwd))
                    {
                        x=true;
                        
                        BankingProject p=new BankingProject();
                        p.homePage(rs.getString("Name"),rs.getInt("AccountNumber"),rs.getString("Type"));
                        
                    }
              
                        
                }
                if(x==false)
                    {
                        JOptionPane.showMessageDialog(this, "Wrong details entered");
                    }
            }
            catch(Exception ex)
            {
                return ;
            }
        }
        else if(e.getSource()==btn2)
        {
            System.out.println("from 2");
            BankingProject b=new BankingProject();
            b.createAccountFrame();
        }
        else if(e.getSource()==btn3)
        {
            try {
                String nam=tf2.getText();
                String mail=tf3.getText();
                String phno=tf4.getText();
                String age=tf5.getText();
                String typ="SA";
                if(b1.isSelected())
                {
                    typ="SA";
                }
                if(b2.isSelected())
                {
                    typ="CA";
                }
                String Password=tf6.getText();
                
                String Bal=tf7.getText();
               Class.forName("com.mysql.jdbc.Driver");
                Connection co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin");
               Statement st=co.createStatement();
               ResultSet rs=st.executeQuery("select * from details ");
               while(rs.next())
               {
                   
                   AccountNumber=Integer.parseInt(rs.getString("AccountNumber"));
               }
               String msg="";
               boolean a=true,b=true,c=true,d=true,f=true,g=true;
               if(Integer.parseInt(Bal)<1000)
               {
                   g=false;
                   msg=msg+"Minimum deposit should be 1000\n";
               }
               if(nam.isEmpty())
               {
                  msg=msg+"Name is required \n";
                  a=false;
               }
               if(!checkMail(mail))
               {
                   msg=msg+"Mail is not valid \n";
                   b=false;
               }
               if(!checkPhone(phno))
               {
                   msg=msg+"Phone number is not correct\n";
                   c=false;
               }
               if(!checkPassword(Password))
               {
                   msg=msg+"Password is not strong enough\n";
                   d=false;
               }
               //JOptionPane.showMessageDialog(this,msg);
               if(Integer.parseInt(age)<18)
               {
                   JOptionPane.showMessageDialog(this,"You are underage\n");
                   f=false;
               }
               if(a && b && c && d && f && g)
               {
                   Statement st1=co.createStatement();
                   AccountNumber++;
                   st.executeUpdate("insert into details values('"+nam+"','"+mail+"','"+phno+"','"+Integer.parseInt(age)+"','"+typ+"','"+Password+"','"+Integer.parseInt(Bal)+"','"+AccountNumber+"')");
                   JOptionPane.showMessageDialog(this, "Account created successfully \n AccountNumber: "+(AccountNumber) );
                   
               }
               else
               {
    
                   JOptionPane.showMessageDialog(this,msg);
               }
               
   
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BankingProject.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BankingProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getSource()==btn4)
        {
            BankingProject p=new BankingProject();
            p.logInFrame();
        }
        
        else if(e.getSource()==btn5)
        {
            try{
            Class.forName("com.mysql.jdbc.Driver");
              Connection co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin");
               Statement st=co.createStatement();
               ResultSet rs=st.executeQuery("select * from details ");
               while(rs.next())
               {
                   if(AccountNumber==rs.getInt("AccountNumber"))
                   {
                       JOptionPane.showMessageDialog(this," Your Account Balance : " +rs.getInt("Balance"));
                   }
               }
            }
            catch(Exception em)
            {
                return ;
            }
            
                    
            
        }
        else if(e.getSource()==btn6)
        { 
            BankingProject s=new BankingProject();
            
            s.transfer();
            
          }
        else if(e.getSource()==btn11)
        {
            BankingProject s=new BankingProject();
            s.homePage(Name, AccountNumber, type);
        }
        else if(e.getSource()==btn9)
        {
            BankingProject s=new BankingProject();
            s.logInFrame();
            
        }
        else if(e.getSource()==btn10)
        {
            String ban=tf8.getText();
            String cban=tf9.getText();
            String nm=tf10.getText().toLowerCase();
            String mon=tf11.getText();
            if(ban.equals(cban) )
            {
                try{
                Class.forName("com.mysql.jdbc.Driver");
               Connection co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin");
               Statement st=co.createStatement();
               ResultSet rst=st.executeQuery("select * from details ");
               boolean z=false;
               int m=0;
               while(rst.next())
               {
                   if(rst.getInt("AccountNumber")==AccountNumber && Integer.parseInt(mon)<=rst.getInt("Balance"))
                   {
                       m=rst.getInt("Balance")-Integer.parseInt(mon);
                       
                       z=true;
                       break;
                     
                   }
               }
               if(z)
               {
               
               ResultSet rs=st.executeQuery("select * from details ");
               boolean h=false;
               while(rs.next())
               {
                   String q=rs.getString("Name").toLowerCase();
                   if(rs.getInt("AccountNumber")==Integer.parseInt(ban) && q.equals(nm))
                   {
                       int k=Integer.parseInt(mon)+rs.getInt("Balance");
                      // System.out.println("Hello");
                      // System.out.println(k);
                      // System.out.println(rs.getInt("AccountNumber"));
                       int t=rs.getInt("AccountNumber");
                       st.executeUpdate("update details set Balance='"+m+"' where AccountNumber='"+AccountNumber+"'");
                       st.executeUpdate("update details set Balance='"+k+"' where AccountNumber='"+t+"'");
                       JOptionPane.showMessageDialog(this,"Transaction Successful");
                       h=true;
                   }
               }
               if(h==false)
               {
                   JOptionPane.showMessageDialog(this, "Wrong Details entered");
               }
                }
               else
               {
                   JOptionPane.showMessageDialog(this,"Not enough Balance");
               }
                }
                catch(Exception exc)
                {
                    return;
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Account numbers do not match");
            }
                
        }
        else if(e.getSource()==btn7)
        {
            BankingProject p=new BankingProject();
            p.respswd();
        }
        else if(e.getSource()==btn12)
        {
            String op=tf12.getText();
            String np=tf13.getText();
            String cnp=tf14.getText();
            try{
                Class.forName("com.mysql.jdbc.Driver");
               Connection co=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin");
               Statement st=co.createStatement();
               ResultSet rst=st.executeQuery("select * from details ");
               boolean z=false;
               
               while(rst.next())
               {
                   if(rst.getString("Password").equals(op))
                   {
                       z=true;
                       break;
                   }
               }
               if(z && np.equals(cnp) && checkPassword(np))
               {
                   st.executeUpdate("update details set Password='"+np+"' where AccountNumber='"+AccountNumber+"'");
                   JOptionPane.showMessageDialog(this, "Password updated Successfully");
                   BankingProject p=new BankingProject();
                   p.homePage(Name, AccountNumber, type);
               }
               else
               {
                   JOptionPane.showMessageDialog(this,"Either Wrong details entered or password is not strong enough");
               }
                
            }
            catch(Exception ep)
            {
                return ;
            }
        }
    }
    
}



