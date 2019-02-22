package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.SortieManager;
import fr.eni.sortir.bo.Sortie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sortie/detail")
public class DetailSortieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SortieManager sortieManager = new SortieManager();
        //Sortie sortie  = sortieManager.selectById((Integer) request.getAttribute("idSortie"));
        Sortie sortie  = sortieManager.selectById(2);

        request.setAttribute("sortie", sortie);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/detailSortie.jsp");
        rd.forward(request, response);
    }
}
