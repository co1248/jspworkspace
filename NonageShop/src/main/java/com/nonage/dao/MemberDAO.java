package com.nonage.dao;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		return instance;
	}

}
