<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/sortie/detail?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Consulter les sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/inscription?id=2" class="float-right btn btn-outline-danger" style="margin-left: 10px;">Inscription</a>
        <a href="${pageContext.request.contextPath}/profilParticipant" class="float-right btn btn-outline-success" style="margin-left: 10px;">Profil</a>
        <a href="${pageContext.request.contextPath}/sortie/ajouter" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Nouvelle sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/desistement?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Desistement</a>


        <div id="toolbar">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <span>Offset: </span>
                    <input name="offset" class="form-control w70" type="number" value="0">
                </div>
                <div class="form-group">
                    <span>Limit: </span>
                    <input name="limit" class="form-control w70" type="number" value="5">
                </div>
                <div class="form-group">
                    <input name="search" class="form-control" type="text" placeholder="Search">
                </div>
                <button id="ok" type="submit" class="btn btn-primary">OK</button>
            </div>
        </div>
        <table
                id="table"
                data-toggle="table"
                data-toolbar="#toolbar"
                data-show-refresh="true"
                data-show-toggle="true"
                data-show-columns="true"
                data-url="https://examples.wenzhixin.net.cn/examples/bootstrap_table/data">
            <thead>
            <tr>
                <th data-field="id">ID</th>
                <th data-field="name">Item Name</th>
                <th data-field="price">Item Price</th>
            </tr>
            </thead>
        </table>

        <script src="<%=request.getContextPath()%>/vendor/jquery/jquery.js"></script>
        <script	src="<%=request.getContextPath()%>/vendor/bootstrap/js/popper.min.js"></script>
        <script	src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script	src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap-table.js"></script>

        <script>
            var $table = $('#table')
            var $ok = $('#ok')

            $(function() {
                $ok.click(function () {
                    $table.bootstrapTable('refresh')
                })
            })

            function queryParams() {
                var params = {}
                $('#toolbar').find('input[name]').each(function () {
                    params[$(this).attr('name')] = $(this).val()
                })
                return params
            }

            function responseHandler(res) {
                return res.rows
            }
        </script>

        <%--<table--%>
            <%--id="table"--%>
            <%--data-toggle="table"--%>
            <%--data-url="/sorties">--%>
            <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th data-field="nom">Nom de la sortie</th>--%>
                    <%--<th data-field="dateDebut">Date de la sortie</th>--%>
                    <%--<th>Item Name</th>--%>
                    <%--<th>Item Price</th>--%>
                <%--</tr>--%>
            <%--</thead>--%>
        <%--</table>--%>

<%@ include file="../layout/footer.jsp"%>