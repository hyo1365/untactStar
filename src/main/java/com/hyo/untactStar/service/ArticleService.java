package com.hyo.untactStar.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyo.untactStar.dao.ArticleDao;
import com.hyo.untactStar.dto.Article;
import com.hyo.untactStar.dto.ResultData;
import com.hyo.untactStar.util.Util;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private MemberService memberService;
	

	public Article getArticle(int id) {
		return articleDao.getArticle(id);

	}

	public List<Article> getArticles(String searchKeywordType, String searchKeyword) {
		return articleDao.getArticles(searchKeywordType, searchKeyword);
	}

	public ResultData addArticle(Map<String, Object> param) {

		articleDao.addArticle(param);
		
		int id = Util.getAsInt(param.get("id"), 0);	
		return new ResultData("S-1", "게시물이 추가되었습니다","id", id);

	}

	public ResultData deleteArticle(int id) {

		articleDao.deleteArticle(id);
		
		return new ResultData("S-1", "게시물이 삭제되었습니다","id", id);


	}

	public ResultData modifyArticle(int id, String title, String body) {

		articleDao.modifyArticle(id, title, body);
		
		return new ResultData("S-1", "게시물이 수정되었습니다", "id", id);


	}

	public ResultData getActorCanModifyRd(Article article, int actorId) {
		if( article.getMemberId() == actorId) {
			return new ResultData("S-1", "수정가능합니다.");
		}
		
		if( memberService.isAdmin(actorId)) {
			return new ResultData("S-2", "수정가능합니다.");

		}
		
		return new ResultData("F-1", "권한이 없습니다.");

	}

	public ResultData getActorCanDeleteRd(Article article, int actorId) {
		
		return getActorCanModifyRd(article,actorId);
	}

	public Article getForPrintArticle(int id) {
		return articleDao.getForPrintArticle(id);

	}

	public List<Article> getForPrintArticles(String searchKeywordType, String searchKeyword, int page, int itemsInAPage, int boardId) {
		return articleDao.getForPrintArticles(searchKeywordType, searchKeyword, page, itemsInAPage, boardId);
	}

}
