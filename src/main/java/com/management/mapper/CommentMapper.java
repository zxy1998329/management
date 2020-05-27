package com.management.mapper;

import com.management.entity.Comment;
import com.management.entity.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(postId,ownerId,ownerNickName,date,content) " +
            "values(#{postId},#{ownerId},#{ownerNickName},#{date},#{content})")
    public void insertComment(Comment comment);

}
