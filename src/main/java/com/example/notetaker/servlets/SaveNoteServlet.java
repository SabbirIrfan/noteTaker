package com.example.notetaker.servlets;

import java.io.*;
import java.util.Date;

import com.example.notetaker.entity.Note;
import com.example.notetaker.helper.FactoryProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "savenoteservlet", value = "/savenoteservlet")
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addNotes.jsp");


            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();



            System.out.println((request.getParameter("id")));
            int id = Integer.parseInt(request.getParameter("id").trim());
            if( !request.getParameter("id").equals("no")  ){
                Note note = session.get(Note.class,id);
                System.out.println(request.getParameter("id").trim()+"nothing??");
                note.setContent(request.getParameter("content"));
                note.setTittle(request.getParameter("tittle"));
                note.setId(id);
                note.setCreatedDate(new Date());
//                session.update(note);
                System.out.println("updating");


            }
            else {
                String tittle = request.getParameter("tittle");
                String content = request.getParameter("content");
//            int userId = request.getParameter("userId");
                Note note = new Note(tittle,content,new Date());
                System.out.println("creating new");
                session.persist(note);
            }
            tx.commit();

//            System.out.println(session.isDirty());
            session.close();

            request.setAttribute("status","Add another note?");
            requestDispatcher.forward(request,response);



        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void destroy() {
    }
}