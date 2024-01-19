// Class definition
var KTCreateRole = (function () {
  var submitButton;
  var cancelButton;
  var form;
  var modal;

  const config = {
    headers: {
      "Content-Type": "application/json",
    },
  };

  // Handle form validation and submittion
  var handleForm = function () {
    // // Stepper custom navigation
    try {
      submitButton.addEventListener("click", function (e) {
        var formData = new FormData(form);
        axios
          .post(
            "/appjee/role/create",

            formData,
            config
          )
          .then(function (response) {
            if (response.data[0] == "success") {
              /* // Hide loading indication
                            submitButton.removeAttribute(
                                "data-kt-indicator"
                            ); */

              // Enable button
              submitButton.disabled = false;
              // Show popup confirmation
              Swal.fire({
                text: "Successfully created!",
                icon: "success",
                buttonsStyling: false,
                confirmButtonText: "Ok, compris!",
                customClass: {
                  confirmButton: "btn btn-primary",
                },
              }).then(function (result) {
                if (result.isDismissed || result.isConfirmed) {
                  form.reset();
                  location.reload();
                }
              });
            } else {
              // Show error popup. For more info check the plugin's official documentation: https://sweetalert2.github.io/
              // Hide loading indication
              form.reset();
              submitButton.removeAttribute("data-kt-indicator");

              // Enable button
              submitButton.disabled = false;
              Swal.fire({
                text: "Impossible d'avoir deux rôles de même nom",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, compris!",
                customClass: {
                  confirmButton: "btn btn-primary",
                },
              });
            }
          })
          .catch(function (error) {
            if (
              error.response &&
              error.response.data &&
              error.response.data.message
            ) {
              // Remove loading indication
              submitButton.removeAttribute("data-kt-indicator");

              // Enable button
              submitButton.disabled = false;

              //console.error('Erreur de soumission du formulaire:', error.response.data.message);
              Swal.fire({
                text: error.response.data.message,
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, compris!",
                customClass: {
                  confirmButton: "btn btn-primary",
                },
              });
            } else {
              // Remove loading indication
              submitButton.removeAttribute("data-kt-indicator");

              // Enable button
              submitButton.disabled = false;

              Swal.fire({
                text: "Erreur de soumission du formulaire:" + error,
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, compris!",
                customClass: {
                  confirmButton: "btn btn-primary",
                },
              });
            }
          });

        // Show error message.
        Swal.fire({
          text: "Désolé, il semble que des erreurs aient été détectées, veuillez réessayer.",
          icon: "error",
          buttonsStyling: false,
          confirmButtonText: "Ok, compris!",
          customClass: {
            confirmButton: "btn btn-primary",
          },
        });
      });

      cancelButton.addEventListener("click", function (e) {
        e.preventDefault();

        Swal.fire({
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
          if (result.value) {
            form.reset(); // Reset form
            modal.hide(); // Hide modal
          } else if (result.dismiss === "cancel") {
            Swal.fire({
              text: "Votre formulaire n'a pas été annulé !.",
              icon: "error",
              buttonsStyling: false,
              confirmButtonText: "Ok, compris!",
              customClass: {
                confirmButton: "btn btn-primary",
              },
            });
          }
        });
      });
    } catch (error) {}
  };

  return {
    // Public functions
    init: function () {
      try {
        form = document.querySelector("#kt_modal_add_role_form");

        submitButton = document.getElementById("kt_modal_add_role_submit");
        cancelButton = document.getElementById("kt_modal_add_role_cancel");
      } catch (error) {}

      /* initForm(); */

      handleForm();
    },
  };
})();

document.addEventListener("DOMContentLoaded", function () {
  // Code à exécuter lorsque le document est chargé
  KTCreateRole.init();
});
