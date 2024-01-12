var SPUpdateRole = (function () {
  var allHrefsUpdate;
  var idRole;
  var submitButton;
  var modal;
  var form;
  var cancelButton;
  var config = {
    headers: {
        "Content-Type": "application/json",
    },
};

  var handle = function () {
    allHrefsUpdate.forEach(function (button) {
      button.addEventListener("click", function (event) {
        event.preventDefault();
         idRole = this.getAttribute("data-id");
         modal.classList.add("show");
         modal.style.display = "block";
         modal.setAttribute("aria-modal", true);

         axios.get('/appjee/role/get/'+idRole)
         .then(function (response) {
           // handle success
           modal.querySelector("input[name='libelle']").value = response.data[0].libelle;
           modal.querySelector("input[name='id']").value = idRole;

         })
         .catch(function (error) {
           // handle error
           //console.log(error);
         })

        modal
          .querySelector(".kt-modal__close")
          .addEventListener("click", function (event) {
            modal.style.display = "none";
          });
      });
    });

      
      try {
        submitButton.addEventListener("click", function (event) {

          event.preventDefault();

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
                        "/appjee/role/update",
                        formData,
                        config
                        )
                    .then(function (response) {
                        
                        if (response.data[0] == "success") {
                            
                        swalWithBootstrapButtons.fire({
                            title: "Updated!",
                            text: "Your role has been updated.",
                            icon: "success"
                        }).then((result) => {
                            if (result.isConfirmed) {
                            window.location.href = "/appjee/role/index";
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
                    text: "Your imaginary role is safe :)",
                    icon: "error"
                  });
                }
              });

           
        })

        cancelButton.addEventListener("click", function (e) {
          e.preventDefault();
          Swal.fire({
            showClass: {
              popup: `
                animate__animated
                animate__fadeInUp
                animate__faster
              `
            },
            hideClass: {
              popup: `
                animate__animated
                animate__fadeOutDown
                animate__faster
              `
            },
            text: "Etes-vous sûr de vouloir annuler ?",
            icon: "warning",
            showCancelButton: true,
            buttonsStyling: false,
            confirmButtonText: "Oui, Annuler !",
            cancelButtonText: "Non, retourner",
            customClass: {
              confirmButton: "btn btn-primary",
              cancelButton: "btn btn-active-light",
            },
          }).then(function (result) {
            if (result.isConfirmed) {
              modal.classList.remove("show");
              modal.setAttribute("aria-hidden", "true");
              modal.style.display = "none";
            }
          })
        })
           
          
    } catch (error) {
        
    }
        }


  return {
    init: function () {
      //alert("init");
      allHrefsUpdate = document.querySelectorAll(".kt-modal-role-update");
      modal = document.getElementById("inlineForm1");
      submitButton = document.getElementById("kt_submit_update_role");
      form = document.getElementById("kt_modal_update_role_form");
      cancelButton = document.getElementById("kt_cancel_update_role");
      handle();

    },
  };
})();

document.addEventListener("DOMContentLoaded", function (event) {
  SPUpdateRole.init();
});
