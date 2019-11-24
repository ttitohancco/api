function PurchaseCreation() {
    let purchase = {
        product: parseInt(document.getElementById("product").value),
        quantity: parseInt(document.getElementById("quantity").value)
    };

    let xhr = new XMLHttpRequest();
    let url = "api/purchase";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            console.log(response);
        }
    };

    xhr.send(JSON.stringify(purchase));
}

function inicio() {
    window.location.replace("index.html");
}