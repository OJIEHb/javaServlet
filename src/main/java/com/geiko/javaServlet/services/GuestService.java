package com.geiko.javaServlet.services;


import com.geiko.javaServlet.dao.GuestDao;
import com.geiko.javaServlet.mappers.GuestMapper;
import com.geiko.javaServlet.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Андрей on 27.02.2017.
 */
@Component
public class GuestService implements GuestDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertGuest;

    @Autowired
    public GuestService(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertGuest = new SimpleJdbcInsert(dataSource)
                .withTableName("guest").usingGeneratedKeyColumns("id");
    }

    public Guest getGuest(int id) {
        Guest guest = this.jdbcTemplate.queryForObject("select * from guest where id = ?",
                new Object[]{id},new GuestMapper());
        return guest;
    }

    public void addGuest(Guest guest) {
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("name", guest.getName());
        parameters.put("comment", guest.getComment());
        parameters.put("mark",guest.getMark());
        Number newId = insertGuest.executeAndReturnKey(parameters);
        guest.setId(newId.intValue());
    }

    public List<Guest> getAll() {
        String sql = "select * from guest order by id DESC ";
        List<Guest> customers  = jdbcTemplate.query(sql,new GuestMapper());
        return customers;
    }

}
