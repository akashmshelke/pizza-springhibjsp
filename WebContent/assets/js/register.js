$(document).ready(function() {

	$("form[name='register']").validate({

		rules : {
			name :"required",
			mobile : "required",
			email : {

				required : true,
				email : true

			},
			address : "required",
			password : "required",

		},

		messages : {
			name : {
				required : "*Please enter name",
				lettersonly : "*Please enter valid name"
					},
			mobile : "*Please enter mobile",
			
			email : {
				required : "*Please enter a email address",
				email : "*Please enter a valid email address"

			},
			
			address : "*Please enter address",
			password : "*Please enter password"
		},
		submitHandler : function(form) {
			form.submit();
		}

	});

});