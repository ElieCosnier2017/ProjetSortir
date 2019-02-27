function inscritPlaceFormatter(value, row, index) {
    return [
        '<p>'+row["nbInscrit"]+'/'+row["nbMax"]+'</p>'
    ].join('')
}

function nomOrganisateurFormatter(value, row, index) {
    return [
        '<a>'+row["nomParticipant"]+' '+row["prenomParticipant"]+'</a>'
    ].join('')
}

function isInscritFormatter(value, row, index) {
    var reponse =  '';
    if(row["isInscrit"] == "true"){
        reponse = 'ok <i class="fa fa-check" aria-hidden="true"></i>';
    }
    console.log(reponse);
    return [
        reponse
    ].join('')
}

