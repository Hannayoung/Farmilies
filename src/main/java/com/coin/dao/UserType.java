package com.coin.dao;

public enum UserType {
	 
	FARMER(101,"farmer",1), ADMIN(102,"admin",2), CITIZEN(103,"cityzen",3),BOTH(104,"both",4);
    
	final private int index;
    final private int type;
    final private String name;
     
    public int getID() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getIndex() {
    	return index;
    }
 
    
    private UserType(int type, String name,int index){
        this.type = type;
        this.name = name;
        this.index = index;
    }
}
