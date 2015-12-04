function submit_new_request(){
	
	var param = {pickupPlace:$(pickupPlace).val(), 
			destination:$(destination).val(), 
			comments:$(comments).val(), 
			startTime:$(startTime).val()}
	
	$.ajax({
		url: "submitNewRequest",
		type: "POST",
	    data : param,
		success: function(result){
			alert("submitted");
		},
		error: function(result){
			alert("error");
		}
	});
}


$(document).ready(function() {
	$('#pickup_time').datetimepicker();
});