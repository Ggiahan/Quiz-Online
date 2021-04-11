$("#contactForm").validator().on("submit", function (event) {
    if (event.isDefaultPrevented()) {
        // handle the invalid form...
        formError();
        submitMSG(false, "Did you fill in the form properly?");
    } else {
        // everything looks good!
        event.preventDefault();
        submitForm();
    }
});


$(document).ready(function(){
                $("#createForm").validate({
                    //set the rules for the field 
                    rules:{//add rule
                        pname:{
                            required: true,
                            rangelength: [2, 50]
                        },
                        price:{
                            required: true,
                            digits: true,
                            maxlength: 8
                        },
                        quantity:{
                            required: true,
                            digits: true,
                            maxlength: 8
                        },
                        description:{
                            required: true
                        },
                        fileUp:{
                            required: true,
                            extension: "png|jpg"
                        }
                    },//end rule
                    messages:{//add message
                        pname:{
                            required: "Please enter product name",
                            rangelength: "Product name's length is between 2 - 50 chars"
                        },
                        price:{
                            required: "Please enter price",
                            digits: "Price only includes digits",
                            maxlength: "Price only contains 8 digits"
                        },
                        quantity:{
                            required: "Please enter quantity",
                            digits: "Quantity only includes digits",
                            maxlength: "Quantity only contains 8 digits"
                        },
                        description: "Please enter description",
                        fileUp:{
                            required: "Please upload product image",
                            accept: "Please upload image file (png or jpg)"
                        }
                    },
                    errorElemet: "em",
                    errorPlacement: function ( error, element ) {
                        // Add the invalid-feedback class to the error element
                        error.addClass( "invalid-feedback" );

                        if ( element.prop( "type" ) === "checkbox" ) {
                                error.insertAfter( element.next( "label" ) );
                        } else {
                                error.insertAfter( element );
                        }
                    },
                    highlight: function ( element, errorClass, validClass ) {
                            $( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
                    },
                    unhighlight: function (element, errorClass, validClass) {
                            $( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
                    }
                });//end validate
            });//end function

function submitForm(){
    // Initiate Variables With Form Content
    var name = $("#name").val();
    var email = $("#email").val();
    var msg_subject = $("#msg_subject").val();
    var message = $("#message").val();


    $.ajax({
        type: "POST",
        url: "php/form-process.php",
        data: "name=" + name + "&email=" + email + "&msg_subject=" + msg_subject + "&message=" + message,
        success : function(text){
            if (text == "success"){
                formSuccess();
            } else {
                formError();
                submitMSG(false,text);
            }
        }
    });
}

function formSuccess(){
    $("#contactForm")[0].reset();
    submitMSG(true, "Message Submitted!")
}

function formError(){
    $("#contactForm").removeClass().addClass('shake animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
        $(this).removeClass();
    });
}

function submitMSG(valid, msg){
    if(valid){
        var msgClasses = "h3 text-center tada animated text-success";
    } else {
        var msgClasses = "h3 text-center text-danger";
    }
    $("#msgSubmit").removeClass().addClass(msgClasses).text(msg);
}