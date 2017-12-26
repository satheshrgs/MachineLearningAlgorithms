package ml_lab;
import java.util.*;
import java.sql.*;
public class InfoGain
{
	static String db;
	static String tab;
	public double Entropy(double Sn,double Sp)
	{	
		if(Sn==Sp)
			return 1;
		else if(Sn==0 || Sp==0)
			return 0;
		else
		{
			double a=Sn/(Sn+Sp),b=Sp/(Sn+Sp);double entropy;	
			entropy=(((-a)*(Math.log(a)/Math.log(2)))+((-b)*(Math.log(b)/Math.log(2))));
			return entropy;
		}
	}
	public double gain(double E,String att,Statement st,String target) throws SQLException
	{
		int i=0;double sum=0;double S[]=null;
		double g=1;double tmp;
		String que="Select COUNT(DISTINCT "+att+" )from "+tab+"";
		ResultSet rs=st.executeQuery(que);
        if(rs.next())
        	S=new double[rs.getInt(1)];
        que="Select "+att+" ,COUNT(*) from "+tab+" GROUP BY "+att;
        rs=st.executeQuery(que);
        while(rs.next())
        {
         	S[i]=rs.getDouble(2);
          	i++;
        }     
        que="Select "+att+" ,COUNT(*) from "+tab+" where "+target+"='yes' GROUP BY "+att;
        rs=st.executeQuery(que); i=0;
        while(rs.next())
        {
        	tmp=rs.getDouble(2);
            sum=sum+(((double)S[i]/14 )*Entropy(rs.getDouble(2),S[i]-tmp));
            i++;
        }
        g=E-sum;
	    return g;	
	}
	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);
		int count=0,i=0,j=0;
		String target=new String();
		double E;String root=null;
		InfoGain in=new InfoGain();
		double tmp;String temp;
		double max=0;
		System.out.println("Java Program for Information Gain...");
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
		    System.out.println("The Attributes are:");
		    String que="SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+tab+"' and TABLE_SCHEMA='"+db+"' ";
		    ResultSet rs=st.executeQuery(que);
		    while(rs.next())
		    {
		    	System.out.print(rs.getString(1)+" ");
		    	count++;
		    }
		    System.out.print("\n");
		    rs.close();
		    System.out.println("Enter the target attribute");
		    target=obj.nextLine();
	        que="SELECT "+target+" , COUNT(*) FROM "+tab+" GROUP BY "+target;
	        rs=st.executeQuery(que);
	        float S[]=new float[2];
	        while(rs.next())
	        {
	        	S[i]=Float.parseFloat(rs.getString(2));
	        	i++;
	        }
	        rs.close();
	        E=in.Entropy(S[0],S[1]);
			System.out.println("Entropy :"+E);
			String col[]=new String[count-1];
			que="SELECT column_name FROM information_schema.columns WHERE table_name='"+tab+"'";
			ResultSet rst=st.executeQuery(que);
	        i=0;
	        boolean t;
	        while(i<count-1)
	        {
	        	rst.next();
	        	if(rst.getString(1)!=target)
	        		col[i]=rst.getString(1);
	        	else
	        		continue;
	        	i++;
	        }
	        rst.close();
	        while(j<i)
	        {
				temp=col[j];
				System.out.println("Attribute :"+temp);
				tmp=in.gain(E,temp,st,target);
				System.out.println("Information Gain:"+tmp+"\n");
				if(max<tmp)
				{
					max=tmp;
					root=temp;
				}
				j++;
	        }	
		
	        System.out.println("Root:"+root);
		}
	    catch(Exception e)
		{
	    	System.out.println(e);
		}
		
	}
}
