function createProduct() {
    let product = {
        name: document.getElementById("name").value,
        description: document.getElementById("description").value,
        price: parseFloat(document.getElementById("price").value)
    };

    var xhr = new XMLHttpRequest();
    var url = "api/product";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            console.log(response);
        }
    };

    xhr.send(JSON.stringify(product));
}

function goHome() {
    window.location.replace("index.html");
}