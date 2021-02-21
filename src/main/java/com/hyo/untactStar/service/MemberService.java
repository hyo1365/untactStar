package com.hyo.untactStar.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyo.untactStar.dao.MemberDao;
import com.hyo.untactStar.dto.Member;
import com.hyo.untactStar.dto.ResultData;
import com.hyo.untactStar.util.Util;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public ResultData join(Map<String, Object> param) {
		memberDao.join(param);
		int id = Util.getAsInt(param.get("id"), 0);
		return new ResultData("S-1", String.format("%s님 환영합니다.", param.get("nickname")), "id", id);
	}

	public Member getMember(int id) {

		return memberDao.getMember(id);
	}

	public Member getMemberByLoginId(String loginId) {

		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberByNickname(String nickname) {

		return memberDao.getMemberByNickname(nickname);
	}

	public ResultData modifyMember(Map<String, Object> param) {
		memberDao.modifyMember(param);

		return new ResultData("S-1", "회원정보가 수정되었습니다");

	}

	public boolean isAdmin(int actorId) {
		return actorId == 1;
	}

}
