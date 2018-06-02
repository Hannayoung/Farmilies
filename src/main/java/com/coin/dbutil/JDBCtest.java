package com.coin.dbutil;

import java.util.List;

import com.coin.dao.ContractDAO;
import com.coin.dao.JDBCutil;
import com.coin.dao.LocationDAO;
import com.coin.dao.PictureDAO;
import com.coin.dao.UserDAO;
import com.coin.dao.UserGroupDAO;
import com.coin.dao.UserType;
import com.coin.dao.WorkDAO;
import com.coin.vo.ContractVO;
import com.coin.vo.UserVO;
import com.coin.vo.WorkVO;

public class JDBCtest {
	
	
	
	public static void main(String[] args) {
		ContractDAO contractDao = JDBCutil.contractDao;
		LocationDAO locationDao = JDBCutil.locationDao;
		PictureDAO pictureDao = JDBCutil.pictureDao;
		UserDAO userDao = JDBCutil.userDao;
		UserGroupDAO userGroupDao = JDBCutil.userGroupDao;
		WorkDAO workDao = JDBCutil.workDao;
		
		
		
		//getById functions return null if no corresponding record
		/*
		userDao.getById(String id);
		workDao.getById(int id);
		contractDao.getById(int id);
		locationDao.getById(int id);
		pictureDao.getById(int id);
		*/
		
		
		userDao.makeNew("qwalar747", "1234", "남호", "이", UserType.CITIZEN , "abc/wew/3gfg");
		userDao.makeNew("aqudwns", "1234", "병준", "이", UserType.CITIZEN , "abc/wew/3ㅎㄷaㅁ");
		userDao.makeNew("brndnjs", "1234", "구원", "이", UserType.BOTH , "abc/wew/3gwagd");
		userDao.makeNew("crltjr", "1234", "기석", "이", UserType.FARMER , "abc/wew/3gfgaaweg");
		
		UserVO userVO = userDao.getById("fkalar747");
		System.out.println(userVO);
		List<UserVO> list = userDao.getListByIDLike("");
		for(UserVO vo : list)System.out.println(vo);
		
		
		
		//workDao.updatePicture(workVO.getId(), "/path/to/photo2");
		
		
		workDao.makeNew("qudwns", "고구마캐기", "고구마를 겁나게 캔다", 132, 33);
		workDao.makeNew("rndnjs", "수박뽀개기", "수박을 겁나게 캔다", 131, 34);
		workDao.makeNew("rltjr", "호박캐기", "호박을 겁나게 캔다", 134.121, 32.426);
		
		
		//ContractVO vo2 = contractDao.makeNew(workVO, "rltjr");
		//ContractVO vo2 = contractDao.makeNew(workVO.getId(), "rltjr");
		//vo2.updateRating(56.56);
		
		
		
	}
}
