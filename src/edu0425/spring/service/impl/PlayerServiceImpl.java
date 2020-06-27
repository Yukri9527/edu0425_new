package edu0425.spring.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0425.common.page.Pagination;
import edu0425.common.page.PaginationResult;
import edu0425.spring.dao.mapper.EmpMapper;
import edu0425.spring.dao.mapper.PlayerMapper;
import edu0425.spring.init.InitInfo;
import edu0425.spring.service.PlayerService;
import edu0425.spring.vo.ChartData;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.EmpInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PlayerInfo;

@Component // 注入
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public Integer getTotalCount() {
		// TODO 获取所有球员
		return playerMapper.getTotalCount();
	}

	@Override
	public PaginationResult<List<PlayerInfo>> getPlayerPage(Integer pageIndex, Integer pageSize) {
		Pagination pagination = new Pagination(pageIndex, pageSize);
		Integer totalCount = getTotalCount();
		pagination.setTotalCount(totalCount);

		// List<DeptInfo> list=getDeptList(); // all
		List<PlayerInfo> list = playerMapper.getPlayer(pagination.getCursor(), pagination.getOffset());
		for (PlayerInfo player : list) {
			// 循环查询设置俱乐部和国家信息
//			player.setClub(playerMapper.getClubById(player.getCid()));
//			player.setNation(playerMapper.GetNationById(player.getNid()));
			player.setClub(InitInfo.club.get(player.getCid()));
			player.setNation(InitInfo.nation.get(player.getNid()));
		}

		pagination.setCurrentPageCount(list.size());
		PaginationResult<List<PlayerInfo>> result = new PaginationResult<List<PlayerInfo>>(pagination, list);
		return result;
	}

	@Override
	public NationInfo GetNationById(Integer nid) {
		// TODO 通过国家Id获取信息
		return playerMapper.GetNationById(nid);
	}

	@Override
	public ClubInfo getClubById(Integer cid) {
		// TODO 获取俱乐部信息
		return playerMapper.getClubById(cid);
	}

	@Override
	public List<NationInfo> getAllNation() {
		// 获取所有国家信息
		return playerMapper.getAllNation();
	}

	@Override
	public List<ClubInfo> getAllClub() {
		// TODO 获取所有俱乐部信息
		return playerMapper.getAllClub();
	}

	@Override
	public PlayerInfo getPlayerById(Integer pid) {
		// TODO 获取所有俱乐部信息
		return playerMapper.getPlayerById(pid);
	}

	@Override
	public JSONArray getJsonAge() {
		List<ChartData> list=playerMapper.getDataOfAge();
		JSONArray array= new JSONArray();
		for(ChartData data:list) {
			JSONObject json =new JSONObject();
			json.put("value", data.getValue());
			json.put("name", data.getValue());
			array.add(json);
		
		}
		return array;
	}

	@Override
	public JSONArray getJsonOverall() {
		List<ChartData> list =playerMapper.getDataOfOverall();
		JSONArray array= new JSONArray();
		for(ChartData data:list) {
			JSONObject json =new JSONObject();
			json.put("value", data.getValue());
			json.put("name", data.getValue());
			array.add(json);
		
		}
		return array;
	}


}
