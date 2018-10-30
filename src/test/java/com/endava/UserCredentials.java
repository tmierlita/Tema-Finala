package com.endava;

public class UserCredentials {

    private String ownerAdminUsername="OWNER_ADMIN";
    private String ownerAdminPassword="test1234";
    private String vetAdminUsername="VET_ADMIN";
    private String vetAdminPassword="test1234";

    public String [] GetCredentials (String role){
        if (role.equals("OWNER_ADMIN")){
            return new String[]{ownerAdminUsername,ownerAdminPassword};
        }
        else if(role.equals("VET_ADMIN")){
            return new String[]{vetAdminUsername,vetAdminPassword};
        }
        else return null;
    }
}
