/**
 * javascript for all the admin site pages
 */

 document.addEventListener("DOMContentLoaded", function () {
  // Get references to the input elements
  var priceInput = document.getElementById("price");
  var discountInput = document.getElementById("discount");
  var discountedPriceInput = document.getElementById("discountedprice");

  // Function to calculate discounted price
  function calculateDiscountedPrice() {
    var price = parseFloat(priceInput.value);
    var discount = parseFloat(discountInput.value);

    // Check if inputs are valid numbers
    if (!isNaN(price) && !isNaN(discount)) {
      var discountedPrice = price - price * (discount / 100);
      // Round to two decimal places
      discountedPrice = Math.round(discountedPrice * 100) / 100;
      // Set the calculated discounted price in the discountedprice input
      discountedPriceInput.value = discountedPrice;
    } else {
      // If inputs are not valid numbers, set discounted price input to empty
      discountedPriceInput.value = "";
    }
  }

  // Event listeners to recalculate discounted price when price or discount changes
  priceInput.addEventListener("input", calculateDiscountedPrice);
  discountInput.addEventListener("input", calculateDiscountedPrice);
});
document.getElementById('closePopup').addEventListener('click', function () {
            document.getElementById('popup').style.display = 'none';
        });
