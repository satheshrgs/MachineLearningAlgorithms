/*
 * Created on 08-Oct-2017
 * @author: Sathesh Rgs
*/
package ml_lab;
import java.sql.*;
import java.util.*;
public class NaiveBayes 
{
	public static void main(String[] args)
	{
		String tab,db;
		int cc,i;
		double rc;
		String col[],target,sample[];
		System.out.println("Java Program for Naive Bayes Classification...");
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the database name..");
		db=obj.nextLine();
		System.out.println("Enter the table name..");
		tab=obj.nextLine();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db+"?autoReconnect=true&useSSL=false","root","");
		    Statement st=conn.createStatement();
		    String tot_rows="SELECT COUNT(*) as cnt FROM "+tab;
		    ResultSet rs=st.executeQuery(tot_rows);
		    rs.next();
		    rc=rs.getDouble("cnt");
		    rs.close();
		    String tot_cols="SELECT COUNT(COLUMN_NAME) as cnt FROM INFORMATION_SCHEMA.COLUMNS where table_name='"+tab+"'";
		    ResultSet rs1=st.executeQuery(tot_cols);
		    rs1.next();
		    cc=rs1.getInt("cnt");
		    rs1.close();
		    System.out.println("The Attributes are:");
		    String que="SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+tab+"' and TABLE_SCHEMA='"+db+"' ";
		    ResultSet rs2=st.executeQuery(que);
			col=new String[cc];
			i=0;
		    while(rs2.next())
		    {
		    	col[i++]=rs2.getString(1);
		    	System.out.print(col[i-1]+" ");
		    }
		    System.out.println("\nEnter target attribute...");
		    target=obj.nextLine();
		    sample=new String[cc];
		    System.out.println("Enter the test sample for evaluation...");
		    for(i=0;i<cc;i++)
		    {
		    	if(!(col[i].equals(target)))
		    	{
		    		System.out.print(col[i]+"--->");
		    		sample[i]=obj.nextLine();
		    	}
		    }
		    String scy="SELECT COUNT(*) as cnt from "+tab+" where "+target+"='yes'";
		    ResultSet rs3=st.executeQuery(scy);
		    rs3.next();
		    double cy=rs3.getDouble("cnt");
		    rs3.close();
		    double cn=rc-cy;
		    double temp,py,pn,temp1;
		    py=cy/rc;
		    pn=cn/rc;
		    for(i=0;i<cc;i++)
		    {
		    	if(!(col[i].equals(target)))
		    	{
		    		String q="SELECT COUNT(*) as cnt from "+tab+" where "+col[i]+"='"+sample[i]+"' and "+target+"='yes'";
		    		ResultSet rs4=st.executeQuery(q);
				    rs4.next();
				    temp=rs4.getDouble("cnt");
				    temp1=temp/cy;
				    py*=temp1;
		    	}
		    }
		    System.out.println("The Probability of Yes is.."+py);
		    for(i=0;i<cc;i++)
		    {
		    	if(!(col[i].equals(target)))
		    	{
		    		String q="SELECT COUNT(*) as cnt from "+tab+" where "+col[i]+"='"+sample[i]+"' and "+target+"='no'";
		    		ResultSet rs4=st.executeQuery(q);
				    rs4.next();
				    temp=rs4.getDouble("cnt");
				    temp1=temp/cn;
				    pn*=temp1;
		    	}
		    }
		    System.out.println("The Probability of No is.."+pn);
		    if(py>pn)
		    	sample[cc-1]="yes";
		    else
		    	sample[cc-1]="no";
		    System.out.println("After Evaluation...");
		    for(String s:sample)
		    	System.out.print(s+" ");
		    
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
