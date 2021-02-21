package com.hyo.untactStar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginid;
	private String loginPw;
	private String name;
	private String nickname;
	private String cellphoneNo;
	private String email;
	

}
