package com.oneteam.dormease.user.parents;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IParentsMapper {
    int insertNewParent(ParentsDto parentsDto);

    ParentsDto selectParentByID(String id);

    int deleteParentByNo(int no);
}
