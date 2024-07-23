/**
 * 
 */

  function submitForm() {
        document.getElementById("searchForm").submit();
    }
    
    
     document.addEventListener('DOMContentLoaded', function() {
            const clickableImage = document.querySelectorAll('.clickable-image','.shop-button');

            clickableImage.forEach(function(image) {
                image.addEventListener('click', function(e) {
                    e.preventDefault();

                    const targetId = this.getAttribute('href').substring(1); // Get the target id
                    const targetElement = document.getElementById(targetId); // Get the target element

                    if (targetElement) {
                        // Scroll smoothly to the target element
                        window.scrollTo({
                            top: targetElement.offsetTop,
                            behavior: 'smooth'
                        });
                    }
                });
            });
        });
        
 function togglePopup() {
            let popup = document.getElementById("popup");
            popup.style.visibility = 
              (popup.style.visibility === "visible") 
                               ? "hidden" : "visible";
        }
