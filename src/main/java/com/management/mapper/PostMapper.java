package com.management.mapper;

import com.management.entity.Liuyan;
import com.management.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select * from post order by date DESC")
    public List<Post> findAll();

    @Select("select * from post where ownerId=#{ownerId}")
    public List<Post> findByOwnerId(Integer ownerId);

    @Select("select * from post where id=#{id}")
    public Post findById(Integer id);



    //一对多查询，在xml文件中实现
    public List<Post> findAllWithComment();
    public List<Post> findByPart(Integer part);

    @Insert("insert into post(id,ownerId,ownerNickName,title,date,content,part) " +
            "values(#{id},#{ownerId},#{ownerNickName},#{title},#{date},#{content},#{part})")
    public void insertPost(Post post);

    @Update("update post set " +
            "title=#{title},content=#{content},part=#{part} " +
            "where id = #{id}")
    public void updatePost(Post post);

    @Delete("delete from post where id=#{id}")
    public void deletePostById(Integer id);
}
