public class human{
	String firstname,lastname,address;
	int age;

	public human(String firstname,String lastname, String address,int age){
		 this.firstname = firstname;
		 this.lastname = lastname;
		 this.address = address;
		 this.age = age;
		}

	public void show_profile(){
		System.out.println("Profile information")
		System.out.println("Firstname : "+firstname);
		System.out.println("Lastname : "+ lastname);
		System.out.println("Address : "+ address);
		System.out.println("Age : " + age);

	}
	public static void main(String args[]){
		human justin = new human("Justin","De la vega","Sambag",20);
		justin.show_profile();
}
}