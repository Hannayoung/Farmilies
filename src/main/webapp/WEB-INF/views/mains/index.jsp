<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, height=device-height, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
      <link href="bootstrap3/css/font-awesome.css" rel="stylesheet">
  <link href="http://fonts.googleapis.com/css?family=Grand+Hotel" rel="stylesheet" type="text/css">
  <link href="bootstrap3/css/bootstrap.css" rel="stylesheet">
  <link href="assets/css/gsdk.css" rel="stylesheet">
  <link href="assets/css/demo.css" rel="stylesheet">
    
    <title>FAMILIES</title>
</head>
<body>
<p>MAP TEST</p>
<div class="search_box">
    <label>
      <input type="text" placeholder="원하시는 지역명, 농협 지점명을 입력해주세요" class="search_box_autocomplete" autocomplete="off" name="region_address" id="room-textfield"> </label>
  </div>
  <div id="map" style="width:100%;height:400px;"></div>
  <div>
    <form action="/" method="post">
      <div class="row">
        <div class="col-md-1">
          <label> 제목 : </label> &nbsp; </div>
        <div class="col-md-10">
          <input class="col-md-5 form-control input-sm" type="text" name="first_name"> </div>
      </div>
      <div class="row">
        <div class="col-md-1">
          <label> 내용 : </label> &nbsp; </div>
        <div class="col-md-10">
          <input class="col-md-5 form-control input-sm" type="text" name="last_name"> </div>
      </div>
      <div class="row" style="text-align:center">
        <input type="button" value="등록" style="margin:10;background-color:blue;color:white" class="btn btn-default" col="50" height="10">
        <input type="button" style="margin:10;background-color:red;color:white" value="수정" class="btn btn-default" width="50">
        <input type="button" value="삭제" style="margin:10;background-color:gray;color:white" class="btn btn-default" width="50"> </div>
    </form>
  </div>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dc54a88a26d4436f660ff09248ab2b95&amp;libraries=service,clusterer,drawing"></script>
  <script type="text/javascript" src="map/mapTest.js">
  </script>
  <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:250px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">Made with Pingendo Free&nbsp;&nbsp;
    <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16">
  </pingendo>
</body>

</html>