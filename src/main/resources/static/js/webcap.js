var exArray = [];
var context1 = canvas1.getContext('2d');

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
    context1.drawImage(video, 0, 0, canvas1.width, canvas1.height);
    canvas1.height()
}

// Video
function getVedio() {
    drawVideoAtCanvas(video, context2);
}
