<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tavi's Travelog - Posted Image</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>
<body>
  <h1>Tavi's Travelog</h1>
  <hr/>
  <p>アップロードが完了しました。</p>
  <form method="get" action="postImage">
    <input type="submit" value="アップロード画面に戻る"/>
  </form>
  <hr/>
  <h2>Posted Image</h2>
  <p>URL : /image/${f:h(imgId)}</p>
  <img alt="/image/${f:h(imgId)}" title="/image/${f:h(imgId)}" src="/image/${f:h(imgId)}">
</body>
</html>