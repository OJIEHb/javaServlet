package com.geiko.javaServlet;

import com.geiko.javaServlet.dao.GuestDao;
import com.geiko.javaServlet.model.Guest;
import com.geiko.javaServlet.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GuestServlet extends HttpServlet {

    ApplicationContext context;
    @Autowired
    GuestDao guestService;

    @Override
    public void init(){
        context = new ClassPathXmlApplicationContext("application-context.xml");
        guestService = (GuestDao) context.getBean("guestService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("guestList",guestService.getAll());
        req.getRequestDispatcher("WEB-INF/views/guest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Guest guest = new Guest();
        guest.setName(req.getParameter("name"));
        guest.setComment(req.getParameter("comment"));
        guest.setMark(Integer.parseInt(req.getParameter("mark")));
        req.setAttribute("guest",guest);
        guestService.addGuest(guest);
        resp.sendRedirect("/");
    }

}
