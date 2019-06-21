$(document).ready(function() {

	$("form[name='login']").validate({

		rules : {
			email : {

				required : true,
				email : true

			},
			password : "required",

		},

		messages : {

			email : {
				required : "*Please enter a email address",
				email : "*Please enter a valid email address"

			},

			password : "*Please enter password"
		},
		submitHandler : function(form) {
			form.submit();
		}

	});

});