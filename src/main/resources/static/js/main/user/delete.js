var SPDeleteUser = (function () {

    var deleteButtons ;
    var idUser;

    var deleteUser = function () {
        try {

            deleteButtons.forEach(action => {
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

                        idUser = action.getAttribute('data-id');

                        axios.post('/appjee/user/delete/'+idUser, )
                          .then(function (response) {
                            if (response.data[0] == "success") {
                                Swal.fire(
                                  'Deleted!',
                                  'The user has been deleted.',
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
                                  'The user has not been deleted.',
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

            deleteButtons = document.querySelectorAll(".kt_modal_delete_user");
         deleteUser();
            
          } catch (error) {}
    
   
        },
      };
})();


document.addEventListener("DOMContentLoaded", function () {
    // Code à exécuter lorsque le document est chargé
    SPDeleteUser.init();

  
  });