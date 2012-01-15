<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog PostEntry</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
<link rel="stylesheet" type="text/css" href="/css/jquery.autocomplete.css" />
<script type="text/javascript" lang="javascript" src="/js/jquery-1.6.4.js" ></script>
<script type="text/javascript" lang="javascript" src="/js/jquery.autocomplete.js" ></script>
<script type="text/javascript">

$(document).ready(function(){
	// 入力済みテキストの値にオートコンプリートを設定
	$("#tagsArea :text").each(function(){
		tagAutoComplete.setTo($(this));
	});
	// 一行もなければ、追加
	if ($("#tagsArea :text").size() == 0) {
		tagTextbox.insert();	
	}
	// 追加ボタンの配置
	tagInsertButton.move();
	// タイトルへフォーカスをあてる
	$("#title").focus();
});

// タグのオートコンプリート設定関数クロージャ
var tagAutoComplete = function () {
	// オートコンプリート選択時の動作関数を定義しておく
	var selectItem = function(item) {
		// 選ばれたらフォーカス移動
		if (item != null) $("#" + tagInsertButton.getId()).focus();
	}
	
	return {
		setTo:function(target) {
			target.autocomplete('ajax/tagAutoComplete',{
				lineSeparator: ',',
				onItemSelect : selectItem,
			    onFindValue : selectItem
		  	});
		}
	}
}();

// タグ行追加関数クロージャ
var tagTextbox = function() {
	var originTextbox = $("<input type='text' name='tagArray' style='width:300px;' maxlength='50' />");
	
	return {
		insert:function() {
			var newInput = originTextbox.clone();
			// オートコンプリートの設定
			tagAutoComplete.setTo(newInput);
			// DOM配置
			$("#tagsArea").append(newInput).append($("<br/>"));
			// 追加した行にフォーカスを移動
			newInput.focus();
		}
	}
}();



// 行追加ボタンの関数クロージャ
var tagInsertButton = function() {
	var id = "tagInsert";
	var button = $('<button id="' + id + '" onclick="tagTextbox.insert();tagInsertButton.move();return false;">＋</button>');
	return {
		// ボタン移動
		move:function() {
			$("#" + id).remove();
			$("#tagsArea :text:last").after(button);
		},
		// ボタンID取得
		getId:function() {
			return id;
		}
	}
}();

</script>

</head>
<body>

<h1>Tavi's Travelog</h1>
<hr/>
<form method="post" action="postingEntry">
タイトル<br/>
<input id="title" type="text" ${f:text("title")}  style="width:300px;" maxlength="500"/><br/>
タグ（新規作成か既存から選択）<br/>
<div id="tagsArea">
	<c:forEach var="tag" items="${tagArray}">
		<input type="text" value='${tag}'  name="tagArray" style="width:300px;" maxlength="50" /><br/>
	</c:forEach>
</div>
<br/>
投稿内容<br/>
<textarea name="content" style="width:900px; height:600px;">${f:h(content)}</textarea><br/>
<input type="submit" value="記事を投稿する">

</form>

</body>
</html>
