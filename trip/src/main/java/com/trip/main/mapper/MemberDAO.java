package com.trip.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.trip.main.domain.MemberVO;

@Mapper
public interface MemberDAO {
	@Select("select * from member where bestyn='y'")
	public List<MemberVO> getBestMemberList() throws Exception;
	
	@Select("select * from member where email=#{email} and password=#{password}")
	public MemberVO selectOne(@Param("email") String email, @Param("password") String password) throws Exception;
	
	@Insert("insert into member(email,password,nickname) values(#{email},#{password},#{nickname}")
	public MemberVO insertMember(@Param("email") String email, @Param("password") String password,@Param("nickname") String nickname) throws Exception;
}
