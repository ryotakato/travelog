<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog PostedEntry</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>
<body>
  <h1>Tavi's Travelog</h1>
  <hr/>
  <p>投稿が完了しました。</p>
  <form method="get" action="postEntry">
    <input type="submit" value="投稿画面に戻る"/>
  </form>
</body>
</html>