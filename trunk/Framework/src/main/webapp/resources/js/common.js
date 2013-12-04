function setBirthYearToSelect(yearId, monthId, dayId){
	for (var i = new Date().getFullYear(); i > 1900; i--){
	    $('#'+yearId).append($('<option />').val(i).html(i));
	}
	
	$('#'+yearId).change(function(){
		updateNumberOfDays(yearId, monthId, dayId);
    });
};

function setBirthMonthToSelect(yearId, monthId, dayId){
	for (var i = 1; i < 13; i++){
		$('#'+monthId).append($('<option />').val(i).html(i));
	}

	$('#'+monthId).change(function(){
		updateNumberOfDays(yearId, monthId, dayId);
	});
};

function updateNumberOfDays(yearId, monthId, dayId){
	$('#'+dayId).html('');
	month = $('#'+monthId).val();
	year = $('#'+yearId).val();
	days = daysInMonth(month, year);
  
	for(var i=1; i < days+1 ; i++){
	  $('#'+dayId).append($('<option />').val(i).html(i));
	}
}

function daysInMonth(month, year) {
	return new Date(year, month, 0).getDate();
}