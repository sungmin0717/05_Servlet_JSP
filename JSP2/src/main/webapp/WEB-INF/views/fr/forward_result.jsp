<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Forward 결과 페이지</title>
</head>


<body>
  <h3>request socpe 객체를 이용해서 전달 받은 값</h3>

  <ul>
    <li> forward 입력 1 : ${param.forwardInput1}</li>
    <li> forward 입력 2 : ${param.forwardInput2}</li>
    <li> str : ${str}</li>
    
  </ul>
  
</body>


</html>