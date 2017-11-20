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

function submitForm() {
    var fileImg = context1.toDataURL();
    // $("#registerForm").attr("enctype", "multipart/form-data");
    // var formData = new FormData($("#registerForm")[0]);
    //formData.append("imgBase64", encodeURIComponent("testtesttest"));//
    formData.append("file", encodeURIComponent(fileImg));//
    // formData.append("fileFileName", "photo.jpg");
    $.ajax({
        url: "/identify",
        type: 'GET',
        data: fileImg,
        timeout: 10000, //超时时间设置，单位毫秒
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (result) {
        },
        error: function () {
            alert('上传图片出错');
        }
    });
}