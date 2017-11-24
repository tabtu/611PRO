/**
 *
 * @Author Tab Tu
 * @Updated Nov.22 2017
 * @Since 1.1
 *
 * var tag_identify = 0;
 * var usr = $("meta[name='usr']").attr("content");
 * var video = document.querySelector('video');
 * var tcanvas = document.getElementById('mycanvas');
 * var tcontext = tcanvas.getContext('2d');
 * var exArray = [];
 */

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
            var similarity = parseInt(msg);
            if (similarity < 50) {
                alert("We are forced to log out since you are not " + usr);
                self.location = "/logout";
            } else if (similarity < 80) {
                if (tag_identify > 2) {
                    alert("We are forced to log out since you are not doing the quiz by yourself " + usr);
                    self.location = "/logout"
                } else {
                    alert("Please finish the quiz by your self alone " + usr);
                    tag_identify++;
                }
            } else {
                tag_identify = 0;
            }
        },
        error: function (msg) {
            alert("Sorry that we've got some proble on this page. " + msg);
            self.location = "/logout";
        }
    });
}

function autoLogin() {
    getPhoto();
    alert(usnm);
    var myImage = tcanvas.toDataURL("image/jpeg");
    $.ajax({
        type: "POST",
        url: '/identify',
        data: {usr: usnm, data: myImage},
        timeout: 60000,
        success: function (msg) {
            var similarity = parseInt(msg);
            if (similarity < 50) {
                alert("We are forced to log out since you are not " + usr);
                self.location = "/logout";
            } else if (similarity < 80) {
                if (tag_identify > 2) {
                    alert("We are forced to log out since you are not doing the quiz by yourself " + usr);
                    self.location = "/logout"
                } else {
                    alert("Please finish the quiz by your self alone " + usr);
                    tag_identify++;
                }
            } else {
                tag_identify = 0;
            }
        },
        error: function (msg) {
            alert("Sorry that we've got some proble on this page. " + msg);
            self.location = "/logout";
        }
    });
}

// Video
// function getVedio() {
//     drawVideoAtCanvas(video, tcontext);
// }