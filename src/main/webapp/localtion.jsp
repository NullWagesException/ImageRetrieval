<%--
  Created by IntelliJ IDEA.
  User: 狐狸
  Date: 2019/4/7
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>浏览器定位</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=1ac34c3325893f8dd2ec97503b107bec"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<body>
<script type="text/javascript">
    var map, geolocation;
    var address;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('container', {
        resizeEnable: true
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'RB'
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        var str=['定位成功'];
        str.push('经度：' + data.position.getLng());
        str.push('纬度：' + data.position.getLat());
        if(data.accuracy){
            str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));

        var point = data.position.getLng()+","+data.position.getLat();
        poiToaddress(point);

    }
    //解析定位错误信息
    function onError(data) {
    }

    //坐标点转地址
    function poiToaddress(poi) {
        AMap.plugin(["AMap.Geocoder"], function () {
            var geocoder = new AMap.Geocoder({
                city: "0315", //城市，默认：“全国”
                radius: 500 //范围，默认：500,以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息
            });
            geocoder.getAddress(poi, function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    address = result.regeocode.formattedAddress; //返回地址描述
                    address2point(address);
                    console.log("地址："+address);
                }
            });
        })
    }

    //地址转坐标
    function address2point(address) {
        AMap.plugin(["AMap.Geocoder"], function () {
            var geocoder = new AMap.Geocoder({
                city: "0315", //城市，默认：“全国”
                radius: 500 //范围，默认：500,以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息
            });
            geocoder.getLocation(address, function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    var geocode = result.geocodes[0];
                    var resultStr = geocode.location.lng + "," + geocode.location.lat;
                    console.log("坐标"+resultStr);
                }
            });
        });
        //第一步 创建ajax对象

        var xhr = new XMLHttpRequest();

//第二步 打开要发送的地址
        xhr.open("get","image/getLocaltion/"+ address);
        /*
            参数1：method--->get post
            参数2：请求的地址
            参数3：布尔值 默认是false 异步true同步
        */
        //第三部发送
        xhr.send();
        console.log(xhr.readyState);
        //第四步
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 && xhr.status == 200){
                console.log(JSON.parse(xhr.responseText))
            }
        };
        window.location.href="index.html";
    }
</script>
</body>
</html>
