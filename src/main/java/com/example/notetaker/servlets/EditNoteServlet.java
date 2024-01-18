package com.example.notetaker.servlets;

import com.example.notetaker.entity.Note;
import com.example.notetaker.helper.FactoryProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "editservlet", value = "/editservlet")
public class EditNoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noteId = Integer.parseInt(request.getParameter("id").trim());

        System.out.println(noteId);

        Session session = FactoryProvider.getFactory().openSession();
//        Transaction tx = session.beginTransaction();

        Note  note = (Note) session.get(Note.class, noteId);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addNotes.jsp");

        request.setAttribute("id", noteId);
        request.setAttribute("content", note.getContent());

        request.setAttribute("tittle", note.getTittle());

        requestDispatcher.forward(request,response);



        session.close();
    }

}
