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
            res = '<a href="/sortie/detail?id='+row["no_sortie"]+'">Modifier</a> - <a>Publier</a>';
        } else {
            res = '<a href="/sortie/detail?id='+row["no_sortie"]+'">Afficher</a>';
        }
    } else {
        res = '<a href="/sortie/detail?id='+row["no_sortie"]+'">Afficher</a>';
        if(row['idOrganisateur'] == row['idConnecter']) {
            res += '<a>Annuler</a> '
        } else {
            datelimit = new Date(row['dateLimiteInscription']);
            if(datelimit > Date.now()) {
                if(row['isInscrit'] == true) {
                    res += ' - <a href="sortie/desistement?id='+row["no_sortie"]+'">Se désister</a> ';
                } else {
                    res += ' - <a href="/sortie/inscription?id='+row["no_sortie"]+'">S\'inscrire</a> '
                }
            }
        }

    }

    // '<a href="/sortie/detail?id='+row["no_sortie"]+'">Afficher</a> '+
    // '<a href="/sortie/detail?id='+row["no_sortie"]+'">Modifier</a> '+
    return [
        res
        // '<a href="sortie/desistement?id='+row["no_sortie"]+'">Se désister</a> '+
        // '<a href="/sortie/inscription?id='+row["no_sortie"]+'">S\'inscrire</a> '+
        // '<a>Annuler</a>'
    ].join('')
}
