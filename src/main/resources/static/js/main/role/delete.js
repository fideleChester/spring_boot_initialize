var SPDeleteRole = (function () {

    var deleteHrefs ;
    var idRole;

    var deleteRole = function () {
        try {

            deleteHrefs.forEach(action => {
                action.addEventListener('click', function (e) {
                    e.preventDefault();
                    Swal.fire({
                        title: "Are you sure?",
                        text: "You won't be able to revert this!",
                        icon: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#3085d6",
                        cancelButtonColor: "#d33",
                        confirmButtonText: "Yes, delete it!"
                      }).then((result) => {
                        if (result.isConfirmed) {

                        idRole = action.getAttribute('data-id');

                        axios.post('/appjee/role/delete/'+idRole, )
                          .then(function (response) {
                            if (response.data[0] == "success") {
                                Swal.fire(
                                  'Deleted!',
                                  'The Role has been deleted.',
                                  'success'
                                ).then((result) => {
                                    if (result.isConfirmed) {
                                        location.reload();
                                    }
                                })
                              
                            }
                            else {
                                Swal.fire(
                                  'Error!',
                                  'This role is assigned to users.',
                                  'error'
                                )
                            }
                                                    })
                          .catch(function (error) {
                            
                          });
                        }
                      });
                        });
                
            });
            
            
        } catch (error) {
            
        }
        
    }


    return {
        // Public functions
        init: function () {

          try {

            deleteHrefs = document.querySelectorAll(".kt-modal-role-delete");
         deleteRole();
            
          } catch (error) {}
    
   
        },
      };
})();


document.addEventListener("DOMContentLoaded", function () {
    // Code à exécuter lorsque le document est chargé
    SPDeleteRole.init();

  
  });