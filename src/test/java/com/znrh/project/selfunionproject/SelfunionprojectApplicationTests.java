package com.znrh.project.selfunionproject;

import com.znrh.project.selfunionproject.mapper.ColumnsMapper;
import com.znrh.project.selfunionproject.model.Columns;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelfunionprojectApplicationTests {

    @Resource
    private ColumnsMapper columnsMapper;

    @Test
    public void columnsTest() {
        List<Columns> columnsList = columnsMapper.selectByTableNameAndSchemaName("dwd_energy_big_table2", "bigdata");
        System.out.println("²éÑ¯½á¹û"+columnsList.toString());
    }

}
