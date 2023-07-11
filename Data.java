import java.util.*;
import java.io.*;

class Data implements Serializable
{
	String name,district,state,gender,admitDate,status;
	int patientId,age,get;
	ArrayList<String> usernames=new ArrayList<>();
	ArrayList<String> passwords=new ArrayList<>();
	Data()
	{
		;
	}
	
	Data(int patientId,String name,int age,String gender,String admitDate,String district,String state,String status)
	{
		this.patientId=patientId;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.district=district;
		this.state=state;
		this.admitDate=admitDate;
		this.status=status;
	}
	
	void addData()
	{
		System.out.println("Enter name:");
		name=Home.sc.nextLine().toLowerCase();
		if(Home.list.size()==0)
		{
			get=1;
		}
		else
		{
			get=(Home.list.get((Home.list.size()-1)).patientId)+1;
		}
		patientId=get;
		System.out.println("Enter age:");
		age=Home.sc.nextInt();
		Home.sc.nextLine();
		System.out.println("Enter gender:");
		gender=Home.sc.nextLine().toLowerCase();
		System.out.println("Enter the date of admission(dd/mm/yyyy:");
		admitDate=Home.sc.nextLine();
		System.out.println("Enter the name of the district:");
		district=Home.sc.nextLine().toLowerCase();
		System.out.println("Enter the name of the state:");
		state=Home.sc.nextLine().toLowerCase();
		status="affected";
		Data d=new Data(patientId,name,age,gender,admitDate,district,state,status);
		Home.list.add(d);
	}
	
	void status()
	{
		int id,count=0;
		char statusChange;
		System.out.println("enter the patientId to change the status:");
		id=Home.sc.nextInt();
		Home.sc.nextLine();
		System.out.println();
		while(true)
		{
			for(Data d:Home.list)
			{
				if(d.patientId==id)
				{
					while(true)
					{
						System.out.println("Enter the status of the patient:");
						System.out.println("press 'r' for recovered:");
						System.out.println("press 'd' for died:");
						statusChange=Home.sc.next().charAt(0);
						if(statusChange=='r'|| statusChange=='R')
						{
							d.status="recovered";
							count=1;
							System.out.println("Status changed");
							break;
						}
						else if(statusChange=='d'|| statusChange=='D')
						{
							d.status="died";
							count=1;
							System.out.println("Status changed");
							break;
						}
						else
						{
							System.out.println("Try again");
						}
					}
				}
			}
			if(count==0)
			{
				System.out.println("Patient not found...");
				int n;
				System.out.println("1.Try again");
				System.out.println("2.go back");
				System.out.println("enter your choice:");
				n=Home.sc.nextInt();
				Home.sc.nextLine();
				if(n==1)
				{
					continue;
				}
				else if(n==2)
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
	}
	
	void access()
	{
		int choice;
		do
		{
			System.out.format("%50s\n","1.ADD DATA");
			System.out.format("%50s\n","2.CHANGE STATUS");
			System.out.format("%50s\n","3.ANALYZE");
			System.out.format("%50s\n","4.LOG OUT");
			System.out.format("%60s\n","===============================");
			choice=Home.sc.nextInt();
			Home.sc.nextLine();
			switch(choice)
			{
				case 1:System.out.format("%50s\n","ADD DATA");
					   System.out.format("%60s\n","===============================");
					   addData();
					   System.out.format("%50s\n","Added Successfully!!!");
					   System.out.format("%60s\n","===============================");
					   break;
				case 2:System.out.format("%50s\n","CHANGE STATUS");
					   System.out.format("%60s\n","===============================");
					   status();
					   break;
				case 3:System.out.format("%50s\n","ANALYZE");
					   System.out.format("%60s\n","===============================");
					   System.out.println();
					   Analyze analyze=new Analyze();
					   analyze.access();
					   break;
				case 4:System.out.format("%50s\n","LOG OUT");
					   System.out.format("%60s\n","===============================");
					   
					   break;	   
			}
		}while(choice!=4);			
	}
	
	void createAccount()
	{
		String userName,password,s;
		try 
		{
			int n;
			usernames.clear();
			passwords.clear();
			FileReader fr=new FileReader("D:/Courses/zoho incubation/Java/Mini_Application/task2/Admin_Credentials.txt");    
			BufferedReader br=new BufferedReader(fr);  
			int flag=0;
			while((s=br.readLine())!=null)
			{
				if(flag==0)
				{
					usernames.add(s);
					flag=1;
				}
				else
				{
					flag=0;
					passwords.add(s);
				}
			}	
			br.close(); 
			fr.close();   
            FileWriter writer = new FileWriter("D:/Courses/zoho incubation/Java/Mini_Application/task2/Admin_Credentials.txt",true);
			while(true)
			{
				System.out.println("enter user name:");
				userName=Home.sc.nextLine();
				if(usernames.contains(userName))
				{
					
					System.out.println("User name already exists....try another user name");
					System.out.println("1.Create Account");
					System.out.println("2.Back");
					System.out.println("enter your choice");
					n=Home.sc.nextInt();
					Home.sc.nextLine();
					if(n==2)
					{
						break;
					}
				}
				else
				{
					System.out.println("enter password:");
					password=Home.sc.nextLine();
					String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,16}$";
					if(password.matches(regex))
					{
						usernames.add(userName);
						passwords.add(password);
						writer.write(userName);
						writer.write("\n");
						writer.write(password);
						writer.write("\n");
						System.out.println("Successfully created the account");
						
						writer.close();
						break;
					}
					else
					{
						System.out.println("Password must contain One Uppercase,One Lowercase,One number ,a special character and must of length 8 to 16...try again!!!");
					}
					System.out.println("Do you want to go back->press 1...to continue->press 2");
					System.out.println("enter your choice");
					n=Home.sc.nextInt();
					Home.sc.nextLine();
					if(n==1)
					{
						break;
					}
				}
			}
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
	}
	
	boolean checkDetails(String userName,String password) throws Exception
	{
		int n;
		FileReader fr=new FileReader("D:/Courses/zoho incubation/Java/Mini_Application/task2/Admin_Credentials.txt");    
        BufferedReader br=new BufferedReader(fr);    
		int flag=0;
		String s;
		usernames.clear();
		passwords.clear();
		while((s=br.readLine())!=null)
		{
			if(flag==0)
			{
				usernames.add(s);
				flag=1;
			}
			else
			{
				flag=0;
				passwords.add(s);
			}
		}	
		br.close(); 
		fr.close();   
		char choice;
		for(int i=0;i<usernames.size();i++)
		{
			if((usernames.get(i).compareTo(userName))==0)
			{
				if((passwords.get(i).compareTo(password))==0)
				{
					System.out.println("Doctor exists");
					return true;
				}
				else
				{
					System.out.println("Password is wrong");
					System.out.println("1.forgot password");
					System.out.println("2.Go Back");
					n=Home.sc.nextInt();
					Home.sc.nextLine();
					if(n==1)
					{
						Random random=new Random();
						int otp = random.nextInt(1000);   
						FileWriter w = new FileWriter("D:/Courses/zoho incubation/Java/Mini_Application/task2/otp.txt");
						PrintWriter p=new PrintWriter(w);
						p.print(otp);
						p.close();
						w.close();
						int check;
						System.out.println("enter otp");
						check=Home.sc.nextInt();
						Home.sc.nextLine();
						if(check==otp)
						{
							while(true)
							{
								String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,16}$";
								System.out.println("enter new password");
								password=Home.sc.nextLine();
								if(password.matches(regex))
								{
									break;
								}
								else
								{
									System.out.println("Password must contain One Uppercase,One Lowercase,One number ,a special character  and must of length 8 to 16...try again!!!");

								}
							}
							
							passwords.set(i,password);
							FileWriter fWriter = new FileWriter("D:/Courses/zoho incubation/Java/Mini_Application/task2/Admin_Credentials.txt");
							
							for(int j=0;j<usernames.size();j++)
							{
								
									s=usernames.get(j);
									fWriter.write(s);
									fWriter.write("\n");
								
								
									s=passwords.get(j);
									fWriter.write(s);
									fWriter.write("\n");
								
							}
							fWriter.close();
							System.out.println("Successfully changed the password");
							
						}
						else
						{
							System.out.println("No longer valid...try again");
						}
					}
				}
				  
				return false;
			}
		}
		System.out.println("Doctor doesn't exists");
		System.out.println("Do you want to register or create a new account");
		System.out.println("If YES press 'y'....If NO press 'n'....");
		choice=Home.sc.next().charAt(0);
		if(choice=='y')
		{
			Home.sc.nextLine();
			createAccount();
		}
		return false;
	}
	public static void main(String args[])
	{
		String userName,password;
		Data data=new Data();
		try
		{
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
				Home.list.add(s1);  
			}
			in.close();
			int choice;
			do
			{
				System.out.format("%50s\n","1.SIGN IN");
				System.out.format("%50s\n","2.SIGN UP");
				System.out.format("%49s\n","3.EXIT");
				System.out.format("%60s\n","===============================");
				System.out.println("enter your choice:");
				
				choice=Home.sc.nextInt();
				Home.sc.nextLine();
				switch(choice)
				{
					case 1:System.out.format("%50s\n","1.SIGN IN");
						System.out.format("%60s\n","===============================");
						System.out.println("enter user name:");
						userName=Home.sc.nextLine();
						System.out.println("enter password");
						password=Home.sc.nextLine();
						boolean answer=data.checkDetails(userName,password);
						
						if(answer==true)
						{
							data.access();
						}
						
						break;
					case 2:System.out.format("%50s\n","SIGN UP");
						System.out.format("%60s\n","===============================");
						data.createAccount();
						break;
					case 3:System.out.format("%50s\n","EXIT");
						System.out.println();
						break;
				}
			}while(choice!=3);
			try
			{
				FileOutputStream file=new FileOutputStream("D:/Courses/zoho incubation/Java/Mini_Application/task2/list.txt");		//Serialization
				ObjectOutputStream out=new ObjectOutputStream(file);
				for (Data d:Home.list)
				{
					out.writeObject(d);
				}
				out.close();
				file.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}