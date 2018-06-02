<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  
  <head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Sign up</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="container" style="margin-top: 5%;">
      <h1 class="text-center text-success">회원 가입</h1>
      <form action="#">
        <div class="btn-group btn-block btn-group-lg form-group">
          <div class="btn-group-lg" role="group">
            <button class="col-sm-12 col-md-6 btn btn-default">농부</button>
            <button class="col-sm-12 col-md-6 btn btn-lg btn-default">시민</button>
          </div>
          <div class="form-group">
            <label for="UserName">ID</label>
            <input type="text" class="form-control" id="email">
          </div>
          <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd">
          </div>
          <div class="form-group">
            <label for="pwd">Confirm Password:</label>
            <input type="password" class="form-control" id="pwd">
          </div>
          <div class="form-group">
            <label for="phone">Phone number</label>
            <input type="text" class="form-control" id="phone">
          </div>
          <button type="submit" class="btn-block btn-Primary btn-lg">작성 완료</button>
          <a href="#" class="pull-right btn-lg">비밀번호 찾기</a>
          <a href="main" class="btn btn-danger"> 이미 회원이세요?   </a>
        </div>
      </form>
      <!-- This design is created by manoj chauhan -->
    </div>
  </body>

</html>