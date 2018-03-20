package kr.bit.model;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class MemoMybatisDAO {

	@Inject
	private SqlSession sqlSession;
	//	----------------------------------
	public List<MemoVO> memoList(){
		// SqlSession => Connection+Statement
//		SqlSession session=sqlFactory.openSession();
		List<MemoVO> list=sqlSession.selectList("memoList"); // id="memoList" -> SQL
//		session.close();
		return list;
	}
	public int memoInsert(MemoVO vo){
//		SqlSession session=sqlFactory.openSession();
		int cnt=sqlSession.insert("memoInsert",vo);
		//sqlSession.commit();
//		session.close();
		return cnt;
	}

	public MemoVO memoContent(int mnum){
//		SqlSession session=sqlFactory.openSession();
		MemoVO vo=sqlSession.selectOne("memoContent",mnum);
//		session.close();
		return vo;
	}
	
	public int memoDelete(int mnum) {
		
//		SqlSession session=sqlFactory.openSession();
		int cnt=sqlSession.delete("memoDelete",mnum);
		//sqlSession.commit();
//		session.close();
		return cnt;
		
	}
	public int memoUpdate(MemoVO vo) {
	
//		SqlSession session=sqlFactory.openSession();
		int cnt=sqlSession.update("memoUpdate",vo);
//		sqlSession.commit();
//		session.close();
		return cnt;
	}	
}
