package com.geiko.javaServlet.mappers;

import com.geiko.javaServlet.model.Guest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Андрей on 27.02.2017.
 */
@Component
public class GuestMapper implements RowMapper<Guest> {
    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
        Guest guest = new Guest();
        guest.setId(rs.getInt("id"));
        guest.setName(rs.getString("name"));
        guest.setComment(rs.getString("comment"));
        guest.setMark(rs.getInt("mark"));
        return guest;
    }
}
