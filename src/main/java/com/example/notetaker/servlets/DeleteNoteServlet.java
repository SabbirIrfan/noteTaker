package com.example.notetaker.servlets;

import com.example.notetaker.entity.Note;
import com.example.notetaker.helper.FactoryProvider;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "deletenoteservlet", value = "/deletenoteservlet")
public class DeleteNoteServlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response){

       try {
           int noteId = Integer.parseInt(request.getParameter("id").trim());
           Session session = FactoryProvider.getFactory().openSession();
           System.out.println(noteId);
           Note note = (Note) session.get(Note.class,noteId);
           Transaction tx = session.beginTransaction();


           session.remove(note);

           tx.commit();

           session.close();

           response.sendRedirect("allNotes.jsp");
       } catch (Exception e){
         e.printStackTrace();
       }


    }
}
