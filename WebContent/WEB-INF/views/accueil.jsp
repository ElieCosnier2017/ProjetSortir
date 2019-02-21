<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <%
            int idparticipant;
            HttpSession httpSession = request.getSession();
            //idparticipant = (Integer) httpSession.getAttribute("idParticipant");
        %>
    <span>

    </span>
        <a href="/sortie/add" class="float-right btn btn-outline-primary">Inscription</a>
<%@ include file="../layout/footer.jsp"%>