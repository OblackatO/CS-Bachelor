package exercise3;

import java.util.*;

public class AccessControlList {
	
	private Map<Subject, Permissions> perms;
	
	public AccessControlList() {
		this.perms = new HashMap <Subject, Permissions>();
	}
	
	public boolean hasReadPermission(Subject subject) {
		if(this.perms.containsKey(subject) && this.perms.get(subject).canRead()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean hasFullAccess(Subject subject) {
		if(this.perms.containsKey(subject) && this.perms.get(subject).FullPerm()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void Add_User(Subject subject, Permissions perms) {
		this.perms.put(subject, perms);
	}
	
	public Permissions Get_permissions(Subject subject) {
		return this.perms.get(subject);
	}
	
	@SuppressWarnings("serial")
	public void grantPermissions(Subject subject, Permissions permissions) throws CannotChangePermissionsException {
		
		if(Get_permissions(subject).equals(permissions)) {
			throw new CannotChangePermissionsException("Cannot change permissions");
		}else {
			this.perms.put(subject, permissions);
			System.out.println("New permissions have been set.");
		}
	}
	
	@SuppressWarnings("serial")
	public Permissions getPermissions(Subject subject) throws HasNoPermissionsException{
		
		//System.out.println("im here lalal");
		if(!(Get_permissions(subject).FullPerm() || Get_permissions(subject).canRead())) {
			throw new HasNoPermissionsException("User has no permissions.");
		}else {
			return this.perms.get(subject);
		}
	}
	
	
	
	

}
