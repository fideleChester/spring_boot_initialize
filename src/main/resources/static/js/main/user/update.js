var SPUpdateUser = (function () {
    var submitButton;
    var editButtons;
    var idUser;
    var cancelButton;
    var form;
    var modal;
    var checkbox;
    const config = {
        headers: {
            "Content-Type": "application/json",
        },
    };

    var handleCheckBox = function () {
        if (checkbox.checked) {
            checkbox.value = "true";
            console.log("c");
        } else {
            checkbox.value = "false";

        }
    
    }


    // Handle form validation and submittion
    var handleForm = function () {
        // // Stepper custom navigation
                try {
                    submitButton.addEventListener("click", function (e) {
                      handleCheckBox();
                        var formData = new FormData(form);

                        const swalWithBootstrapButtons = Swal.mixin({
                            customClass: {
                              confirmButton: "btn btn-success",
                              cancelButton: "btn btn-danger"
                            },
                            buttonsStyling: false
                          });
                          swalWithBootstrapButtons.fire({
                            title: "Are you sure?",
                            text: "You won't be able to revert this!",
                            icon: "warning",
                            showCancelButton: true,
                            confirmButtonText: "Yes, update it!",
                            cancelButtonText: "No, cancel!",
                            reverseButtons: true
                          }).then((result) => {
                            if (result.isConfirmed) {

                                axios.post(
                                    "/appjee/user/update",
                                    formData,
                                    config
                                    )
                                .then(function (response) {
                                    
                                    if (response.data[0] == "success") {
                                        
                                    swalWithBootstrapButtons.fire({
                                        title: "Updated!",
                                        text: "Your file has been updated.",
                                        icon: "success"
                                    }).then((result) => {
                                        if (result.isConfirmed) {
                                        window.location.href = "/appjee/user/index";
                                        }
                                    });
                                   
                                    }else{
                                      swalWithBootstrapButtons.fire({
                                        title: "Cancelled",
                                        text: "An error has occurred.",
                                        icon: "error"
                                      });
                                    }
                                }).catch(function (error) {
                                    console.log("error");
                                });


                            } else if (
                              /* Read more about handling dismissals below */
                              result.dismiss === Swal.DismissReason.cancel
                            ) {
                              swalWithBootstrapButtons.fire({
                                title: "Cancelled",
                                text: "Your imaginary user is safe :)",
                                icon: "error"
                              });
                            }
                          });

                       
                    })
                       
                      
                } catch (error) {
                    
                }
            
            
            }   

    return {
        // Public functions
        init: function () {
            form = document.querySelector("#kt_modal_update_user_form");
            submitButton = document.getElementById("kt_modal_update_user_submit");
            cancelButton = document.getElementById("kt_modal_update_user_cancel");
            editButtons = document.querySelectorAll(".kt_modal_update_user");
            checkbox = document.querySelector('input[name="enabled"]');
            handleForm();

        },
    }
    })();

    document.addEventListener("DOMContentLoaded", function () {
        // Code à exécuter lorsque le document est chargé
        SPUpdateUser.init();
      
      });
