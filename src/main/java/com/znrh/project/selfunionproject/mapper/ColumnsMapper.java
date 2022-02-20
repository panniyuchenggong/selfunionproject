package com.znrh.project.selfunionproject.mapper;

import com.znrh.project.selfunionproject.model.Columns;
import com.znrh.project.selfunionproject.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnsMapper extends MyMapper<Columns> {

    /**
     * 根据表名和库名查询表字段信息【字段名，注释，字段类型】
     * @param tableName 表名
     * @param schemaName 库名
     * @return
     */
    List<Columns> selectByTableNameAndSchemaName(@Param("tableName") String tableName, @Param("schemaName") String schemaName);

}