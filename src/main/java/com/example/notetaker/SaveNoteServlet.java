package com.example.notetaker;

import java.io.*;
import java.util.Date;

import com.example.notetaker.entity.Note;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "savenoteservlet", value = "/savenoteservlet")
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        try {
            String tittle = request.getParameter("tittle");
            String content = request.getParameter("Content");
            Note note = new Note(tittle,content,new Date());

            System.out.println(note.getId()+"  >> "+ note.getContent());

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void destroy() {
    }
}