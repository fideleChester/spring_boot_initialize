var SPUpdateRole = (function () {
  var allHrefsUpdate;
  var idRole;
  var modal;

  var handle = function () {
    allHrefsUpdate.forEach(function (button) {
      button.addEventListener("click", function (event) {
         idRole = this.getAttribute("data-id");
         modal.classList.add("show");
         modal.style.display = "block";
         modal.setAttribute("aria-modal", true);

        modal
          .querySelector(".kt-modal__close")
          .addEventListener("click", function (event) {
            modal.style.display = "none";
          });
      });
    });
  };

  return {
    init: function () {
      //alert("init");
      allHrefsUpdate = document.querySelectorAll(".kt-modal-role-update");
      modal = document.getElementById("inlineForm1");
      handle();
      console.log(modal);
    },
  };
})();

document.addEventListener("DOMContentLoaded", function (event) {
  SPUpdateRole.init();
});
