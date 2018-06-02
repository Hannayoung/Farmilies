package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.vo.ContractVO;
import com.coin.vo.UserVO;
import com.coin.vo.WorkVO;

public class ContractDAO {

	
	static final String table_name = "contracts";
	
	static final String[] columnNames = {
			"id",
			"stage",
			"rating",
			"comments",
			"worker_id",
			"work_id"
	};
	
	public ContractVO getById(int id) {
		return getById_private(id);
	}
	public List<ContractVO> getListByWorkerID(String workerID){
		return getListBy("worker_id",workerID,false); 
	}
	public List<ContractVO> getListByWorkID(int workID){
		return getListBy("work_id",workID); 
	}
	public ContractVO makeNew(WorkVO vo,String worker_id) {
		return makeNew_private(vo.getId(),worker_id);
	}
	public ContractVO makeNew(int work_id,String worker_id) {
		return makeNew_private(work_id,worker_id);
	}
	public int updateComments(ContractVO vo,String comments) {
		return update(vo.getId(), "comments",comments);
	}
	public int updateComments(int id,String comments) {
		return update(id, "comments",comments);
	}
	public int updateRating(ContractVO vo,double rating) {
		return update(vo.getId(), "rating",rating);
	}
	public int updateRating(int id,double rating) {
		return update(id, "rating",rating);
	}
	public int updateStage(ContractVO vo,int stage) {
		return update(vo.getId(), "stage",stage);
	}
	public int updateStage(int id,int stage) {
		return update(id, "stage",stage);
	}
	public int delete(ContractVO vo) {
		return delete_private(vo.getId());
	}
	public int delete(int id) {
		return delete_private(id);
	}
	
	
	
	
	
	
	static final String insert_values;
	static {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		for(int i = 0 ; i < columnNames.length ; i++) {
			sb.append(columnNames[i]);
			if(i != columnNames.length -1) {
				sb.append(",");
			}
		}
		sb.append(") values (");
		for(int i = 0 ; i < columnNames.length ; i++) {
			sb.append("?");
			if(i != columnNames.length -1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		insert_values = sb.toString();
	}
	
	
	private List<ContractVO> getListBy(String type, String val, boolean like){
		if(like) {
			return getListBy_private(type, val, like);
		}else {
			return getListBy_private(type,"'"+val+"'",like);
		}
	}
	private List<ContractVO> getListBy(String type, double val){
		return getListBy_private(type, Double.toString(val), false);
	}
	private List<ContractVO> getListBy(String type, int val){
		return getListBy_private(type, Integer.toString(val), false);
	}
	private List<ContractVO> getListBy_private(String type, String val , boolean like) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int result = 0;
		List<ContractVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			String likeOrEquals = null;
			if(like) {
				likeOrEquals = " like '%"+val+"%'";
			}else {
				likeOrEquals = "="+val;				
			}
			
			
			ps = con.prepareStatement("select * from "
										+table_name
										+" where " 
										+ type 
										+likeOrEquals);
			
			
										
			//result = ps.executeUpdate();
			rs = ps.executeQuery();
		
			
			while(rs.next()) {
				ContractVO vo = new ContractVO();
				vo.setId(rs.getInt(columnNames[0]));
				vo.setStage(rs.getInt(columnNames[1]));
				vo.setRating(rs.getDouble(columnNames[2]));
				vo.setComments(rs.getString(columnNames[3]));
				vo.setWorker_id(rs.getString(columnNames[4]));
				vo.setWork_id(rs.getInt(columnNames[5]));
				list.add(vo);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return list;
	} 
	
	
	private int insert(ContractVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		//List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			
			ps = con.prepareStatement("insert into "
										+table_name
										+ insert_values);
			
			int count = 1;
			ps.setInt(count++,vo.getId());
			ps.setInt(count++,vo.getStage());
			ps.setDouble(count++,vo.getRating());
			ps.setString(count++,vo.getComments());
			ps.setString(count++,vo.getWorker_id());
			ps.setInt(count++,vo.getWork_id());
			
										
			result = ps.executeUpdate();
			//rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return result;
	}
	
	private ContractVO getById_private(int id) {
		List<ContractVO> list = getListBy("id",Integer.toString(id),false);
		if(!list.isEmpty()) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	private int delete_private(ContractVO vo) {
		return delete(vo.getId());
	}
	private int delete_private(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		//List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			
			ps = con.prepareStatement("delete from "
										+table_name
										+" where id=?");
			
			int count = 1;
			ps.setInt(count++,id);
			
										
			result = ps.executeUpdate();
			//rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return result;
	}
	private int update(int id,String type , String val) {
		return update_private(id,type, new StringBuilder().append("'").append(val).append("'").toString());
	}
	private int update(int id,String type , int val) {
		return update_private(id,type, Integer.toString(val));
	}
	private int update(int id,String type , double val) {
		return update_private(id,type, Double.toString(val));
	}
	private int update_private(int id,String type, String val) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		//List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			
			ps = con.prepareStatement("update "
										+table_name
										+" set "
										+ type
										+" = "
										+val
										+" where id=?");		
			int count = 1;
			ps.setInt(count++,id);
			
										
			result = ps.executeUpdate();
			//rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return result;
	}
		
	public ContractVO makeNew_private(int work_id,String worker_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		//List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			ps = con.prepareStatement(" select (max(id)+1) as id from "+table_name);
			
			int id = 1;
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			
			ps = con.prepareStatement(" insert into "+table_name+ insert_values);
			/*
			 * "id",
			"stage",
			"rating",
			"comments",
			"worker_id",
			"work_id"
			 */
			int count = 1;			
			ps.setInt(count++,id);
			ps.setNull(count++,java.sql.Types.NUMERIC);
			ps.setNull(count++,java.sql.Types.DOUBLE);
			ps.setNull(count++,java.sql.Types.VARCHAR);
			ps.setString(count++,worker_id);
			ps.setInt(count++,work_id);
										
			result = ps.executeUpdate();
			
			return getById(id);
			//rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return null;
	}
}
