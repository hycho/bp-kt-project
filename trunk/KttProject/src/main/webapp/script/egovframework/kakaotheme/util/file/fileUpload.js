/**
 * byte사이즈를 용량에 따라 kb, mb, gb, tb, pb 까지 변환해서 값을 리턴합니다.
 * @param byteSize : byte 사이즈 입니다.
 * @param type : size[byte, kb, mb등 type이 붙어서 반환 되지 않습니다.], type & non [byte, kb, mb..등이 자동으로 붙어서 반환 됩니다.]
 * @returns
 */
function convertByteSize(byteSize, type){
	var arrByteType = ['bytes', 'KB', 'MB', 'GB', 'TB', 'PB'];
	var byteLine = Math.floor(Math.log(byteSize)/Math.log(1024));
	if(byteLine >= arrByteType.length){
		byteLine = arrByteType.length - 1;
	}
	
	if(byteLine == "-Infinity"){
		return "0 " + arrByteType[0];
	}else{
		if(type == "size"){
			return (byteSize/Math.pow(1024, Math.floor(byteLine))).toFixed(1);
		}else{
			return (byteSize/Math.pow(1024, Math.floor(byteLine))).toFixed(1)+" "+arrByteType[byteLine];
		}
	}
}


function fileUploadProcess(file){
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
		var metadata = jQuery.parseJSON(data.currentTarget.responseText);
		var mimetype = metadata.mimetype;
		
		$("#<portlet:namespace />rpd_projectThumbnail").hide();
    	$("#<portlet:namespace />settingmetadata").show();
    	$("#<portlet:namespace />settingmetadatabtng").show();
    	$("#<portlet:namespace />metadatatitle").val(metadata.filename);
    	$("#<portlet:namespace />metadatasubject").val(metadata.subject);
    	$("#<portlet:namespace />metadatadescription").val(metadata.description!=null?metadata.description.en_US:"");
    	$("#<portlet:namespace />metadatamimetype").val(getTypeName(metadata.mimetype));
    	$("#<portlet:namespace />metadatafullmimetype").val(metadata.mimetype);
    	$("#<portlet:namespace />metadatafilename").val(metadata.filename);
    	$("#<portlet:namespace />metadatacreateddate").val(metadata.createdate);
    	$("#<portlet:namespace />metadatacreator").val(metadata.creator);
    	$("#<portlet:namespace />metadatatempfilename").val(metadata.tempfilename);
    	$("#<portlet:namespace />metadataauthor").val(metadata.author);
    	
    	<portlet:namespace />setMimetypeProp(mimetype, metadata);
    	
    	$("#<portlet:namespace />progressBarLayerGroup").fadeOut();
    	
    	$("#<portlet:namespace />titleregistlayer").hide();
    	$("#<portlet:namespace />tabregistlayer").hide();
    	$("#<portlet:namespace />rpd_clickfile").hide();
    	
    	layerFadeIn($("#<portlet:namespace />registorLayerGroup"), $("#<portlet:namespace />registorLayer"));
	}, false);
	xhr.addEventListener("error", function(){
		alert("Error");
	}, false);  
	xhr.open("POST", "${alfresco_url}/wcservice/ubion/lcms/piece/beforeregist?userId=${USER_EMAIL}");
	xhr.send(fd);
}