package com.japrod.sharebox.server.model;

public enum RoleEnum {
	USER((byte)1), ADMIN((byte)2);

	private byte id;
	
	private RoleEnum(byte id){
		this.id = id;
	}
	
	public byte getId() {
		return this.id;
	}	
}
