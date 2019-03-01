function inscritPlaceFormatter(value, row, index) {
    return [
        '<p>'+row["nbInscrit"]+'/'+row["nbMax"]+'</p>'
    ].join('')
}

function nomOrganisateurFormatter(value, row, index) {
    return [
        '<a href="/user/profil?id='+row['idOrganisateur']+'">'+row["prenomOrganisateur"]+' '+row["nomOrganisateur"]+'</a>'
    ].join('')
}

function isInscritFormatter(value, row, index) {
    var res;
    if(row["isInscrit"] == true) {
        res = '<i class="fa fa-check"></i>';
    }
    return [
        res
    ].join('')
}

function actionFormatter(value, row, index) {
    var res;
    if(row['libelleEtat'] == "En création"){

        if(row['idOrganisateur'] == row['idConnecter']) {
            res = '<a class="btn btn-outline-info" href="/sortie/editer?id='+row["no_sortie"]+'">Modifier</a>  ' +
                '<button class="btn btn-outline-success" onclick="publier('+row["no_sortie"]+')">Publier</button>';
        } else {
            res = '<a class="btn btn-outline-info" href="/sortie/detail?id='+row["no_sortie"]+'">Afficher</a>';
        }
    } else {
        res = '<a class="btn btn-outline-info" href="/sortie/detail?id='+row["no_sortie"]+'">Afficher</a>';
        if(row['idEtat'] != 7){
            if(row['idOrganisateur'] == row['idConnecter']) {
                res += '  <a class="btn btn-outline-danger" href="/sortie/annuler?id='+row["no_sortie"]+'">Annuler</a> '
            } else {
                datelimit = new Date(row['dateLimiteInscription']);
                if(datelimit > Date.now()) {
                    if(row['isInscrit'] == true) {
                        res += '  <button class="btn btn-outline-warning" onclick="desister('+row["no_sortie"]+')">Se désister</button> ';
                    } else {
                        res += '  <button class="btn btn-outline-success" onclick="inscrire('+row["no_sortie"]+')">S\'inscrire</button> '
                    }
                }
            }
        }
    }
    return [res].join('')
}

$('#selectSite').on('changed.bs.select', function () {
    var siteselect = $('.selectpicker').val();
    $('#table').bootstrapTable('refresh', { url: '/sortie?id='+siteselect})
});

function inscrire(id){
    $.ajax({url: "/sortie/inscription?id="+id, success: function(result){
        $('#table').bootstrapTable('refresh');
    }});
}
function desister(id){
    $.ajax({url: "/sortie/desistement?id="+id, success: function(result){
        $('#table').bootstrapTable('refresh');
    }});
}
function publier(id){
    $.ajax({url: "/sortie/publier?id="+id, success: function(result){
        $('#table').bootstrapTable('refresh');
    }});
}

