package exercise3;

public class Launcher {

	public static void main(String[] args)  { // throws CannotChangePermissionsException, HasNoPermissionsException{
		
		/*
		 * If I use throws CannotChangePermissionsException, HasNoPermissionsException the program
		 * will run in the exact same way... Does that mean if we have try/catch statements 
		 * we do not need the throws keyword at the declaration of the method ? 
		 */
		
		//Creates a couple of users
		Subject subject_object = new Subject("Pedro");
		Subject subject_object2 = new Subject("Esteves");
		Subject subject_object3 =  new Subject("Ricardo");
		
		//Creates an Access Control List for a certain random file X
		AccessControlList control_list = new AccessControlList();
		
		//Create permissions object
		Permissions permissions_object = new Permissions();
		permissions_object.setFullPerm(true);
		
		Permissions permissions_object2 = new Permissions();
		permissions_object2.setRead(true);
		
		//Adds three users to the access control list without permissions
		control_list.Add_User(subject_object, permissions_object);
		control_list.Add_User(subject_object2, permissions_object2);
		control_list.Add_User(subject_object3, permissions_object2);
		
		//gives full permissions to Pedro again, so I get exception
		try {
			control_list.grantPermissions(subject_object, permissions_object);
		}catch(CannotChangePermissionsException e) {
			System.out.println("Those permissions are already set.");
			System.out.println("Exception details:");
			System.out.println(e);
		}
		//Now changes all permissions of Esteves subject_object2 to false
		permissions_object = new Permissions();
		permissions_object.setFullPerm(false);
		try {
			control_list.grantPermissions(subject_object2, permissions_object);
		}catch(CannotChangePermissionsException e) {
			System.out.println("Those permissions are already set.");
			System.out.println("Exception details:");
			System.out.println(e);
		}
		
		//Esteves tries to access the file and this happens : 
		try {
			control_list.getPermissions(subject_object2);
		}catch(HasNoPermissionsException e) {
			System.out.println("User:"+subject_object2.getName()+" has no permissions on the file.");
			System.out.println("Exception details:");
			System.out.println(e);
		}
		
		
		
		
	}

}
