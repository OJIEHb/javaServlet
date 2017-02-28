package com.geiko.javaServlet.dao;

import com.geiko.javaServlet.model.Guest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Андрей on 27.02.2017.
 */
@Repository
@Transactional
public interface GuestDao {
    public Guest getGuest(int id);
    public void addGuest(Guest guest);
    public List<Guest> getAll();
}
