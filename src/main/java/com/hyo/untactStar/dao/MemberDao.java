package com.hyo.untactStar.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyo.untactStar.dto.Member;

@Mapper
public interface MemberDao {

	public void join(Map<String, Object> param);

	public Member getMember(@Param("id") int id);

	public Member getMemberByLoginId(@Param("loginId") String loginId);

	public Member getMemberByNickname(@Param("nickname") String nickname);

	public void modifyMember(Map<String, Object> param);

}
