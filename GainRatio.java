package ml_lab;
import java.util.*;
import java.sql.*;
public class GainRatio
{
	static String db;
	static String tab;
	static int count=0;
	static String col[];
	static double gain[],tcr,gro;
	static double val,temp,si;
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
	public void gr(Statement st)
	{
		int i=0;
		System.out.println("Gain Ratio");
		  for(String a : col)
		  {
			  try
			  {
				  String q1="SELECT "+a+",COUNT(*) as cnt from "+tab+" group by "+a;
				  ResultSet rs1=st.executeQuery(q1);
				  si=0.0;
				  while(rs1.next())
				  {					
					  val=Double.parseDouble(rs1.getString(2));
					  temp=-((val/tcr)*(Math.log(val/tcr)/Math.log(2)));
					  si+=temp;
				  }
				  System.out.println(a+":");
				  System.out.println("Information Gain:"+gain[i]);
				  System.out.println("Split Information:"+si);
				  gro=gain[i++]/si;
				  System.out.println("Gain Ratio:"+gro+"\n");
			  }
			  catch(Exception e)
			  {}
		  }
	}
	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);
		int i=0,j=0;
		String target=new String();
		double E;String root=null;
		GainRatio in=new GainRatio();
		double tmp;String temp;
		System.out.println("Java Program for Gain Ratio...");
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
		    ResultSet r1=st.executeQuery(tot_rows);
		    r1.next();
		    tcr=r1.getDouble("cnt");  
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
	        col=new String[count-1];
	        gain=new double[count-1];
	        E=in.Entropy(S[0],S[1]);
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
				tmp=in.gain(E,temp,st,target);
				gain[j]=tmp;
				j++;
	        }	
	        in.gr(st);
		}
	    catch(Exception e)
		{
	    	System.out.println(e);
		}
		
	}
}
