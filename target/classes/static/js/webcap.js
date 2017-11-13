function getMedia() {
    if (navigator.getUserMedia) {
        navigator.getUserMedia({
            'video': {
                'optional': [{
                    'sourceId': exArray[1]  // get Camera.
                }]
            },
            'audio':true
        }, successFunc, errorFunc);
    }
    else {
        alert('Native device media streaming (getUserMedia) not supported in this browser.');
    }
}

function successFunc(stream) {
    //alert('Succeed to get media!');
    if (video.mozSrcObject !== undefined) {
        // In Firefox, video.mozSrcObject will initial to null, not uninitial
        video.mozSrcObject = stream;
    }
    else {
        video.src = window.URL && window.URL.createObjectURL(stream) || stream;
    }

    //video.play();

    // Audio
    audio = new Audio();
    audioType = getAudioType(audio);
    if (audioType) {
        audio.src = 'polaroid.' + audioType;
        audio.play();
    }
}

// error
function errorFunc(e) {
    alert('Error！'+e);
}

// draw video to Canvas, 60ms change every frame
function drawVideoAtCanvas(video,context) {
    window.setInterval(function () {
        context.drawImage(video, 0, 0,90,120);
    }, 60);
}

// AudioType
function getAudioType(element) {
    if (element.canPlayType) {
        if (element.canPlayType('audio/mp4; codecs="mp4a.40.5"') !== '') {
            return ('aac');
        } else if (element.canPlayType('audio/ogg; codecs="vorbis"') !== '') {
            return ("ogg");
        }
    }
    return false;
}

// draw video to canvas
//        video.addEventListener('play', function () {
//            drawVideoAtCanvas(video, context2);
//        }, false);

// Photo
function getPhoto() {
    context1.drawImage(video, 0, 0,120,90); //将video对象内指定的区域捕捉绘制到画布上指定的区域，实现拍照。
}

// Video
function getVedio() {
    drawVideoAtCanvas(video, context2);
}