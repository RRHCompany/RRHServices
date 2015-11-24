$('#submitBtn').click(function() {
	$.ajax({
		type : 'POST',
		url : 'login/webLogin',
		data : {
			'username' : $('#username').val(),
			'password' : $('#password').val()
		},
		success : function(data) {
			if(data.result == 'false'){
				$('#msg').show('normal');
			}else{
				location.href = 'sysresources.html';
			}
		},
		dataType : 'json'
	});
});