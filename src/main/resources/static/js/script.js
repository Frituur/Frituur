// jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.quantity input');
// jQuery('.quantity').each(function() {
//     var spinner = jQuery(this),
//         input = spinner.find('input[type="number"]'),
//         btnUp = spinner.find('.quantity-up'),
//         btnDown = spinner.find('.quantity-down'),
//         min = input.attr('min'),
//         max = input.attr('max');
//
//     btnUp.click(function() {
//         var oldValue = parseFloat(input.val());
//         if (oldValue >= max) {
//             var newVal = oldValue;
//         } else {
//             var newVal = oldValue + 1;
//         }
//         spinner.find("input").val(newVal);
//         spinner.find("input").trigger("change");
//     });
//
//     btnDown.click(function() {
//         var oldValue = parseFloat(input.val());
//         if (oldValue <= min) {
//             var newVal = oldValue;
//         } else {
//             var newVal = oldValue - 1;
//         }
//         spinner.find("input").val(newVal);
//         spinner.find("input").trigger("change");
//     });
//
// });
//    window.location = "[[@{/}]]";
//};

function changeValue()
{
    let value = this.id;
    let change = value.substring(0,3);
    value = value.slice(3);
    let oldValue = value;
    let quantity = parseInt(document.getElementById(oldValue).value);

    if (change === "sub"){

        document.getElementById(oldValue).value = quantity++;
    } else {
        document.getElementById(oldValue).value = quantity--;
    }


}

