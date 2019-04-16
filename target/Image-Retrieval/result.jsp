<%--
  Created by IntelliJ IDEA.
  User: 狐狸
  Date: 2019/4/7
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图像识别结果</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-fileinput.css" rel="stylesheet">
    <style type="text/css">
        .allbody{
            width: 100%;
            height: 100%;
            background-color: #FFA500;
            text-align:center
        }
    </style>

    <script type="text/javascript">
        var flag = false;
        function voice() {
            flag = !flag;
            if (flag) {
                document.getElementById("audio").play();
            }else{
                document.getElementById("audio").pause();
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="allbody">
        <div class="page-header">
            <br>
            <h3>图像检索结果</h3>
            <hr>
            <br>
            <br>
                <audio hidden="hidden" id="audio" src='\dataResourceImages\voice.mp3'></audio>
                <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                    <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                        <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                            <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="\dataResourceImages${rootPath}" alt="" />
                        </div>
                        <div  class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                        <div>
                            <br>
                            <span class="btn btn-primary btn-file" style="pointer-events:none">
                            <span class="fileinput-new">关键字：${keyword}</span>
                        </span>
                        </div>
                    </div>
                </div>
                <button type="button" id="uploadSubmit" class="btn btn-info" style="width: 60%;pointer-events:none;word-wrap: break-word !important;
    word-break: break-all !important;
    white-space: normal !important;margin-top: -1vw">描述信息：${desc}</button>
                <span><input style="width: 3vw;height: 3vw;" type="image" onclick="voice()" src="\dataResourceImages\sound.png" /></span>
            <hr>
            <h4>相似图片</h4>
            <hr>
            <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img class="mimage" style="width: 100%;height: auto;max-height: 120px;" src="\dataResourceImages${searchPath_1}" alt="">
                        ${semblance_1}
                        <p>\dataResourceImages${searchPath_1}</p>
                    </div>
                </div>
            </div>
            <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img class="mimage" style="width: 100%;height: auto;max-height: 120px;" src="\dataResourceImages${searchPath_2}" alt="">
                        ${semblance_2}
                    </div>
                </div>
            </div>
            <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img class="mimage" style="width: 100%;height: auto;max-height: 120px;" src="\dataResourceImages${searchPath_3}" alt="">
                        ${semblance_3}
                    </div>
                </div>
            </div>
            <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img class="mimage" style="width: 100%;height: auto;max-height: 120px;" src="\dataResourceImages${searchPath_4}" alt="">
                        ${semblance_4}
                    </div>
                </div>
            </div>
            <div class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img class="mimage" style="width: 100%;height: auto;max-height: 120px;" src="\dataResourceImages${searchPath_5}" alt="">
                        ${semblance_5}
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap-fileinput.js"></script>
</body>
</html>
