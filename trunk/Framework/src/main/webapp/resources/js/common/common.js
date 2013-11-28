// 주민등록번호 검증 Script
function checkIhidNum(ihidNum1, ihidNum2) {
	if(ihidNum1 == null || ihidNum2 == null || ihidNum1 == "" || ihidNum2 == ""){
		return false;
	}
	
	var sum = 0;
	var idNum = new Array(13);
	var weighNum = new Array(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5);
	var inputId = ihidNum1 + ihidNum2; // 두 양식을 하나로 합침
	
	for (var i = 0; i < 13; i++) {
		idNum[i] = inputId.substr(i, 1); 
	}
	
	for (var i = 0; i < 12; i++) {
		sum += idNum[i] * weighNum[i];
	}
	check = 11 - (sum % 11);
	
	if (check > 9) {
		check -= 10;
	}
	
	if (check != idNum[12]) {
		return false;
	} else {
		return true;
	}
}