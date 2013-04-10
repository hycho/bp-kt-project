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