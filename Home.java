/*Covid-19 management and analyser application using Java*/
import java.util.*;
import java.io.*;

class Analyze
{
	float maleDied=0,femaleDied=0,maleAffected=0,femaleAffected=0,maleRecovered=0,femaleRecovered=0;
	void stateAnalyze()
	{
		String state;
		System.out.println("enter the state name you like to analyze");
		state=Home.sc.nextLine().toLowerCase();
		System.out.printf("%10s%20s%8s%12s%15s%15s%15s%15s\n","Patient Id","Name","Age","Gender","Admission Date","District","State","Status"); 
		System.out.format("--------------------------------------------------------------------------------------------------------------------\n");  
		int total=0,male=0,female=0,died=0,affected=0,recovered=0;
		for(Data d:Home.list)
		{
			if(d.state.equals(state))
			{
				total++;
				System.out.printf("%10d%20s%8d%12s%15s%15s%15s%15s\n",d.patientId,d.name,d.age,d.gender,d.admitDate,d.district,d.state,d.status); 
				if(d.gender.equals("male"))
				{
					male++;
					if(d.status.equals("died"))
					{
						died++;
						maleDied++;
					}
					else if(d.status.equals("affected"))
					{
						affected++;
						maleAffected++;
					}
					else if(d.status.equals("recovered"))
					{
						recovered++;
						maleRecovered++;
					}
					
				}
				else if(d.gender.equals("female"))
				{
					female++;
					if(d.status.equals("died"))
					{
						died++;
						femaleDied++;
					}
					else if(d.status.equals("affected"))
					{
						affected++;
						femaleAffected++;
					}
					else if(d.status.equals("recovered"))
					{
						recovered++;
						femaleRecovered++;
					}
				}
				else
				{
					;
				}
				
			}
		}
		if(total==0)
		{
			System.out.println();
			System.out.println("No data found for this state "+state);
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("Total cases:"+total+"  Male:"+male+"  Female:"+female+"  Affected:"+affected+"  Recovered:"+recovered+"  Died:"+died);
			System.out.println();
			System.out.printf("Male Affected(%%)  :%.2f   Male Recovered(%%)  :%.2f   Male Died(%%)  :%.2f  \n",((maleAffected/male)*100),((maleRecovered/male)*100),((maleDied/male)*100));
			System.out.println();
			System.out.printf("Female Affected(%%):%.2f   Female Recovered(%%):%.2f   Female Died(%%):%.2f  \n",((femaleAffected/female)*100),((femaleRecovered/female)*100),((femaleDied/female)*100));
			System.out.println();
			maleDied=0;
			femaleDied=0;
			maleAffected=0;
			femaleAffected=0;
			maleRecovered=0;
			femaleRecovered=0;
		}
	}
	void districtAnalyze()
	{
		String district;
		
		System.out.println("enter the district name you like to analyse");
		district=Home.sc.nextLine().toLowerCase();
		System.out.printf("%10s%20s%8s%12s%15s%15s%15s%15s\n","Patient Id","Name","Age","Gender","Admission Date","District","State","Status"); 
		System.out.format("--------------------------------------------------------------------------------------------------------------------\n");  
		int male=0,female=0,died=0,affected=0,recovered=0;
		int count1=0,count2=0;
		for(Data d:Home.list)
		{
			
				count1++;
				if(d.district.equals(district))
				{
					count2++;
					System.out.printf("%10d%20s%8d%12s%15s%15s%15s%15s\n",d.patientId,d.name,d.age,d.gender,d.admitDate,d.district,d.state,d.status); 
					if(d.gender.equals("male"))
					{
						male++;
						if(d.status.equals("died"))
						{
							died++;
							maleDied++;
						}
						else if(d.status.equals("affected"))
						{
							affected++;
							maleAffected++;
						}
						else if(d.status.equals("recovered"))
						{
							recovered++;
							maleRecovered++;
						}
					}
					else if(d.gender.equals("female"))
					{
						female++;
						if(d.status.equals("died"))
						{
							died++;
							femaleDied++;
						}
						else if(d.status.equals("affected"))
						{
							affected++;
							femaleAffected++;
						}
						else if(d.status.equals("recovered"))
						{
							recovered++;
							femaleRecovered++;
						}
					}
				}
		}
		
		if(count2==0)
		{
			System.out.println();
			System.out.println("No data found for the district "+district);
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("State count:"+count1+"  District count:"+count2+"  Male:"+male+"  Female:"+female+"  Affected:"+affected+"  Recovered:"+recovered+"  Died:"+died);
			System.out.println();
			System.out.printf("Male Affected(%%)  :%.2f   Male Recovered(%%)  :%.2f   Male Died(%%)  :%.2f  \n",((maleAffected/male)*100),((maleRecovered/male)*100),((maleDied/male)*100));
			System.out.println();
			System.out.printf("Female Affected(%%):%.2f   Female Recovered(%%):%.2f   Female Died(%%):%.2f  \n",((femaleAffected/female)*100),((femaleRecovered/female)*100),((femaleDied/female)*100));
			System.out.println();
			maleDied=0;
			femaleDied=0;
			maleAffected=0;
			femaleAffected=0;
			maleRecovered=0;
			femaleRecovered=0;			
		}
		
	}
	void displayAll()
	{
		System.out.printf("%10s%20s%8s%12s%15s%15s%15s%15s\n","Patient Id","Name","Age","Gender","Admission Date","District","State","Status"); 
		System.out.format("--------------------------------------------------------------------------------------------------------------------\n");  
		int total=0,male=0,female=0,died=0,affected=0,recovered=0;
		
		for(Data d:Home.list)
		{
			total++;
			System.out.printf("%10d%20s%8d%12s%15s%15s%15s%15s\n",d.patientId,d.name,d.age,d.gender,d.admitDate,d.district,d.state,d.status); 
			if(d.gender.equals("male"))
			{
				male++;
				if(d.status.equals("died"))
				{
					died++;
					maleDied++;
				}
				else if(d.status.equals("affected"))
				{
					affected++;
					maleAffected++;
				}
				else if(d.status.equals("recovered"))
				{
					recovered++;
					maleRecovered++;
				}	
			}
			else if(d.gender.equals("female"))
			{
				female++;
				if(d.status.equals("died"))
				{
					died++;
					femaleDied++;
				}
				else if(d.status.equals("affected"))
				{
					affected++;
					femaleAffected++;
				}
				else if(d.status.equals("recovered"))
				{
					recovered++;
					femaleRecovered++;
				}
			}
		}
		System.out.println();
		System.out.println("Total cases:"+total+"  Male:"+male+"  Female:"+female+"  Affected:"+affected+"  Recovered:"+recovered+"  Died:"+died);
		System.out.println();
		System.out.printf("Male Affected(%%)  :%.2f   Male Recovered(%%)  :%.2f   Male Died(%%)  :%.2f  \n",((maleAffected/male)*100),((maleRecovered/male)*100),((maleDied/male)*100));
		System.out.println();
		System.out.printf("Female Affected(%%):%.2f   Female Recovered(%%):%.2f   Female Died(%%):%.2f  \n",((femaleAffected/female)*100),((femaleRecovered/female)*100),((femaleDied/female)*100));
		System.out.println();
		maleDied=0;
		femaleDied=0;
		maleAffected=0;
		femaleAffected=0;
		maleRecovered=0;
		femaleRecovered=0;	
	}
	
	void access()
	{
		int choice;
		do
		{
			System.out.format("%50s\n","1.ANALYZE BY STATE");
			System.out.format("%50s\n","2.ANALYZE BY DISTRICT");
			System.out.format("%50s\n","3.DISPLAY ALL CASES");
			System.out.format("%50s\n","4.GO BACK");
			System.out.format("%60s\n","===============================");
			System.out.println("enter your choice");
			choice=Home.sc.nextInt();
			Home.sc.nextLine();
			switch(choice)
			{
				case 1:System.out.format("%50s\n","ANALYZE BY STATE");
					   System.out.format("%60s\n","===============================");
					   stateAnalyze();
					   break;
				case 2:System.out.format("%50s\n","ANALYZE BY DISTRICT");
					   System.out.format("%60s\n","===============================");
					   districtAnalyze();
					   break;
				case 3:System.out.format("%50s\n","DISPLAY ALL CASES");
					   System.out.format("%60s\n","===============================");
					   displayAll();
					   break;	   
				case 4:System.out.format("%50s\n","GOING BACK");
					   System.out.format("%60s\n","===============================");
					   System.out.println();
					   break;
			}
		}while(choice!=4);			
	}
	
}
public class Home
{
	static List<Data> list=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);;
	public static void main(String args[])
	{
		Data data;
		Analyze analyze;
		
		try{
		FileInputStream in=new FileInputStream("D:/Courses/zoho incubation/Java/Mini_Application/task2/list.txt");				//deserialize
		ObjectInputStream ois=null;  
		try
		{
			ois=new ObjectInputStream(in);  
		}
		catch(EOFException e)
		{
			;
		}
		
		Data s1;
		while(in.available()!=0)
		{
			s1=(Data)ois.readObject();
			list.add(s1);  
		}

		in.close();
		int choice;
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.format("%55s\n","COVID 19 APPLICATION");
			System.out.format("%60s\n","===============================");
			System.out.format("%50s\n","1.ANALYZE");
			System.out.format("%50s\n","2.EXIT");
			System.out.format("%60s\n","===============================");
			System.out.println("enter your choice");
			choice=sc.nextInt();											//getting user's choice
			sc.nextLine();
			switch(choice)
			{

				case 1:System.out.format("%50s\n","ANALYZE");
					   System.out.format("%60s\n","===============================");
					   analyze=new Analyze();
					   analyze.access();
					   break;
					  
				case 2:System.out.format("%50s\n","EXIT");
					   System.out.println();
					   break;
			}
			
		}while(choice!=2);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}