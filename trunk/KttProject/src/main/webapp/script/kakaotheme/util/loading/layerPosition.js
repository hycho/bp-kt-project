/**
 * Ajax 통신을 할 때 Image Path를 중앙에 띄워준다.
 * layer/layerPosition.js를 의존한다.
 * @param imageRootPath : image태그에 보여질 img 경로
 */
function settingAjaxStartLoadingBar(imageRootPath){
	if($("body").find("#loadingBar").length < 1 ){
		$("body").append('<img alt="loadingBar" id="loading" src="'+imageRootPath+'" style="position:absolute;left:100px;top:100px;z-index:200000;display: none;"/>');
	}
	setPosition($("#loading"), "cm");
	$("#loading").ajaxStart(function() { $(this).show(); }).ajaxStop(function() { $(this).hide(); });
} 