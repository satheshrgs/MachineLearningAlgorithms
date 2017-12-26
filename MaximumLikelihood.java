/*
 * Created on 10-Oct-2017
 * @author: Sathesh Rgs
*/
package ml_lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class MaximumLikelihood
{
	
	public static void main(String[] args)
	{
		String tab,db,col[],target,c[];
		int i,cc,clc,rc;
		double mean,sdin[],count,di[];
		//double sdin[],mean,sd,count=0;
		System.out.println("Java Program for Maximum Likelihood...");
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
		    String tot_cols="SELECT COUNT(COLUMN_NAME) as cnt FROM INFORMATION_SCHEMA.COLUMNS where table_name='"+tab+"'";
		    ResultSet rs1=st.executeQuery(tot_cols);
		    rs1.next();
		    cc=rs1.getInt("cnt"); 
		    di=new double[cc];
		    rs1.close();
		    String tot_rows="SELECT COUNT(*) as cnt FROM "+tab;
		    ResultSet rs=st.executeQuery(tot_rows);
		    rs.next();
		    rc=rs.getInt("cnt");
		    sdin=new double[rc];
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
		    que="Select count(DISTINCT "+target+") from "+tab+"";
		    ResultSet rs3=st.executeQuery(que);
		    rs3.next();
	        clc=rs3.getInt(1);
	        System.out.println("Enter the test sample for evaluation...");
		    for(i=0;i<cc;i++)
		    {
		    	if(!(col[i].equals(target)))
		    	{
		    		System.out.print(col[i]+"--->");
		    		di[i]=obj.nextDouble();
		    	}
		    }
		    que="Select DISTINCT "+target+" from "+tab+"";
		    ResultSet rs4=st.executeQuery(que);
		    i=0;
		    c=new String[clc];
	        while(rs4.next())
	        {
	        	c[i++]=rs4.getString(1);
	        }
	        int k=0,l;
	        double temp=0.0,sd,a,p[]=new double[c.length],temp1,temp2;
	        for(i=0;i<c.length;i++)
	        {
	        	p[i]=1.0;
	        	for(int j=0;j<col.length;j++)
	        	{
	        		if(!(col[j].equals(target)))
	        		{
	        			
	        			que="SELECT AVG("+col[j]+") FROM `"+tab+"` WHERE class='"+c[i]+"'";
	        			ResultSet rs5=st.executeQuery(que);
	        			rs5.next();
	        			mean=rs5.getDouble(1);
	        			que="SELECT "+col[j]+" FROM `"+tab+"` WHERE class='"+c[i]+"'";
	        			ResultSet rs6=st.executeQuery(que);
	        			k=0;
	        			temp=0.0;
	        			while(rs6.next())
	        			{
	        				sdin[k++]=rs6.getDouble(1);
	        			
	        			}
	        			for(l=0;l<k;l++)
	        			{
	        				a=sdin[l];
	        	            temp += (a-mean)*(a-mean);
	        			}
	        			sd=Math.sqrt(temp/(k-1));
	        	        temp1=Math.pow((di[j]-mean),2);
	        	    	temp2=2*Math.pow(sd,2);
	        	    	temp1/=temp2;
	        	    	temp1=-temp1;
	        	    	temp1=Math.exp(temp1);
	        	    	temp2=Math.sqrt(2*Math.PI*Math.pow(sd,2));
	        	    	sd=temp1/temp2;
	        	    	p[i]*=sd;
	        		}
	        	}
	        }
	        double max1=p[0];
	        int m=0;
	        for(i=1;i<p.length;i++)
	        {
	        	if(p[i]>max1)
	        	{
	        		m=i;
	        		max1=p[i];
	        	}
	        }
	        System.out.println("After Evaluation");
	        for(i=0;i<col.length;i++)
	        	if(col[i].equals(target))
	        		System.out.print(c[m]);
	        	else
	        		System.out.print(di[i]+" ");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
