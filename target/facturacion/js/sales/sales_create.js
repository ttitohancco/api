function SalesCreation() {
    let sales = {
        product: parseInt(document.getElementById("product").value),
        quantity_sales: parseInt(document.getElementById("quantity_sales").value)
    };

    let xhr = new XMLHttpRequest();
    let url = "api/sales";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            console.log(response);
        }
    };

    xhr.send(JSON.stringify(sales));
}

function inicio() {
    window.location.replace("index.html");
}