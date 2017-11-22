function getMedia() {
    if (navigator.getUserMedia) {
        navigator.getUserMedia({
            'video': {
                'optional': [{
                    'sourceId': exArray[1]  // get Camera.
                }]
            },
            'audio':false
        }, successFunc, errorFunc);
    }
    else {
        alert('Native device media streaming (getUserMedia) not supported in this browser.');
    }
}

function successFunc(stream) {
    if (video.mozSrcObject !== undefined) {
        // In Firefox, video.mozSrcObject will initial to null, not uninitial
        video.mozSrcObject = stream;
    }
    else {
        video.src = window.URL && window.URL.createObjectURL(stream) || stream;
    }
}

// error
function errorFunc(e) {
    alert('Error！'+e);
}

// Photo
function getPhoto() {
    tcontext.drawImage(video, 0, 0, tcanvas.width, tcanvas.height);
}

function submitForm() {
    getPhoto();
    var usrName = usr;
    // alert(usrName);
    var myImage = tcanvas.toDataURL("image/jpeg");
    $.ajax({
        type: "POST",
        url: '/identify',
        data: {usr: usrName, data: myImage},
        timeout: 60000,
        success: function (msg) {
            alert(msg);
            if (parseInt(msg)<50) {
                self.location = "/logout"
            }
        },
        error: function (msg) {
            alert(msg);
        }
    });
}

// Video
// function getVedio() {
//     drawVideoAtCanvas(video, context2);
// }