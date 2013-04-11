var eventMenu = function($menu_obj, $form) {
	$menu_obj.find("a").click(function(){
		$form.attr("action", $(this).attr("page")).submit();
	});
};