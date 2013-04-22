/**
 * HTML5 전용 UPLOAD ie10+, chorme, firefox
 * 필요 스크립트 convertByte.js
 * @param file
 * @param url
 */
function fileUploadProcess(file, url){
	var startTime = new Date();
	var transmission_speed = 0;
	
	var fileFormData = new FormData();
	fileFormData.append("filedata", file);
						
	xhr = new XMLHttpRequest();
	xhr.addEventListener('progress', function(e){
        var done = e.position || e.loaded, total = e.totalSize || e.total;
    }, false);
	
	if (xhr.upload){
        xhr.upload.onprogress = function(e) {
            var done = e.position || e.loaded, total = e.totalSize || e.total;
            $("#<portlet:namespace />progressbarsendsize").text(convertByteSize(done));
            $("#<portlet:namespace />progressbartotalsize").text(convertByteSize(total));
            
            $("#<portlet:namespace />progressbar").progressbar("value", (Math.floor(done/total*1000)/10));
            
            transmission_speed = Math.round((1024*1024)/((new Date()-startTime)/1000));
            
            $("#<portlet:namespace />progressbartranmissionsrate").empty().text(convertByteSize(transmission_speed));
            
            $("#<portlet:namespace />progressbarlosetime").empty().text(Math.round(((convertByteSize(total,"size")-convertByteSize(done, "size"))/convertByteSize(transmission_speed,"size")))+"초");
			
            startTime = new Date();
        };
    }
	
	xhr.addEventListener("load", function(data){
		console.log(data);
	}, false);
	
	xhr.addEventListener("error", function(){
		alert("Error");
	}, false);
	
	xhr.open("POST", url);
	
	xhr.send(fileFormData);
}