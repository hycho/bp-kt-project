/**
 * 현재 서비스의 URL정보를 읽어 들여 path를 리턴합니다.
 * @returns http://xxx.xxx.com
 */
function getContextPath(){
	return window.location.protocol + "//" + window.location.host;
}

/**
 * 현재 URL정보를 읽어들여 Parameter를 분리해서 Object객체로 만들어 넘겨줍니다.
 * Object는 Map과 비슷한 형태의 객체라 보면 됩니다.
 */
function getParameter(){
	var param = new Array();
	var size = params.length;
	var key, value;
	var params;
	var url = decodeURIComponent(window.location.href);
	url = decodeURIComponent(url);

	params = url.substring( url.indexOf('?')+1, url.length );
	params = params.split("&");
	
	for(var i=0; i < size; i++) {
		key = params[i].split("=")[0];
		value = params[i].split("=")[1];
		param[key] = value;
	}
	
	return param;
}