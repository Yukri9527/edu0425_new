package edu0425.spring.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.page.PaginationResult;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PlayerInfo;

public interface PlayerService {
	
	Integer getTotalCount();

	PaginationResult<List<PlayerInfo>> getPlayerPage(Integer pageIndex, Integer pageSize);

	NationInfo GetNationById(Integer nid);

	ClubInfo getClubById(Integer cid);

	List<NationInfo> getAllNation();

	List<ClubInfo> getAllClub();

	PlayerInfo getPlayerById(Integer pid);
	
	JSONArray getJsonAge();
	
	JSONArray getJsonOverall();
	

}
