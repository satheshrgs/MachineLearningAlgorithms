package ml_lab;

import java.util.*;
import java.sql.*;
public class LinearRegression 
{
	static int in,an,i;
	static float temp=1;
	static float data[][];
	static float mean[]=new float[2];
	static String db;
	static String tab;
	public static void main(String[] args) 
	{
			Scanner obj=new Scanner(System.in);
			System.out.println("Java Program for Linear Regression...");
			System.out.println("Enter the database name..");
			db=obj.nextLine();
			System.out.println("Enter the table name..");
			tab=obj.nextLine();
		    try
		    {
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection conn = null;
			  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","");
			  Statement st=conn.createStatement();
		      String tot_rows="SELECT COUNT(*) as cnt FROM "+tab;
		      ResultSet rs=st.executeQuery(tot_rows);
		      rs.next();
		      in=rs.getInt("cnt");
		      data=new float[2][in];
		      rs.close();
		      String que="SELECT * FROM "+tab;
			  ResultSet rs1=st.executeQuery(que);
			  ResultSetMetaData metadata = rs1.getMetaData();		
			  int columnCount = metadata.getColumnCount();
			  int r=0;
			  while (rs1.next()) 
			  {
			    for (i = 1; i <=columnCount; i++) 
			    {

			    	data[i-1][r]=rs1.getFloat(i);			        
			    }
			    r++;
			    }
			   rs1.close();
			  
		    }
		    catch(Exception ex)
		    {
		      System.out.println("Exception: " + ex.getMessage());
		    }
			Arrays.fill(mean,0);
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<in;j++)
				{
					mean[i]+=data[i][j];
				}
			}
			for(i=0;i<2;i++)
			{
				mean[i]/=in;
			}
			float diff[][]=new float[2][in];
			for(i=0;i<2;i++)
			{
				for(int j=0;j<in;j++)
				{
					diff[i][j]=data[i][j]-mean[i];
				}
			}
			float num=0,denom=0;
			for(int j=0;j<in;j++)
			{
				temp=1;
				for(i=0;i<2;i++)
				{
					temp*=diff[i][j];
				}
				num+=temp;
					
			}
			for(i=0;i<in;i++)
			{
				denom+=diff[0][i]*diff[0][i];
			}
			float b1=num/denom;
			float b0=mean[1]-(b1*mean[0]);
			System.out.println("b0--->"+b0+"\n"+"b1--->"+b1);
			System.out.println("Y--->"+b0+"+"+b1+"x");			
	}
}