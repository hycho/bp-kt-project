/**
 * type에 따라 $elem의 위치를 세팅 합니다.
 * 선행조건을 $elem이 absoulte이며 z-index를 높여서 보일 수 있도록 해야 합니다.
 * @param $layergr
 * @param $layer
 * @param type : cm[화면에 width, height가 중앙에 가는 정중앙에 보여지는 타입]
 */
function setPosition($elem, type){
	if(type == "cm"){
		var top = ($(window).innerHeight() / 2) - ($elem.outerHeight() / 2) + "px";
		var left = ($(window).innerWidth() / 2) - ($elem.outerWidth() / 2) + "px";
		
		if($elem.outerHeight() < $(document).height()){
			$elem.css("top", top);
		}else{
			$elem.css("top", "0px");
		}
		if($elem.outerWidth() < $(document).width()){
			$elem.css("left", left);
		}else{
			$elem.css("left", "0px");
		}
	}
};