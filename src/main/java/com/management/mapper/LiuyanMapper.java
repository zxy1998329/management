package com.management.mapper;

import com.management.entity.Liuyan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LiuyanMapper {
    @Select("select * from liuyan where ownerId=#{ownerId}")
    public List<Liuyan> findLiuyanByOwnerId(Integer ownerId);

    @Delete("delete from liuyan where id = #{id}")
    public void deleteLiuyanById(Integer id);

    @Insert("insert into liuyan(ownerId,leaveId,leaveUserName,date,content,postTitle) " +
            "values(#{ownerId},#{leaveId},#{leaveUserName},#{date},#{content},#{postTitle})")
    public void insertLiuyan(Liuyan liuyan);
}
